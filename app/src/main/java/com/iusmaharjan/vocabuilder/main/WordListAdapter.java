package com.iusmaharjan.vocabuilder.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iusmaharjan.vocabuilder.R;
import com.iusmaharjan.vocabuilder.model.Word;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.ViewHolder>{

    private List<Word> words;

    public WordListAdapter(List<Word> words) {
        this.words = checkNotNull(words);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textWord;

        public ViewHolder(View itemView) {
            super(itemView);
            textWord = (TextView) itemView.findViewById(R.id.text_word);
        }
    }

    @Override
    public WordListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View wordView = inflater.inflate(R.layout.item_word_list, parent, false);
        return new ViewHolder(wordView);
    }

    @Override
    public void onBindViewHolder(WordListAdapter.ViewHolder holder, int position) {
        Word word = words.get(position);
        holder.textWord.setText(word.getWord());
    }

    @Override
    public int getItemCount() {
        return words.size();
    }

    public void replaceData(List<Word> words) {
        setList(words);
        notifyDataSetChanged();
    }

    private void setList(List<Word> words) {
        this.words = checkNotNull(words);
    }
}
