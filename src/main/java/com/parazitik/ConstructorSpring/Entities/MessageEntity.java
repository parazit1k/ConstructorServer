package com.parazitik.ConstructorSpring.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "message")
@Getter
@Setter
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Long message_id;

    private String content_type;
    private Long date;
    private String text;
    private String audio;
    private String document;
    private String photo;
    private String sticker;
    private String video;
    private String videoNote;
    private String voice;
    private String caption;
    private String contact;
    private String location;
    private String venue;
    private String animation;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private UsersEntity user;

}
