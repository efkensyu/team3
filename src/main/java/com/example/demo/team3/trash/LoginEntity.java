package com.example.demo.team3.trash;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name = "login_tbl")
public class LoginEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "ユーザー名を入力してください")
    private String username;

//    private String password;

    // getter setter
}