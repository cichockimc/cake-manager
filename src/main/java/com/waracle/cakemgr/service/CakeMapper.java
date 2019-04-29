package com.waracle.cakemgr.service;

import com.waracle.cakemgr.dao.CakeEntity;
import com.waracle.cakemgr.model.Cake;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CakeMapper {

    @Autowired
    ModelMapper mapper;

    public Cake entityToModel(CakeEntity entity) {
        return mapper.map(entity, Cake.class);
    }

    public CakeEntity modelToEntity(Cake cake) {
        return mapper.map(cake, CakeEntity.class);
    }
}
