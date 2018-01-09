package com.assignment.planetspark.learnline.screen.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.assignment.planetspark.learnline.R;
import com.assignment.planetspark.learnline.model.home.Topic;
import com.assignment.planetspark.learnline.utils.AppUtil;

import java.util.ArrayList;

/**
 * Created by ramit on 09/01/18.
 */

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.TopicHolder>{

    private ArrayList<Topic> topics;

    public TopicAdapter(ArrayList<Topic> topics)
    {
        this.topics = topics;
    }

    @Override
    public int getItemCount() {
        return AppUtil.isCollectionEmpty(topics) ? 0 : topics.size();
    }

    @Override
    public TopicHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.topic_item, parent, false);

        return new TopicHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TopicHolder holder, int position) {

        Topic topic = topics.get(position);

        holder.textViewTitle.setText(topic.getTitle());
        holder.textViewPercentage.setText(String.valueOf(topic.getPercentage()));

    }

    public class TopicHolder extends RecyclerView.ViewHolder
    {
        public TextView textViewTitle;
        public TextView textViewPercentage;


        public TopicHolder(View view)
        {
            super(view);
            textViewTitle = (TextView) view.findViewById(R.id.textViewTitle);
            textViewPercentage = (TextView) view.findViewById(R.id.textViewPercentage);
        }
    }
}
