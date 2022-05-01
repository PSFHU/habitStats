package pte.mik.habitstatsserver.service.stat;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pte.mik.habitstatsserver.dto.ActionStatDto;
import pte.mik.habitstatsserver.entity.stat.*;
import pte.mik.habitstatsserver.repository.stat.ProgressRepository;
import pte.mik.habitstatsserver.repository.stat.StatRepository;

import java.util.List;
import java.util.stream.Collectors;

import static pte.mik.habitstatsserver.service.TryCatchService.tryFunction;

@Service
public class ProgressService {

    ProgressRepository progressRepository;
    StatRepository statRepository;

    private final ModelMapper mapper = new ModelMapper();

    public ProgressService(ProgressRepository progressRepository, StatRepository statRepository) {
        final Converter<Long, Stat> idToStat = id -> statRepository.getById(id.getSource());

        final TypeMap<ActionProgressDto, Progress> actionStatDtoStatTypeMap = mapper.createTypeMap(ActionProgressDto.class, Progress.class);

        actionStatDtoStatTypeMap.addMappings(
                mapper -> mapper.using(idToStat).map(ActionProgressDto::getStatId,Progress::setStat)
        );
        this.progressRepository = progressRepository;
        this.statRepository = statRepository;
    }

    public List<Progress> listAll(){
        return progressRepository.findAll();
    }

    public List<Progress> getByStatId(Long statId) { return progressRepository.getByStatId(statId);}

    public String create(ActionProgressDto progress) {
        Progress newProgress = this.mapper.map(progress,Progress.class);
        return  tryFunction(()->progressRepository.save(newProgress));
    }

    public String edit(ActionProgressDto progress) {
        if (progressRepository.existsById(progress.getId())){
            Progress newProgress = this.mapper.map(progress,Progress.class);
            return tryFunction(()->progressRepository.save(newProgress));
        }
        else
            return "Progress doesn't exists";
    }

    public String deleteById(Long id){
        return tryFunction(()->progressRepository.deleteById(id));
    }

}
