package com.iusmaharjan.vocabuilder.worddetail;

import android.support.annotation.NonNull;

public interface WordDetailInterface {
    interface View {
        void showWord(String word);

        void showNote(String note);

        void showDeleted(String word);
    }

    interface UserInteractions {
        void openWord(@NonNull String wordId);

        void deleteWord(@NonNull String wordId);
    }
}
