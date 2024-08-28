package com.example.demo.controller;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_STUDENT")
public class Student {

  @OneToOne(
      mappedBy = "student",
      cascade = CascadeType.ALL
  )
  private StudentProfile studentProfile;

  public StudentProfile getStudentProfile() {
    return studentProfile;
  }

  public void setStudentProfile(StudentProfile studentProfile) {
    this.studentProfile = studentProfile;
  }

  @Id
  @GeneratedValue
  private Integer id;
  @Column(
      name = "c_fname",
      length = 20
  )
  private String firstname;
  private String lastname;

  @Column(
      unique = true
  )
  private String email;
  private String age;

  public Student(String firstname, String lastname, String email, String age) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.age = age;
  }

  @ManyToOne
  @JoinColumn(
      name = "school_id"
  )
  @JsonBackReference
  private School school;



  public School getSchool() {
    return school;
  }

  public void setSchool(School school) {
    this.school = school;
  }

  public Student() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }
}
