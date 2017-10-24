package vn.menugo.server.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.menugo.server.model.Mon;

import java.util.List;
import java.util.UUID;

import vn.menugo.server.model.Wrap;
import vn.menugo.server.service.CategoryService;
import vn.menugo.server.service.MonService;

/**
 * Created by itn0309 on 6/13/2017.
 */
@Api(tags = "Mon")
@RestController
@RequestMapping("/item")
public class MonController {

    private final CategoryService categoryService;
    private final MonService monService;

    @Autowired
    public MonController(CategoryService categoryService, MonService monService) {
        this.categoryService = categoryService;
        this.monService = monService;
    }

    @RequestMapping(value = "/c", produces = {"application/json", "text/json"}, method = RequestMethod.GET)
    public ResponseEntity getItem(@RequestParam("cid") UUID cid) {
        List<Mon> items = monService.findAllByCategory(cid);
        Wrap w = new Wrap<>(items);
        return new ResponseEntity<>(w, HttpStatus.OK);
    }
}


