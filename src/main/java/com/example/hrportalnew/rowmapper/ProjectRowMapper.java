package com.finalproject.hrportal.rowmapper;

import com.finalproject.hrportal.domain.Project;
import com.finalproject.hrportal.domain.enums.ProjectStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ProjectRowMapper implements RowMapper<Project> {
    @Override
    public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
        int projectId=rs.getInt("project_id");
        String name=rs.getString("name");
        ProjectStatus status=ProjectStatus.valueOf(rs.getString("status"));
        LocalDate createdAt=rs.getDate("created_at").toLocalDate();
        LocalDate updatedAt=rs.getDate("updated_at").toLocalDate();
        double budgetBandMin=rs.getDouble("budget_band_min");
        double budgetBandMax=rs.getDouble("budget_band_max");
        LocalDate startDate=rs.getDate("start_date").toLocalDate();
        LocalDate endDate=rs.getDate("end_date").toLocalDate();

        return new Project(projectId,name,status,createdAt,updatedAt,budgetBandMin,budgetBandMax,startDate,endDate);
    }
}
