package com.playstationbackend.playstationbackend.entity;


import lombok.*;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
