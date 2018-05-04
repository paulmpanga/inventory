package com.paulmpanga.inventory.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.paulmpanga.inventory.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LowStockFragment extends Fragment {


    public LowStockFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_low_stock, container, false);
    }

}
