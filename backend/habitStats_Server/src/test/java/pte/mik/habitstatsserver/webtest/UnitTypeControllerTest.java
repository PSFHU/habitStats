package pte.mik.habitstatsserver.webtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pte.mik.habitstatsserver.controller.stat.UnitTypeController;
import pte.mik.habitstatsserver.entity.stat.UnitType;
import pte.mik.habitstatsserver.repository.stat.UnitTypeRepository;

import javax.transaction.Transactional;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UnitTypeControllerTest {

    @Autowired
    private UnitTypeController controller;
    @Autowired
    UnitTypeRepository repository;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    @Transactional
    public void create() throws Exception{
        UnitType unitType = new UnitType();
        unitType.setId(latestUnitType().getId());
        unitType.setName("Teszt");
        assertThat(controller.create(unitType)).isEqualTo("Done!");
    }

    @Test
    public void read() throws Exception{
        assertThat(controller.getById(latestUnitType().getId()).getId()).isEqualTo(repository.getById(latestUnitType().getId()).getId());
        assertThat(controller.listAll().stream().map(UnitType::getId).filter(Long -> Long.equals(latestUnitType().getId())).findFirst().isPresent());
    }

    @Test
    @Transactional
    public void delete() throws Exception{
        Long idActedOn = latestUnitType().getId();
        assertThat(controller.delete(idActedOn)).isEqualTo("Done!");
        assertThat(repository.existsById(idActedOn)).isFalse();
    }

    private UnitType latestUnitType(){
        return controller.listAll().stream().max(Comparator.comparing(UnitType::getId)).get();
    }
}
