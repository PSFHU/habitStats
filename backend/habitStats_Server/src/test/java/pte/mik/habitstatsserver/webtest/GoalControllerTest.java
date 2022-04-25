package pte.mik.habitstatsserver.webtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pte.mik.habitstatsserver.controller.stat.GoalController;
import pte.mik.habitstatsserver.dto.CreateGoalDto;
import pte.mik.habitstatsserver.entity.stat.Goal;
import pte.mik.habitstatsserver.entity.stat.Stat;
import pte.mik.habitstatsserver.entity.stat.StatCategory;
import pte.mik.habitstatsserver.entity.stat.UnitType;
import pte.mik.habitstatsserver.repository.stat.GoalRepository;
import pte.mik.habitstatsserver.repository.stat.StatRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class GoalControllerTest {

    @Autowired
    private GoalController controller;
    @Autowired
    GoalRepository repository;
    @Autowired
    StatRepository statRepository;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    @Transactional
    public void create() throws Exception{
        CreateGoalDto goalDto = new CreateGoalDto("Test title", 99f, "<=", false,new ArrayList<>(latestStat().getId()));
        assertThat(controller.create(goalDto)).isEqualTo("Done!");
    }

    @Test
    public void read() throws Exception{
        assertThat(controller.listAll().stream().map(Goal::getId).filter(integer -> integer.equals(latestGoal().getId())).findFirst().isPresent());
    }

    @Test
    @Transactional
    public void delete() throws Exception{
        Integer idActedOn = latestGoal().getId();
        assertThat(controller.delete(idActedOn)).isEqualTo("Done!");
    }

    private Goal latestGoal(){
        return controller.listAll().stream().max(Comparator.comparing(Goal::getId)).get();
    }
    private Stat latestStat(){
        return statRepository.findAll().stream().max(Comparator.comparing(Stat::getId)).get();
    }
}
