package com.parazitik.ConstructorSpring.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long userId;

    private Long fromUserId;

    private boolean admin = false;

    private int state;

    @ManyToOne
    @JoinColumn(name = "id_username")
    private BotEntity bot;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonIgnore
    private List<MessageEntity> message;

}
