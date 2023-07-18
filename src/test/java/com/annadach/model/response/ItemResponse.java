package com.annadach.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemResponse {

    @JsonProperty("result")
    public Result result;

    @JsonProperty("message")
    public Result message;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Result {

        @JsonProperty("id")
        public Integer id;

        @JsonProperty("name")
        public String name;

        @JsonProperty("section")
        public String section;

        @JsonProperty("description")
        public String description;

        @JsonProperty("color")
        public String color;

        @JsonProperty("price")
        public Double price;

        @JsonProperty("params")
        public String params;
    }
}
