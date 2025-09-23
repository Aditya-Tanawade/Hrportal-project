package com.finalproject.hrportal.domain;

import com.finalproject.hrportal.domain.enums.ProjectStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    private int projectId;
    private String name;
    private ProjectStatus status;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private double budgetBandMin;
    private double budgetBandMax;
    private LocalDate startDate;
    private LocalDate endDate;
}
