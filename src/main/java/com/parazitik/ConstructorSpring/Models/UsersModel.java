package com.parazitik.ConstructorSpring.Models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.parazitik.ConstructorSpring.Entities.UsersEntity;

import java.util.List;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsersModel {
    private Long userId;

    private Long fromUserId;
    private boolean admin = false;

    private int state;

    private List<MessageModel> messageModels;

    public static UsersModel toModel(UsersEntity users) {
        UsersModel model = new UsersModel();

        model.setUserId(users.getUserId());
        model.setFromUserId(users.getFromUserId());
        model.setAdmin(users.isAdmin());
        model.setState(users.getState());
        model.setMessageModels(users.getMessage().stream().map(MessageModel::toModel).collect(Collectors.toList()));

        return model;
    }

    public UsersModel() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public List<MessageModel> getMessageModels() {
        return messageModels;
    }

    public void setMessageModels(List<MessageModel> messageModels) {
        this.messageModels = messageModels;
    }
}
