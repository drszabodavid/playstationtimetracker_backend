package com.playstationbackend.playstationbackend.repository;

import com.playstationbackend.playstationbackend.entity.SelectedGame;
import com.playstationbackend.playstationbackend.model.ComplexGame;
import lombok.Singular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface SelectedGameRepository extends JpaRepository<SelectedGame, Long> {




}
