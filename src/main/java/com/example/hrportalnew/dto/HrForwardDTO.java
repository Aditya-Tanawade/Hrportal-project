package com.finalproject.hrportal.dto;


import com.finalproject.hrportal.domain.enums.JobRequestPriority;
import com.finalproject.hrportal.domain.enums.JobRequestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HrForwardDTO {
    private String hrId;
    private JobRequestStatus status;
    private JobRequestPriority priority;
    private double minCtc;
    private double maxCtc;
    private int headCount;
}
