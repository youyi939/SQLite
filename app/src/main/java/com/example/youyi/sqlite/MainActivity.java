package com.example.youyi.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button updata;
    private Button delete;
    private Button find;


    private ViewPager viewPager;
    private List<Fragment> fragments = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewpager);
        fragments.add(new AddFragment());
        fragments.add(new findFragment());

        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        };
        viewPager.setAdapter(adapter);



//        find = findViewById(R.id.find);
//        delete = findViewById(R.id.delete);
//        updata = findViewById(R.id.up_data);






//
//        updata.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SQLiteDatabase db = dbHelper.getWritableDatabase();
//                ContentValues values = new ContentValues();
//                values.put("price",1.1);
//                db.update("Book",values,"name = ?",new String[]{"百科全书"});
//                Toast.makeText(MainActivity.this,"数据修改成功",Toast.LENGTH_LONG).show();
//            }
//        });
//
//
//        delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SQLiteDatabase db = dbHelper.getWritableDatabase();
//                db.delete("Book","pages > ?" , new String[]{"100"});
//            }
//        });
//
//        find.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SQLiteDatabase db = dbHelper.getWritableDatabase();
//                Cursor cursor = db.query("Book",null,null,null,null,null,null);
//                if (cursor.moveToFirst()){
//                    do{
//                        //遍历cursor对象
//                        String name = cursor.getString(cursor.getColumnIndex("name"));
//                        String authoe = cursor.getString(cursor.getColumnIndex("author"));
//                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
//                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
//                        Log.i("Book","name: "+name+" author:"+authoe+" pages:"+pages+" price"+price);
//                    }while (cursor.moveToNext());
//                }
//                cursor.close();
//            }
//        });

    }
}
