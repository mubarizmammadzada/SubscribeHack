package com.example.subscribesystem.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class MyUser {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String Name;
    private String surname;
    @Column(unique = true)
    private String email;
    private String password;
    @Column(unique = true)
    private String username;
    private boolean isVerificated;

    public MyUser(String name, String surname, String email, String password, String username, boolean isVerificated) {
        Name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.username = username;
        this.isVerificated = isVerificated;
    }
}
