package com.assignment.planetspark.learnline.screen;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.assignment.planetspark.learnline.R;

/* BaseActivity is parent of all activities.
All common code goes here */
public class BaseActivity extends AppCompatActivity {


    public void setActionBar(boolean showBack)
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null)
        {
            actionBar.setDisplayHomeAsUpEnabled(showBack);
            actionBar.setDisplayShowHomeEnabled(showBack);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int menuItemId = item.getItemId();

        switch (menuItemId)
        {
            case android.R.id.home:
            {
                finish();
                break;
            }

        }

        return super.onOptionsItemSelected(item);
    }

}
