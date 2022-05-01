package pte.mik.habitstatsserver.service.stat;

import lombok.AllArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pte.mik.habitstatsserver.dto.CreateGoalDto;
import pte.mik.habitstatsserver.entity.stat.*;
import pte.mik.habitstatsserver.repository.stat.GoalRepository;

import java.util.List;
import java.util.stream.Collectors;

import static pte.mik.habitstatsserver.service.TryCatchService.tryFunction;

@Service
public class GoalService {

    private GoalRepository goalRepository;
    private StatService statService;
    private final ModelMapper mapper = new ModelMapper();

    public GoalService(@Autowired GoalRepository goalRepository, @Autowired StatService statService) {
        final TypeMap<CreateGoalDto, Goal> propertyMapper = mapper.createTypeMap(CreateGoalDto.class, Goal.class);
        final Converter<List<Long>, List<Stat>> idToStat = id -> {
            return id.getSource()
                    .stream()
                    .map(statService::getStatById)
                    .collect(Collectors.toList());
        };

        propertyMapper.addMappings(
                mapper -> mapper.using(idToStat).map(CreateGoalDto::getStatListIds,Goal::setStatList)
        );
    }

    public List<Goal> listAll(){
        return goalRepository.findAll();
    }

    public Goal getById(Long id){return goalRepository.getById(id);}

    // TODO Check progress on Stat

    public String edit(Goal goal){
        if (goalRepository.existsById(goal.getId())){
            return tryFunction(()->goalRepository.save(goal));
        }
        else
            return "Goal doesn't exists";
    }

    // TODO DTO for creating goals
    public String create(CreateGoalDto goal){
        Goal selectedGoal = mapper.map(goal, Goal.class);
        return tryFunction(()->goalRepository.save(selectedGoal));
    }

    public String delete(Long id){return tryFunction(()->goalRepository.deleteById(id));}
}
