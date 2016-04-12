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

    private WordItemListener itemListener;

    public WordListAdapter(List<Word> words, WordItemListener wordItemListener) {
        this.words = checkNotNull(words);
        itemListener = wordItemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView textWord;

        private WordItemListener wordItemListener;

        public ViewHolder(View itemView, WordItemListener listener) {
            super(itemView);
            wordItemListener = listener;
            textWord = (TextView) itemView.findViewById(R.id.text_word);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int pos = getAdapterPosition();
            Word word = getItem(pos);
            wordItemListener.onClick(word);
        }
    }

    public Word getItem(int position) {
        return words.get(position);
    }

    @Override
    public WordListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View wordView = inflater.inflate(R.layout.item_word_list, parent, false);
        return new ViewHolder(wordView, itemListener);
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

    public interface WordItemListener {
        void onClick(Word clickedWord);
    }
}
