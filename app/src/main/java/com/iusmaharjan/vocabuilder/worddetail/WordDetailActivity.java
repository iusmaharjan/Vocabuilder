package com.iusmaharjan.vocabuilder.worddetail;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.iusmaharjan.vocabuilder.R;

public class WordDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_detail);
        Bundle bundle = getIntent().getExtras();
        if(null == savedInstanceState) {
            initFragment(WordDetailFragment.getInstance(bundle));
        }
    }

    public static Intent launchWordDetailActivity(Context context, String wordId) {
        Intent intent = new Intent(context, WordDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(context.getString(R.string.key_word_id), wordId);
        intent.putExtras(bundle);
        return intent;
    }


    public void initFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.contentFrame, fragment);
        transaction.commit();
    }
}
