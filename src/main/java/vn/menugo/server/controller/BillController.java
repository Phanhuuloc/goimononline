//package vn.menugo.server.controller;
//
//import io.swagger.annotations.Api;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import vn.menugo.server.Exception.FailedCreatingEx;
//import vn.menugo.server.Service.BillRepositoryService;
//import vn.menugo.server.Service.MenuItemRepositoryService;
//import vn.menugo.server.Service.UserRepositoryService;
//import vn.menugo.server.model.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import vn.menugo.server.utils.ItemUtil;
//
//import java.util.Date;
//import java.util.List;
//import java.util.UUID;
//
///**
// * Created by itn0309 on 8/2/2017.
// */
//@RestController
//@RequestMapping("/bill")
//public class BillController {
//
//    private static final Logger logger = LoggerFactory.getLogger(BillController.class);
//    private static final int OPENING = 0;
//    private static final int CLOSED = 1;
//    private final BillRepositoryService bService;
//
//    private final UserRepositoryService uService;
//
//    private final MenuItemRepositoryService mService;
//
//    @Autowired
//    public BillController(BillRepositoryService bService, UserRepositoryService uService, MenuItemRepositoryService mService) {
//        this.bService = bService;
//        this.uService = uService;
//        this.mService = mService;
//    }
//
//    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
//    public ResponseEntity<String> createBill(@RequestBody Bill bill) {
//
//        String result;
////        Bill b = new Bill(UUID.randomUUID(), bill.getType());
////        Client user = uService.findByUuid(bill.getClient().getUuid());
////
////        b.setClient(user);
////        b.setListItem(bill.getListItem());
////        b.setStatus(OPENING);
////        b.setDate(new Date());
////
////        //Count price for all items of the bill
////        List<Mon> fullList = mService.findFullObjects(bill.getListItem());
////        long price = ItemUtil.countPrice(fullList);
////        b.setPrice(price);
////
////        try {
////            bService.create(b);
////        } catch (Exception e) {
////            result = "Create bill failed";
////            logger.error(result, e);
////            throw new FailedCreatingEx(result);
////        }
////
////        user.getBills().add(b);
////        uService.update(user);
//
//        result = String.format("Create bill successfully");
//        return new ResponseEntity<String>(result, HttpStatus.CREATED);
//    }
//
//    //View info Basic of a bill
//    @GetMapping(value = "{uuid}", produces = {"application/json", "text/json"})
//    public ResponseEntity<Wrap> getBill(@PathVariable("uuid") UUID uuid) {
//        Bill bill = bService.findByUuid(uuid);
//        Wrap w = new Wrap<Bill>(bill);
//        return new ResponseEntity<>(w, HttpStatus.OK);
//    }
//
//    //View list menuItem of a bill
//    @RequestMapping(value = "{uuid}/menu", produces = {"application/json", "text/json"}, method = RequestMethod.GET)
//    public ResponseEntity getMenu(@PathVariable("uuid") UUID uuid) {
//        Bill bill = bService.findByUuid(uuid);
//        List<Mon> menu = bill.getListItem();
//        Wrap w = new Wrap<>(menu);
//
//        return new ResponseEntity<>(w, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "status", produces = {"application/json", "text/json"}, method = RequestMethod.POST)
//    public ResponseEntity<String> updateBillStatus(@RequestBody Bill specBill) {
//        String result;
//        Bill bill = bService.findByUuid(specBill.getUuid());
//        if (bill != null) {
//            bill.setStatus(specBill.getStatus());
//            try {
//                bService.update(bill);
//                result = String.format("update status for bill %s successfully", specBill.getUuid());
//                logger.info(result);
//            } catch (Exception e) {
//                result = String.format("update status for bill %s failed", specBill.getUuid());
//                logger.error(result, e);
//                throw new FailedCreatingEx(result);
//            }
//        } else {
//            result = String.format("Cannot find the bill %s ", specBill.getUuid());
//            logger.error("result");
//        }
//        return new ResponseEntity<String>(result, HttpStatus.CREATED);
//    }
//}
//
//
