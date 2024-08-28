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
public class FirstController {

    private final StudentRepository repository;


  public FirstController(StudentRepository repository) {
    this.repository = repository;
  }

  @PostMapping("/students")
  public Student posts(
      @RequestBody Student student
  ){
    return repository.save(student);

  }

  @GetMapping("/students/{student_id}")
  public Student findStudentById(
      @PathVariable("student_id") Integer id) {
    return repository.findById(id).
        orElse(new Student());
  }

  @GetMapping("/students")
  public List<Student> findAll() {
    return repository.findAll();
  }

  @GetMapping("/students/search/{student-name}")
  public List<Student> findByFirstName(@PathVariable("student-name") String name) {
    return repository.findAllByFirstnameContaining(name);
  }

  @DeleteMapping("students/{student-id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteStudentById(
      @PathVariable("student-id") Integer id
  ){
    repository.deleteById(id);
  }

}
