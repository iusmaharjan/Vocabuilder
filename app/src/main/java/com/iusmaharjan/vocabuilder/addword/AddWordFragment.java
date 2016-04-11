package com.iusmaharjan.vocabuilder.addword;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.iusmaharjan.vocabuilder.R;
import com.iusmaharjan.vocabuilder.model.RealmWordsApi;
import com.iusmaharjan.vocabuilder.model.WordsRepositoryImpl;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddWordFragment extends Fragment implements AddWordContract.View{

    @Bind(R.id.edit_word)
    TextView word;

    @Bind(R.id.edit_note)
    TextView note;

    private AddWordContract.UserInteractions userInteractions;

    public AddWordFragment() {

    }

    public static AddWordFragment getInstance() {
        return new AddWordFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        userInteractions = new AddWordPresenter(this, new WordsRepositoryImpl(new RealmWordsApi()));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_addword, container, false);

        ButterKnife.bind(this, rootView);

        FloatingActionButton floatingActionButton = (FloatingActionButton)getActivity().findViewById(R.id.fab_done);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInteractions.saveWord(word.getText().toString(),note.getText().toString());
            }
        });

        return rootView;
    }

    @Override
    public void showWordList() {
        Toast.makeText(getContext(), "Save Successful", Toast.LENGTH_LONG).show();
        getActivity().setResult(Activity.RESULT_OK);
        getActivity().finish();
    }

    @Override
    public void showEmptyWordError() {
        Toast.makeText(getContext(), getString(R.string.error_empty_word), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showDuplicateWordError() {
        Toast.makeText(getContext(), getString(R.string.error_duplicate_word), Toast.LENGTH_LONG).show();
    }
}
