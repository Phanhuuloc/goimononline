package vn.menugo.server.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.menugo.server.service.ProviderService;
import vn.menugo.server.model.Category;
import vn.menugo.server.model.Provider;
import vn.menugo.server.model.Wrap;

import java.util.Set;
import java.util.UUID;


/**
 * Created by itn0309 on 6/11/2017.
 */
@Api(tags = "Provider")
@RestController
@RequestMapping("/provider")
public class ProviderController {

    private final ProviderService providerService;

    @Autowired
    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }


    @PostMapping(value = "", produces = {"application/json", "text/json"})
    public ResponseEntity createProvider(@RequestParam String name,
                                         @RequestParam(defaultValue = "https://media.foody.vn/res/g13/126459/prof/s576x330/foody-mobile-12-jpg-972-636149689500469055.jpg") String image,
                                         @RequestParam(defaultValue = "Nhà Hàng Ẩm Thực Gà Hàn Quốc") String description,
                                         @RequestParam(defaultValue = "16 Lê Quý Đôn,  Quận 3, TP. HCM") String address,
                                         @RequestParam(defaultValue = "https://www.foody.vn/ho-chi-minh/nha-hang-am-thuc-ga-boom-dak") String url,
                                         @RequestParam(defaultValue = "10.300003") double latitude,
                                         @RequestParam(defaultValue = "106.000006") double longitude,
                                         @RequestParam(defaultValue = "Trưa - Tối: 11:00 - 22:00") String openHour,
                                         @RequestParam(defaultValue = "8.2") double star) {
        Provider provider = new Provider(name, image, description, address, url, latitude, longitude, openHour, star);
        providerService.create(provider);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/cat", produces = {"application/json", "text/json"})
    public ResponseEntity createCategory(@RequestParam UUID pid, @RequestParam String name) {
        providerService.createCategory(pid, name);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/mon", produces = {"application/json", "text/json"})
    public ResponseEntity createMon(@RequestParam UUID pid, @RequestParam String cname, @RequestParam String name,
                                    @RequestParam int price, @RequestParam String des, @RequestParam String note) {
        providerService.fetchMon(pid, cname, name, price, des, note);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/list", produces = {"application/json", "text/json"})
    public ResponseEntity getProviders() {
        return new ResponseEntity<>(new Wrap<>(providerService.findAll()), HttpStatus.OK);
    }

    @GetMapping(value = "/{uuid}/menu", produces = {"application/json", "text/json"})
    public ResponseEntity getMenu(@PathVariable("uuid") UUID uuid) {
        Set<Category> categories = providerService.getOne(uuid).getCategories();
        return new ResponseEntity<>(new Wrap<>(categories), HttpStatus.OK);
    }

    @GetMapping(value = "/{uuid}/category", produces = {"application/json", "text/json"})
    public ResponseEntity getCategory(@PathVariable("uuid") UUID uuid) {
        Set<Category> categories = providerService.getOne(uuid).getCategories();
        return new ResponseEntity<>(new Wrap<>(categories), HttpStatus.OK);
    }

    @GetMapping(value = "/{uuid}", produces = {"application/json", "text/json"})
    public ResponseEntity getProvider(@PathVariable("uuid") UUID uuid) {
        return new ResponseEntity<>(providerService.getOne(uuid), HttpStatus.OK);
    }
}
