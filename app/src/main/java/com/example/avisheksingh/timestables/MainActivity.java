package com.example.avisheksingh.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView tableList;
    SeekBar scroller;

    public void generateTableContent(int tableValue){

        ArrayList<String> tableContent = new ArrayList<String>();

        for (int i = 1; i <=10; i++){
            tableContent.add(Integer.toString(tableValue * i));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tableContent);
        tableList.setAdapter(arrayAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tableList = (ListView)findViewById(R.id.tableList);
        scroller = (SeekBar) findViewById(R.id.scroller);

        scroller.setMax(20);
        scroller.setProgress(10);

        scroller.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int tableValue;
                if (progress < 1){
                    tableValue = 1;
                    scroller.setProgress(tableValue);
                } else {
                    tableValue = progress;
                }

                generateTableContent(tableValue);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        generateTableContent(10);

    }
}
