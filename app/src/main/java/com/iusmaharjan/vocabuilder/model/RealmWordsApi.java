package com.iusmaharjan.vocabuilder.model;

import java.util.List;

import io.realm.Realm;

public class RealmWordsApi implements WordsServiceApi {
    @Override
    public void getAllWords(WordsServiceCallback<List<Word>> callback) {
        Realm realm = Realm.getDefaultInstance();
        List<Word> words = realm.where(Word.class).findAll();
        callback.onLoaded(words);
        realm.close();
    }

    @Override
    public void getWord(String wordId, WordsServiceCallback<Word> callback) {
        Realm realm = Realm.getDefaultInstance();
        Word word = realm.where(Word.class).equalTo("word", wordId).findFirst();
        callback.onLoaded(word);
        realm.close();
    }

    @Override
    public void saveWord(final Word word) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(word);
            }
        });
    }
}
