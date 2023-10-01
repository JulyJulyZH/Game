package org.example;

public class Player {
    int id;
    String name;
    int strength;

    Player (String name, int id, int strength){
        this.name = name;
        this.id = id;
        this.strength = strength;
    }
    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

}

