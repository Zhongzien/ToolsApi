package com.tools.utils;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.File;

/**
 * Created by zze on 8/1/18.
 */

public final class IntentUtils {
    public static final String MEDIA_ALL = "*/*";
    public static final String MEDIA_IMAGE = "image/*";
    public static final String MEDIA_AUDIO = "audio/*";
    public static final String MEDIA_VIDEO = "video/*";
    public static final String MEDIA_VIDEO_AND_IMAGE = "video/*;image/";

    private IntentUtils() {
    }

    /**
     * need <uses-permission id="android.permission.CALL_PHONE" />
     *
     * @param phone
     * @return
     */
    public static Intent phoneBoardIntent(String phone) {
        Uri uri = Uri.parse("tel:" + phone);
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        return intent;
    }

    /**
     * need <uses-permission id="android.permission.CALL_PHONE" />
     *
     * @param phone
     * @return
     */
    public static Intent callPhoneIntent(String phone) {
        Uri uri = Uri.parse("tel:" + phone);
        Intent intent = new Intent(Intent.ACTION_CALL, uri);
        return intent;
    }

    public static Intent webIntent(String url) {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        return intent;
    }

    /**
     * <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
     * @param mediaType
     * @return
     */
    public static Intent openMedia(String mediaType) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType(mediaType);//设置类型，我这里是任意类型，任意后缀的可以这样写。
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        return intent;
    }

    /**
     * need <uses-permission android:name="android.permission.SEND_SMS" />
     *
     * @param photo
     * @param content
     * @return
     */
    public static Intent sendSMSIntent(String photo, String content) {
        Uri uri = Uri.parse("smsto:" + photo);
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra("sms_body", content);
        return intent;
    }

    /**
     * <uses-permission android:name="android.permission.CAMERA" />
     * <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
     * <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
     * @param file
     * @return
     */
    public static Intent openCameraIntent(File file) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (file != null) {
            Uri uri = Uri.fromFile(file);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        }
        return intent;
    }
}
