/*

MIT License
        FeelsBook: An emotion logger for android.
        Copyright (c) 2018 Joe Heppelle heppelle@ualberta.ca

        Permission is hereby granted, free of charge, to any person obtaining a copy
        of this software and associated documentation files (the "Software"), to deal
        in the Software without restriction, including without limitation the rights
        to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
        copies of the Software, and to permit persons to whom the Software is
        furnished to do so, subject to the following conditions:

        The above copyright notice and this permission notice shall be included in all
        copies or substantial portions of the Software.

        THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
        IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
        FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
        AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
        LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
        OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
        SOFTWARE.

*/

package com.example.heppelle_feelsbook;

import android.content.Context;
import android.content.Intent;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import static com.example.heppelle_feelsbook.EmotionListController.*;

public class MainActivity extends AppCompatActivity {
    private static final String FILENAME = "file.sav";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EmotionListController.getEmotionList();
        TextView loveCount = findViewById(R.id.loveCount);
        //int count = EmotionListController.getLoveCount();
        loveCount.setText(Integer.toString(EmotionListController.getLoveCount()));
        TextView joyCount = findViewById(R.id.joyCount);
        joyCount.setText(Integer.toString(EmotionListController.getJoyCount()));
        TextView surpriseCount = findViewById(R.id.surpriseCount);
        surpriseCount.setText(Integer.toString(EmotionListController.getSurpriseCount()));
        TextView angerCount = findViewById(R.id.angerCount);
        angerCount.setText(Integer.toString(EmotionListController.getAngerCount()));
        TextView sadnessCount = findViewById(R.id.sadnessCount);
        sadnessCount.setText(Integer.toString(EmotionListController.getSadnessCount()));
        TextView fearCount = findViewById(R.id.fearCount);
        fearCount.setText(Integer.toString(EmotionListController.getFearCount()));
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.main_menu, menu);

        //MenuInflater inflater = getMenuInflater();
        //inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id==R.id.menu_history){
            Toast.makeText(this, "You are now viewing your emotions!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, ListEmotionsActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    public void love_buttonOnClick(View v){
        Toast.makeText(this, "Love is added to your emotions!", Toast.LENGTH_SHORT).show();
        Emotion emotion = new Love();
        addEmotion(emotion);
        int count = EmotionListController.getLoveCount();
        TextView loveCount = findViewById(R.id.loveCount);
        loveCount.setText(Integer.toString(count));
        // increment count on mainActivity
        // create new love class
        // store Loveclass info in EmotionList.
    }

    public void joy_buttonOnClick(View v){
        Toast.makeText(this, "Joy is added to your emotions!", Toast.LENGTH_SHORT).show();
        Emotion emotion = new Joy();
        addEmotion(emotion);
        int count = EmotionListController.getJoyCount();
        TextView joyCount = findViewById(R.id.joyCount);
        joyCount.setText(Integer.toString(count));

        // increment count on mainActivity
        //create new joy class
        // store new joy class info in EmotionList.
    }

    public void surprise_buttonOnClick(View v){
        Toast.makeText(this, "Surprise is added your emotions!", Toast.LENGTH_SHORT).show();
        Emotion emotion = new Surprise();
        addEmotion(emotion);
        int count = EmotionListController.getSurpriseCount();
        TextView surpriseCount = findViewById(R.id.surpriseCount);
        surpriseCount.setText(Integer.toString(count));
        // increment count on mainActivity
        // store Loveclass info in His.
    }

    public void anger_buttonOnClick(View v){
        Toast.makeText(this, "Anger is added to your emotions!", Toast.LENGTH_SHORT).show();
        Emotion emotion = new Anger();
        addEmotion(emotion);
        int count = EmotionListController.getAngerCount();
        TextView angerCount = findViewById(R.id.angerCount);
        angerCount.setText(Integer.toString(count));
        // increment count on mainActivity
        // store Loveclass info in Histoty.
    }

    public void sadness_buttonOnClick(View v){
        Toast.makeText(this, "Sadness is added to your emotions!", Toast.LENGTH_SHORT).show();
        Emotion emotion = new Sadness();
        addEmotion(emotion);
        int count = EmotionListController.getSadnessCount();
        TextView sadnessCount = findViewById(R.id.sadnessCount);
        sadnessCount.setText(Integer.toString(count));
        // increment count on mainActivity
        // store Loveclass info in Histoty.
    }

    public void fear_buttonOnClick(View v){
        Toast.makeText(this, "Fear is added to your emotions!", Toast.LENGTH_SHORT).show();
        Emotion emotion = new Fear();
        addEmotion(emotion);
        int count = EmotionListController.getFearCount();
        TextView fearCount = findViewById(R.id.fearCount);
        fearCount.setText(Integer.toString(count));
        // increment count on mainActivity
        // store Loveclass info in Histoty.
    }

}
