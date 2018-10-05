package com.example.heppelle_feelsbook;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public abstract class Emotion implements Serializable{
    //protected ArrayList<String> emotions = ("Love", "Joy", "Anger", "Fear", "Sadness", "Surprise");
    protected String emotion;
    public Date date = new Date();
    public String optionalText = "";

    public void Emotion(){ }

    public String getText(){
        return this.optionalText;
    }

    public String getEmotion(){
        return this.emotion;
    }

    public String getDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
        return dateFormat.format(this.date);
    }

    public void setText(String text){
        this.optionalText = text;
    }

    public void setEmotion(String newEmotion){
        this.emotion = newEmotion;
    }

    public void setDate(Date newDate){
        this.date = newDate;
    }

    public String toString(){
        return getEmotion() + " | " + getDate() + ": " + getText();
    }

}
