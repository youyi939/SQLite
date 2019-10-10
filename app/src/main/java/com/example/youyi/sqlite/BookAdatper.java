package com.example.youyi.sqlite;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.example.youyi.sqlite.findFragment.books;

public class BookAdatper extends ArrayAdapter<Book> {
    private int resourceId;
    private SQLiteOpenHelper dbHelper;
    private Context context;

    public BookAdatper(Context context, int resource,  List<Book> objects) {
        super(context, resource, objects);
        resourceId = resource;
        this.context = context;
    }
    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        dbHelper = new MyDatabasesHelper(getContext(),"BookStore.db",null,1);
        final Book book = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        final TextView bookName = view.findViewById(R.id.book_name);
        final TextView bookAuthor = view.findViewById(R.id.book_author);
        final TextView bookPrice = view.findViewById(R.id.book_price);
        Button delete = view.findViewById(R.id.delete);

        bookName.setText(String.valueOf(book.getName()));
        bookAuthor.setText(String.valueOf(book.getAuthor()));
        bookPrice.setText(String.valueOf(book.getPrice()));


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.delete("Book","name > ?" , new String[]{book.getName()});
                books.remove(book);
                notifyDataSetChanged();
            }
        });


    return view;
    }
}
