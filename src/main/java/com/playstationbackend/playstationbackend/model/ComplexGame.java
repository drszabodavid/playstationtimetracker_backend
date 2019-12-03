package com.playstationbackend.playstationbackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ComplexGame {

    private Long id;
    private String imageUrl;
    private String name;
    private double gameplayCompletionist;
    private double gameplayMain;
    private double gameplayMainExtra;

    private String gameId;
    private boolean liked;
    private boolean completed;
    private double timeSpent;
    private double remainingTime;


}
