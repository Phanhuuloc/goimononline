//package vn.menugo.server.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import vn.menugo.server.Service.UserRepositoryService;
//import vn.menugo.server.model.Bill;
//import vn.menugo.server.model.Provider;
//import vn.menugo.server.model.Client;
//import vn.menugo.server.model.Wrap;
//
//import java.util.List;
//import java.util.UUID;
//
///**
// * Created by itn0309 on 8/20/2017.
// */
//@RestController
//@RequestMapping("/user")
//public class UserController {
//
//    private final UserRepositoryService uService;
//
//    @Autowired
//    public UserController(UserRepositoryService uService) {
//        this.uService = uService;
//    }
//
//    @GetMapping(value="list",  produces = {"application/json", "text/json"})
//    public ResponseEntity getUsers () {
//        return new ResponseEntity<>(uService.findAll(), HttpStatus.OK);
//    }
//
//    @PostMapping(value="",produces = {"application/json", "text/json"})
//    public ResponseEntity createUser (@RequestBody Client user) {
//        uService.create(user);
//        return new ResponseEntity<>(String.format("Create user %s successfully",user.getName()), HttpStatus.CREATED);
//    }
//
//    @GetMapping(value="{uuid}/bill",  produces = {"application/json", "text/json"})
//    public ResponseEntity<Wrap> getBills (@PathVariable("uuid") UUID uuid ) {
//        Client user = uService.findByUuid(uuid);
//        List<Bill> bills = user.getBills();
//        Wrap w = new Wrap<>(bills);
//        return new ResponseEntity<Wrap>(w, HttpStatus.OK);
//    }
//
//}
