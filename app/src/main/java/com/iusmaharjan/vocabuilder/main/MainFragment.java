package com.iusmaharjan.vocabuilder.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iusmaharjan.vocabuilder.AddWordActivity;
import com.iusmaharjan.vocabuilder.R;
import com.iusmaharjan.vocabuilder.Word;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainFragment extends Fragment implements MainActivityContract.View {

    private static final int REQUEST_CODE_ADD_WORD = 101;

    private MainActivityContract.UserActionsListener userActionsListener;

    private WordListAdapter wordListAdapter;

    @Bind(R.id.list_words)
    RecyclerView recyclerView;

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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<Word> words = new ArrayList<>();
        words.add(new Word("One"));
        words.add(new Word("Two"));
        words.add(new Word("Three"));

        wordListAdapter = new WordListAdapter(words);
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
        ButterKnife.bind(this, rootView);

        recyclerView.setAdapter(wordListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return rootView;
    }

    @Override
    public void showAddNewWord() {
        startActivityForResult(AddWordActivity.launchAddWordActivity(getContext()), REQUEST_CODE_ADD_WORD);
    }
}
