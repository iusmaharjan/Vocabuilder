package com.iusmaharjan.vocabuilder.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iusmaharjan.vocabuilder.AddWordActivity;
import com.iusmaharjan.vocabuilder.R;

import butterknife.Bind;
import butterknife.OnClick;

public class MainFragment extends Fragment implements MainActivityContract.View {

    private static final int REQUEST_CODE_ADD_WORD = 101;

    private MainActivityContract.UserActionsListener userActionsListener;

    public MainFragment() {

    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        userActionsListener = new MainActivityPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab_add_words);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userActionsListener.addNewWord();
            }
        });

        return rootView;
    }

    @Override
    public void showAddNewWord() {
        startActivityForResult(AddWordActivity.launchAddWordActivity(getContext()), REQUEST_CODE_ADD_WORD);
    }
}
