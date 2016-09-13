package com.maggard.adapterdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get listview object from XML
        listView = (ListView) findViewById(R.id.listView);

        //create array to hold information taken from XML file
        String[] values = getResources().getStringArray(R.array.list_adapter_array);

        //array adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1,values);

        //assign adapter to listview
        listView.setAdapter(adapter);

        //set event handler for list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //list view clicked item index
                int itemPosition = position;

                //listview clicked item value
                String itemValue = (String) listView.getItemAtPosition(position);

                //show alert by toasting it
                Toast.makeText(getApplicationContext(), "position" + (itemPosition + 1) +
                        "\nList Item: " + itemValue, Toast.LENGTH_LONG).show();
            }
        });
    }
}
