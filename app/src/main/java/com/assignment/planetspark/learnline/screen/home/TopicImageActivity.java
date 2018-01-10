package com.assignment.planetspark.learnline.screen.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.assignment.planetspark.learnline.R;
import com.assignment.planetspark.learnline.constants.AppConstant;
import com.assignment.planetspark.learnline.screen.BaseActivity;
import com.squareup.picasso.Picasso;

/**
 * Created by ramit on 10/01/18.
 */

public class TopicImageActivity extends BaseActivity{

    private ImageView imageViewTopic;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viewer);

        setActionBar(true);

        initializeView();

        String imageUrl = getIntent().getStringExtra(AppConstant.INTENT_KEY_IMAGE_URL);
        populateView(imageUrl);
    }

    private void initializeView()
    {
        imageViewTopic = (ImageView) findViewById(R.id.imageViewTopic);
    }

    private void populateView(String imageUrl)
    {
        Picasso.with(this).load(imageUrl).placeholder(R.drawable.loading).into(imageViewTopic);
    }
}
