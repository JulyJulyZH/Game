package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {
    @Test
    void registerEmptyArrayList() {
        Game game = new Game();
        Player player1 = new Player("player1", 12, 14);
        Player player2 = new Player("player2", 13, 19);
        boolean actual = game.registeredPlayers.isEmpty();
        Assertions.assertTrue(actual);

    }

    @Test
    void registerNotRegistratedYet() {
        Game game = new Game();
        Player player1 = new Player("player1", 12, 14);
        game.register(player1);
        Player player2 = new Player("player2", 13, 19);
        game.register(player2);
        boolean actual = game.registeredPlayers.contains(player1);
        Assertions.assertTrue(actual);

    }
    @Test
    void registerRegistratedYet() {
        Game game = new Game();
        Player player1 = new Player("player1", 12, 14);
        game.register(player1);
        Player player2 = new Player("player1", 13, 19);

        Assertions.assertThrows(AlreadyRegistredExseptiion.class,
                () -> game.register(player2));

    }

    @Test
    void roundFirstPlayerNotRegistred() {
        Game game = new Game();
        Player player1 = new Player("player1", 12, 14);
        Player player2 = new Player("player2", 12, 14);
        game.register(player2);


        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round(player1.getName(),player2.getName()));

    }
    @Test
    void roundSecondPlayerNotRegistred() {
        Game game = new Game();
        Player player1 = new Player("player1", 12, 14);
        Player player2 = new Player("player2", 12, 14);
        game.register(player1);


        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round(player1.getName(),player2.getName()));

    }
    @Test
    void roundBothPlayersNotRegistred() {
        Game game = new Game();
        Player player1 = new Player("player1", 12, 14);
        Player player2 = new Player("player2", 12, 14);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round(player1.getName(),player2.getName()));

    }

    @Test
    void roundFirstPlayerWin() {
        Game game = new Game();
        Player player1 = new Player("player1", 12, 20);
        Player player2 = new Player("player2", 12, 14);
        game.register(player1);
        game.register(player2);
        int expected = 1;
        int actual = game.round(player1.getName(),player2.getName());
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void roundSecondPlayerWin() {
        Game game = new Game();
        Player player1 = new Player("player1", 12, 14);
        Player player2 = new Player("player2", 12, 19);
        game.register(player1);
        game.register(player2);
        int expected = 2;
        int actual = game.round(player1.getName(),player2.getName());
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void roundDrow() {
        Game game = new Game();
        Player player1 = new Player("player1", 12, 14);
        Player player2 = new Player("player2", 12, 14);
        game.register(player1);
        game.register(player2);
        int expected = 0;
        int actual = game.round(player1.getName(),player2.getName());
        Assertions.assertEquals(expected, actual);
    }
    void findByNameNull() {
        Game game = new Game();
        Player player1 = new Player("player1", 12, 14);
        Player actual = game.findByName(player1.getName());
        Assertions.assertNull(actual);
    }





}