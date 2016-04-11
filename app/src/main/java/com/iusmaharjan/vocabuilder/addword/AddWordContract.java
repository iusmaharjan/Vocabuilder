package com.iusmaharjan.vocabuilder.addword;

import com.iusmaharjan.vocabuilder.model.Word;

public interface AddWordContract {

    interface View {
        void showWordList();

        void showEmptyWordError();
    }

    interface UserInteractions {
        void saveWord(String word, String note);
    }
}
