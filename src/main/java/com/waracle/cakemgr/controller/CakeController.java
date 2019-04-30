package com.waracle.cakemgr.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.waracle.cakemgr.model.Cake;
import com.waracle.cakemgr.service.CakeService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class CakeController {

    final CakeService service;

    final ObjectMapper objectMapper;

    public CakeController(CakeService service, ObjectMapper objectMapper) {
        this.service = service;
        this.objectMapper = objectMapper;
    }

    @PutMapping("/cakes")
    public void putCake(@RequestBody Cake cake) {
        service.add(cake);
    }

    @GetMapping(value = "/cakes", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public byte[] getCakes() throws IOException {
        List<Cake> cakes = service.getAll();
        return objectMapper.writeValueAsBytes(cakes);
    }

}
