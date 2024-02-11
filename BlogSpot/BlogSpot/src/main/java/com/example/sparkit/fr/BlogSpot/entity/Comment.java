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
@Table(name="comment")
public class Comment {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    @Lob
    @Column(name=("content"),nullable = false)
    private String content;

    @Column(name = "createCom",nullable = false, updatable = false)
    private LocalDateTime createCom;
    @Column(name = "updateCom",nullable = false)
    private LocalDateTime updateCom;
    @ManyToOne
    private User user;
    @ManyToOne
    private  Publication publication;
}
