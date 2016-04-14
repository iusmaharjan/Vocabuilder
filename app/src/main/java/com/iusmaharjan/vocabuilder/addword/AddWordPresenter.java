package com.iusmaharjan.vocabuilder.addword;

import android.support.annotation.NonNull;

import com.iusmaharjan.vocabuilder.model.Word;
import com.iusmaharjan.vocabuilder.model.WordsRepository;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
        if(word == null || "".equals(word)) {
            view.showEmptyWordError();
        } else {
            if(wordsRepository.checkDuplicate(word)) {
                view.showDuplicateWordError();
            } else {
                wordsRepository.saveWord(new Word(word, note, new Date()));
                view.showWordList();
            }
        }
    }
}
