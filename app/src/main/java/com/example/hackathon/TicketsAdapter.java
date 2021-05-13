package com.example.forschool;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hackathon.R;
import com.example.hackathon.Ticket;

import java.util.ArrayList;


public class TicketsAdapter extends RecyclerView.Adapter<TicketsAdapter.TicketsViewHolder> {

    private ArrayList<Ticket> tickets;
    private final Listener onTicketClickListener;

    public TicketsAdapter(ArrayList<Ticket> tickets, Listener onTicketClickListener) {
        this.tickets = tickets;
        this.onTicketClickListener = onTicketClickListener;
    }

    @NonNull
    @Override
    public TicketsAdapter.TicketsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.olympiad_item, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTicketClickListener.onTicketClick((int) v.getTag());
            }
        });
        return new TicketsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TicketsAdapter.TicketsViewHolder holder, int position) {
        Ticket ticket = tickets.get(position);
        holder.bind(ticket);
        holder.itemView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return tickets.size();
    }

    static final class TicketsViewHolder extends RecyclerView.ViewHolder{

        private final TextView nameTextView;
        private final TextView organizerTextView;
        private final TextView subjectTextView;
        private final TextView levelTextView;
        private final ImageView img;

        public TicketsViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.name);
            organizerTextView = itemView.findViewById(R.id.organizer);
            subjectTextView = itemView.findViewById(R.id.subject);
            levelTextView = itemView.findViewById(R.id.level);
            img  = itemView.findViewById(R.id.imageView5);

            //itemView.setOnCreateContextMenuListener(this);
        }

        public void bind(Ticket ticket) {
            nameTextView.setText(.getShortName());
            organizerTextView.setText(olympiad.getOrganizer());
            subjectTextView.setText(olympiad.getSubject());
            levelTextView.setText(olympiad.getLevel());
            img.setImageBitmap(olympiad.getBitmap());
        }
        /*
        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            contextMenu.setHeaderTitle(R.string.recycle_view_context_menu_title);
            contextMenu.add(0, 0, 0, R.string.recycle_view_context_menu_favorite);
            contextMenu.add(0, 1, 0, R.string.recycle_view_context_menu_share);
        }
         */

    }



    interface Listener {

        void onTicketClick(int position);

    }
}