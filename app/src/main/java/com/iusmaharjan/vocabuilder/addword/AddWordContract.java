package com.iusmaharjan.vocabuilder.addword;

import com.iusmaharjan.vocabuilder.model.Word;

public interface AddWordContract {

    interface View {
        void showWordList();
    }

    interface UserInteractions {
        void saveWord(String word, String note);
    }
}
