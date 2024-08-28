package com.example.demo.controller;

public record StudentDto(
     String firstname,
     String lastname,
     String email,
     Integer schoolId
) {
}
