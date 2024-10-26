package edu.psu.swen888.authenticationpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.Date;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{
    Context context;
    private ArrayList<Book> booksList;

    public RecyclerViewAdapter(Context context, ArrayList<Book> booksList){
        this.context = context;
        this.booksList = booksList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView bookAuthor;
        private TextView bookIsbn;
        private TextView bookPublishDate;
        private TextView bookPublisher;
        private TextView bookTitle;
        public MyViewHolder(final View view){
            super(view);
            bookAuthor = view.findViewById(R.id.textview_book_author);
            bookIsbn = view.findViewById(R.id.textview_book_isbn);
            bookPublishDate = view.findViewById(R.id.textview_book_publish_date);
            bookPublisher = view.findViewById(R.id.textview_book_publisher);
            bookTitle = view.findViewById(R.id.textview_book_title);
        }
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.book_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bookAuthor.setText(booksList.get(position).getAuthor());
        holder.bookIsbn.setText(Long.toString(booksList.get(position).getIsbn()));
        holder.bookPublishDate.setText(booksList.get(position).getPublication());
        holder.bookPublisher.setText(booksList.get(position).getPublisher());
        holder.bookTitle.setText(booksList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        if(booksList != null) {
            return booksList.size();
        }
        return 0;
    }
}
