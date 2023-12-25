package com.parazitik.ConstructorSpring.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "command")
@Getter
@Setter
public class CommandEntity {
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
    @JoinColumn(name="id_username")
    private BotEntity bot;

}
