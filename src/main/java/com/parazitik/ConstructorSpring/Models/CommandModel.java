package com.parazitik.ConstructorSpring.Models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.parazitik.ConstructorSpring.Entities.CommandEntity;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommandModel {
    private Long id;
    private String name;
    private String text;
    private String type;
    private String caption;
    private String image;
    private String keyboard;

    public static CommandModel toModel(CommandEntity entity) {
        CommandModel model = new CommandModel();

        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setType(entity.getType());

        model.setKeyboard(entity.getKeyboard());

        switch (entity.getType()) {
            case ("text") -> model.setText(entity.getText());
            case ("photo") -> {
                model.setCaption(entity.getCaption());
                model.setImage(entity.getImage());
            }
        }

        return model;
    }

    public CommandModel() {
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }
}
