package com.example.gatha;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListOviAdapter extends BaseAdapter {

    private Context mcontext;
    private List<ClassListItems> mclassListItems;

    public ListOviAdapter(Context mcontext, List<ClassListItems> mclassListItems) {
        this.mcontext = mcontext;
        this.mclassListItems = mclassListItems;
    }

    @Override
    public int getCount() {
        return mclassListItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mclassListItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mclassListItems.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View v = View.inflate(mcontext, R.layout.list_view_mysql,null);
        TextView index = (TextView)v.findViewById(R.id.textView);
        TextView abhang = (TextView)v.findViewById(R.id.textView2);
        index.setText(mclassListItems.get(position).getIndexText());
        abhang.setText(mclassListItems.get(position).getOviText());
        return view;
    }
}
