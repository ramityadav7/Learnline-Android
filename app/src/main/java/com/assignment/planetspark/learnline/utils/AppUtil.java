package com.assignment.planetspark.learnline.utils;

import java.util.Collection;

/**
 * Created by ramit on 09/01/18.
 */

public class AppUtil {

    //Check Collection for Empty
    public static boolean isCollectionEmpty(Collection<? extends Object> collection)
    {
        if(collection == null || collection.isEmpty())
        {
            return true;
        }

        return false;
    }
}
