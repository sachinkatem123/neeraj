package com.example.gatha;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

import static android.database.sqlite.SQLiteDatabase.openDatabase;

public class DatabaseHelper extends SQLiteOpenHelper
{
    public static final String DB_NAME = "SantTukaramGatha.db";
    public static final String DB_PATH = "/data/data/com.example.gatha/databases/";
    private Context mcontext;
    private SQLiteDatabase mdatabase;



    public DatabaseHelper(Context context)
    {
        super(context,DB_NAME,null,3);
        this.mcontext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onOpen(SQLiteDatabase mdatabase) {
        super.onOpen(mdatabase);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
        mdatabase.disableWriteAheadLogging();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


    }

    public void openDatabase()
    {
        int permissionstate = ContextCompat.checkSelfPermission(mcontext, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if(permissionstate == PackageManager.PERMISSION_GRANTED) {
            String dbPath = mcontext.getDatabasePath(DB_NAME).getPath();
            if (mdatabase != null && mdatabase.isOpen()) {
                return;
            }
            mdatabase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
        }
    }

    public  void closeDatabase()
    {
        if(mdatabase != null)
        {
            mdatabase.close();
        }
    }

    public List<ClassListItems> getClassListItems()
    {
        ClassListItems classListItems = null;
        List<ClassListItems> classListItemsList = new ArrayList<>();
        openDatabase();
        mdatabase = getReadableDatabase();
        Cursor cursor = mdatabase.rawQuery("select * from ovi",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast())
        {
            classListItems = new ClassListItems(cursor.getInt(0),cursor.getString(1),cursor.getString(2));
            classListItemsList.add(classListItems);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return classListItemsList;
    }
}
