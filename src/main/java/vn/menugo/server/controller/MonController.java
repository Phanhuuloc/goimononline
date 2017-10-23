package vn.menugo.server.controller;


import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.menugo.server.model.Mon;
import vn.menugo.server.model.Wrap;
import vn.menugo.server.service.MonServices;

import java.util.UUID;

@Api(tags = "Mon")
@RestController
@RequestMapping("/mon")
public class MonController {

    private final MonServices monService;

    @Autowired
    public MonController(MonServices monService) {
        this.monService = monService;
    }

    @GetMapping(value = "/list", produces = {"application/json", "text/json"})
    public ResponseEntity getMons() {
        return new ResponseEntity<>(new Wrap<>(monService.findAll()), HttpStatus.OK);
    }

//    @GetMapping(value = "", produces = {"application/json", "text/json"})
//    public ResponseEntity getMonsByProviderAndCategory(@RequestParam("pid") UUID pid,@RequestParam("cat") String cat ) {
//        Set<Mon> mons = monService.getOne(pid).getMons();
//        return new ResponseEntity<>(new Wrap<>(mons), HttpStatus.OK);
//    }
//
//    @GetMapping(value = "/{pid}/{cid}/mon", produces = {"application/json", "text/json"})
//    public ResponseEntity getMonsByProviderAndCategory(@PathVariable("pid") UUID pid) {
//        Set<Mon> mons = providerService.getOne(pid).getCategories();
//        return new ResponseEntity<>(new Wrap<>(mons), HttpStatus.OK);
//    }
}
