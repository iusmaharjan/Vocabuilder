package com.iusmaharjan.vocabuilder.addword;

public interface AddWordContract {

    interface View {
        void showWordList();
    }

    interface UserInteractions {
        void saveWord();
    }
}
