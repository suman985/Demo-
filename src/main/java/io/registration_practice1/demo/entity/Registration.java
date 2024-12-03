package io.registration_practice1.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "registration")
public class Registration {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id", nullable = false)
   private Long id;

   @Column(name = "email", nullable = false, unique = true)
   private String email;

   @Column(name = "name", nullable = false)
   private String name;

   @Column(name = "mobile", nullable = false, unique = true)
   private String mobile;
}