package com.example.sparkit.fr.BlogSpot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="userName", nullable = false)
    private  String userName;

    @Column(name="email", nullable = false)
    private  String email;

    @Column(name="password",nullable = false)
    private  String password;

    @Column(name="isAdmin")
    private  Boolean isAdmin;





}
