package com.iusmaharjan.vocabuilder.model;

import android.support.annotation.NonNull;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class WordsRepositoryImpl implements WordsRepository {

    private WordsServiceApi mWordsServiceApi;

    public WordsRepositoryImpl(@NonNull WordsServiceApi wordsServiceApi) {
        mWordsServiceApi = checkNotNull(wordsServiceApi);
    }

    @Override
    public void getWords(@NonNull final LoadWordsCallback callback) {
        mWordsServiceApi.getAllWords(new WordsServiceApi.WordsServiceCallback<List<Word>>() {
            @Override
            public void onLoaded(List<Word> words) {
                callback.onWordsLoaded(words);
            }
        });
    }

    @Override
    public void getWord(@NonNull String wordId, @NonNull final GetWordCallback callback) {
        mWordsServiceApi.getWord(wordId, new WordsServiceApi.WordsServiceCallback<Word>() {
            @Override
            public void onLoaded(Word words) {
                callback.onWordLoaded(words);
            }
        });
    }

    @Override
    public void saveWord(@NonNull Word word) {
        mWordsServiceApi.saveWord(word);
    }

    @Override
    public void refreshData() {

    }

    @Override
    public boolean checkDuplicate(@NonNull String word) {
        return mWordsServiceApi.checkDuplicate(word);
    }
}
