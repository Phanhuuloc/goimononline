//package vn.menugo.server.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import sun.jvm.hotspot.memory.Universe;
//import vn.menugo.server.Exception.FailedCreatingEx;
//import vn.menugo.server.Service.CategoryRepositoryService;
//import vn.menugo.server.Service.MenuItemRepositoryService;
//import vn.menugo.server.Service.ProviderRepositoryService;
//import vn.menugo.server.model.Category;
//import vn.menugo.server.model.Mon;
//import vn.menugo.server.model.Provider;
//import vn.menugo.server.model.Wrap;
//
//import java.util.List;
//import java.util.Set;
//import java.util.UUID;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
///**
// * Created by itn0309 on 6/13/2017.
// */
//@RestController
//@RequestMapping("/item")
//public class MenuItemController {
//
//    private static final Logger logger = LoggerFactory.getLogger(MenuItemController.class);
//
//    private final MenuItemRepositoryService mService;
//
//    private final ProviderRepositoryService pService;
//
//    private final CategoryRepositoryService cService;
//
//    @Autowired
//    public MenuItemController(MenuItemRepositoryService mService, ProviderRepositoryService pService, CategoryRepositoryService cService) {
//        this.mService = mService;
//        this.pService = pService;
//        this.cService = cService;
//    }
//
//    @PostMapping(value = "", produces = {"application/json", "text/json"})
//    public ResponseEntity<String> createMenuItem(@RequestParam("pid") UUID pid, @RequestParam("cat") String category,
//                                                 @RequestParam String name, @RequestParam String price) {
//        try {
//            mService.createItem(pid, category, name, price);
//            logger.info("Create item successfully");
//            return new ResponseEntity<String>("Create menu successfully", HttpStatus.OK);
//        } catch (Exception ex){
//            logger.info(ex.getMessage());
//            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//
//    }
//
//    @RequestMapping(value = "{uuid}", produces = {"application/json", "text/json"}, method = RequestMethod.GET)
//    public ResponseEntity<Mon> getItem(@PathVariable("uuid") UUID uuid) {
//        Mon item = mService.findByUuid(uuid);
//        return new ResponseEntity<Mon>(item, HttpStatus.OK);
//    }
//}
//
//
