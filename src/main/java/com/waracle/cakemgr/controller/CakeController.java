package com.waracle.cakemgr.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.waracle.cakemgr.model.Cake;
import com.waracle.cakemgr.service.CakeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@Slf4j
public class CakeController {

    private final CakeService service;

    private final ObjectMapper objectMapper;

    public CakeController(CakeService service, ObjectMapper objectMapper) {
        this.service = service;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/cakes")
    public void postCake(@Valid @RequestBody Cake cake) {
        log.debug("POST cake {}", cake);
        service.add(cake);
    }

    @GetMapping(value = "/cakes/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public byte[] downloadCakes() throws IOException {
        log.debug("Download cakes");
        List<Cake> cakes = service.getAll();
        return objectMapper.writeValueAsBytes(cakes);
    }

    @GetMapping("/cakes")
    public List<Cake> getCakes() {
        log.debug("Get cakes");
        return service.getAll();
    }


}
