package com.iusmaharjan.vocabuilder.model;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Word extends RealmObject {

    @PrimaryKey
    private String word;

    private String note;

    public Word() {}

    public Word(String word, String note) {
        this.word = word;
        this.note = note;
    }

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
