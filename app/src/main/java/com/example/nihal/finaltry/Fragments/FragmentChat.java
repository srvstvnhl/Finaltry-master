package com.example.nihal.finaltry.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nihal.finaltry.Adapters.RecyclerViewAdapter;
import com.example.nihal.finaltry.Classes.Chat;
import com.example.nihal.finaltry.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentChat extends Fragment {

    View v;
    private RecyclerView myrecyclerview;
    private List<Chat> FirstChat;
    public FragmentChat() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v= inflater.inflate(R.layout.chat_fragment,container,false);
        myrecyclerview= v.findViewById(R.id.chat_recyclerview);
        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getContext(),FirstChat);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirstChat = new ArrayList<>();
        FirstChat.add(new Chat("xyz",R.drawable.chat1));
        FirstChat.add(new Chat("abc",R.drawable.chat2));
    }
}
