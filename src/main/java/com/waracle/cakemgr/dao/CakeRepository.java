package com.waracle.cakemgr.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CakeRepository extends CrudRepository<CakeEntity, Integer> {

    List<CakeEntity> findAll();
}
