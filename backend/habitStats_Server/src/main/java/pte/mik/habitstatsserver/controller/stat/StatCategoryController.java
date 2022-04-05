package pte.mik.habitstatsserver.controller.stat;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pte.mik.habitstatsserver.entity.stat.StatCategory;
import pte.mik.habitstatsserver.service.stat.StatCategoryService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/category")
public class StatCategoryController {

    @Autowired
    private StatCategoryService statCategoryService;

    @GetMapping
    public List<StatCategory> listAllCategory() {
        return statCategoryService.listAllCategory();
    }

    @PostMapping
    public String createCategory(@RequestBody StatCategory category) {
        return statCategoryService.createCategory(category);
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable("id") Integer id) {
        return statCategoryService.deleteCategory(id);
    }
}
