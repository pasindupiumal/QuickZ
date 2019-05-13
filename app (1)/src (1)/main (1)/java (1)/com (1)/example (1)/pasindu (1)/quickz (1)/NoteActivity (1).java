package com.example.pasindu.quickz;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pasindu.quickz.R;

public class NoteActivity extends AppCompatActivity {

    private EditText mEtTitle;
    private EditText mEtContent;

    private String mNoteFileName;
    private note mLoadedNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        mEtTitle = (EditText) findViewById(R.id.note_et_title);
        mEtContent = (EditText) findViewById(R.id.note_et_content);

        mNoteFileName = getIntent().getStringExtra("NOTE_FILE");
        if (mNoteFileName != null && !mNoteFileName.isEmpty()){
            mLoadedNote = utilities.getNoteByName(this,mNoteFileName);

            if (mLoadedNote != null){
                mEtTitle.setText(mLoadedNote.getnTitle());
                mEtContent.setText(mLoadedNote.getnContent());
            }
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_note_new, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            
            case R.id.action_note_save:
                saveNote();
            case R.id.action_note_delete:
                deleteNote();
                break;
        }

        return true;
    }

    private void saveNote() {
       note note;

        if(mLoadedNote == null) {

            note = new note(System.currentTimeMillis(), mEtTitle.getText().toString(), mEtContent.getText().toString());

        }else{
            note = new note(mLoadedNote.getnDateTime(), mEtTitle.getText().toString(), mEtContent.getText().toString());
        }

        if(utilities.saveNote(this,note)){
            Toast.makeText(this,"your note is saved!",Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(this,"can not save this note, please make sure tou have enough space on your device",Toast.LENGTH_SHORT).show();

        }
        finish();
    }

    private void deleteNote(){
        if (mLoadedNote == null){
            finish();
        }else {

            AlertDialog.Builder dialog = new AlertDialog.Builder(this).setTitle("delete").setMessage("you are about to delete   " + mEtTitle.getText().toString()+", are you sure?").setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    utilities.deleteNote(getApplicationContext(),mLoadedNote.getnDateTime() + utilities.FILE_EXTENSION);
                    Toast.makeText(getApplicationContext(),mEtTitle.getText().toString()+"  is deleted",Toast.LENGTH_SHORT).show();
                    finish();
                }
            })
                    .setNegativeButton("no",null).setCancelable(false);
            dialog.show();


        }
    }
}
