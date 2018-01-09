package com.assignment.planetspark.learnline.manager;

import com.assignment.planetspark.learnline.model.home.Topic;

import java.util.ArrayList;

/**
 * Created by ramit on 09/01/18.
 */

public class DummyDataManager {

    public static ArrayList<Topic> getTopics()
    {
        ArrayList<Topic> topics = new ArrayList<>();

        Topic topic = new Topic();
        topic.setTitle("Title one");
        topic.setPercentage(50);
        topics.add(topic);

        Topic topic2 = new Topic();
        topic2.setTitle("Title one");
        topic2.setPercentage(50);
        topics.add(topic2);

        return topics;
    }
}
