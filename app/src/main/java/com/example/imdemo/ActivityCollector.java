package com.example.imdemo;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/9/25.
 */
public class ActivityCollector {
    private static List<Activity> activityList = new ArrayList<Activity>();


    public static void addActivity(Activity activity){
        activityList.add(activity);
    }
    public static void removeActivity(Activity activity){
        activityList.remove(activity);
    }
    public static void finishAll(){
        for (Activity activity : activityList){
            if (! activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
