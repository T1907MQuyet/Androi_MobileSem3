package com.example.assignment4;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter  extends BaseAdapter {
    private List<ContacModel> listCOntacts;
    private Activity activity;

    public ContactAdapter(List<ContacModel> listCOntacts, Activity activity) {
        this.listCOntacts = listCOntacts;
        this.activity = activity;
    }

    @Override
    public int getCount() {
       return  listCOntacts.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater inflater = activity.getLayoutInflater();
            convertView = inflater.inflate(R.layout.item_contact,parent,false);
            ViewHolder holder = new ViewHolder() ;
            holder.tvName = (TextView) convertView.findViewById(R.id.tvName);
            holder.tvPhone = (TextView) convertView.findViewById(R.id.tvPhone);
            holder.ivAvatar = (ImageView) convertView.findViewById(R.id.tvAvatar);
            convertView.setTag(holder);
        }
        ViewHolder holder =(ViewHolder) convertView.getTag();
        ContacModel model = listCOntacts.get(position);
        holder.tvName.setText(model.getName());
        holder.tvPhone.setText(model.getPhone());
        holder.ivAvatar.setImageResource(model.getImage());
        return convertView;

    }
    static class ViewHolder{
        TextView tvName;
        TextView tvPhone;
        ImageView ivAvatar;
    }
}
