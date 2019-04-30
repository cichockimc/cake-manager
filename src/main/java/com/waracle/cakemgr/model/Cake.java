package com.waracle.cakemgr.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;

@Data
public class Cake {

    @JsonProperty(access = WRITE_ONLY)
    Integer id;

    String title;

    @JsonProperty("desc")
    String description;

    String image;
}
