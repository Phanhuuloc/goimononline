package vn.menugo.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.menugo.server.repo.CategoryRepository;
import vn.menugo.server.model.Category;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;


    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
