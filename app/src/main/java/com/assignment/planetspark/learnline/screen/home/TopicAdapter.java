package com.assignment.planetspark.learnline.screen.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.assignment.planetspark.learnline.R;
import com.assignment.planetspark.learnline.constants.AppConstant;
import com.assignment.planetspark.learnline.model.home.Topic;
import com.assignment.planetspark.learnline.model.home.TopicDetail;
import com.assignment.planetspark.learnline.utils.AppUtil;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeStandalonePlayer;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;
import com.google.android.youtube.player.YouTubeThumbnailView.OnInitializedListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ramit on 09/01/18.
 */

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.TopicHolder>{

    public interface TopicItemEventHandler
    {
        void handleTopicItemClick(int position);
    }

    private ArrayList<Topic> topics;
    private TopicItemEventHandler topicItemEventHandler;
    private Context context;

    public TopicAdapter(Context context, TopicItemEventHandler topicItemEventHandler, ArrayList<Topic> topics)
    {
        this.context = context;
        this.topicItemEventHandler = topicItemEventHandler;
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

        holder.relativeLayoutTopic.setTag(position);
        holder.youTubeThumbnailView1.setTag(position);
        holder.youTubeThumbnailView2.setTag(position);
        holder.imageViewTopic.setTag(position);
        holder.webViewTopic.setTag(position);

        if(topic.isExpanded())
        {
            holder.imageViewStatus.setImageResource(R.drawable.up);
            holder.linearLayoutDetailParent.setVisibility(View.VISIBLE);
            holder.viewLine.setVisibility(View.VISIBLE);
        }
        else
        {
            holder.imageViewStatus.setImageResource(R.drawable.down);
            holder.linearLayoutDetailParent.setVisibility(View.GONE);
            holder.viewLine.setVisibility(View.GONE);
        }

        final TopicDetail topicDetail = topic.getTopicDetail();
        if(topic.isExpanded() && topicDetail != null)
        {
            Picasso.with(context).load(topicDetail.getPicture()).placeholder(R.drawable.loading).into(holder.imageViewTopic);
            holder.webViewTopic.loadUrl(topicDetail.getWebUrl());
            holder.youTubeThumbnailView1.initialize(AppConstant.YOUTUBE_KEY, new MediaInitializeListener(topicDetail.getVideoOne()));
            holder.youTubeThumbnailView2.initialize(AppConstant.YOUTUBE_KEY, new MediaInitializeListener(topicDetail.getVideoTwo()));
        }
    }

    public class MediaInitializeListener implements OnInitializedListener
    {
        private String video;

        public MediaInitializeListener(String video)
        {
            this.video = video;
        }

        @Override
        public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, final YouTubeThumbnailLoader youTubeThumbnailLoader) {
            youTubeThumbnailLoader.setVideo(video);
            youTubeThumbnailLoader.setOnThumbnailLoadedListener(new YouTubeThumbnailLoader.OnThumbnailLoadedListener(){
                @Override
                public void onThumbnailError(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader.ErrorReason errorReason) {
                }

                @Override
                public void onThumbnailLoaded(YouTubeThumbnailView youTubeThumbnailView, String s) {
                    youTubeThumbnailLoader.release();
                }
            });
        }

        @Override
        public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {

        }
    }

    public class TopicHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnTouchListener
    {
        public TextView textViewTitle;
        public TextView textViewPercentage;
        public RelativeLayout relativeLayoutTopic;
        public LinearLayout linearLayoutDetailParent;
        public ImageView imageViewTopic;
        public WebView webViewTopic;
        public YouTubeThumbnailView youTubeThumbnailView1;
        public YouTubeThumbnailView youTubeThumbnailView2;
        public ImageView imageViewStatus;
        public TextView viewLine;

        public TopicHolder(View view)
        {
            super(view);
            textViewTitle = view.findViewById(R.id.textViewTitle);
            textViewPercentage = view.findViewById(R.id.textViewPercentage);
            relativeLayoutTopic = view.findViewById(R.id.relativeLayoutTopic);
            linearLayoutDetailParent = view.findViewById(R.id.linearLayoutDetailParent);
            imageViewTopic = view.findViewById(R.id.imageViewTopic);
            webViewTopic = view.findViewById(R.id.webViewTopic);
            youTubeThumbnailView1 = view.findViewById(R.id.youTubeThumbnailView1);
            youTubeThumbnailView2 = view.findViewById(R.id.youTubeThumbnailView2);
            imageViewStatus = view.findViewById(R.id.imageViewStatus);
            viewLine = view.findViewById(R.id.viewLine);

            imageViewTopic.setOnClickListener(this);
            relativeLayoutTopic.setOnClickListener(this);
            youTubeThumbnailView1.setOnClickListener(this);
            youTubeThumbnailView2.setOnClickListener(this);
            webViewTopic.setOnTouchListener(this);
        }

        @Override
        public void onClick(View view)
        {
            int position = (int) view.getTag();

            switch (view.getId())
            {
                case R.id.relativeLayoutTopic:
                {
                    topicItemEventHandler.handleTopicItemClick(position);
                    break;
                }

                case R.id.youTubeThumbnailView1:
                {
                    String videoId = topics.get(position).getTopicDetail().getVideoOne();
                    launchVideoPlayer(videoId);
                    break;
                }

                case R.id.youTubeThumbnailView2:
                {
                    String videoId = topics.get(position).getTopicDetail().getVideoTwo();
                    launchVideoPlayer(videoId);
                    break;
                }

                case R.id.imageViewTopic:
                {
                    Intent intent = new Intent(context, TopicImageActivity.class);
                    intent.putExtra(AppConstant.INTENT_KEY_IMAGE_URL, topics.get(position).getTopicDetail().getPicture());
                    context.startActivity(intent);
                    break;
                }


            }
        }

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent)
        {
            int position = (int) view.getTag();

            switch (view.getId())
            {
                case R.id.webViewTopic:
                {
                    if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    {
                        Intent intent = new Intent(context, TopicWebviewActivity.class);
                        intent.putExtra(AppConstant.INTENT_KEY_WEB_VIEW_URL, topics.get(position).getTopicDetail().getWebUrl());
                        context.startActivity(intent);
                    }
                    break;
                }
            }
            return false;
        }

        private void launchVideoPlayer(String videoId)
        {
            Intent intent = YouTubeStandalonePlayer.createVideoIntent((Activity) context, AppConstant.YOUTUBE_KEY, videoId);
            context.startActivity(intent);
        }
    }
}
