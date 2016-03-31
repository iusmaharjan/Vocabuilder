package com.iusmaharjan.vocabuilder.addword;

import android.support.annotation.NonNull;

import static com.google.common.base.Preconditions.checkNotNull;

public class AddWordPresenter implements AddWordContract.UserInteractions {

    private final AddWordContract.View view;

    public AddWordPresenter(@NonNull AddWordContract.View view) {
        this.view = checkNotNull(view);
    }
    @Override
    public void saveWord() {
        // TODO: Save to Database

        view.showWordList();
    }
}
