package com.demo.demo.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerDTO {
    Long id;
     String username;
     String password;
     String fullName;
     String address;
     String phone;
     String email;
     String birthday;
     String active;
}
