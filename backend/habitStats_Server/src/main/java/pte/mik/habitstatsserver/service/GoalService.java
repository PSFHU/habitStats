package pte.mik.habitstatsserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pte.mik.habitstatsserver.entity.Goal;
import pte.mik.habitstatsserver.repository.GoalRepository;

import java.util.List;

import static pte.mik.habitstatsserver.service.TryCatchService.tryFunction;

@Service
public class GoalService {

    @Autowired
    GoalRepository goalRepository;

    public List<Goal> listAll(){
        return goalRepository.findAll();
    }

    // TODO Check progress on Stat

    public String edit(Goal goal){
        if (goalRepository.existsById(goal.getId())){
        return tryFunction(()->goalRepository.save(goal));
    }
    else
        return "Goal doesn't exists";
    }

    // TODO DTO for creating goals
    public String create(Goal goal){return tryFunction(()->goalRepository.save(goal));}

    public String delete(Integer id){return tryFunction(()->goalRepository.deleteById(id));}
}
