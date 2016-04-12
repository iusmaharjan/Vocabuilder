package com.iusmaharjan.vocabuilder.model;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.exceptions.RealmPrimaryKeyConstraintException;

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
                try {
                    realm.copyToRealm(word);
                } catch (RealmPrimaryKeyConstraintException e) {
                    //Show appropriate error
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public boolean checkDuplicate(String word) {
        Realm realm = Realm.getDefaultInstance();

        if(realm.where(Word.class).equalTo("word", word).findAll().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void deleteWord(String wordId) {
        Realm realm = Realm.getDefaultInstance();
        final RealmResults<Word> result = realm.where(Word.class).equalTo("word", wordId).findAll();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                result.clear();
            }
        });

    }
}
