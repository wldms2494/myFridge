package com.example.myfridge.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    //unique 는 중복 허용 여부,비밀번호는 중복 허용
    @Column(nullable = false, unique = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRoleEnum role;

//로그인 폼을 위한 생성자
    public User(String username, String password, String email, UserRoleEnum role){

        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }
}
