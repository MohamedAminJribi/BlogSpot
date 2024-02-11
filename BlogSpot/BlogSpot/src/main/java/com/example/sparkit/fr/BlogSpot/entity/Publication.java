package com.example.sparkit.fr.BlogSpot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="publication")
public class Publication {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    @Lob
    @Column(name=("content"),nullable = false)
    private String content;
    @Column(name=("title"),nullable = false)
    private String title;

    @Column(name = "createPub",nullable = false, updatable = false)
    private LocalDateTime createPub;

    @Column(name = "updatePub",nullable = false)
    private LocalDateTime updatePub;

    @ManyToOne
    private User user;



}