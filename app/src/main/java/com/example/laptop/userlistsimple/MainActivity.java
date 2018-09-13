package com.example.laptop.userlistsimple;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;

import android.view.View;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    CustomUserAdapter customUserAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List userList = new ArrayList();

        userList.add(new User("User1","http://fb.com/user1",R.drawable.tintin_thumb));
        userList.add(new User("User2","http://fb.com/user2",R.drawable.snowy_thumb));
        userList.add(new User("User3","http://fb.com/user3",R.drawable.asterix_thumb));
        userList.add(new User("User4","http://fb.com/user4",R.drawable.obelix_thumb));

        customUserAdapter = new CustomUserAdapter(this,R.layout.custom_user_layout, userList);

        setListAdapter(customUserAdapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        User user = customUserAdapter.getItem(position);
        Intent myIntent= new Intent(
                Intent.ACTION_VIEW,
                Uri.parse(user.getUrl()));
        startActivity(myIntent);

    }
}
