package com.example.fregment1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class FirstFragment extends Fragment {
    View fragment1view;
 ListView listView;
   String[] countryname=new String[]{"Pakistan","India","America","Nepal","Austrlia","UK"};



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragment1view = inflater.inflate (R.layout.fragment_first, container, false);
        listView=fragment1view.findViewById(R.id.list_view);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1,countryname);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SecondFragment secondFragment=(SecondFragment)getFragmentManager().findFragmentById(R.id.second_fragment);
                secondFragment.setmethod("Country:- "+countryname[i]);
                listView.setSelector(android.R.color.holo_blue_dark);
            }
        });
        return fragment1view;
    }
}