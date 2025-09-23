package com.finalproject.hrportal.rowmapper;

import com.finalproject.hrportal.domain.Employee;
import com.finalproject.hrportal.domain.Interview;
import com.finalproject.hrportal.domain.enums.InterviewStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class InterviewRowMapper implements RowMapper<Interview> {
    @Override
    public Interview mapRow(ResultSet rs, int rowNum) throws SQLException {
        int interviewId=rs.getInt("INTERVIEW_ID");
        String employeeId=rs.getString("EMPLOYEE_ID");
        int candidateId=rs.getInt("CANDIDATE_ID");
        int jobRequestId=rs.getInt("JOB_REQUEST_ID");
        int roundNumber=rs.getInt("ROUND_NUMBER");
        InterviewStatus status=InterviewStatus.valueOf(rs.getString("STATUS"));
        String remarks=rs.getString("REMARKS");
        double score=rs.getDouble("SCORE");
        LocalDate createdAt=rs.getDate("CREATED_AT").toLocalDate();
        LocalDate updatedAt=rs.getDate("UPDATED_AT").toLocalDate();
        LocalDate interviewScheduledDate=rs.getDate("INTERVIEW_SCHEDULED_DATE").toLocalDate();
        return new Interview(interviewId,employeeId,candidateId,jobRequestId,roundNumber,status,remarks,score,createdAt,updatedAt,interviewScheduledDate);
    }
}
