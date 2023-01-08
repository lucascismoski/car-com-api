package com.fiorin.springboot.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendorController {
    private final VendorRepository vendorRepository;

    public VendorController(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @GetMapping("/vendors")
    public Iterable<Vendor> getVendors() {
        return vendorRepository.findAll();
        //return new Vendor(1,"Lucas", 1000, "04/06/2018 00:00:00", "04/06/2018 00:00:00", "04/06/2018 00:00:00");
    }
}
