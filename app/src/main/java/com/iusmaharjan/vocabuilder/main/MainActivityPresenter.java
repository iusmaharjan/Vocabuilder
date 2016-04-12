package com.iusmaharjan.vocabuilder.main;

import android.content.Intent;
import android.support.annotation.NonNull;

import com.iusmaharjan.vocabuilder.model.Word;
import com.iusmaharjan.vocabuilder.model.WordsRepository;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class MainActivityPresenter implements MainActivityContract.UserActionsListener{

    @NonNull
    private final MainActivityContract.View view;

    @NonNull
    private final WordsRepository wordsRepository;

    public MainActivityPresenter(@NonNull MainActivityContract.View view, @NonNull WordsRepository wordsRepository) {
        this.view = checkNotNull(view, "View cannot be null");
        this.wordsRepository = wordsRepository;
    }

    @Override
    public void addNewWord() {
        view.showAddNewWord();
    }

    @Override
    public void loadNotes(boolean forced) {
        wordsRepository.getWords(new WordsRepository.LoadWordsCallback() {
            @Override
            public void onWordsLoaded(List<Word> words) {
                view.showWords(words);
            }
        });
    }

    @Override
    public void openWordsDetail(@NonNull Word requestedWord) {
        view.showWordDetailUi(requestedWord.getWord());
    }
}
