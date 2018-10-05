package com.example.heppelle_feelsbook;

import java.util.ArrayList;
import java.util.Collection;

public class EmotionList{
    protected ArrayList<Emotion> emotionList;
    public int loveCount=0;
    public int angerCount=0;
    public int fearCount=0;
    public int joyCount=0;
    public int sadnessCount=0;
    public int surpriseCount=0;


    public EmotionList(){
        emotionList = new ArrayList<Emotion>();
    }

    public ArrayList<Emotion> getEmotions() {
        //TODO add more things.
        return emotionList;
    }

    public int getLoveCount() {
        return loveCount;
    }
    public int getAngerCount(){
        return angerCount;
    }
    public int getFearCount(){
        return fearCount;
    }
    public int getJoyCount(){
        return joyCount;
    }
    public int getSadnessCount(){
        return sadnessCount;
    }
    public int getSurpriseCount(){
        return surpriseCount;
    }

    public void addEmotion(Emotion emotion){
        emotionList.add(emotion);
        incrementEmotion(emotion);
    }

    private void incrementEmotion(Emotion emotion){
        String emotionString = emotion.getEmotion();
        switch(emotionString){
            case "Love":
                loveCount++;
                break;
            case "Anger":
                angerCount++;
                break;
            case "Fear":
                fearCount++;
                break;
            case "Joy":
                joyCount++;
                break;
            case "Sadness":
                sadnessCount++;
                break;
            case "Surprise":
                surpriseCount++;
                break;
            default:
                loveCount+=0;
        }

    }

}
