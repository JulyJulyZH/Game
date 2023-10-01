package org.example;

import java.util.ArrayList;

public class Game {
    ArrayList<Player> registeredPlayers = new ArrayList<>();

    public void register(Player player) {
        if (findByName(player.getName()) != null) {
            throw new AlreadyRegistredExseptiion(player.getName());
        } else {
            registeredPlayers.add(player);
        }

    }


    public Player findByName(String name) {
        for (Player player : registeredPlayers) {
            if (player.getName().equals(name)) {
                return player;
            }

        }
        return null;
    }


    public int round(String playerName1, String playerName2) {

        if (findByName(playerName1) == null) {
            throw new NotRegisteredException(playerName1);
        } else if (findByName(playerName2) == null) {
            throw new NotRegisteredException(playerName2);
        } else {
            Player player1 = findByName(playerName1);
            Player player2 = findByName(playerName2);
            if (player1.getStrength() > player2.getStrength()) {
                return 1;
            } else if (player1.getStrength() < player2.getStrength()) {
                return 2;
            } else {
                return 0;
            }


        }


    }

}
