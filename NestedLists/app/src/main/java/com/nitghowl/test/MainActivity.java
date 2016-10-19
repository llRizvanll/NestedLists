package com.nitghowl.test;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ActionBarDrawerToggle drawerToggle;
    List<RestaurantDataModel.Restaurant> messageListModel = new ArrayList();
    Toolbar myToolbar;
    int scrolledPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_list_layout);
        mRecyclerView = (RecyclerView) findViewById(R.id.listContainer);
        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        scrolledPosition = 0;
        getNextSetOfRestaurantData(scrolledPosition);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        //mRecyclerView.setLayoutManager(mLayoutManager);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);

        swipeRefreshLayout.setOnRefreshListener(new     SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //refreshData();
                swipeRefreshLayout.setRefreshing(false);

            }
        });



        Drawable drawable = getResources().getDrawable(R.drawable.line);
        RecyclerView.ItemDecoration dividerItemDecoration = new DividerItemDecoration(drawable);

        mRecyclerView.addItemDecoration(dividerItemDecoration);
        setupDrawer();
         linearLayoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());


        mRecyclerView.addOnScrollListener(new EndlessOnScrollListener(linearLayoutManager) {

            @Override
            public void onScrolledToEnd() {
                if (!loading) {
                    loading = true;
                    scrolledPosition++;
                    // add 10 by 10 to tempList then notify changing in data
                    getNextSetOfRestaurantData(scrolledPosition);
                }
                loading = false;
            }
        });


    }
    SwipeRefreshLayout swipeRefreshLayout;
    LinearLayoutManager linearLayoutManager;
    Boolean loading = false;

    @Override
    protected void onPause() {
        super.onPause();
        swipeRefreshLayout.setRefreshing(false);
    }

    DrawerLayout drawerLayout = null ;
    private void setupDrawer() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        drawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override public void onDrawerOpened(View drawerView) {

            }

            @Override public void onDrawerClosed(View drawerView) {

            }

            @Override public void onDrawerStateChanged(int newState) {

            }
        });
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, myToolbar, R.string.open, R.string.close);
         drawerToggle.syncState();
        drawerLayout.addDrawerListener(drawerToggle);
    }

    public void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override public boolean onNavigationItemSelected(MenuItem item) {
                        item.setChecked(true);
                        // manage menu item click
                        drawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    private void showLocationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("NOW");
        builder.setMessage("Hello World!");

        String positiveText = getString(android.R.string.ok);
        builder.setPositiveButton(positiveText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // positive button logic
                        dialog.cancel();
                    }
                });

        String negativeText = getString(android.R.string.cancel);
        builder.setNegativeButton(negativeText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // negative button logic
                        dialog.cancel();
                    }
                });

        AlertDialog dialog = builder.create();
        // display dialog
        dialog.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_settings:
                return true;

            case R.id.action_compose:
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }

    /**
     * Add a divider in between views
     */
    public class DividerItemDecoration extends  RecyclerView.ItemDecoration{
        private Drawable mDivider;
        public DividerItemDecoration(Drawable divider) {
            mDivider = divider;
        }
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);

            if (parent.getChildAdapterPosition(view) == 0) {
                return;
            }

            outRect.top = mDivider.getIntrinsicHeight();
        }

        @Override
        public void onDraw(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
            int dividerLeft = parent.getPaddingLeft();
            int dividerRight = parent.getWidth() - parent.getPaddingRight();
            //System.out.println("Dividers : "+dividerLeft+" divider right : "+dividerRight);
            int childCount = parent.getChildCount();
            for (int i = 0; i < childCount - 1; i++) {
                View child = parent.getChildAt(i);

                RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

                int dividerTop = child.getBottom() + params.bottomMargin;
                int dividerBottom = dividerTop + mDivider.getIntrinsicHeight();

                mDivider.setBounds(dividerLeft, dividerTop, dividerRight, dividerBottom);
                mDivider.draw(canvas);
            }
        }
    }

    public void getNextSetOfRestaurantData(int page){
        if(InternetRequest.isConnectedToInternet(MainActivity.this)){
            Call<RestaurantDataModel> getRestaurantDataRequest = HttpRequestMaker.createService().getRestaurantData(page);
            getRestaurantDataRequest.enqueue(new Callback<RestaurantDataModel>() {
                @Override
                public void onResponse(Call<RestaurantDataModel> call, Response<RestaurantDataModel> response) {
                    if(response.body()!=null){
                        messageListModel.addAll(response.body().getRestaurants());
                        bindViewsByData();
                    }
                    else{
                        CustomToast.show(MainActivity.this,"Error occured ");
                    }
                }

                @Override
                public void onFailure(Call<RestaurantDataModel> call, Throwable t) {
                    CustomToast.show(MainActivity.this,"Error occured ");
                }
            });
        }
        else{
            CustomToast.show(MainActivity.this,"Please Enable Internet Connection!");
        }

    }

    public void bindViewsByData(){

        if (mAdapter == null){
            // specify an adapter (see also next example)
            mAdapter = new MainListAdapter(this,messageListModel);
            mRecyclerView.setAdapter(mAdapter);
        }
        else{

            mAdapter.notifyDataSetChanged();
        }
        loading = false;
        //linearLayoutManager.scrollToPosition(messageListModel.getRestaurants().size()-5);


    }



}
