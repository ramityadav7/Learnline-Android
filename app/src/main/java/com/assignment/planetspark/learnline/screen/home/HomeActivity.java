package com.assignment.planetspark.learnline.screen.home;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.assignment.planetspark.learnline.manager.TopicManager;
import com.assignment.planetspark.learnline.model.home.Topic;
import com.assignment.planetspark.learnline.screen.BaseActivity;
import com.assignment.planetspark.learnline.R;
import com.assignment.planetspark.learnline.screen.BaseVideoActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;

import java.util.ArrayList;

public class HomeActivity extends BaseActivity implements TopicAdapter.TopicItemEventHandler
{
    private RecyclerView recyclerViewHome;
    private  TopicAdapter topicAdapter;
    private ArrayList<Topic> topics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initializeView();
        populateView();

    }

    private void initializeView()
    {
        recyclerViewHome = (RecyclerView) findViewById(R.id.recyclerViewHome);

        topics = new ArrayList<>();
        topicAdapter = new TopicAdapter(this, this, topics);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewHome.setLayoutManager(mLayoutManager);
        recyclerViewHome.setAdapter(topicAdapter);
    }

    private void populateView()
    {
        ArrayList<Topic> topics = TopicManager.getTopics();
        this.topics.addAll(topics);
        topicAdapter.notifyDataSetChanged();
    }

    @Override
    public void handleTopicItemClick(int position)
    {
        Topic topic = topics.get(position);
        topic.setExpanded(!topic.isExpanded());
        topicAdapter.notifyItemChanged(position);
    }
}
