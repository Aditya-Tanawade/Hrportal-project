package com.finalproject.hrportal.strategy;

import com.finalproject.hrportal.dto.CandidateFilterRequestDTO;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.util.Optional;

public interface CandidateFilterStrategy {
    /**
     * Returns Optional SQL fragment (without leading "AND"/"WHERE").
     * Implementations add param values into the provided MapSqlParameterSource.
     */
    Optional<String> createCondition(CandidateFilterRequestDTO req, MapSqlParameterSource params);
}
