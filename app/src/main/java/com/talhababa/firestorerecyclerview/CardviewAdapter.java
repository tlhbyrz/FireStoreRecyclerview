package com.talhababa.firestorerecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class CardviewAdapter extends FirestoreRecyclerAdapter<CardviewNotes,CardviewAdapter.CardHolder> {

    public CardviewAdapter(@NonNull FirestoreRecyclerOptions<CardviewNotes> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull CardviewAdapter.CardHolder holder, int position, @NonNull CardviewNotes model) {
        holder.title.setText(model.getTitle());
        holder.description.setText(model.getDescription());
        holder.priority.setText(String.valueOf(model.getPriority()));
    }

    public void deleteNote(int position){
        getSnapshots().getSnapshot(position).getReference().delete();
    }

    @NonNull
    @Override
    public CardviewAdapter.CardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);

        return new CardHolder(view);
    }

    public class CardHolder extends RecyclerView.ViewHolder{

        private TextView title;
        private TextView description;
        private TextView priority;

        public CardHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.textview_title);
            description = itemView.findViewById(R.id.textview_description);
            priority = itemView.findViewById(R.id.textview_priority);
        }
    }
}
