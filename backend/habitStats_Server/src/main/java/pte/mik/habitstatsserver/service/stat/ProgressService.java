package pte.mik.habitstatsserver.service.stat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pte.mik.habitstatsserver.entity.stat.Progress;
import pte.mik.habitstatsserver.repository.stat.ProgressRepository;
import pte.mik.habitstatsserver.repository.stat.StatRepository;

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
        return progressRepository.findById(id).get();
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
