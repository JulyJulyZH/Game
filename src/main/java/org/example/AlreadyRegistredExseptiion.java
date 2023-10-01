package org.example;

public class AlreadyRegistredExseptiion extends RuntimeException{
    public AlreadyRegistredExseptiion (String player) {
        super("Player with name" + player + " is already registered");
    }
}
