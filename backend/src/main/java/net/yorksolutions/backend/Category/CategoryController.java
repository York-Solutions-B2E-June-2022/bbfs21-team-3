package net.yorksolutions.backend.Category;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {

    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/list")
    public ArrayList<String> list() {
       return categoryService.list();
    }

    @PostMapping("/create")
    public void create(@RequestBody CategoryReq requestBody) {
        categoryService.create(requestBody.category);
    }

}

class CategoryReq {

    public String category;
}
