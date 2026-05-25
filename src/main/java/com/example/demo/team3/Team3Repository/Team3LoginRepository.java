package com.example.demo.team3.Team3Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.team3.Team3Entity.LoginEntity;
@Repository
public interface Team3LoginRepository extends JpaRepository<LoginEntity,Integer> {

	LoginEntity findByUsername(String username);
}
