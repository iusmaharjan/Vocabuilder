package com.iusmaharjan.vocabuilder.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iusmaharjan.vocabuilder.R;

public class AddWordFragment extends Fragment {

    public AddWordFragment() {

    }

    public static AddWordFragment getInstance() {
        return new AddWordFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_addword, container, false);

        return rootView;

    }
}
