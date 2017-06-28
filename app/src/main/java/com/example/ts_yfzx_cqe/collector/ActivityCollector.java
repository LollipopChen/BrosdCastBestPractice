package com.example.ts_yfzx_cqe.collector;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Activity活动管理器
 * Created by TS-YFZX-CQE on 2017/6/28.
 */

public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<>();

    //添加Activity
    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    //移除Activity
    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    //结束所有的Activity
    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()){ //判断活动是否没有结束
                activity.finish();
            }
        }
    }
}
