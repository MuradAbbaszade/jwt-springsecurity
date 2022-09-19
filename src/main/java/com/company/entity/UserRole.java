package com.company.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_role", schema = "public")
public class UserRole {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    @OneToOne(fetch=EAGER)
    private User user;
    @OneToOne(fetch=EAGER)
    private Role role;
}