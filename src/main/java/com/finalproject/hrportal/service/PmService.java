package com.finalproject.hrportal.service;


import com.finalproject.hrportal.dto.*;

import java.util.List;

public interface PmService {
    ProjectResponseDTO createProject( ProjectRequestDTO projectRequestDTO,String loginPmId);
    List<String> getEmployeeByRole(String role);
    List<EmployeeResponseDTO> getEmployeesOnBench();
    boolean setProjectIdToEmployee(int jobRequestId,String employeeId);
    List<PmJobRequestResponseDTO> getAllJobRequestByPmId(String pmId);
    boolean forwardToHr(HrForwardDTO hrForwardDTO, int jobRequestId);
    ProjectResponseDTO getProjectByIdWithTeamLeaderName(int projectId);
}
