package com.demo.demo.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentDTO {
     Long id;
     String name;
     String email;
     int age;
}
