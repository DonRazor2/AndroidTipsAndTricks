package com.example.android.myapplication;

import android.content.Context;

/**
 * Created by visla on 5/23/2018.
 */

public class Tip {

    public Tip(String content) {
        mContent = content;
        mMessage = "Tip";
    }

    public Tip(String content, String message)
    {
        mContent = content;
        mMessage = message;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String mContent) {
        this.mContent = mContent;
    }

    public String getMessage() {
        return mMessage;
    }

    private String mContent;
    private String mMessage;
}
