package iam.mfa.fleetmanagementsystem.jpa.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import iam.mfa.fleetmanagementsystem.jpa.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HAMMA FATAKA (mfataka@monetplus.cz)
 * @project fleet-management-system
 * @date 26.11.2022 20:10
 */
@Data
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user")
public class AppUser {
    @Id
    @Column(name = "user_id")
    private String userId;
    @Column(name = "fist_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "password")
    private String password;
    @Column(name = "age")
    private Integer age;
    @Column(name = "email")
    private String email;
    @Column(name = "language")
    private String language;
    @Column(name = "role")
    private UserRole role;
    @Column(name = "last_login")
    private LocalDateTime lastLogin;

}
