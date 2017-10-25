package vn.menugo.server.controller;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.menugo.server.model.Bill;
import vn.menugo.server.model.Mon;
import vn.menugo.server.model.Wrap;
import vn.menugo.server.service.BillServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Created by itn0309 on 8/2/2017.
 */
@Api(tags = "Bill")
@RestController
@RequestMapping("/bill")
public class BillController {

    private static final Logger logger = LoggerFactory.getLogger(BillController.class);
    private static final int OPENING = 0;
    private static final int CLOSED = 1;
    private final BillServices bService;


    @Autowired
    public BillController(BillServices bService) {
        this.bService = bService;
    }

    @PostMapping(value = ""/*, consumes = MediaType.ALL_VALUE,
            produces = {MediaType.ALL_VALUE}*/)
    public ResponseEntity createBill(@RequestBody Bill data, @RequestParam("pid") UUID pid) {
        Bill bill = bService.createBill(data, pid);
        if (null != data) {
            return new ResponseEntity<>("success!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/list", produces = {"application/json", "text/json"})
    public ResponseEntity getBills() {
        return new ResponseEntity<>(new Wrap<>(bService.findAll()), HttpStatus.OK);
    }

    //View info Basic of a bill
    @GetMapping(value = "/{uuid}", produces = {"application/json", "text/json"})
    public ResponseEntity getBill(@PathVariable("uuid") UUID uuid) {
        Bill bill = bService.findByUuid(uuid);
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }

    //View list menuItem of a bill
//    @RequestMapping(value = "{uuid}/menu", produces = {"application/json", "text/json"}, method = RequestMethod.GET)
//    public ResponseEntity getMenu(@PathVariable("uuid") UUID uuid) {
//        Bill bill = bService.findByUuid(uuid);
//        Set<Mon> menu = bill.getMons();
//        Wrap w = new Wrap<>(menu);
//        return new ResponseEntity<>(w, HttpStatus.OK);
//    }

//    @RequestMapping(value = "status", produces = {"application/json", "text/json"}, method = RequestMethod.POST)
//    public ResponseEntity<String> updateBillStatus(@PathVariable("uuid") UUID uuid) {
//        String result;
//        Bill bill = bService.findByUuid(uuid);
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
}


