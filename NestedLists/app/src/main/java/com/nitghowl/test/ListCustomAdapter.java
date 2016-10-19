package com.nitghowl.test;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Rizvan Hawaldar on 19/10/16.
 */

public class ListCustomAdapter extends BaseAdapter {

    List<RestaurantDataModel.Chain> list;
    Context context;
    public ListCustomAdapter(List<RestaurantDataModel.Chain> strList, Context context){
        this.context = context;
        this.list = strList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        LayoutInflater mInflater = (LayoutInflater)
                context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.main_list_item, null);
            holder = new ViewHolder();
            holder.main_list_item_summary = (TextView) convertView.findViewById(R.id.main_list_item_summary);
            holder.costfortwo = (TextView) convertView.findViewById(R.id.costfortwo);
            holder.cidName = (TextView) convertView.findViewById(R.id.cidName);
            holder.cus_item = (TextView) convertView.findViewById(R.id.cus_item);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        RestaurantDataModel.Chain chain = list.get(position);

        holder.main_list_item_summary.setText(chain.getAvgRating());
        holder.costfortwo.setText(chain.getCostForTwo());
        holder.cidName.setText(chain.getArea());
        String cuisineStr = "";
        if (chain.getCuisine()!=null) {
            for (String s :
                    chain.getCuisine()) {
                if(cuisineStr.isEmpty()){
                    cuisineStr = s;
                }
                else
                    cuisineStr +=","+s;
            }
            holder.cus_item.setText(cuisineStr);
        }



        return convertView;
    }

    @Override
    public int getCount() {
        return list.size();
    }


    /*private view holder class*/
    private class ViewHolder {
        TextView costfortwo;
        TextView main_list_item_summary;
        TextView cidName;
        TextView cus_item;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }
}
