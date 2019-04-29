package com.waracle.cakemgr.controller;

import com.waracle.cakemgr.model.Cake;
import com.waracle.cakemgr.service.CakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CakeRestController {

    @Autowired
    CakeService service;

    @GetMapping("/cakes")
    public List<Cake> getCakes() {
        return service.getAll();
    }

    @PutMapping("/cakes")
    public void putCake(@RequestBody Cake cake) {
        service.add(cake);
    }
}
