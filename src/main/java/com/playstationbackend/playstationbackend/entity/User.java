package com.playstationbackend.playstationbackend.entity;

import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

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
    @Column(name = "Id_user", nullable = false)
    private Long id;

    @Column(name = "Name", length = 64, nullable = false)
    private String name;

    @Column(name = "Password", length = 64, nullable = false)
    private int password;

    @Column(name = "Email", length = 64, nullable = false)
    private String email;

    @ManyToMany
    @JoinColumn(name = "game")
    private List<Game> games;


}
