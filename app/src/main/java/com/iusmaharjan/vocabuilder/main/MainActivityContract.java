package com.iusmaharjan.vocabuilder.main;

import android.support.annotation.NonNull;

import com.iusmaharjan.vocabuilder.model.Word;

import java.util.List;

public interface MainActivityContract {

    interface View {

        void showAddNewWord();

        void showWords(List<Word> words);

        void showWordDetailUi(String wordId);
    }

    interface UserActionsListener {

        void addNewWord();

        void openWordsDetail(@NonNull Word requesetedWord);

    }
}
