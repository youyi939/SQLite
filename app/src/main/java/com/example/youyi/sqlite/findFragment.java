package com.example.youyi.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class findFragment extends Fragment {
    private ListView listView;
    public static List<Book> books = new ArrayList<>();
    public static BookAdatper adatper;
    private SQLiteOpenHelper dbHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find,container,false);
        listView = view.findViewById(R.id.listView);
        dbHelper = new MyDatabasesHelper(getContext(),"BookStore.db",null,1);


        SQLiteDatabase db = dbHelper.getWritableDatabase();
                Cursor cursor = db.query("Book",null,null,null,null,null,null);
                if (cursor.moveToFirst()){
                    do{
                        //遍历cursor对象
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String authoe = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        books.add(new Book(name,authoe,price));
                    }while (cursor.moveToNext());
                }
                cursor.close();




        adatper = new BookAdatper(getContext(),R.layout.item,books);
        listView.setAdapter(adatper);



        return view;
    }


}
