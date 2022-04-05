package pte.mik.habitstatsserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import pte.mik.habitstatsserver.dto.ActionStatDto;
import pte.mik.habitstatsserver.entity.Stat;
import pte.mik.habitstatsserver.service.StatService;

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
