package io.pigutty.udemy.Full.Stack.Project.exceptions;

public class UsernameAlreadyExistsExceptionResponse {

    private String username;

    public UsernameAlreadyExistsExceptionResponse(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
