package com.assignment.planetspark.learnline.manager;

import com.assignment.planetspark.learnline.model.home.Topic;
import com.assignment.planetspark.learnline.model.home.TopicDetail;

import java.util.ArrayList;

/**
 * Created by ramit on 09/01/18.
 */

public class DummyDataManager {

    public static ArrayList<Topic> getTopics()
    {
        ArrayList<Topic> topics = new ArrayList<>();

        for(int iterator = 0; iterator < 30; iterator++)
        {
            Topic topic = new Topic();
            topic.setTitle("Title"+iterator);
            topic.setPercentage((iterator*10) % 100);

            TopicDetail topicDetail = new TopicDetail();
            topicDetail.setPicture("http://kelpies.us/wp-content/uploads/2017/02/worksheets-snapshot-image-of-lucky-leprechaun-subtraction-worksheet-1.jpg");
            topicDetail.setWebUrl("https://s3.ap-south-1.amazonaws.com/planetspark-random/animation.html");
            topicDetail.setVideoOne("_0NsV-tol7s");
            topicDetail.setVideoTwo("-QU8xG-molE");
            topic.setTopicDetail(topicDetail);
            topics.add(topic);
        }

        return topics;
    }
}
