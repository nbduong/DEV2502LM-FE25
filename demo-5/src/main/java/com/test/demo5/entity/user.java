package com.test.demo5.entity;


import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class user {
    String id;
    String username;
    String password;
    String email;
}
