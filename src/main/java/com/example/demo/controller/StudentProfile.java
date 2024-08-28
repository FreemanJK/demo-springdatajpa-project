package com.example.demo.controller;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class StudentProfile {

  @OneToOne
  @JoinColumn(
      name = "student_id"
  )
  private Student student;


  @Id
  @GeneratedValue
  private Integer id;

  private String bio;

  public StudentProfile(String bio) {
    this.bio = bio;
  }

  public StudentProfile() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }
}
