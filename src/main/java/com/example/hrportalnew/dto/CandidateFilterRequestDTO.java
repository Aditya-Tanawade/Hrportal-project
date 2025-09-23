package com.finalproject.hrportal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateFilterRequestDTO {
    private List<String> skills;
    private Double minExperience;
    private Double maxExperience;
    private BigDecimal minExpectedCtc;
    private BigDecimal maxExpectedCtc;
    private String status;
    private Integer noticePeriod;
    private Integer page = 0;
    private Integer size = 20;
}

