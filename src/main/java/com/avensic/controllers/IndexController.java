package com.avensic.controllers;

import com.avensic.model.Category;
import com.avensic.model.UnitOfMeasure;
import com.avensic.repositories.CategoryRepository;
import com.avensic.repositories.UnitOfMeasureRepository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

public class IndexController {
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage() {

        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");


        System.out.println("Cat Id is: " + categoryOptional.get().getId());
        System.out.println("UoM Id is: " + unitOfMeasureOptional.get().getId());

        return "index";
    }
}
