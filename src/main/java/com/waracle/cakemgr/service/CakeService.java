package com.waracle.cakemgr.service;

import com.waracle.cakemgr.dao.CakeRepository;
import com.waracle.cakemgr.model.Cake;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CakeService {

    @Autowired
    CakeRepository repository;

    @Autowired
    CakeMapper mapper;

    public List<Cake> getAll() {
        log.trace("Get all called");
        List<Cake> cakes = repository.findAll().stream().map(mapper::entityToModel).collect(Collectors.toList());
        log.trace("Found {} cakes", cakes.size());
        return cakes;
    }

    public Integer add(Cake cake) {
        Integer id = Optional.ofNullable(repository.save(mapper.modelToEntity(cake)).getId()).orElseThrow(() -> new RuntimeException("Saving " + cake + " failed"));
        log.debug("Saved new entity, id: {}", id);
        return id;
    }

}
