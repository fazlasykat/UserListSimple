package com.example.laptop.userlistsimple;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomUserAdapter extends ArrayAdapter<User> {

    private List<User> userList;
    private Context context;

    public CustomUserAdapter(@NonNull Context context, int textViewResourceId, List<User> userList) {
        super(context, textViewResourceId, userList);
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View customView= convertView;
        if (customView==null)
        {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            customView = vi.inflate(R.layout.custom_user_layout, null);

        }

        User user = userList.get(position);


        if(user!=null)
        {

            TextView nameTextView = (TextView) customView.findViewById(R.id.tvName);
            nameTextView.setText(user.getName());

            // thumb image
            ImageView imageView = (ImageView) customView.findViewById(R.id.userImg);
            imageView.setImageResource(user.getImgRes());

            TextView urlTextView = (TextView) customView.findViewById(R.id.tvUrl);
            urlTextView.setText(user.getUrl());

        }

        return  customView;

    }
}