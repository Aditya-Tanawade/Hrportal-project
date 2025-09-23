package com.finalproject.hrportal.domain;


import com.finalproject.hrportal.domain.enums.RoleKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private int roleID;
    private RoleKey roleKey;
    private String DisplayName;
}
