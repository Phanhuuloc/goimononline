//package vn.menugo.server.controller;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import vn.menugo.server.Exception.FailedCreatingEx;
//import vn.menugo.server.Repo.CategoryRepository;
//import vn.menugo.server.Service.CategoryRepositoryService;
//import vn.menugo.server.Service.CategoryService;
//import vn.menugo.server.Service.ProviderRepositoryService;
//import vn.menugo.server.model.*;
//
//
//import java.util.List;
//import java.util.UUID;
//
///**
// * Created by itn0309 on 7/8/2017.
// */
//@RestController
//@RequestMapping("/category")
//public class CategoryController {
//
//    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
//
//    private final CategoryService categoryService;
//
//
//    @Autowired
//    public CategoryController(CategoryService categoryService) {
//        this.categoryService = categoryService;
//    }
//
//    @PostMapping(value = "")
//    public ResponseEntity<String> createCategory(Category category) {
//
//        Category c = new Category(UUID.randomUUID(), category.getName(), category.getDefaultImage());
//        Provider provider = pservice.findByUuid(category.getProvider().getUuid());
//        c.setProvider(provider);
//
//        try {
//            service.create(c);
//        } catch (Exception e) {
//            logger.error("Create category failed", e);
//            throw new FailedCreatingEx("Create category failed");
//        }
//
//        provider.getCat().add(c);
//        pservice.update(provider);
//
//        logger.info("Create category successfully");
//        return new ResponseEntity<String>(String.format("Create provider %s successfully", c.getName()), HttpStatus.CREATED);
//    }
//
//    @RequestMapping(value = "list", produces = {"application/json", "text/json"}, method = RequestMethod.GET)
//    public ResponseEntity<Wrap> getCategories() {
//        List<Category> list = service.findAll();
//        Wrap w = new Wrap<>(list);
//        return new ResponseEntity<Wrap>(w, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "{uuid}/menu", produces = {"application/json", "text/json"}, method = RequestMethod.GET)
//    public ResponseEntity getMenu(@PathVariable("uuid") UUID uuid) {
//        Category cat = service.findByUuid(uuid);
//        List<Mon> menu = cat.getMenu();
//        Wrap w = new Wrap<>(menu);
//
//        return new ResponseEntity<>(w, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "{uuid}", produces = {"application/json", "text/json"}, method = RequestMethod.GET)
//    public ResponseEntity getCategory(@PathVariable("uuid") UUID uuid) {
//        Category c = service.findByUuid(uuid);
//
//        return new ResponseEntity<>(c, HttpStatus.OK);
//    }
//}
