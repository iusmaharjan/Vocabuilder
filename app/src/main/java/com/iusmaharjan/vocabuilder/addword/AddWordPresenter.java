package com.iusmaharjan.vocabuilder.addword;

import android.support.annotation.NonNull;

import com.iusmaharjan.vocabuilder.model.Word;
import com.iusmaharjan.vocabuilder.model.WordsRepository;

import static com.google.common.base.Preconditions.checkNotNull;

public class AddWordPresenter implements AddWordContract.UserInteractions {

    @NonNull
    private final AddWordContract.View view;

    @NonNull
    private final WordsRepository wordsRepository;

    public AddWordPresenter(@NonNull AddWordContract.View view, @NonNull WordsRepository wordsRepository) {
        this.view = checkNotNull(view);
        this.wordsRepository = wordsRepository;
    }
    @Override
    public void saveWord(String word, String note) {
        wordsRepository.saveWord(new Word(word, note));
        view.showWordList();
    }
}
