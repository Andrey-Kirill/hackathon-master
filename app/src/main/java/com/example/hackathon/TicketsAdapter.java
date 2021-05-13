package com.example.hackathon;

import android.graphics.Bitmap;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ticket_item, parent, false);
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

        private final TextView name;
        private final TextView price;
        private final TextView date;
        private final ImageView photo;

        public TicketsViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            date = itemView.findViewById(R.id.date);
            photo = itemView.findViewById(R.id.photo);

            //itemView.setOnCreateContextMenuListener(this);
        }

        public void bind(Ticket ticket) {
            name.setText(ticket.getEvent().getName());
            price.setText(ticket.getEvent().getCost());
            date.setText(ticket.getEvent().getStartDate().toString());
            photo.setImageBitmap(ticket.getEvent().getPhoto());
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