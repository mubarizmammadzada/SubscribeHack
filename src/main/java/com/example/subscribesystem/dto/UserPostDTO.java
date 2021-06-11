package com.example.subscribesystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPostDTO {
    private int id;
    private String Name;
    private String surname;
    private String email;
    private String password;
    private String username;
    private boolean isVerificated;
}
