package com.example.demo.team3.Team3Repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.team3.Team3Entity.Team3Expense;
@Repository
public interface Team3DateaddRepository extends JpaRepository<Team3Expense,Integer> {
	List<Team3Expense> findByDate(LocalDate date);
    @Query("SELECT SUM(e.price * e.amount) FROM Team3Expense e WHERE e.date = :date")
    Integer sumTotalByDate(@Param("date") LocalDate date);
}