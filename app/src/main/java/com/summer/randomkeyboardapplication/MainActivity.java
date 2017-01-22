package com.summer.randomkeyboardapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    private WebView webRandomKeyboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webRandomKeyboard = (WebView) findViewById(R.id.web_random_keyboard);
        hideSysInput();
        webRandomKeyboard.getSettings().setJavaScriptEnabled(true);
        webRandomKeyboard.loadUrl("http://dingdang.idsmanager.com:8643/enc/login");
    }

    private void hideSysInput() {
        if (this.getWindow().getDecorView().getWindowToken() != null) {
            InputMethodManager imm = (InputMethodManager) this
                    .getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(this.getWindow().getDecorView().getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
