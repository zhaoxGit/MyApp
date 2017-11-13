package com.xian.myapp.Utils;

import android.content.Context;

/**
 * Created by LXR-yfb on 2017/11/13.
 */

public class Utils {


    public static int px2dip(Context mContext, float px) {

        float scale = mContext.getResources().getDisplayMetrics().density;

        return (int) (px / scale + 0.5f);

    }
}
