package com.parazitik.ConstructorSpring.Models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.parazitik.ConstructorSpring.Entities.MessageEntity;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageModel {
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

    public static MessageModel toModel(MessageEntity message) {
        MessageModel model = new MessageModel();

        model.setId(message.getId());
        model.setMessage_id(message.getMessage_id());
        if (message.getText() != null) model.setText(message.getText());

        if (message.getContent_type() != null) model.setContent_type(message.getContent_type());
        if (message.getAnimation() != null) model.setAnimation(message.getAnimation());
        if (message.getAudio() != null) model.setAudio(message.getAudio());
        if (message.getCaption() != null) model.setCaption(message.getCaption());
        if (message.getContact() != null) model.setContact(message.getContact());
        if (message.getDate() != null) model.setDate(message.getDate());
        if (message.getDocument() != null) model.setDocument(message.getDocument());
        if (message.getPhoto() != null) model.setPhoto(message.getPhoto());
        if (message.getSticker() != null) model.setSticker(message.getSticker());
        if (message.getVideo() != null) model.setVideo(message.getVideo());
        if (message.getLocation() != null) model.setLocation(message.getLocation());
        if (message.getVenue() != null) model.setVenue(message.getVenue());
        if (message.getVoice() != null) model.setVoice(message.getVoice());
        if (message.getVideoNote() != null) model.setVideoNote(message.getVideoNote());

        return model;
    }

    public MessageModel() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setSticker(String sticker) {
        this.sticker = sticker;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public void setVideoNote(String videoNote) {
        this.videoNote = videoNote;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public void setAnimation(String animation) {
        this.animation = animation;
    }

    public Long getId() {
        return id;
    }

    public String getContent_type() {
        return content_type;
    }

    public Long getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public String getAudio() {
        return audio;
    }

    public String getDocument() {
        return document;
    }

    public String getPhoto() {
        return photo;
    }

    public String getSticker() {
        return sticker;
    }

    public String getVideo() {
        return video;
    }

    public String getVideoNote() {
        return videoNote;
    }

    public String getVoice() {
        return voice;
    }

    public String getCaption() {
        return caption;
    }

    public String getContact() {
        return contact;
    }

    public String getLocation() {
        return location;
    }

    public String getVenue() {
        return venue;
    }

    public String getAnimation() {
        return animation;
    }

    public Long getMessage_id() {
        return message_id;
    }

    public void setMessage_id(Long message_id) {
        this.message_id = message_id;
    }
}
