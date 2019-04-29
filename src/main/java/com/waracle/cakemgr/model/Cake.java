package com.waracle.cakemgr.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Cake {

    String title;

    @JsonProperty("desc")
    String description;

    String image;
}
