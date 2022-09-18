package com.company.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user_roles")
public class UserRoles {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    @ManyToMany(fetch=EAGER)
    private User user;
    @ManyToMany(fetch=EAGER)
    private Role role;
}