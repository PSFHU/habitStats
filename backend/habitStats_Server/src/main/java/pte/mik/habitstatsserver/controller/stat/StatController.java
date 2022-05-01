package pte.mik.habitstatsserver.controller.stat;

import java.util.List;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import pte.mik.habitstatsserver.dto.ActionStatDto;
import pte.mik.habitstatsserver.dto.MapperGoalDto;
import pte.mik.habitstatsserver.entity.stat.Stat;
import pte.mik.habitstatsserver.service.stat.StatService;

@RestController
@RequestMapping("/api/stat")
public class StatController {

    private final StatService statService;

    public StatController(@Autowired StatService statService) {
        this.statService = statService;
    }

    @GetMapping
    public List<Stat> listAllStat() {
        return statService.listAllStat();
    }

    @GetMapping("/{id}")
    public Stat getByStatId(@PathVariable("id") Long id){ return statService.getStatById(id);}

    @PostMapping
    public String addStat(@RequestBody ActionStatDto stat) {
        return statService.addStat(stat);
    }

    @PutMapping
    public String editStat(@RequestBody ActionStatDto stat) {
        return statService.editStat(stat);
    }

    @DeleteMapping("/{id}")
    public String deleteStat(@PathVariable Long id) {
        return statService.deleteStat(id);
    }

    // NOTE Goal actions

    @PostMapping("/Goal")
    public String addGoal(MapperGoalDto mapperGoalDto){return statService.addGoal(mapperGoalDto);}

    @DeleteMapping ("/Goal")
    public String removeGoal(MapperGoalDto mapperGoalDto){return statService.deleteGoal(mapperGoalDto);}

    // TODO Implementing Progress actions

    public String addProgress(){return "Not implemented";}
    public String editProgress(){return "Not implemented";}
    public String deleteProgress(){return "Not implemented";}
}
