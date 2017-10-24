package vn.menugo.server.controller;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.menugo.server.exception.FailedCreatingEx;
import vn.menugo.server.model.Category;
import vn.menugo.server.model.Mon;
import vn.menugo.server.model.Provider;
import vn.menugo.server.model.Wrap;
import vn.menugo.server.service.CategoryService;
import vn.menugo.server.service.ProviderService;

import java.util.List;
import java.util.UUID;

/**
 * Created by itn0309 on 7/8/2017.
 */
@Api(tags = "Category")
@RestController
@RequestMapping("/category")
public class CategoryController {

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    private final CategoryService categoryService;
    private final ProviderService providerService;


    @Autowired
    public CategoryController(CategoryService categoryService, ProviderService providerService) {
        this.categoryService = categoryService;
        this.providerService = providerService;
    }

    @RequestMapping(value = "/p", produces = {"application/json", "text/json"}, method = RequestMethod.GET)
    public ResponseEntity getCategoriesByProvider(@RequestParam("pid") UUID pid) {
        List<Category> list = categoryService.findAllByProviderUuid(pid);
        Wrap w = new Wrap<>(list);
        return new ResponseEntity<>(w, HttpStatus.OK);
    }

}
