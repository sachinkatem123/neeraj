package com.example.gatha;


import android.Manifest;
import android.content.Context;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import android.widget.ListView;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class MangalActivity extends AppCompatActivity
{
    private ListView lvList;
    private ListOviAdapter adapter;
    private List<ClassListItems> mclassListItems;
    private DatabaseHelper mDBhelper;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
        {
            int permissionstate= ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            mDBhelper.openDatabase();
        }
        else {
            Toast.makeText(this, "PERMISSION DENIED", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mangal);
        lvList = (ListView) findViewById(R.id.ovi_list);
        mDBhelper = new DatabaseHelper(this);

        //Check exist database
        File database = getApplicationContext().getDatabasePath(DatabaseHelper.DB_PATH);
        if(false == database.exists())
        {
            mDBhelper.getReadableDatabase();

            //Copy DB
            if(copyDataBase(this))
            {
                Toast.makeText(this,"Copy Database Succes",Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(null,"Copy data error",Toast.LENGTH_SHORT).show();
                return;
            }
        }

        //Get Ovi list in DB when DB exists
        mclassListItems = mDBhelper.getClassListItems();
        //Init adapter
        adapter = new ListOviAdapter(this,mclassListItems);
        //Set Adapter for ListView
        lvList.setAdapter(adapter);

    }

    private boolean copyDataBase(Context context)
    {
        try
        {
            InputStream inputStream = context.getAssets().open(DatabaseHelper.DB_NAME);
            String outFileName = DatabaseHelper.DB_PATH + DatabaseHelper.DB_NAME;
            OutputStream outputStream = new FileOutputStream(outFileName);
            byte[] buff = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buff))>0)
            {
                outputStream.write(buff,0,length);
            }
            outputStream.flush();
            outputStream.close();
            Log.w("MangalActivity","DB copied");
            return true;

        }
        catch (Exception e)
        {
           e.printStackTrace();
           return false;
        }
    }
}
