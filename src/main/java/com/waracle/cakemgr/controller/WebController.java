package com.waracle.cakemgr.controller;

import com.waracle.cakemgr.service.CakeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class WebController {

    private final CakeService service;

    public WebController(CakeService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model model) {
        log.debug("Received index request");
        model.addAttribute("cakes", service.getAll());
        return "index";
    }
}
