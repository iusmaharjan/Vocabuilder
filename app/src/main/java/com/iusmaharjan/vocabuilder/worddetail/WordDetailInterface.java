package com.iusmaharjan.vocabuilder.worddetail;

import android.support.annotation.NonNull;

public interface WordDetailInterface {
    interface View {
        void showWord(String word);

        void showNote(String note);
    }

    interface UserInteractions {
        void openWord(@NonNull String wordId);
    }
}
