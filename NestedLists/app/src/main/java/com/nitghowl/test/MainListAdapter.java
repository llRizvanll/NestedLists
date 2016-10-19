package com.nitghowl.test;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.nitghowl.test.R.id.main_container2;
import static com.nitghowl.test.R.id.switcher;


public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.ViewHolder> {

    private Context context;
    private List<RestaurantDataModel.Restaurant> dataObject;
    final String POS_TAG = "positionSelected";
    final String TOTPAGES_TAG = "TOTAL_PAGES_DOWNLOAD";

    public MainListAdapter(Context context,List<RestaurantDataModel.Restaurant> curRestDataHolder){
        this.context = context;
        this.dataObject = curRestDataHolder;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView restaurantNameView,restAreaNameView,summaryTxtView,ratingView,costForTwo,cidNameView;
        public ViewSwitcher viewSwitcher;
        public RelativeLayout card_view;
        public ListView listView;
        public TextView moreOutLet ;
        public RelativeLayout maincontainer2;
        public ViewHolder(View rootView){
            super(rootView);
        }
    }

    @Override
    public MainListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemdetail_main,parent,false);
        MainListAdapter.ViewHolder viewHolder = new MainListAdapter.ViewHolder(view);
        viewHolder.restaurantNameView = (TextView) view.findViewById(R.id.restaurant_name);
        viewHolder.restAreaNameView = (TextView) view.findViewById(R.id.rest_area_name);
        viewHolder.summaryTxtView = (TextView) view.findViewById(R.id.main_list_item_summary);
        viewHolder.viewSwitcher = (ViewSwitcher) view.findViewById(switcher);
        viewHolder.ratingView = (TextView) view.findViewById(R.id.rating);
        viewHolder.costForTwo = (TextView) view.findViewById(R.id.costfortwo);
        viewHolder.cidNameView = (TextView) view.findViewById(R.id.cidName);
        viewHolder.card_view = (RelativeLayout) view.findViewById(R.id.card_view);
        viewHolder.maincontainer2 = (RelativeLayout) view.findViewById(R.id.main_container2);
        viewHolder.listView  = (ListView) view.findViewById(R.id.item_listview);
        viewHolder.moreOutLet = (TextView) view.findViewById(R.id.chainOutletView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MainListAdapter.ViewHolder holder, final int position) {

        final RestaurantDataModel.Restaurant list = dataObject.get(position);


        holder.restaurantNameView.setText(list.getName());

        holder.restAreaNameView.setText(list.getArea());

        holder.summaryTxtView.setText(list.getCity());

        holder.ratingView.setText(list.getAvgRating());

        holder.cidNameView.setText(list.getCid());

        holder.costForTwo.setText(list.getCostForTwo());

        if (false) {
            holder.viewSwitcher.showNext();
        }
        else {
            holder.viewSwitcher.showPrevious();
        }

        if( list.getChain()!= null && list.getChain().size()>0){
            holder.maincontainer2.setVisibility(View.VISIBLE);

            holder.moreOutLet.setText(list.getChain().size()+" more outlet");

            holder.moreOutLet.setVisibility(View.VISIBLE);

            holder.moreOutLet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try{
                        List<String> list1 = new ArrayList<>();
                        ListCustomAdapter adapter = new ListCustomAdapter(list.getChain(),context);
                        holder.listView.setAdapter(adapter);
                        holder.listView.setVisibility(View.VISIBLE);

                        setListViewHeightBasedOnItems(holder.listView);

                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });

        }
        else{
            holder.listView.setVisibility(View.GONE);
            holder.maincontainer2.setVisibility(View.GONE);
            holder.moreOutLet.setVisibility(View.GONE);
        }

        holder.viewSwitcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewSwitcher switcher = (ViewSwitcher) view;
                if (switcher.getDisplayedChild() == 0) {
                    switcher.showNext();
                }
                else {
                    switcher.showPrevious();
                }
            }
        });

        holder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataObject.size();
    }


    public static boolean setListViewHeightBasedOnItems(ListView listView) {

        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter != null) {

            int numberOfItems = listAdapter.getCount();

            // Get total height of all items.
            int totalItemsHeight = 0;
            for (int itemPos = 0; itemPos < numberOfItems;itemPos++){
                View item = listAdapter.getView(itemPos, null, listView);
                item.measure(0, 0);
                totalItemsHeight += item.getMeasuredHeight();
            }

            // Get total height of all item dividers.
            int totalDividersHeight = listView.getDividerHeight() *
                    (numberOfItems - 1);

            // Set list height.
            ViewGroup.LayoutParams params = listView.getLayoutParams();
            params.height = totalItemsHeight + totalDividersHeight;
            listView.setLayoutParams(params);
            listView.requestLayout();

            return true;

        } else {
            return false;
        }

    }

}
