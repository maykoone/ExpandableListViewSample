package br.com.maykoone.app.expandablelistviewsample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends ActionBarActivity {

    private Map<String, List<String>> mListChildren;
    private List<String> mListGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillListGroupAndChildren();
        ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        expandableListView.setAdapter(new ExpandableAdapter(MainActivity.this,mListGroup,mListChildren));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


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

    private void fillListGroupAndChildren(){
        mListGroup = Arrays.asList("Animation","Sci-Fi","Gangster");
        mListChildren = new HashMap<>();

        mListChildren.put(mListGroup.get(0), Arrays.asList("Pinocchio", "The Lyon King", "Toy Story"));
        mListChildren.put(mListGroup.get(1), Arrays.asList("Star Wars", "Back to the Future", "2001: A Space Oddysey "));
        mListChildren.put(mListGroup.get(2), Arrays.asList("Scarface", "Pulp Fiction", "The Godfather"));
    }
}
