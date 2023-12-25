package com.parazitik.ConstructorSpring.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "bot")
@Getter
@Setter
public class BotEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long ids;

    private String idUsername;

    private String token;

    private boolean chatgpt = false;
    private String chatgptToken;

    private String mainKeyboard = "[]";

    private boolean ruz = false;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bot", orphanRemoval = true)
    @JsonIgnore
    private List<CommandEntity> commands;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bot", orphanRemoval = true)
    @JsonIgnore
    private List<TextEntity> text;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bot", orphanRemoval = true)
    @JsonIgnore
    private List<UsersEntity> users;

}
