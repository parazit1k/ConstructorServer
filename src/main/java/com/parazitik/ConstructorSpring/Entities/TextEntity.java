package com.parazitik.ConstructorSpring.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TextEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String type;
    private String text;
    private String caption;
    private String image;
    private String keyboard;

    @ManyToOne
    @JoinColumn(name = "id_username")
    private BotEntity bot;
}
