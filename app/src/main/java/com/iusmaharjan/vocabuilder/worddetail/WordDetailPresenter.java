package com.iusmaharjan.vocabuilder.worddetail;

import android.support.annotation.NonNull;

import com.iusmaharjan.vocabuilder.model.Word;
import com.iusmaharjan.vocabuilder.model.WordsRepository;

public class WordDetailPresenter implements WordDetailInterface.UserInteractions {

    private WordDetailInterface.View view;
    private WordsRepository wordsRepository;

    public WordDetailPresenter(@NonNull WordDetailInterface.View view, @NonNull WordsRepository wordsRepository) {
        this.view = view;
        this.wordsRepository = wordsRepository;
    }

    @Override
    public void openWord(@NonNull String wordId) {
        wordsRepository.getWord(wordId, new WordsRepository.GetWordCallback() {
            @Override
            public void onWordLoaded(Word word) {
                view.showWord(word.getWord());
                view.showNote(word.getNote());
            }
        });
    }
}
