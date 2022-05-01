package pte.mik.habitstatsserver.controller.stat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pte.mik.habitstatsserver.entity.stat.UnitType;
import pte.mik.habitstatsserver.service.stat.UnitTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/unit")
public class UnitTypeController {

    private final UnitTypeService unitTypeService;

    public UnitTypeController(@Autowired UnitTypeService unitTypeService) {
        this.unitTypeService = unitTypeService;
    }

    @GetMapping
    public List<UnitType> listAll(){return unitTypeService.listAll();}

    @GetMapping("/{id}")
    public UnitType getById(@PathVariable("id") Long id){return unitTypeService.getById(id);}

    @PostMapping
    public String create(UnitType unitType){return unitTypeService.create(unitType);}

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){return unitTypeService.delete(id);}
}
