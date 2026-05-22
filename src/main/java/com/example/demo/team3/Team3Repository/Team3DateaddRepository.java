package com.example.demo.team3.Team3Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.team3.Team3Entity.Team3Expense;
@Repository
public interface Team3DateaddRepository extends JpaRepository<Team3Expense,Integer> {

}
