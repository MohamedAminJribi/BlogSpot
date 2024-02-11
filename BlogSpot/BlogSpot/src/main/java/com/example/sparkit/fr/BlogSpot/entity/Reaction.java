package com.example.sparkit.fr.BlogSpot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name="Reaction")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reaction {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name="Reaction", nullable = false)
    private  Boolean reaction;
    @OneToOne
    private  User user;
    @ManyToOne
    private  Publication publication;


}
