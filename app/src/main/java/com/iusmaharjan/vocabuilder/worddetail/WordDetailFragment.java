package com.iusmaharjan.vocabuilder.worddetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iusmaharjan.vocabuilder.R;
import com.iusmaharjan.vocabuilder.model.RealmWordsApi;
import com.iusmaharjan.vocabuilder.model.WordsRepositoryImpl;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WordDetailFragment extends Fragment implements WordDetailInterface.View {

    @Bind(R.id.text_word_value)
    TextView wordTextView;

    @Bind(R.id.text_note_value)
    TextView noteTextView;

    private WordDetailInterface.UserInteractions userInteractions;

    private String wordId;

    public WordDetailFragment() {
    }

    public static WordDetailFragment getInstance(Bundle bundle) {
        WordDetailFragment fragment = new WordDetailFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        userInteractions = new WordDetailPresenter(this, new WordsRepositoryImpl(new RealmWordsApi()));
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        wordId = getArguments().getString(getString(R.string.key_word_id));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_word_detail, container, false);

        ButterKnife.bind(this, rootView);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        userInteractions.openWord(wordId);
    }

    @Override
    public void showWord(String word) {
        wordTextView.setText(word);
    }

    @Override
    public void showNote(String note) {
        noteTextView.setText(note);
    }
}
