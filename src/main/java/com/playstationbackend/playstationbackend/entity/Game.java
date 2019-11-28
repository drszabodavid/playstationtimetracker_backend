package com.playstationbackend.playstationbackend.entity;


import lombok.*;

import java.util.List;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "GAME")
public class Game {

    private int gameplayCompletionist;
    private int gameplayMain;
    private int gameplayMainExtra;

    @Id
    private String id;
    private String imageUrl;
    private String name;

    @ElementCollection
    @Singular
    @OneToMany
    private List<SelectedGame> gameUpdates;





}
