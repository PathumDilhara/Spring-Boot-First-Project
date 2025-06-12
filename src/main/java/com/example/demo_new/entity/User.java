package com.example.demo_new.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Hey, I want to save and load this object from the database
@NoArgsConstructor // Generates a default constructor: public User() { }
@AllArgsConstructor // Generates a constructor with all fields as parameters: public User(int id, String name, String address) { ... }
@Data
public class User {
    @Id // Marks the field id as the primary key of the table.
    private int id;
    private String name;
    private String address;
}
