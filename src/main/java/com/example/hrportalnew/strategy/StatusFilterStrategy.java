package com.finalproject.hrportal.strategy;


import com.finalproject.hrportal.dto.CandidateFilterRequestDTO;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StatusFilterStrategy implements CandidateFilterStrategy {
    @Override
    public Optional<String> createCondition(CandidateFilterRequestDTO req, MapSqlParameterSource params) {
        if (req.getStatus() == null || req.getStatus().isBlank()) {
            return Optional.empty();
        }
        params.addValue("status", req.getStatus());
        return Optional.of("ca.status = :status");
    }
}

