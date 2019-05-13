package com.example.pasindu.quickz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private CardView voiceRecorderCard, notesCard, todoCard, reminderCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        voiceRecorderCard = (CardView) findViewById(R.id.voiceRecorder);
        notesCard = (CardView) findViewById(R.id.notes);
        todoCard = (CardView) findViewById(R.id.todo);
        reminderCard = (CardView) findViewById(R.id.reminder);

        voiceRecorderCard.setOnClickListener(this);
        notesCard.setOnClickListener(this);
        todoCard.setOnClickListener(this);
        reminderCard.setOnClickListener(this);




    }

    @Override
    public void onClick(View v){

        Intent intent;

        switch(v.getId()){

            case R.id.notes:
                intent = new Intent(this, NoteHome.class);
                startActivity(intent);
                break;

            case R.id.todo:
                intent = new Intent(this, TodoHome.class);
                startActivity(intent);
                break;

            case R.id.voiceRecorder:
                intent = new Intent(this, RecorderHome.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
