package pte.mik.habitstatsserver.service.stat;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import pte.mik.habitstatsserver.dto.ActionStatDto;
import pte.mik.habitstatsserver.dto.MapperGoalDto;
import pte.mik.habitstatsserver.entity.stat.Goal;
import pte.mik.habitstatsserver.entity.stat.Stat;
import pte.mik.habitstatsserver.entity.stat.StatCategory;
import pte.mik.habitstatsserver.entity.stat.UnitType;
import pte.mik.habitstatsserver.repository.stat.GoalRepository;
import pte.mik.habitstatsserver.repository.stat.StatRepository;
import static pte.mik.habitstatsserver.service.TryCatchService.tryFunction;

@Service
@AllArgsConstructor
public class StatService {

    @Autowired
    private StatRepository statRepository;
    @Autowired
    private GoalRepository goalRepository;
    @Autowired
    private StatCategoryService statCategoryService;
    @Autowired
    private UnitTypeService unitTypeService;

    private final ModelMapper mapper = new ModelMapper();

    public StatService() {
        final Converter<Integer, StatCategory> idToCategory = id -> statCategoryService.getCategoryById(id.getSource());
        final Converter<Integer, UnitType> idToUnitType = id -> unitTypeService.getById(id.getSource());
        final Converter<List<Goal>, List<Integer>> goalsToIds = goals -> goals.getSource()
                .stream()
                .map(Goal::getId)
                .collect(Collectors.toList());

        final TypeMap<ActionStatDto, Stat> actionStatDtoStatTypeMap = mapper.createTypeMap(ActionStatDto.class, Stat.class);

        actionStatDtoStatTypeMap.addMappings(
                mapper -> mapper.using(idToCategory).map(ActionStatDto::getCategoryId,Stat::setCategory)
        );
        actionStatDtoStatTypeMap.addMappings(
                mapper -> mapper.using(idToUnitType).map(ActionStatDto::getUnit_typeId,Stat::setUnit_type)
        );
    }

    public List<Stat> listAllStat() {
        return statRepository.findAll();
    }

    public Stat getStatById(Integer id){ return statRepository.findById(id).get();}

    public String addStat(ActionStatDto stat) {
        Stat newStat = this.mapper.map(stat,Stat.class);
        return tryFunction(() -> statRepository.save(newStat));
    }

    public String editStat(ActionStatDto stat) {
        Stat newStat = this.mapper.map(stat,Stat.class);
        return tryFunction(() -> statRepository.save(newStat));
    }

    // TODO Make interface to use for GoalActions
    public String addGoal(MapperGoalDto mapperGoalDto){
        Stat selectedStat = statRepository.getById(mapperGoalDto.getStatId());
        if(selectedStat != null){
            //TODO Check action happened or not
            if (selectedStat.getGoalList().stream().filter(goal -> goal.getId().equals(mapperGoalDto.getGoalId())).findFirst().isPresent())
                return "Goal already added!";
            else
                selectedStat.getGoalList().add(goalRepository.getById(mapperGoalDto.getGoalId()));
            return tryFunction(() -> statRepository.save(selectedStat));
        }else
            return "Stat doesn't exists!";
    }

    // TODO Apply changes like in addGoal
    public String deleteGoal(MapperGoalDto mapperGoalDto){
        Stat selectedStat = statRepository.getById(mapperGoalDto.getStatId());
        if(selectedStat != null){
            if (selectedStat.getGoalList().stream().filter(goal -> goal.getId().equals(mapperGoalDto.getGoalId())).findFirst().isPresent())
                selectedStat.getGoalList().remove(goalRepository.getById(mapperGoalDto.getGoalId()));
            else
                return "Goal already removed!";
            return tryFunction(() -> statRepository.save(selectedStat));
        }else
            return "Stat doesn't exists!";
    }

    public String deleteStat(Integer id) {
        return tryFunction(() -> statRepository.deleteById(id));
    }


}
