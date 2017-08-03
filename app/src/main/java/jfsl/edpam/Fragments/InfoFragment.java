package jfsl.edpam.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jfsl.edpam.R;

/**
 * Created by kayla2 on 8/21/2016.
 */
public class InfoFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup fragment, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.info_fragment, fragment, false);
        return view;
    }
}