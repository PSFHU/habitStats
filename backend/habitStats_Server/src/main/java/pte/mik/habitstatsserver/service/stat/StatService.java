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
public class StatService {

    private StatRepository statRepository;
    private GoalRepository goalRepository;
    private StatCategoryService statCategoryService;
    private UnitTypeService unitTypeService;

    private final ModelMapper mapper = new ModelMapper();

    public StatService() {
        final Converter<Long, StatCategory> idToCategory = id -> statCategoryService.getCategoryById(id.getSource());
        final Converter<Long, UnitType> idToUnitType = id -> unitTypeService.getById(id.getSource());
        final Converter<List<Goal>, List<Long>> goalsToIds = goals -> goals.getSource()
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

    @Autowired
    public StatService(StatRepository statRepository, GoalRepository goalRepository, StatCategoryService statCategoryService, UnitTypeService unitTypeService) {
        this.statRepository = statRepository;
        this.goalRepository = goalRepository;
        this.statCategoryService = statCategoryService;
        this.unitTypeService = unitTypeService;
    }

    public List<Stat> listAllStat() {
        return statRepository.findAll();
    }

    public Stat getStatById(Long id){ return statRepository.findById(id).get();}

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
            if (selectedStat.getGoalList().stream().anyMatch(goal -> goal.getId().equals(mapperGoalDto.getGoalId())))
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
            if (selectedStat.getGoalList().stream().anyMatch(goal -> goal.getId().equals(mapperGoalDto.getGoalId())))
                selectedStat.getGoalList().remove(goalRepository.getById(mapperGoalDto.getGoalId()));
            else
                return "Goal already removed!";
            return tryFunction(() -> statRepository.save(selectedStat));
        }else
            return "Stat doesn't exists!";
    }

    public String deleteStat(Long id) {
        return tryFunction(() -> statRepository.deleteById(id));
    }


}
