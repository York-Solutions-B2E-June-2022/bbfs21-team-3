package net.yorksolutions.backend.Category;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CategoryService {

    CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public ArrayList<String> list() {

        Iterable<Category> categories = categoryRepository.findAll();

        ArrayList<String> data = new ArrayList<String>();

        categories.forEach(category -> data.add(category.getCategory()));

        return data;
    }

    public void create(String catName) {

        Optional<Category> catExist = categoryRepository.findByCategory(catName);

        if (catExist.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        Category category = new Category(catName);

        categoryRepository.save(category);
    }
}
