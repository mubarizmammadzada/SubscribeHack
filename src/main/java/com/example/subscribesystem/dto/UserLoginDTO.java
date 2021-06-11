package com.example.subscribesystem.dto;

import com.example.subscribesystem.models.MyUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLoginDTO {
    String token;
    String surname;
    String name;
    Integer id;
}
