package com.example.nadahassanplatform.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
public class SortDTO {

    @JsonProperty("empty")
    private Boolean empty;

    @JsonProperty("sorted")
    private Boolean sorted;

    @JsonProperty("unsorted")
    private Boolean unsorted;
}
