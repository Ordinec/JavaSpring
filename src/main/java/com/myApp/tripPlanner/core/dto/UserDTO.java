package com.myApp.tripPlanner.core.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class UserDTO {
    private Long id;
    private String email;
    private String name;
    private List<RoleDTO> roleList;
}
