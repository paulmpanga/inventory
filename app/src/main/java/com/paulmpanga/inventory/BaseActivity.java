package com.paulmpanga.inventory;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TextInputEditText;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;

/**
 * Created by paulmpanga on 1/26/17.
 */

public class BaseActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    //SessionManager session = new SessionManager(this);

    private ProgressDialog mProgressDialog;
    private AlertDialog.Builder mAlertDialog;

    public void showProgressDialog(String message) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            //progredd disloag is not cancelleable on click outside
            mProgressDialog.setCancelable(false);
            mProgressDialog.setMessage(message);
        }

        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    public void showAlertDialog(String title, String message) {
        if (mAlertDialog == null) {
            mAlertDialog = new AlertDialog.Builder(this);
            mAlertDialog.setTitle(title);
            mAlertDialog.setMessage(message);
            //this cancels on click outside
            mAlertDialog.setCancelable(true);
        }
        mAlertDialog.show();
    }

    public boolean attachDrawer(Toolbar toolbar) {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        return true;
    }

    //disables and enables cursor
    public void cursorAction(final TextInputEditText text) {
        text.setCursorVisible(false);
        text.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                text.setCursorVisible(true);
                return false;
            }
        });
    }

  /*  //adds border, enables ands disbales cursor
    public void borderCursorAction(final TextInputEditText text) {
        text.setBackgroundResource(R.drawable.textinputedittext_border);
        text.setGravity(Gravity.CENTER_HORIZONTAL);
        text.setCursorVisible(false);
        text.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                text.setCursorVisible(true);
                return false;
            }
        });
    }

    public void borderActionAuto(final AutoCompleteTextView text) {
        text.setBackgroundResource(R.drawable.textinputedittext_border);
        text.setGravity(Gravity.CENTER_HORIZONTAL);
        text.setCursorVisible(false);
        text.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                text.setCursorVisible(true);
                return false;
            }
        });
    }
*/
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_manage_transactions) {
            startActivity(new Intent(this, MainActivity.class));
        } else if (id == R.id.nav_manage_items) {
            startActivity(new Intent(this, ManageItemsActivity.class));

        } else if (id == R.id.nav_transactions_history) {
            startActivity(new Intent(this, TransactionHistoryActivity.class));

        } else if (id == R.id.nav_transfer_data) {
            startActivity(new Intent(this, TransferDataActivity.class));

        } else if (id == R.id.nav_out_of_Stock) {
            startActivity(new Intent(this, OutOfStockActivity.class));

        } else if (id == R.id.nav_help) {
            startActivity(new Intent(this, HelpActivity.class));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
