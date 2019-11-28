package com.playstationbackend.playstationbackend.repository;

import com.playstationbackend.playstationbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<User, Long> {

    List<User> findByNameLike(String name);

}
