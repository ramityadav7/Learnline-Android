package com.assignment.planetspark.learnline.screen.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebView;
import android.widget.ImageView;

import com.assignment.planetspark.learnline.R;
import com.assignment.planetspark.learnline.constants.AppConstant;
import com.assignment.planetspark.learnline.screen.BaseActivity;

/**
 * Created by ramit on 10/01/18.
 */

public class TopicWebviewActivity extends BaseActivity{

    private WebView webViewTopic;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        setActionBar(true);

        initializeView();

        String webUrl = getIntent().getStringExtra(AppConstant.INTENT_KEY_WEB_VIEW_URL);
        populateView(webUrl);
    }

    private void initializeView()
    {
        webViewTopic = (WebView) findViewById(R.id.webViewTopic);
    }

    private void populateView(String webUrl)
    {
        webViewTopic.loadUrl(webUrl);
    }
}
