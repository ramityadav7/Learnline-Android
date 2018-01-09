package com.assignment.planetspark.learnline.manager;

import com.assignment.planetspark.learnline.model.home.Topic;

import java.util.ArrayList;

/**
 * Created by ramit on 09/01/18.
 */

public class TopicManager
{
    public static ArrayList<Topic> getTopics()
    {
        ArrayList<Topic> topics = DummyDataManager.getTopics();

        return topics;
    }
}
