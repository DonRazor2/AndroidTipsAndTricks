package com.example.android.myapplication;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Pair<String, String>>  TIPS = new ArrayList<>(15);
    private ArrayList<Tip> tipsList = new ArrayList<Tip>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        populateTips();
        populateList();
    }

    private void populateTips() {
        TIPS.add(new Pair("How to do something", "This is the tip for it!"));
    }

    private void populateList() {
        for(Pair<String, String> pair : TIPS) {
            tipsList.add(new Tip(pair.first, pair.second));
        }

        TipAdapter tipAdapter = new TipAdapter(this, tipsList, R.color.secondary_text_default_material_light);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(tipAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Tip curentTip = tipsList.get(i);

                Context context = getApplicationContext();
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, curentTip.getMessage(), duration);
                toast.show();
            }
        });
    }
}
