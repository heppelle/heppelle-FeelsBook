package com.example.heppelle_feelsbook;

public class OptionalTextTooLongExcepion extends Exception {
    OptionalTextTooLongExcepion(){
        super("Please enter optional text in under 100 characters.");
    }
}
