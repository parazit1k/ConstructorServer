package com.parazitik.ConstructorSpring.Models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.parazitik.ConstructorSpring.Entities.CommandEntity;
import com.parazitik.ConstructorSpring.Entities.TextEntity;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TextModel {

    private Long id;
    private String name;
    private String type;
    private String image;
    private String caption;
    private String text;
    private String keyboard;

    public static TextModel toModel(TextEntity entity) {
        TextModel model = new TextModel();

        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setText(entity.getText());
        model.setCaption(entity.getCaption());
        model.setType(entity.getType());
        model.setImage(entity.getImage());
        model.setKeyboard(entity.getKeyboard());

        return model;
    }

    public TextModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }
}
