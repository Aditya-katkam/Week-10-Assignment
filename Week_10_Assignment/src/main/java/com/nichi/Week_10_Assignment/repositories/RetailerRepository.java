package com.nichi.Week_10_Assignment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nichi.Week_10_Assignment.Retailer;


@Repository
public interface RetailerRepository extends JpaRepository<Retailer, Integer> {
    public int deleteByName(String name);

    @Query(value = "SELECT * RETAILER f where f.name=:name OR f.age=:age", nativeQuery = true)
    public int findByNameOrAge(String name, int age);

    @Modifying
    @Query(value = "DELETE FROM RETAILER f where f.age=:age", nativeQuery = true)
    public int deleteByAge(int age);

    @Modifying
    @Query(value = "DELETE FROM RETAILER f where f.age=:age and f.name=:name", nativeQuery = true)
    public int deleteByAgeAndName(int age, String name);

}


