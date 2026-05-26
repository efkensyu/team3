package com.example.demo.team3.trash;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface Team3LoginRepository extends JpaRepository<LoginEntity,Integer> {

	LoginEntity findByUsername(String username);
}
