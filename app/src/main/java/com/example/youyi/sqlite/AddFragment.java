package com.example.youyi.sqlite;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.youyi.sqlite.findFragment.adatper;
import static com.example.youyi.sqlite.findFragment.books;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddFragment extends Fragment {

    private SQLiteOpenHelper dbHelper;
    private Button add;
    private EditText add_name;
    private EditText add_author;
    private EditText add_pages;
    private EditText add_price;


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add,container,false);
        add = view.findViewById(R.id.add_data);
        add_name = view.findViewById(R.id.add_name);
        add_author = view.findViewById(R.id.add_author);
        add_pages = view.findViewById(R.id.add_pages);
        add_price = view.findViewById(R.id.add_price);

        dbHelper = new MyDatabasesHelper(getContext(),"BookStore.db",null,1);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                //开始组装第一条数据
                values.put("name",add_name.getText().toString());
                values.put("author",add_author.getText().toString());
                values.put("pages",Integer.valueOf(add_pages.getText().toString()));
                values.put("price",Double.parseDouble(add_price.getText().toString()));
                db.insert("Book",null,values);
                Toast.makeText(getContext(),add_name.getText().toString()+"插入数据库成功",Toast.LENGTH_LONG).show();

                books.add(new Book(add_name.getText().toString(),add_author.getText().toString(),Double.valueOf(add_price.getText().toString())));
                adatper.notifyDataSetChanged();
                add_name.setText("");
                add_author.setText("");
                add_pages.setText("");
                add_price.setText("");
            }
        });
        return view;
    }


}
