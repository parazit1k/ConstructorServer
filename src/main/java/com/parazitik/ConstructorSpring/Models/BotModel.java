package com.parazitik.ConstructorSpring.Models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.parazitik.ConstructorSpring.Entities.BotEntity;

import java.util.List;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BotModel {
    private String idUsername;
    private String token;
    private boolean chatgpt;
    private String chatgptToken;
    private String mainKeyboard;
    private boolean ruz;
    private List<CommandModel> commands;
    private List<TextModel> text;
    private List<UsersModel> users;

    public static BotModel toModel(BotEntity entity) {
        BotModel model = new BotModel();

        model.setIdUsername(entity.getIdUsername());
        model.setToken(entity.getToken());
        model.setChatgpt(entity.isChatgpt());
        model.setChatgptToken(entity.getChatgptToken());
        model.setRuz(entity.isRuz());
        model.setCommands(entity.getCommands().stream().map(CommandModel::toModel).collect(Collectors.toList()));
        model.setText(entity.getText().stream().map(TextModel::toModel).collect(Collectors.toList()));
        model.setUsers(entity.getUsers().stream().map(UsersModel::toModel).collect(Collectors.toList()));
        model.setMainKeyboard(entity.getMainKeyboard());

        return model;
    }

    public static BotModel toModelUsernames(BotEntity entity){
        BotModel model = new BotModel();

        model.setIdUsername(entity.getIdUsername());

        return model;
    }

    public BotModel() {
    }

    public String getIdUsername() {
        return idUsername;
    }

    public void setIdUsername(String idUsername) {
        this.idUsername = idUsername;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isChatgpt() {
        return chatgpt;
    }

    public void setChatgpt(boolean chatgpt) {
        this.chatgpt = chatgpt;
    }

    public String getChatgptToken() {
        return chatgptToken;
    }

    public void setChatgptToken(String chatgptToken) {
        this.chatgptToken = chatgptToken;
    }

    public String getMainKeyboard() {
        return mainKeyboard;
    }

    public void setMainKeyboard(String mainKeyboard) {
        this.mainKeyboard = mainKeyboard;
    }

    public boolean isRuz() {
        return ruz;
    }

    public void setRuz(boolean ruz) {
        this.ruz = ruz;
    }

    public List<CommandModel> getCommands() {
        return commands;
    }

    public void setCommands(List<CommandModel> commands) {
        this.commands = commands;
    }

    public List<TextModel> getText() {
        return text;
    }

    public void setText(List<TextModel> text) {
        this.text = text;
    }

    public List<UsersModel> getUsers() {
        return users;
    }

    public void setUsers(List<UsersModel> users) {
        this.users = users;
    }
}
