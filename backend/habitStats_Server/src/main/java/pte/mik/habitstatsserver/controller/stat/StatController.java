package pte.mik.habitstatsserver.controller.stat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import pte.mik.habitstatsserver.dto.ActionStatDto;
import pte.mik.habitstatsserver.entity.stat.Stat;
import pte.mik.habitstatsserver.service.stat.StatService;

@RestController
@RequestMapping("/api/stat")
@AllArgsConstructor
public class StatController {

    @Autowired
    private StatService statService;

    @GetMapping
    public List<Stat> listAllStat() {
        return statService.listAllStat();
    }

    @GetMapping("/{id}")
    public Stat getByStatId(@PathVariable("id") Integer id){ return statService.getStatById(id);}

    @PostMapping
    public String addStat(@RequestBody ActionStatDto stat) {
        return statService.addStat(stat);
    }

    @PutMapping
    public String editStat(@RequestBody ActionStatDto stat) {
        return statService.editStat(stat);
    }

    @DeleteMapping("/{id}")
    public String deleteStat(@PathVariable Integer id) {
        return statService.deleteStat(id);
    }
}
