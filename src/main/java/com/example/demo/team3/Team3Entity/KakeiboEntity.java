package com.example.demo.team3.Team3Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="shohin_tbl")

public class KakeiboEntity {
    @Id
    private Integer id;
    //カテゴリー
    private String item;
    //価格
    private Integer price;
}