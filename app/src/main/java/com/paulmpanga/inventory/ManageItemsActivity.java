package com.paulmpanga.inventory;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;

public class ManageItemsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_items);
        Toolbar toolbar = (Toolbar) findViewById(R.id.manageItemsToolbar);
        toolbar.setVisibility(View.VISIBLE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.manage_items));

        final ViewGroup viewGroup = (ViewGroup) findViewById(R.id.manageItemsLayout);
        viewGroup.setVisibility(View.VISIBLE);


        attachDrawer(toolbar);
    }

}
