package com.nitghowl.test;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by rizvan on 19/10/16.
 */

public abstract class EndlessOnScrollListener extends RecyclerView.OnScrollListener {


    // use your LayoutManager instead
    private LinearLayoutManager llm;

    public EndlessOnScrollListener(LinearLayoutManager sglm) {
        this.llm = sglm;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        if (!recyclerView.canScrollVertically(1)) {
            onScrolledToEnd();
        }
    }

    public abstract void onScrolledToEnd();
}
