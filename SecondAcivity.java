package com.jinh.application;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.widget.Button;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
//import com.ashokvarma.bottomnavi
public class SecondAcivity extends Activity {
    Button b0,b1,b2,b3,b4,b5,b6,
            b7,b8,b9,b10,b11,b12,
            b13,b14,b15,b16,b17,b18,
            b19,b20,b21,b22,b23,b24,
            b25,b26,b27,b28,b29,b30;
    Integer[][] Bid= new Integer[][]{
            {R.id.b00,R.id.b01,R.id.b02,R.id.b03,R.id.b04,R.id.b05},
            {R.id.b10,R.id.b11,R.id.b12,R.id.b13,R.id.b14,R.id.b15},
            {R.id.b20,R.id.b21,R.id.b22,R.id.b23,R.id.b24,R.id.b25},
            {R.id.b30,R.id.b31,R.id.b32,R.id.b33,R.id.b34,R.id.b35},
            {R.id.b40,R.id.b41,R.id.b42,R.id.b43,R.id.b44,R.id.b45}
    };
    Button[] Buttons=new Button[]{
            b0,b1,b2,b3,b4,b5,b6,
            b7,b8,b9,b10,b11,b12,
            b13,b14,b15,b16,b17,b18,
            b19,b20,b21,b22,b23,b24,
            b25,b26,b27,b28,b29,b30
//            b31,b32,b33,b34,b35,b36,
//            b37,b38,b39,b40,b41,b42,
//            b43,b44,b45,b46,b47,
    };
//    BottomNavigationBar
    Button PlayMusic;
    SoundPool soundPool;
    int soundID;
    Button B3;
    WebView webView;
    String[] ClassInformation = new String[30];
    int[][] ClassTime = new int[30][2];
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule);
        //将数据写入按钮
        webView=findViewById(R.id.webView);
        ReadInformation();
        for(int i=0;i<5;i++){
            for(int j=0;j<6;j++){
                Buttons[i*6+j]=findViewById(Bid[i][j]);
            }
        }
        String ClassName;
        for(int i=0;i<30;i++){
            ClassName=ClassInformation[i];
//                        System.out.print(ClassInformation[i]);

//                        Buttons[ClassTime[i][0]*6+ClassTime[i][1]].setText(ClassInformation[i]);
//                        Buttons[i].setText(String.valueOf(i));
//                    Buttons[i].findViewById(Bid[ClassTime[i][0]][ClassTime[i][1]]);
            Buttons[ClassTime[i][0]*6+ClassTime[i][1]/2].setText(ClassName);
        }

//        mBottomNavigationBar=
        soundPool=new SoundPool.Builder().build();
        soundID=soundPool.load(this, R.raw.a1,1);
        PlayMusic=findViewById(R.id.sing);
        PlayMusic.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                soundPool.play(
                        soundID,
                        0.1f,
                        0.5f,
                        0,0,1
                );
            }
        });

        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_home_black_24dp, "课程"))
                .addItem(new BottomNavigationItem(R.drawable.ic_schedule_black_24dp, "登录"))
                .addItem(new BottomNavigationItem(R.drawable.ic_face_black_24dp, "我的"))
                .initialise();
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener(){
            @Override
            public void onTabSelected(int position) {
                switch (position){
                    //课程
                    case 0:break;
                    //登录
                    case 1:Intent intent = new Intent();
                        intent.setClass(SecondAcivity.this,MainActivity.class);
                        startActivity(intent);
                        break;
                     //我的
                    case 2:Intent intent1 = new Intent();
                        intent1.setClass(SecondAcivity.this,PhotoActivity.class);
                        startActivity(intent1);
                }
            }
            @Override
            public void onTabUnselected(int position) {
            }
            @Override
            public void onTabReselected(int position) {
            }
        });
        B3=findViewById(R.id.b000);
        B3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("isFirstUse", MODE_WORLD_READABLE);
                SharedPreferences.Editor editor = preferences.edit();
                //存入数据
                editor.putBoolean("isFirstUse", true);
                //提交修改
                editor.commit();
                //重新加载第一页
                Intent intent = new Intent();
                intent.setClass(SecondAcivity.this,MainActivity.class);
                startActivity(intent);
//                    android.webkit.CookieSyncManager cookieSyncManager =  CookieSyncManager.createInstance(webView.getContext());
                CookieManager cookieManager = CookieManager.getInstance();
                cookieManager.setAcceptCookie(true);
                cookieManager.removeAllCookies(null);
//                setContentView(R.layout.activity_main);

//                webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
//                webView.clearHistory();
//                webView.clearFormData();
//                webView.clearCache(true);


            }
        });
    }
    public void ReadInformation(){
        BufferedReader br=null;
        String TempInformation=null;
        try {

            br=new BufferedReader(new InputStreamReader(openFileInput("ClassInformation.txt"),"utf-8"));
            TempInformation=br.readLine();
            for(int i=0;i<30;i++){
                if(TempInformation!=null)
                    ClassInformation[i]=TempInformation;
                TempInformation=br.readLine();
            }
            for(int i=0;i<30;i++){
                for(int j=0;j<2;j++){
                    if(TempInformation!=null)
                        ClassTime[i][j]=Integer.valueOf(TempInformation);
                    TempInformation=br.readLine();
                }
            }

        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br!=null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
