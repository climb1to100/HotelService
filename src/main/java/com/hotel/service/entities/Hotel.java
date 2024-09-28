package com.hotel.service.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="hotels")
public class Hotel {

    @Id
    @Column(name = "ID", nullable = false , unique = true)
    @SequenceGenerator(name = "microSequences", sequenceName = "hotels_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "microSequences")
    private Long id;

    @Column(name = "NAME", length = 20)
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ABOUT")
    private String about;
}