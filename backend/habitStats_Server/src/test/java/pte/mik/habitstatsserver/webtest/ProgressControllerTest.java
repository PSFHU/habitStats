package pte.mik.habitstatsserver.webtest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pte.mik.habitstatsserver.controller.stat.ProgressController;
import pte.mik.habitstatsserver.entity.stat.ActionProgressDto;
import pte.mik.habitstatsserver.entity.stat.Progress;
import pte.mik.habitstatsserver.repository.stat.ProgressRepository;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.Comparator;

@SpringBootTest
public class ProgressControllerTest {

    @Autowired
    private ProgressController controller;
    @Autowired
    ProgressRepository progressRepository;

    private final Integer testStatId = 1;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    @Transactional
    public void create() throws Exception{
        ActionProgressDto actionProgressDto = new ActionProgressDto(0,1,99f, Instant.now());
        assertThat(controller.create(actionProgressDto)).isEqualTo("Done!");
        assertThat(actionProgressDto.getTimestamp()).isIn(latestProgress().getTimestamp());
    }

    @Test
    public void read() throws Exception{
        assertThat(controller.getByStatId(latestProgress().getStat().getId()).stream().map(Progress::getId).filter(integer -> integer.equals(latestProgress())).findFirst().isPresent());
        assertThat(controller.listAll().stream().map(Progress::getId).filter(integer -> integer.equals(latestProgress())).findFirst().isPresent());
    }

    @Test
    @Transactional
    public void update() throws Exception{
        ActionProgressDto actionProgressDto = new ActionProgressDto(latestProgress().getId(),1,88f, Instant.now());

        assertThat(controller.edit(actionProgressDto)).isEqualTo("Done!");
        assertThat(actionProgressDto.getValue()).isEqualTo(latestProgress().getValue());
    }

    @Test
    @Transactional
    public void delete() throws Exception{
        Integer idActedOn = latestProgress().getId();
        assertThat(controller.deleteById(idActedOn)).isEqualTo("Done!");
        assertThat(progressRepository.existsById(idActedOn)).isFalse();
    }

    private Progress latestProgress(){
        return controller.getByStatId(testStatId).stream().max(Comparator.comparing(Progress::getId)).get();
    }
}
