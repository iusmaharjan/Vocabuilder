package com.iusmaharjan.vocabuilder.model;

import java.util.List;

public interface WordsServiceApi {
    interface WordsServiceCallback<T> {
        void onLoaded(T words);
    }

    void getAllWords(WordsServiceCallback<List<Word>> callback);

    void getWord(String wordId, WordsServiceCallback<Word> callback);

    void saveWord(Word word);

    boolean checkDuplicate(String word);
}
