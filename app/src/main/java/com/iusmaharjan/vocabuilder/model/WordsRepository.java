package com.iusmaharjan.vocabuilder.model;

import android.support.annotation.NonNull;

import java.util.List;

public interface WordsRepository {
    interface LoadWordsCallback {
        void onWordsLoaded(List<Word> words);
    }

    interface GetWordCallback {
        void onWordLoaded(Word word);
    }

    void getWords(@NonNull LoadWordsCallback callback);

    void getWord(@NonNull String wordId, @NonNull GetWordCallback callback);

    boolean checkDuplicate(@NonNull String word);

    void saveWord(@NonNull Word word);

    void refreshData();
}
