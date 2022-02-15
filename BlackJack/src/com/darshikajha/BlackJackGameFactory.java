package com.darshikajha;

public class BlackJackGameFactory {

    public BlackjackGame getGame(String playerName) {
        return new BlackjackGame(playerName);
    }
}
