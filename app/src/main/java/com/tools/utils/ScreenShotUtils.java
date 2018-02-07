package com.tools.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;

/**
 * Created by zze on 7/2/18.
 */

public final class ScreenShotUtils {

    private ScreenShotUtils() {
    }

    public static Bitmap shotActivity(Activity activity) {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();

        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache(), 0, 0,
                view.getMeasuredWidth(), view.getMeasuredHeight());

        view.setDrawingCacheEnabled(false);
        view.destroyDrawingCache();

        return bitmap;
    }
}
