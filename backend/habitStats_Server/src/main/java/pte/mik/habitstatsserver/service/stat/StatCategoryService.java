package pte.mik.habitstatsserver.service.stat;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pte.mik.habitstatsserver.entity.stat.StatCategory;
import pte.mik.habitstatsserver.repository.stat.StatCategoryRepository;

import java.util.List;

import static pte.mik.habitstatsserver.service.TryCatchService.tryFunction;


@Service
@AllArgsConstructor
public class StatCategoryService {

    @Autowired
    StatCategoryRepository categoryRepository;

    public List<StatCategory> listAllCategory() {
        return categoryRepository.findAll();
    }

    public StatCategory getCategoryById(Integer id){
        return categoryRepository.findById(id).get();
    }

    public String createCategory(StatCategory statCategory) {
        if (!categoryRepository.existsById(statCategory.getId())) {
            return tryFunction(() -> categoryRepository.save(statCategory));
        } else {
            return "Already made!";
        }
    }

    public String deleteCategory(Integer id) {
        return tryFunction(() -> categoryRepository.deleteById(id));
    }
}
