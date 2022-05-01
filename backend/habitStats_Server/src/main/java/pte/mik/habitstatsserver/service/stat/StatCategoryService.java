package pte.mik.habitstatsserver.service.stat;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pte.mik.habitstatsserver.entity.stat.StatCategory;
import pte.mik.habitstatsserver.repository.stat.StatCategoryRepository;

import java.util.List;

import static pte.mik.habitstatsserver.service.TryCatchService.tryFunction;


@Service
public class StatCategoryService {

    StatCategoryRepository categoryRepository;

    public StatCategoryService(@Autowired StatCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<StatCategory> listAllCategory() {
        return categoryRepository.findAll();
    }

    public StatCategory getCategoryById(Long id){
        return categoryRepository.findById(id).get();
    }

    // TODO Introduce DTO
    public String createCategory(StatCategory statCategory) {
        return tryFunction(() -> categoryRepository.save(statCategory));
    }

    public String deleteCategory(Long id) {
        return tryFunction(() -> categoryRepository.deleteById(id));
    }
}
