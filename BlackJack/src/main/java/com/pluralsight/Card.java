package com.pluralsight;

public class Card {
    //Todo - variables
    private String suit;
    private String value;
    private boolean isFaceUp;

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public String getValue() {
        return value;
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    //derived getter
    public int getPointValue() {
        return getPointValue();
    }
}
