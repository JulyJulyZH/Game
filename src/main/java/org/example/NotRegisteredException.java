package org.example;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException (String player) {
        super("Player with name" + player + " have not registered yet");
    }
}
