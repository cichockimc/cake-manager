package com.waracle.cakemgr.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

@Data
public class Cake {

    @JsonProperty(access = READ_ONLY)
    Integer id;

    @NotBlank
    String title;

    @JsonProperty("desc")
    String description;

    @URL
    String image;
}
