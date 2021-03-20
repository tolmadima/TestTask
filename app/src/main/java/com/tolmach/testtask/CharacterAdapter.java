package com.tolmach.testtask;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterViewHolder> {
    public CharacterAdapter(OnCharacterListener onCharacterListener){
        this.mOnCharacterListener = onCharacterListener;
    }

    private List<Character> list = new ArrayList<>();
    private OnCharacterListener mOnCharacterListener;

    public void addItems(List<Character> characters){
        list.addAll(characters);
        notifyDataSetChanged();
    }

    public void clearItems(){
        list.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewCharacters = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new CharacterViewHolder(viewCharacters, mOnCharacterListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public interface OnCharacterListener{
        void onCharacterClick(int position);
    }
}
