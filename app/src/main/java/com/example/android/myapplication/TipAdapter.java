package com.example.android.myapplication;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by visla on 5/23/2018.
 */

public class TipAdapter extends ArrayAdapter<Tip> {

    // public WordAdapter (Activity context, ArrayList<Word> wordList) {super(context,0, wordList); }

    public TipAdapter (Activity context, ArrayList<Tip> tipList) {
        super(context, 0, tipList);
    }

    public TipAdapter (Activity context, ArrayList<Tip> tipList, int backGroundColor) {
        super(context, 0, tipList);
        mBackgroundColor = backGroundColor;
    }

    @Override
    @NonNull
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null ) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        final Tip curentTip = getItem(position);

        TextView originalTextView = (TextView) listItemView.findViewById(R.id.original_id);
        originalTextView.setText(curentTip.getContent());


        View layout = listItemView.findViewById(R.id.text_linear_layout);

        int color = ContextCompat.getColor(getContext(), mBackgroundColor);

        layout.setBackgroundColor(color);

        return listItemView;

    }


    private int mBackgroundColor;
}
