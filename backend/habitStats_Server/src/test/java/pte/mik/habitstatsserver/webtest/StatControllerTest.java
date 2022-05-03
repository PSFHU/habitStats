package pte.mik.habitstatsserver.webtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pte.mik.habitstatsserver.controller.stat.StatController;
import pte.mik.habitstatsserver.dto.ActionStatDto;
import pte.mik.habitstatsserver.dto.MapperGoalDto;
import pte.mik.habitstatsserver.entity.stat.*;
import pte.mik.habitstatsserver.repository.stat.GoalRepository;
import pte.mik.habitstatsserver.repository.stat.StatCategoryRepository;
import pte.mik.habitstatsserver.repository.stat.StatRepository;
import pte.mik.habitstatsserver.repository.stat.UnitTypeRepository;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.map;

@SpringBootTest
public class StatControllerTest {

    @Autowired
    private StatController controller;
    @Autowired
    private StatRepository statRepository;
    @Autowired
    private UnitTypeRepository unitTypeRepository;
    @Autowired
    private StatCategoryRepository statCategoryRepository;
    @Autowired
    private GoalRepository goalRepository;

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    @Transactional
    public void create() {
        ActionStatDto actionStatDto = new ActionStatDto(latestStat().getId(),"Test",latestStatCategory().getId(),latestUnitType().getId());
        assertThat(controller.addStat(actionStatDto)).isEqualTo("Done!");
    }

    @Test
    public void read() {
        assertThat(controller.getByStatId(latestStat().getId()).getId()).isEqualTo(latestStat().getId());
        assertThat(controller.listAllStat().stream().map(Stat::getId).anyMatch(Long -> Long.equals(latestStat().getId()))).isTrue();
    }

    @Test
    @Transactional
    public void update() {
        ActionStatDto actionStatDto = new ActionStatDto(latestStat().getId(),"Edited test",latestStatCategory().getId(),latestUnitType().getId());

        assertThat(controller.editStat(actionStatDto)).isEqualTo("Done!");
        assertThat(actionStatDto.getTitle()).isEqualTo(latestStat().getTitle());
        assertThat(actionStatDto.getCategoryId()).isEqualTo(latestStatCategory().getId());
        assertThat(actionStatDto.getUnit_typeId()).isEqualTo(latestUnitType().getId());
    }

    @Test
    @Transactional
    public void delete() {
        Long idActedOn = latestStat().getId();
        assertThat(controller.deleteStat(idActedOn)).isEqualTo("Done!");
        assertThat(statRepository.existsById(idActedOn)).isFalse();
    }

    // NOTE Goal tests

    @Test
    @Transactional
    public void addGoal() {
        removeGoal();
        MapperGoalDto mapperGoalDto = new MapperGoalDto(latestStat().getId(),latestGoal().getId());
        assertThat(controller.addGoal(mapperGoalDto)).isEqualTo("Done!");
        assertThat(controller.addGoal(mapperGoalDto)).isEqualTo("Goal already added!");
    }

    @Test
    @Transactional
    public void removeGoal() {
        MapperGoalDto mapperActedOnGoalDto = new MapperGoalDto(latestStat().getId(),latestStat().getGoalList().stream().max(Comparator.comparing(Goal::getId)).get().getId());
        assertThat(controller.removeGoal(mapperActedOnGoalDto)).isEqualTo("Done!");
        assertThat(controller.removeGoal(mapperActedOnGoalDto)).isEqualTo("Goal already removed!");
    }

    private Stat latestStat(){
        return controller.listAllStat().stream().max(Comparator.comparing(Stat::getId)).get();
    }
    private UnitType latestUnitType(){
        return unitTypeRepository.findAll().stream().max(Comparator.comparing(UnitType::getId)).get();
    }
    private StatCategory latestStatCategory(){
        return statCategoryRepository.findAll().stream().max(Comparator.comparing(StatCategory::getId)).get();
    }
    private Goal latestGoal(){
        return goalRepository.findAll().stream().max(Comparator.comparing(Goal::getId)).get();
    }
}
