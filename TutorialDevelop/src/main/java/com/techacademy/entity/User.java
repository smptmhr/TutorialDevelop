package com.techacademy.entity;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data   // getter,setterが自動で準備される
@Entity // Entityクラス(=データベースのテーブルにマッピングするクラス）であることを示す
@Table  // エンティティが対応する（紐づく）テーブル名を指定する。
public class User {
    public static enum Gender {
        男性, 女性
    }
    
    @Id // Primary Keyであることを示す

    // PKを自動生成する。
    // GenerationType.AUTO：データベースに最適な方法が自動的に選択される。
    // GenerationType.IDENTITY：自動インクリメントで生成する（データベースがOracleの場合はSEQUENCEと同じ処理を行う）。
    // GenerationType.SEQUENCE：シーケンスを使って生成する（データベースがMySQLの場合はTABLEと同じ処理を行う）。
    // GenerationType.TABLE：シーケンス専用テーブルを使って生成する。
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(length=20, nullable = false) // nullableのデフォルト値はtrue
    @NotEmpty
    @Length(max=20)
    private String name;
    
    @Column(length = 2)
    @Enumerated(EnumType.STRING) // Enum型であることを示す
    @NotNull
    private Gender gender;
    
    @Min(0)
    @Max(120)
    private Integer age;
    
    @Column(length = 50)
    @Email
    @Length(max=50)
    private String email;
}
