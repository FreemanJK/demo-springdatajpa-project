package com.example.demo.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {
  private final SchoolRepository schoolRepository;

  public SchoolController(SchoolRepository schoolRepository) {
    this.schoolRepository = schoolRepository;
  }
  @PostMapping("/schools")
  public School createSchool(
      @RequestBody School school
  ){
    return schoolRepository.save(school);
  }

  @GetMapping("/schools")
  public List<School> findAllSchools(){
    return schoolRepository.findAll();
  }

  @DeleteMapping("/schools/{school-id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteSchool( @PathVariable("school-id") Integer id) {
     schoolRepository.deleteById(id);
  }
}
