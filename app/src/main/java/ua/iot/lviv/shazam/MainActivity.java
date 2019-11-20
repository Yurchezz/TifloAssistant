package ua.iot.lviv.shazam;

import android.os.Bundle;

import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;

import java.util.ArrayList;

import ua.iot.lviv.client.ApiException;
import ua.iot.lviv.client.api.MoviecontrollerApi;
import ua.iot.lviv.client.model.SoundBoard;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ListViewAdapter adapter;
    String[] title;
    String[] description;
    int[] icon;
    ArrayList<SoundBoard> arrayList = new ArrayList<SoundBoard>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final MoviecontrollerApi controller = new MoviecontrollerApi();

        Thread one = new Thread() {
            public void run() {

                    title = new String[]{"Battery", "Cpu", "Display", "Memory", "Sensor"};
                    description = new String[]{"Battery detail...", "Cpu detail...", "Display detail...", "Memory detail...", "Sensor detail..."};
                    icon = new int[]{R.drawable.battery, R.drawable.cpu, R.drawable.display, R.drawable.memory, R.drawable.sensor};


            }
        };
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Items List");


        listView = findViewById(R.id.listView);


        for (int i = 0; i < title.length; i++) {
            SoundBoard model = new SoundBoard();
            //nu yob
            model.setMovieName(title[i]);
            model.setDescription(description[i]);
            arrayList.add(model);
        }
//        try {
//            arrayList = (ArrayList<SoundBoard>) controller.getSoundsUsingGET();
//        } catch (ApiException e) {
//            e.printStackTrace();
//        }
        //pass results to listViewAdapter class
        adapter = new ListViewAdapter(this, arrayList);

        //bind the adapter to the listview
        listView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(myActionMenuItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (TextUtils.isEmpty(s)){
                    adapter.filter("");
                    listView.clearTextFilter();
                }
                else {
                    adapter.filter(s);
                }
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id==R.id.action_settings) {
            //do your functionality here
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}