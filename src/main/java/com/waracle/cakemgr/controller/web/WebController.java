package com.waracle.cakemgr.controller.web;

import com.waracle.cakemgr.dao.CakeEntity;
import com.waracle.cakemgr.dao.CakeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Slf4j
public class WebController {

    @Autowired
    CakeRepository repository;

    @GetMapping("/")
    public String index(Model model) {
        log.debug("Received index request");
        List<CakeEntity> cakes = repository.findAll();
        log.trace("Found {} entities", cakes.size());
        model.addAttribute("cakes", cakes);
        return "index";
    }
}
