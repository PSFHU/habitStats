package pte.mik.habitstatsserver.controller;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pte.mik.habitstatsserver.entity.StatCategory;
import pte.mik.habitstatsserver.service.StatCategoryService;

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

    @DeleteMapping
    public String deleteCategory(@RequestBody StatCategory category) {
        return statCategoryService.deleteCategory(category);
    }
}
