package com.example.android.sunshine2;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.Menu;
import android.view.MenuItem;

import java.net.URL;
import java.util.ArrayList;

import com.example.android.sunshine2.FetchWeatherTask;

/**
 * A placeholder fragment containing a simple view.
 */
public class ForecastFragment extends Fragment {

    public ForecastFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ArrayList<String> weatherList = new ArrayList<String>();
        weatherList.add("Today - Sunny - 88/63");
        weatherList.add("Tomorrow - Sunny 88/63");
        weatherList.add("Wed - Cloudy - 22/0");
        weatherList.add("Thur - Snow - 0/0");
        weatherList.add("Fri - Sunny - 88/63");

        ArrayAdapter<String> weatherAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item_forecast,
                R.id.list_item_forecast_textview, weatherList);
        ListView forecastList = (ListView)rootView.findViewById(R.id.listview_forecast);
        forecastList.setAdapter(weatherAdapter);
        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_refresh) {
            new FetchWeatherTask().execute("07670,us");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
