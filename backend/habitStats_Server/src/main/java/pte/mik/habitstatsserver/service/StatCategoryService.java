package pte.mik.habitstatsserver.service;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pte.mik.habitstatsserver.entity.StatCategory;
import pte.mik.habitstatsserver.repository.StatCategoryRepository;

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
        return categoryRepository.getById(id);
    }

    public String createCategory(StatCategory statCategory) {
        if (!categoryRepository.existsById(statCategory.getId())) {
            return tryFunction(() -> categoryRepository.save(statCategory));
        } else {
            return "Already made!";
        }
    }

    public String deleteCategory(StatCategory statCategory) {
        return tryFunction(() -> categoryRepository.deleteById(statCategory.getId()));
        /*try {
            categoryRepository.delete(statCategory);
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
        return "Done!";*/
    }
}
