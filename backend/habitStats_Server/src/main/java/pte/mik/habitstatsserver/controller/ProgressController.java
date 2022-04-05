package pte.mik.habitstatsserver.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pte.mik.habitstatsserver.entity.Progress;
import pte.mik.habitstatsserver.service.ProgressService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/progress")
public class ProgressController {

    @Autowired
    private ProgressService progressService;

    @GetMapping
    public List<Progress> listAll(){
        return progressService.listAll();
    }

    @GetMapping("/{id}")
    public Progress getById(@PathVariable("id") Integer id){
        return progressService.getById(id);
    }

    @GetMapping("/stat/{id}")
    public List<Progress> getByStatId(@PathVariable("id") Integer statId){return progressService.getByStatId(statId);}

    @PostMapping
    public String create(@RequestBody Progress progress){
        return progressService.create(progress);
    }

    @PutMapping
    public String edit(@RequestBody Progress progress){
        return progressService.edit(progress);
    }

    @DeleteMapping
    public String deleteById(Integer id){
        return progressService.deleteById(id);
    }
}
