package com.example.nadahassanplatform.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PageableDTO {

    @JsonProperty("offset")
    private Long offset;

    @JsonProperty("pageNumber")
    private Integer pageNumber;

    @JsonProperty("pageSize")
    private Integer pageSize;

    @JsonProperty("paged")
    private Boolean paged;

    @JsonProperty("sort")
    private SortDTO sort;

    @JsonProperty("unPaged")
    private Boolean unPaged;
}
