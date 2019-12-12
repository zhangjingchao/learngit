package com.example.testforfloatingwindow;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testforfloatingwindow.util.GetData;
import com.example.testforfloatingwindow.util.HttpUtil1;


public class MainActivity extends AppCompatActivity {
    private TextView txtMenu, txtshow;
    private ImageView imgPic;
    private WebView webView;
    private ScrollView scroll;
    private Bitmap bitmap;
    private String detail = "";
    private boolean flag = false;
    private final static String PIC_URL = "http://ww2.sinaimg.cn/large/7a8aed7bgw1evshgr5z3oj20hs0qo0vq.jpg";
    private final static String HTML_URL = "https://www.w3cschool.cn/uawnhh/wcrjqozt.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViews();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0) {
            if (!Settings.canDrawOverlays(this)) {
                Toast.makeText(this, "授权失败", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "授权成功", Toast.LENGTH_SHORT).show();
                startService(new Intent(MainActivity.this, FloatingButtonService.class));
            }
        } else if (requestCode == 1) {
            if (!Settings.canDrawOverlays(this)) {
                Toast.makeText(this, "授权失败", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "授权成功", Toast.LENGTH_SHORT).show();
                startService(new Intent(MainActivity.this, FloatingImageDisplayService.class));
            }
        } else if (requestCode == 2) {
            if (!Settings.canDrawOverlays(this)) {
                Toast.makeText(this, "授权失败", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "授权成功", Toast.LENGTH_SHORT).show();
                startService(new Intent(MainActivity.this, FloatingVideoService.class));
            }
        }
    }

    private void setViews() {
        txtMenu = (TextView) findViewById(R.id.txtMenu);
        txtshow = (TextView) findViewById(R.id.txtshow);
        imgPic = (ImageView) findViewById(R.id.imgPic);
        webView = (WebView) findViewById(R.id.webView);
        scroll = (ScrollView) findViewById(R.id.scroll);
        registerForContextMenu(txtMenu);
    }


    // 用于刷新界面
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case 0x001:
                    hideAllWidget();
                    imgPic.setVisibility(View.VISIBLE);
                    imgPic.setImageBitmap(bitmap);
                    Toast.makeText(MainActivity.this, "图片加载完毕", Toast.LENGTH_SHORT).show();
                    break;
                case 0x002:
                    hideAllWidget();
                    scroll.setVisibility(View.VISIBLE);
                    txtshow.setText(detail);
                    Toast.makeText(MainActivity.this, "HTML代码加载完毕", Toast.LENGTH_SHORT).show();
                    break;
                case 0x003:
                    hideAllWidget();
                    webView.setVisibility(View.VISIBLE);
                    webView.loadDataWithBaseURL("", detail, "text/html", "UTF-8", "");
                    Toast.makeText(MainActivity.this, "网页加载完毕", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }

        ;
    };


    // 定义一个隐藏所有控件的方法:
    private void hideAllWidget() {
        imgPic.setVisibility(View.GONE);
        scroll.setVisibility(View.GONE);
        webView.setVisibility(View.GONE);
    }

    public void startFloatingButtonService(View view) {
/*        new Thread()
        {
            public void run()
            {
                try {

                    String url = "https://www.baidu.com/";
                    //String str = ""; // HttpUtil1.sendGet(url);
                    String str =  HttpUtil1.sendGet(url);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };
        }.start();*/
        new Thread() {
            public void run() {
                try {
                    detail = GetData.getHtml(HTML_URL);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        handler.sendEmptyMessage(0x002);
/*        if (FloatingButtonService.isStarted) {
            return;
        }
        if (!Settings.canDrawOverlays(this)) {
            Toast.makeText(this, "当前无权限，请授权", Toast.LENGTH_SHORT);
            startActivityForResult(new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName())), 0);
        } else {
            startService(new Intent(MainActivity.this, FloatingButtonService.class));
        }*/
    }

    public void startFloatingImageDisplayService(View view) {
        if (FloatingImageDisplayService.isStarted) {
            return;
        }
        if (!Settings.canDrawOverlays(this)) {
            Toast.makeText(this, "当前无权限，请授权", Toast.LENGTH_SHORT);
            startActivityForResult(new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName())), 1);
        } else {
            startService(new Intent(MainActivity.this, FloatingImageDisplayService.class));
        }
    }

    public void startFloatingVideoService(View view) {
        if (FloatingVideoService.isStarted) {
            return;
        }
        if (!Settings.canDrawOverlays(this)) {
            Toast.makeText(this, "当前无权限，请授权", Toast.LENGTH_SHORT);
            startActivityForResult(new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName())), 2);
        } else {
            startService(new Intent(MainActivity.this, FloatingVideoService.class));
        }
    }
/*
    private void GetMobileTel() {
        new Thread()
        {
            public void run()
            {
                try {
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpGet httpGet = new HttpGet("//www.w3cschool.cn/python/python-tutorial.html");
                    HttpResponse httpResponse = httpClient.execute(httpGet);
                    if (httpResponse.getStatusLine().getStatusCode() == 200) {
                        HttpEntity entity = httpResponse.getEntity();
                        detail = EntityUtils.toString(entity, "utf-8");
                        handler.sendEmptyMessage(SHOW_DATA);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };
        }.start();
    }*/
/*    private static void getRequestTest() {

        String url = "http://localhost:8080/SpringMVC/greeting?name=lisi";
        try {
            String str = HttpClientUtil.doGet(url, "UTF-8");
            if (str != null) {
                logger.info("http Get request result:" + str);
            } else {
                logger.info("http Get request process fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
