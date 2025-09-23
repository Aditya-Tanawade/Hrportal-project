package com.example.hrportalnew.controller;


import com.finalproject.hrportal.service.PmService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/pm/view")
@RestController
public class PmController {

    private final PmService pmService;

    //To Create Project
    @PostMapping("/add")
    public ResponseEntity<com.finalproject.hrportal.dto.ProjectResponseDTO> createProjectDTO(@RequestBody @Valid ProjectRequestDTO projectRequestDTO, @RequestParam String loginPmId){
        return ResponseEntity.status(HttpStatus.CREATED).body(pmService.createProject(projectRequestDTO,loginPmId));
    }


    //To Get TEAMLEAD TO ASSIGN PROJECT
    @GetMapping("/get/{role}")
    public ResponseEntity<List<String>> getEmployeeByRole(@PathVariable("role") String role){
        return ResponseEntity.ok( pmService.getEmployeeByRole(role));
    }

    //TO GET EMPLOYEES ON BENCH
    @GetMapping("/bench")
    public ResponseEntity<List<EmployeeResponseDTO>>getAllEmployeesOnBench(){
        return ResponseEntity.ok(pmService.getEmployeesOnBench());
    }

    //TO Get ALL JobRequestByPmID
    @GetMapping("/job-requests")
    public ResponseEntity<List<PmJobRequestResponseDTO>>getAllJobRequestByPmId(@RequestParam String pmId){
        return ResponseEntity.ok(pmService.getAllJobRequestByPmId(pmId));
    }

    //TO ASSIGN PROJECT TO RESPECTIVE EMPLOYEE ON BENCH reduce headCount
    @PatchMapping("/{jobRequestId}/assign-project")
    public ResponseEntity<String>assignProject(@PathVariable("jobRequestId") int jobRequestId,@RequestParam String employeeId){

        System.out.println(jobRequestId);
        if(pmService.setProjectIdToEmployee(jobRequestId,employeeId)){
            return ResponseEntity.ok("Project Assigned TO Employee Having Id " + employeeId);
        }
        return ResponseEntity.badRequest().body("Project Not Assigned To Employee");
    }

    @PatchMapping("/forward-hr/{jobRequestId}")
    public ResponseEntity<String> ForwardTohr(@RequestBody HrForwardDTO hrForwardDTO, @PathVariable("jobRequestId")int jobRequestId){
        if(pmService.forwardToHr(hrForwardDTO,jobRequestId)){
            return ResponseEntity.ok("Forwarded To Hr");
        }
        return ResponseEntity.ok("Failed To Forward ");
    }






//    //To Display Project Details Based ON Id
//    @GetMapping("/getProject/{projectId}")
//    public ResponseEntity<ProjectResponseDTO> getProjectByIdWithTeamLeaderName(@PathVariable("projectId") int projectId){
//        return ResponseEntity.ok(pmService.getProjectByIdWithTeamLeaderName(projectId));
//    }








}
