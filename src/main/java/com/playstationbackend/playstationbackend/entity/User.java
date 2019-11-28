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

    private int password;

    private String email;

//    @ManyToMany
//    @JoinColumn(name = "game")
//    private List<Game> games;

    @OneToMany
    private List<SelectedGame> selectedGames;


}
