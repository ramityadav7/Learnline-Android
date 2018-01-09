package com.assignment.planetspark.learnline.model.home;

import com.assignment.planetspark.learnline.model.BaseModel;

/**
 * Created by ramit on 09/01/18.
 */

public class Topic extends BaseModel
{
    private String title;
    private int percentage;
    private TopicDetail topicDetail;
    private boolean isExpanded;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public TopicDetail getTopicDetail() {
        return topicDetail;
    }

    public void setTopicDetail(TopicDetail topicDetail) {
        this.topicDetail = topicDetail;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }
}
