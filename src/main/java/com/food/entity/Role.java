package com.food.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_role")
    private String role;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "role")
    Collection<User> users;

}
