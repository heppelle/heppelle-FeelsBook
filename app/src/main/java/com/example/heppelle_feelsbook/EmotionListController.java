package com.example.heppelle_feelsbook;

import java.util.ArrayList;

public class EmotionListController {

    // lazy singleton
    //public EmotionList emotionList = null;
    private static EmotionList emotionList = null;
    public static EmotionList getEmotionList(){
        if (emotionList == null) {
            emotionList = new EmotionList();
        }
        return emotionList;
    }

    public static void addEmotion(Emotion emotion){
        if (emotionList == null) {
            emotionList = new EmotionList();
        }
        emotionList.addEmotion(emotion);
    }

    public static void setEmotionList(EmotionList List){
        if (emotionList == null) {
            emotionList = new EmotionList();
        }
        emotionList = List;
    }

    public static int getLoveCount(){
        return emotionList.getLoveCount();
    }

    public static int getJoyCount(){
        return emotionList.getJoyCount();
    }

    public static int getSurpriseCount(){
        return emotionList.getSurpriseCount();
    }

    public static int getAngerCount(){
        return emotionList.getAngerCount();
    }

    public static int getSadnessCount(){
        return emotionList.getSadnessCount();
    }

    public static int getFearCount(){
        return emotionList.getFearCount();
    }


/*    public int addEmotion(Emotion emotion){
        return getEmotionList().addEmotion(emotion);
    }*/

}
