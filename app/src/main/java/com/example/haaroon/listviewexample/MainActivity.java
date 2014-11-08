package com.example.haaroon.listviewexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] favouriteTVShows = {
                "Pokemon", "Digimon", "Suits", "Dark Knight",
                "Gotham", "Superman", "Life of Mars",
                "Arrow", "Breaking Bad", "Orphan Black"
        };

        //generates rtows for listview
        ListAdapter theAdapter = new ArrayAdapter<String>(this, R.layout.row_layotu,
                R.id.textview1, favouriteTVShows);
        //create list view
        ListView theListView = (ListView) findViewById(R.id.MainListView);
        //tell list view what values it will use
        theListView.setAdapter(theAdapter);

        theListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                    String tvShowPicked = "You Selected " +
                            String.valueOf( adapterView.getItemAtPosition(position));

                    Toast.makeText( MainActivity.this, tvShowPicked, Toast.LENGTH_SHORT ).show();
                };
        });
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
