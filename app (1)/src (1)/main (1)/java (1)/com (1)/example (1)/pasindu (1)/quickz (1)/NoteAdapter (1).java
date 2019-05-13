package com.example.pasindu.quickz;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NoteAdapter  extends ArrayAdapter<note>{
    public NoteAdapter(@NonNull Context context, int resource, @NonNull ArrayList<note> notes) {
        super(context, resource, notes);
    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_note, null);
        }

        note note = getItem(position);

        if(note != null) {
            TextView title = (TextView) convertView.findViewById(R.id.list_note_title);
            TextView date = (TextView) convertView.findViewById(R.id.list_note_date);
            TextView content = (TextView) convertView.findViewById(R.id.list_note_content);

            title.setText(note.getnTitle());
            date.setText(note.getDateTimeFormatted(getContext()));

            if (note.getnContent().length()>50){
                content.setText(note.getnContent().substring(0,50));
            }
            else {
                content.setText(note.getnContent());
            }
        }
        return convertView;

    }

}
