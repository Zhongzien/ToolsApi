package com.tools.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.tools.R;
import com.tools.utils.IntentUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void ACTION_DIAL(View v) {
        startActivity(IntentUtils.phoneBoardIntent("10010"));
    }

    public void ACTION_CALL(View v) {
        startActivity(IntentUtils.callPhoneIntent("10010"));
    }

    public void ACTION_GET_CONTENT(View v) {
        startActivityForResult(IntentUtils.openMedia(IntentUtils.MEDIA_IMAGE), 1);
    }

    public void ACTION_SENDTO(View v) {
        startActivity(IntentUtils.sendSMSIntent("10010", "abc"));
    }

    public void ACTION_IMAGE_CAPTURE(View v) {
        startActivityForResult(IntentUtils.openCameraIntent(null), 0);
    }
}
