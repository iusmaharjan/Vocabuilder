package com.iusmaharjan.vocabuilder.model;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Word extends RealmObject {

    @PrimaryKey
    private String word;

    private String note;

    private Date date_added;

    public Word() {}

    public Word(String word, String note, Date date_added) {
        this.word = word;
        this.note = note;
        this.date_added = date_added;
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

    public Date getDate() {
        return date_added;
    }

    public void setDate(Date date) {
        this.date_added = date;
    }
}
