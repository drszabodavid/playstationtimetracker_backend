package com.playstationbackend.playstationbackend.entity;


import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table
public class Game {


    @Id
    private String id;
    private String imageUrl;
    private String name;
    private double gameplayCompletionist;
    private double gameplayMain;
    private double gameplayMainExtra;






}
