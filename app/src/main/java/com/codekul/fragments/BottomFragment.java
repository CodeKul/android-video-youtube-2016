package com.codekul.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class BottomFragment extends Fragment {

    public static BottomFragment getInstance(){

        BottomFragment fragment = new BottomFragment();

        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_bottom, container, false);

        initButtons(rootView);

        return rootView;
    }

    private void initButtons(View rootView){

        rootView.findViewById(R.id.btnTony).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeAvenger(R.drawable.tony);
            }
        });

        rootView.findViewById(R.id.btnHulk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeAvenger(R.drawable.hulk);
            }
        });
    }

    private void changeAvenger(int avenger){
        ((MainActivity)getActivity())
                .runFragTxn(R.id.frameContainer, ImageFragment.getInstance(avenger));
    }
}
