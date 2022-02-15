package com.darshikajha;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BlackJackGameFactory blackJackGameFactory = new BlackJackGameFactory();
        BlackjackGame blackjackGame = blackJackGameFactory.getGame("Steve");
        blackjackGame.play();
    }
}
