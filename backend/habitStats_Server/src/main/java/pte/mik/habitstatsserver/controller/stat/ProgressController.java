package pte.mik.habitstatsserver.controller.stat;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pte.mik.habitstatsserver.entity.stat.ActionProgressDto;
import pte.mik.habitstatsserver.entity.stat.Progress;
import pte.mik.habitstatsserver.service.stat.ProgressService;

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


    @GetMapping("/stat/{id}")
    public List<Progress> getByStatId(@PathVariable("id") Integer statId){return progressService.getByStatId(statId);}
    
    @PostMapping
    public String create(@RequestBody ActionProgressDto progress){
        return progressService.create(progress);
    }

    @PutMapping
    public String edit(@RequestBody ActionProgressDto progress){
        return progressService.edit(progress);
    }

    @DeleteMapping
    public String deleteById(Integer id){
        return progressService.deleteById(id);
    }
}
