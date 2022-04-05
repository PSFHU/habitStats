package pte.mik.habitstatsserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pte.mik.habitstatsserver.entity.Progress;
import pte.mik.habitstatsserver.entity.StatCategory;
import pte.mik.habitstatsserver.repository.ProgressRepository;
import pte.mik.habitstatsserver.repository.StatRepository;

import java.util.List;

import static pte.mik.habitstatsserver.service.TryCatchService.tryFunction;

@Service
public class ProgressService {

    @Autowired
    ProgressRepository progressRepository;
    @Autowired
    StatRepository statRepository;

    public List<Progress> listAll(){
        return progressRepository.findAll();
    }

    public List<Progress> getByStatId(Integer statId) { return progressRepository.getByStatId(statId);}

    public Progress getById(Integer id){
        return progressRepository.getById(id);
    }

    public String create(Progress progress) {
        progress.setStat(statRepository.getById(progress.getStat().getId()));
        return  tryFunction(()->progressRepository.save(progress));
    }

    public String edit(Progress progress) {
        if (progressRepository.existsById(progress.getId())){
            return tryFunction(()->progressRepository.save(progress));
        }
        else
            return "Progress doesn't exists";
    }

    public String deleteById(Integer id){
        return tryFunction(()->progressRepository.deleteById(id));
    }

}
