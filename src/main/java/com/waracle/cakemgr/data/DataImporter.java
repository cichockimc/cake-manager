package com.waracle.cakemgr.data;

import com.waracle.cakemgr.dao.CakeEntity;
import com.waracle.cakemgr.dao.CakeRepository;
import com.waracle.cakemgr.model.Cake;
import com.waracle.cakemgr.service.CakeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Slf4j
public class DataImporter {

    @Value("${cake-manager.data.url}")
    String url;

    private final RestTemplate restTemplate;

    private final CakeRepository repository;

    private final CakeMapper mapper;

    public DataImporter(RestTemplate restTemplate, CakeRepository repository, CakeMapper mapper) {
        this.restTemplate = restTemplate;
        this.repository = repository;
        this.mapper = mapper;
    }

    @PostConstruct
    public void init() {
        importData();
    }

    private void importData() {
        log.trace("Calling {}", url);
        ResponseEntity<List<Cake>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Cake>>() {
        });
        // no try - catch here, let it fail if something goes wrong
        HttpStatus statusCode = responseEntity.getStatusCode();
        if (statusCode != HttpStatus.OK) {
            throw new RuntimeException("Unexpected http status : " + statusCode);
        }
        Set<CakeEntity> entities = Optional.ofNullable(responseEntity.getBody())
                .map(list ->
                        list.stream()
                                .map(mapper::modelToEntity)
                                .collect(Collectors.toSet())
                ).orElseThrow(() -> new RuntimeException("Import went wrong"));
        log.trace("About to save {} entities", entities.size());
        repository.saveAll(entities);
    }


}
