package com.example.demo.team3.Team3Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.team3.Team3Entity.KakeiboEntity;

public class Team3Repository {
	public interface KakeiboRepository extends JpaRepository<KakeiboEntity, Integer> {

	}

}
