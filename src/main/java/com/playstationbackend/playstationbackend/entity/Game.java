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
@Table(name = "GAME")
public class Game {

    private int gameplayCompletionist;
    private int gameplayMain;
    private int gameplayMainExtra;

    @Id

    private String id;
    private String imageUrl;
    private String name;
    private boolean liked;
    private boolean completed;
    private int timeSpent;
    private int remainingTime;





}
