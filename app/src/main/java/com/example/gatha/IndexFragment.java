package com.example.gatha;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class IndexFragment extends Fragment implements View.OnClickListener
{
    private Button mangalcharan;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_index, container,false);

        mangalcharan = view.findViewById(R.id.mangalID);
        mangalcharan.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(IndexFragment.this.getActivity(),MangalActivity.class);
        startActivity(intent);
    }

}
