package com.playstationbackend.playstationbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "SELECTED_GAMES")
public class SelectedGame {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(targetEntity = User.class)
    private User user;

    private String gameId;

    private boolean liked;
    private boolean completed;
    private double timeSpent;
    private double remainingTime;


}
