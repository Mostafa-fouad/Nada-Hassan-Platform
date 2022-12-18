package com.example.nadahassanplatform.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import java.util.List;

@Setter
@Getter
@Builder
public class PageDTO {

    @JsonProperty("content")
    @Valid
    private List<Object> content = null;

    @JsonProperty("empty")
    private Boolean empty;

    @JsonProperty("first")
    private Boolean first;

    @JsonProperty("last")
    private Boolean last;

    @JsonProperty("number")
    private Integer number;

    @JsonProperty("numberOfElements")
    private Integer numberOfElements;

    @JsonProperty("pageable")
    private PageableDTO pageable;

    @JsonProperty("size")
    private Integer size;

    @JsonProperty("sort")
    private SortDTO sort;

    @JsonProperty("totalElements")
    private Long totalElements;

    @JsonProperty("totalPages")
    private Integer totalPages;
}
