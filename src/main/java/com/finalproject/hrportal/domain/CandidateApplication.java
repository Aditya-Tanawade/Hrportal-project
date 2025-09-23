package com.finalproject.hrportal.domain;

import com.finalproject.hrportal.domain.enums.CandidateApplicationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateApplication {
    private int applicationId;
    private int candidateId;
    private int jobRequestId;
    private LocalDate appliedAt;
    private CandidateApplicationStatus status;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
