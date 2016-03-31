package com.iusmaharjan.vocabuilder.addword;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.iusmaharjan.vocabuilder.R;

public class AddWordFragment extends Fragment implements AddWordContract.View{

    private AddWordContract.UserInteractions userInteractions;

    public AddWordFragment() {

    }

    public static AddWordFragment getInstance() {
        return new AddWordFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        userInteractions = new AddWordPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_addword, container, false);

        FloatingActionButton floatingActionButton = (FloatingActionButton)getActivity().findViewById(R.id.fab_done);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInteractions.saveWord();
            }
        });

        return rootView;
    }

    @Override
    public void showWordList() {
        Toast.makeText(getContext(), "Save Successful", Toast.LENGTH_LONG).show();
    }
}
