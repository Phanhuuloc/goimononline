package vn.menugo.server.controller;

import com.sun.javadoc.Tag;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import vn.menugo.server.Service.ProviderService;
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


    @PostMapping(value = "",consumes = MediaType.ALL_VALUE,
            produces = {MediaType.ALL_VALUE})
    public ResponseEntity createProvider(@RequestBody Provider provider) {
        providerService.create(provider);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "list", produces = {"application/json", "text/json"})
    public ResponseEntity getProviders() {
        return new ResponseEntity(new Wrap<Provider>(providerService.findAll()), HttpStatus.OK);
    }

    @GetMapping(value = "{uuid}/menu", produces = {"application/json", "text/json"})
    public ResponseEntity getMenu(@PathVariable("uuid") UUID uuid) {
        Set<Category> categories = providerService.getOne(uuid).getCategories();
        return new ResponseEntity(new Wrap<>(categories), HttpStatus.OK);
    }

    @GetMapping(value = "{uuid}/category", produces = {"application/json", "text/json"})
    public ResponseEntity getCategory(@PathVariable("uuid") UUID uuid) {
        Set<Category> categories = providerService.getOne(uuid).getCategories();
        return new ResponseEntity(new Wrap<>(categories), HttpStatus.OK);
    }

    @GetMapping(value = "{uuid}", produces = {"application/json", "text/json"})
    public ResponseEntity getProvider(@PathVariable("uuid") UUID uuid) {
        return new ResponseEntity(providerService.getOne(uuid), HttpStatus.OK);
    }
}
