package com.example.heppelle_feelsbook;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class EditEmotionsActivity extends AppCompatActivity {
    public Emotion emotion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_emotions);
        emotion = (Emotion) getIntent().getSerializableExtra("Selected Emotion");
        String text = emotion.toString();
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        final Calendar myCalendar = Calendar.getInstance();
        final TextView edittext= (TextView)findViewById(R.id.calendarDisplay);
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
            private void updateLabel() {
                String myFormat = "yyyy-MM-dd'T'HH:mm:ss"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                edittext.setText(sdf.format(myCalendar.getTime()));
            }
        };

        edittext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new DatePickerDialog(EditEmotionsActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        final String[] selectEmotions = {"Love", "Joy", "Surprise", "Sadness", "Fear", "Anger"};

        Button mButton = findViewById(R.id.emotionsDisplay);
        final TextView mResult = (TextView) findViewById(R.id.emotionsDisplay);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(EditEmotionsActivity.this);
                mBuilder.setTitle("Choose an item");
                mBuilder.setSingleChoiceItems(selectEmotions, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mResult.setText(selectEmotions[i]);
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public void submitOnClick(View v){
        TextView text = findViewById(R.id.optionalText);
        emotion.setText(text.getText().toString());
        Intent intent = new Intent(EditEmotionsActivity.this,ListEmotionsActivity.class);
        startActivity(intent);
    }








}
