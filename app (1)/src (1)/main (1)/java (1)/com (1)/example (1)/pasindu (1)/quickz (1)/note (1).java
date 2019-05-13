package com.example.pasindu.quickz;

import android.content.Context;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class note implements Serializable {
    private long nDateTime;
    private String nTitle;
    private  String nContent;

    public note(long DateTime, String Title, String Content) {
        this.nDateTime = DateTime;
        this.nTitle = Title;
        this.nContent = Content;
    }

    public void setDateTime(long DateTime) {
        this.nDateTime = DateTime;
    }

    public void setTitle(String nTitle) {
        this.nTitle = nTitle;
    }

    public void setContent(String nContent) {
        this.nContent = nContent;
    }

    public long getnDateTime() {
        return nDateTime;
    }

    public String getnTitle() {
        return nTitle;
    }

    public String getnContent() {
        return nContent;
    }

    public String getDateTimeFormatted(Context context){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy  HH:mm:ss",context.getResources().getConfiguration().locale);
        sdf.setTimeZone(TimeZone.getDefault());
        return sdf.format(new Date(nDateTime));
    }


}