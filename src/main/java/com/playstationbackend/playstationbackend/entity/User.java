package com.playstationbackend.playstationbackend.entity;

import lombok.*;

import java.util.List;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String password;

    private String email;

    @ElementCollection
    @Singular
    private List<String> roles;



}
