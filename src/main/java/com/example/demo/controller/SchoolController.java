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
import java.util.stream.Collectors;

@RestController
public class SchoolController {
  private final SchoolRepository schoolRepository;

  public SchoolController(SchoolRepository schoolRepository) {
    this.schoolRepository = schoolRepository;
  }
  @PostMapping("/schools")
  public SchoolDto createSchool(
      @RequestBody SchoolDto dto
  ){
    var school = toSchool(dto);
    schoolRepository.save(school);

    return dto;
  }

  private School toSchool(SchoolDto dto) {
    return new School(dto.name());
  }

  private SchoolDto toSchoolDto(School school) {
    return new SchoolDto(school.getName());
  }
  @GetMapping("/schools")
  public List<SchoolDto> findAllSchools(){
    return schoolRepository.findAll()
        .stream()
        .map(this::toSchoolDto)
        .collect(Collectors.toList());
  }

  @DeleteMapping("/schools/{school-id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteSchool( @PathVariable("school-id") Integer id) {
     schoolRepository.deleteById(id);
  }
}
