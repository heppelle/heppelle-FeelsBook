package com.example.heppelle_feelsbook;

public class EmotionListEmptyException extends Exception {

    EmotionListEmptyException() {
        super("You have no emotions logged.");
    }

}
