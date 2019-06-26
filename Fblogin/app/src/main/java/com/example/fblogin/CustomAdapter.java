package com.example.fblogin;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fblogin.User.User;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<User> implements View.OnClickListener{

    private ArrayList<User> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView id;
        TextView bloger_name;
        TextView pic_url;
        TextView types;
        TextView college;
        TextView bloger_topic;
        TextView bloger_blog;
        TextView bloger_status;
        TextView bloger_pic;
        TextView fblink;
        TextView instalink;
    }

    public CustomAdapter(ArrayList<User> data, Context context) {
        super(context, R.layout.row_item, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

//        int position=(Integer) v.getTag();
//        Object object= getItem(position);
//        User user=(User)object;
//
//        switch (v.getId())
//        {
//            case R.id.item_info:
//                Snackbar.make(v, "Release date " + user.getFeature(), Snackbar.LENGTH_LONG)
//                        .setAction("No action", null).show();
//                break;
//        }
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        User user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item, parent, false);
            viewHolder.id = convertView.findViewById(R.id.id);
            viewHolder.bloger_name = convertView.findViewById(R.id.bloger_name);
            viewHolder.pic_url = convertView.findViewById(R.id.pic_url);
            viewHolder.types = convertView.findViewById(R.id.types);
            viewHolder.college = convertView.findViewById(R.id.college);
            viewHolder.bloger_topic = convertView.findViewById(R.id.bloger_topic);
            viewHolder.bloger_blog = convertView.findViewById(R.id.bloger_blog);
            viewHolder.bloger_status = convertView.findViewById(R.id.bloger_status);
            viewHolder.bloger_pic = convertView.findViewById(R.id.bloger_pic);
            viewHolder.fblink = convertView.findViewById(R.id.fblink);
            viewHolder.instalink = convertView.findViewById(R.id.instalink);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        viewHolder.id.setText(user.getId());
        viewHolder.bloger_name.setText(user.getbloger_name());
        viewHolder.pic_url.setText(user.getpic_url());
//        viewHolder.pic_url.setOnClickListener(this);
//        viewHolder.pic_url.setTag(position);
        viewHolder.types.setText(user.getTypes());
        viewHolder.bloger_status.setText(user.getbloger_status());
        viewHolder.college.setText(user.getCollege());
        viewHolder.bloger_topic.setText(user.getbloger_topic());
        viewHolder.bloger_blog.setText(user.getbloger_blog());
        viewHolder.bloger_pic.setText(user.getbloger_pic());
//        viewHolder.bloger_pic.setOnClickListener(this);
//        viewHolder.bloger_pic.setTag(position);
        viewHolder.fblink.setText(user.getFblink());
        viewHolder.instalink.setText(user.getInstalink());
        // Return the completed view to render on screen
        return convertView;
    }
}

