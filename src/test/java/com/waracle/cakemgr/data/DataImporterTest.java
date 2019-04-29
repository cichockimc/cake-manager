package com.waracle.cakemgr.data;

import com.waracle.cakemgr.dao.CakeEntity;
import com.waracle.cakemgr.dao.CakeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataImporterTest {

    @Autowired
    CakeRepository repository;

    @Test
    public void init() {
        List<CakeEntity> all = repository.findAll();
        assertEquals(20L, all.size());
    }
}