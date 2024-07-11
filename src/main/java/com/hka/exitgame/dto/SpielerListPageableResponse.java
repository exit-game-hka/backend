package com.hka.exitgame.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hka.exitgame.entities.Spieler;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SpielerListPageableResponse {

    @JsonProperty("pageContent")
    private List<Spieler> pageContent;

    @JsonProperty("pageNumber")
    private Integer pageNumber;

    @JsonProperty("pageSize")
    private Integer pageSize;

    @JsonProperty("totalElements")
    private Long totalElements;

    @JsonProperty("totalPages")
    private Integer totalPages;

    @JsonProperty("isFirst")
    private Boolean isFirst;

    @JsonProperty("isLast")
    private Boolean isLast;
}
