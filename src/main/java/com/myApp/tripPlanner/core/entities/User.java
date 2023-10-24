package com.myApp.tripPlanner.core.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder(toBuilder=true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users", schema = "tripPlanner")
@Component
@Scope("prototype")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;

    @JsonIgnore
    private String password;
    @ManyToMany
    @JoinTable(
            name = "user_roles", schema = "tripPlanner",
            joinColumns = {
                    @JoinColumn(
                            name = "user_id",
                            nullable = false
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "role_id",
                            nullable = false
                    )
            }

    )
    private List<Role> roleList = new ArrayList<>();
}
