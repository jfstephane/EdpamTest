package jfsl.edpam.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import jfsl.edpam.R;

/**
 * Created by kayla2 on 9/18/2016.
 */
public class LocationFragment extends Fragment {

    String[] Location={"Trottoir", "Route", "Poteau", "incident"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.location_fragment, container, false);

        ListView lvLocation = (ListView) view.findViewById(R.id.lvLocation);
        ArrayAdapter adapter = new ArrayAdapter(this.getActivity(), android.R.layout.simple_list_item_1, Location);
        lvLocation.setAdapter(adapter);

        lvLocation.setOnItemClickListener(new AdapterView.OnItemClickListener(){


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getActivity(), Location[position], Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
