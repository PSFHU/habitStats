package pte.mik.habitstatsserver.webtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pte.mik.habitstatsserver.controller.stat.StatCategoryController;
import pte.mik.habitstatsserver.entity.stat.StatCategory;
import pte.mik.habitstatsserver.repository.stat.StatCategoryRepository;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class StatCategoryControllerTest {

    @Autowired
    private StatCategoryController controller;
    @Autowired
    StatCategoryRepository statCategoryRepository;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    @Transactional
    public void create() throws Exception{
        StatCategory statCategory = new StatCategory();
        statCategory.setId(latestCategory().getId());
        statCategory.setName("Teszt");
        assertThat(controller.createCategory(statCategory)).isEqualTo("Done!");
    }

    @Test
    public void read() throws Exception{
        assertThat(controller.listAllCategory().stream().map(StatCategory::getId).filter(integer -> integer.equals(latestCategory().getId())).findFirst().isPresent());
    }

    @Test
    @Transactional
    public void delete() throws Exception{
        Integer idActedOn = latestCategory().getId();
        assertThat(controller.deleteCategory(idActedOn)).isEqualTo("Done!");
    }

    private StatCategory latestCategory(){
        return controller.listAllCategory().stream().max(Comparator.comparing(StatCategory::getId)).get();
    }
}
