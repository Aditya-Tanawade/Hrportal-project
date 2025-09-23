package com.finalproject.hrportal.repository.impl;

import com.finalproject.hrportal.domain.Candidate;
import com.finalproject.hrportal.dto.CandidateFilterRequestDTO;
import com.finalproject.hrportal.repository.CandidateRepository;
import com.finalproject.hrportal.rowmapper.CandidateRowMapper;
import com.finalproject.hrportal.strategy.CandidateFilterStrategy;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
@Slf4j
public class CandidateRepositoryImpl implements CandidateRepository {

    private final NamedParameterJdbcTemplate jdbc;
    private final JdbcTemplate jdbcTemplate;
    private final List<CandidateFilterStrategy> strategies;

    @Override
    public List<Candidate> searchCandidates(int jobRequestId, CandidateFilterRequestDTO filter) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        List<String> whereParts = new ArrayList<>();

        // Always filter by jobRequestId
        whereParts.add("ca.job_request_id = :jobRequestId");
        params.addValue("jobRequestId", jobRequestId);

        // Apply other dynamic filters from strategies
        for (CandidateFilterStrategy s : strategies) {
            s.createCondition(filter, params).ifPresent(whereParts::add);
        }

        String where = " WHERE " + String.join(" AND ", whereParts);

        int page = Optional.ofNullable(filter.getPage()).orElse(0);
        int size = Optional.ofNullable(filter.getSize()).orElse(20);
        int offset = page * size;

        params.addValue("offset", offset);
        params.addValue("limit", size);

        String sql =
                "SELECT c.* " +
                        "FROM candidates c " +
                        "JOIN candidate_applications ca ON c.candidate_id = ca.candidate_id " +
                        where +
                        " ORDER BY c.created_at DESC " +
                        " OFFSET :offset ROWS FETCH NEXT :limit ROWS ONLY";

        log.info("Final SQL: {}", sql);
        log.info("Params: {}", params.getValues());

        return jdbc.query(sql, params, new CandidateRowMapper());
    }


    @Override
    public Candidate getCandidateById(int candidateId) {
        String sql="SELECT * FROM candidates WHERE candidate_id=?";
        return jdbcTemplate.queryForObject(sql,new CandidateRowMapper(),candidateId);
    }

}
