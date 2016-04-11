package com.iusmaharjan.vocabuilder.main;

import android.content.Intent;
import android.support.annotation.NonNull;

import com.iusmaharjan.vocabuilder.model.Word;

import static com.google.common.base.Preconditions.checkNotNull;

public class MainActivityPresenter implements MainActivityContract.UserActionsListener{

    private final MainActivityContract.View view;

    public MainActivityPresenter(@NonNull MainActivityContract.View view) {
        this.view = checkNotNull(view, "View cannot be null");
    }

    @Override
    public void addNewWord() {
        view.showAddNewWord();
    }

    @Override
    public void loadNotes(boolean forced) {
        //TODO: Implement this method
    }

    @Override
    public void openWordsDetail(@NonNull Word requesetedWord) {
        //TODO: Implement this method
    }
}
