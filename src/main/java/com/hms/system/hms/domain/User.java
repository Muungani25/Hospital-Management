package com.hms.system.hms.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String dateOfBirth;
    private String phoneNumber;
    private String address;
    private String email;
    private String password;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private String userId;
    private String specialization;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_to_roles",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<Role> roles = new HashSet<>();

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
