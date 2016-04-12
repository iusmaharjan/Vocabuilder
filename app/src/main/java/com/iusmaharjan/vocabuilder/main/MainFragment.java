package com.iusmaharjan.vocabuilder.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.iusmaharjan.vocabuilder.addword.AddWordActivity;
import com.iusmaharjan.vocabuilder.R;
import com.iusmaharjan.vocabuilder.model.RealmWordsApi;
import com.iusmaharjan.vocabuilder.model.Word;
import com.iusmaharjan.vocabuilder.model.WordsRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

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

        userActionsListener = new MainActivityPresenter(this, new WordsRepositoryImpl(new RealmWordsApi()));
    }

    private WordListAdapter.WordItemListener wordItemListener = new WordListAdapter.WordItemListener() {
        @Override
        public void onClick(Word clickedWord) {
            userActionsListener.openWordsDetail(clickedWord);
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        wordListAdapter = new WordListAdapter(new ArrayList<Word>(0), wordItemListener);
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
    public void onResume() {
        super.onResume();
        userActionsListener.loadNotes(false);
    }

    @Override
    public void showAddNewWord() {
        startActivityForResult(AddWordActivity.launchAddWordActivity(getContext()), REQUEST_CODE_ADD_WORD);
    }

    @Override
    public void showWords(List<Word> words) {

        List<Word> wordsList = new ArrayList<Word>();

        // TODO: Review
        // Hack to remove realm error
        for(Word word: words) {
            wordsList.add(new Word(word.getWord()));
        }

        wordListAdapter.replaceData(wordsList);
    }

    @Override
    public void showWordDetailUi(String wordId) {
        Toast.makeText(getContext(), wordId, Toast.LENGTH_LONG).show();
    }
}
