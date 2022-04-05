package pte.mik.habitstatsserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pte.mik.habitstatsserver.entity.Goal;
import pte.mik.habitstatsserver.service.GoalService;

import java.util.List;

@RestController
@RequestMapping("/api/goal")
public class GoalController {

    @Autowired
    private GoalService goalService;

    @GetMapping
    public List<Goal> listAll(){
        return goalService.listAll();
    }

    @PostMapping
    public String create(@RequestBody Goal goal){
        return goalService.create(goal);
    }
    @PutMapping
    public String edit(@RequestBody Goal goal){
        return goalService.edit(goal);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Integer id){
        return goalService.delete(id);
    }
}
