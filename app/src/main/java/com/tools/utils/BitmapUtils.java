package com.tools.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * Created by zze on 7/2/18.
 */

public final class BitmapUtils {
    private BitmapUtils() {
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        final int width = options.outWidth;
        final int height = options.outHeight;
        int inSampleSize = 1;

        if (width > reqWidth || height > reqHeight) {
            int halfWidth = width / 2;
            int halfHeight = height / 2;
            while ((halfWidth / inSampleSize) >= reqWidth && (halfHeight / inSampleSize) >= reqHeight) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    public static Bitmap decodeSimpleBitmapFromFile(String file, int reqWidth, int reqHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file, options);

        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;

        return BitmapFactory.decodeFile(file, options);
    }

    public static Bitmap compressBitmap(Bitmap bitmap, int tagerSize) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //这里压缩options%,100表示不压缩
        int options = 100;
        bitmap.compress(Bitmap.CompressFormat.JPEG, options, outputStream);
        options -= 10;
        while (outputStream.toByteArray().length / 1024 > tagerSize) {
            outputStream.reset();
            bitmap.compress(Bitmap.CompressFormat.JPEG, options, outputStream);
            options -= 10;
        }
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        return BitmapFactory.decodeStream(inputStream, null, null);
    }

    public static Bitmap zoomBitmap(Bitmap bm, int newWidth, int newHeight) {
        // 获得图片的宽高
        int width = bm.getWidth();
        int height = bm.getHeight();
        // 计算缩放比例
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // 取得想要缩放的matrix参数
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        // 得到新的图片
        return Bitmap.createBitmap(bm, 0, 0, width, height, matrix, true);
    }

}
