package com.food.repository;

import com.food.entity.Dish;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Repository
@Transactional
public interface IDishRepository extends JpaRepository<Dish, Long> {
    @Query("select d from Dish d where d.isActive = true")
    Page<Dish> findAll(Pageable pageable);

    @Query("SELECT d FROM Dish d WHERE d.name LIKE %:name%")
    Page<Dish> findByNameContaining(@Param("name") String name,Pageable pageable);

    Optional<Dish> findById(Long id);

    @Modifying
    @Query("update Dish d set d.isActive = false where d.name = :dishName")
    void DeleteByName(@Param("dishName") String dishName);

    @Modifying
    @Query("update Dish d set d.isActive = false where d.id = :dishId")
    void softDeleteById(@Param("dishId") Long dishId);


    Page<Dish> findAllByNameAndActiveIsTrue( String name,Pageable pageable);

}
