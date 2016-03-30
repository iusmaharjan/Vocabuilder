package com.iusmaharjan.vocabuilder.main;

public interface MainActivityContract {

    interface View {

        void showAddNewWord();

    }

    interface UserActionsListener {

        void addNewWord();

    }
}
