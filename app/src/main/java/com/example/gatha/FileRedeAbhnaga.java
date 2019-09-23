package com.example.gatha;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileRedeAbhnaga {
    public FileRedeAbhnaga() {
        super();
    }
    public static List<String> fetchAbhangaFromDoc(Context context, String path) throws FileNotFoundException, IOException {

        List<String> returnList = new ArrayList<>();
        File internalStorageDir = context.getFilesDir();
        File file = new File(internalStorageDir,path);

        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);

        String str;
        String appendString = "";
        while((str = br.readLine()) != null){
            System.out.println("This is string"+str);
            if(str.contains("/")){
                appendString = appendString + str.substring(0, str.indexOf('/'));
                returnList.add(appendString);
                appendString = str.substring(str.indexOf('/'));
            }
            else{
                appendString = appendString + str ;
            }
            //System.out.println(appendString);
        }

        return returnList;
    }

}
