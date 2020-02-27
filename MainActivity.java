package com.jinh.application;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.CookieSyncManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import com.friendlyarm.AndroidSDK.HardwareControler;

//import com.friendlyarm.AndroidSDK.SPIEnum;
//import com.friendlyarm.AndroidSDK.GPIOEnum;
//import com.friendlyarm.AndroidSDK.FileCtlEnum;
public class MainActivity extends AppCompatActivity {

    Handler handler=new Handler(){
        public void handleMessage(android.os.Message msg){
        //处理消息
//            setContentView(R.layout.schedule);
//            B3=findViewById(R.id.b000);
//            B3.setOnClickListener(new View.OnClickListener() {
//
//                public void onClick(View view) {
////                    android.webkit.CookieSyncManager cookieSyncManager =  CookieSyncManager.createInstance(webView.getContext());
//                    android.webkit.CookieManager cookieManager = android.webkit.CookieManager.getInstance();
//                    cookieManager.setAcceptCookie(true);
//                    cookieManager.removeAllCookies(null);
//                    setContentView(R.layout.activity_main);
//
//                webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
//                webView.clearHistory();
//                webView.clearFormData();
//                webView.clearCache(true);
//
//
//                }
//            });
//            for(int i=0;i<5;i++){
//                for(int j=0;j<6;j++){
//                    Buttons[i*6+j]=findViewById(Bid[i][j]);
//                }
//            }
//            String ClassName;
//            for(int i=0;i<30;i++){
//                ClassName=ClassInformation[i];
////                        System.out.print(ClassInformation[i]);
//
////                        Buttons[ClassTime[i][0]*6+ClassTime[i][1]].setText(ClassInformation[i]);
////                        Buttons[i].setText(String.valueOf(i));
////                    Buttons[i].findViewById(Bid[ClassTime[i][0]][ClassTime[i][1]]);
//                Buttons[ClassTime[i][0]*6+ClassTime[i][1]/2].setText(ClassName);
//            }
        };
    };
    private boolean isFirstUse;
    int i=0;
    int index=0;
    String cookie;
    //Switch S1;
    Button B1,B2,B3;
    Button  b0,b1,b2,b3,b4,b5,b6,
            b7,b8,b9,b10,b11,b12,
            b13,b14,b15,b16,b17,b18,
            b19,b20,b21,b22,b23,b24,
            b25,b26,b27,b28,b29,b30;
    WebView webView;
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

    String[] ClassInformation = new String[30];
    int[][] ClassTime = new int[30][2];
    //Button myButton2 = (Button)findViewById(R.id.button);
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //设置网络请求cookie
        CookieSyncManager.createInstance(this);
        Random rand = new Random();

        int randomNum = rand.nextInt((3- 0) + 0);
        switch (randomNum ){
            case 0: setTheme(R.style.AppBoy);break;
            case 1: setTheme(R.style.AppGirl);break;
            case 2: setTheme(R.style.AppGay);break;
//            case 3: setTheme(R.style.AppTheme);
        }
//        是否是第一次使用
//        第一次使用，则应该显示加载界面
//        之后使用直接加载课程表
//        SharedPreferences preferences = getSharedPreferences("isFirstUse", MODE_WORLD_READABLE);
//        isFirstUse = preferences.getBoolean("isFirstUse", true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        if(isFirstUse) setContentView(R.layout.activity_main);
//        else {
//            //如果不是第一次使用，不仅要直接加载课程表，还要填入课程表的内容///////////////////////////////////////
//            ///////////////////////////////////////////////////////////////////////////////////////////////////
////            setContentView(R.layout.schedule);
//            ///////////////////////////////////////////////////////////////////////////////////////////////////
//            for(int i=0;i<5;i++){
//                for(int j=0;j<6;j++){
//                    Buttons[i*6+j]=findViewById(Bid[i][j]);
//                }
//            }
////            ReadInformation();
//            //填入课程表////////////////////////////////////////////////////////////
//            String ClassName;
//            for(int i=0;i<30;i++){
//                ClassName=ClassInformation[i];
////                        System.out.print(ClassInformation[i]);
//
////                        Buttons[ClassTime[i][0]*6+ClassTime[i][1]].setText(ClassInformation[i]);
////                        Buttons[i].setText(String.valueOf(i));
////                    Buttons[i].findViewById(Bid[ClassTime[i][0]][ClassTime[i][1]]);
//                Buttons[ClassTime[i][0]*6+ClassTime[i][1]/2].setText(ClassName);
//            }
//        }
//        ///////////////////////////////////////////////////
        //S1=findViewById(R.id.switch1);
        B1 = findViewById(R.id.b1);
        B2 = findViewById(R.id.b2);
        String[] ctype = new String[]{"大一上", "大一下", "大二上", "大二下", "大三上","大三下","大四上","大四下"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ctype);  //创建一个数组适配器
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     //设置下拉列表框的下拉选项样式
        Spinner spinner = super.findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
//        index=Integer.valueOf(spinner.getSelectedItem().toString());
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               index=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        webView = (WebView) findViewById(R.id.webView);
        for(int i=0;i<30;i++){
            ClassInformation[i]=" ";
        }
        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_home_black_24dp, "课程"))
                .addItem(new BottomNavigationItem(R.drawable.ic_schedule_black_24dp, "登录"))
                .addItem(new BottomNavigationItem(R.drawable.ic_face_black_24dp, "我的"))
                .setFirstSelectedPosition(1)
                .initialise();
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener(){
            @Override
            public void onTabSelected(int position) {
                switch (position){
                    //课程
                    case 0:Intent intent = new Intent();
                        intent.setClass(MainActivity.this,SecondAcivity.class);
                        startActivity(intent);
                        break;
                     //登录
                    case 1:
                        break;
                     //我的
                    case 2:Intent intent1 = new Intent();
                        intent1.setClass(MainActivity.this,PhotoActivity.class);
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
        //myButton2 = (Button)findViewById(R.id.button);
        B1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                init();

            }
        });
        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCookie();
                new Thread(){
                    public void run(){
                        DoPrepare();
                        ///////////////////////////////////////////////////////////////
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this,SecondAcivity.class);
                        startActivity(intent);
                        ///////////////////////////////////////////////////////////////
                        Message msg=new Message();
                        msg.what=1 ;
                        msg.arg1=1;
                        handler.sendEmptyMessage(msg.what);
                    };
                }.start();
                //DoPrepare();
//                setContentView(R.layout.schedule);
//                for(int i=0;i<5;i++){
//                    for(int j=0;j<6;j++){
//                        Buttons[i*6+j]=findViewById(Bid[i][j]);
//                    }
//                }
//                String ClassName;
//                for(int i=0;i<13;i++){
//                    ClassName=ClassInformation[i];
////                        System.out.print(ClassInformation[i]);
//
////                        Buttons[ClassTime[i][0]*6+ClassTime[i][1]].setText(ClassInformation[i]);
////                        Buttons[i].setText(String.valueOf(i));
////                    Buttons[i].findViewById(Bid[ClassTime[i][0]][ClassTime[i][1]]);
//                    Buttons[ClassTime[i][0]*6+ClassTime[i][1]].setText(ClassName);
//                }
//                setContentView(R.layout.schedule);
//                b0=(Button)findViewById(R.id.b11);
//                b0.setText("SomethingWrong");
            }
        });

    }

    //最初设计为写入是否初始化的标志，现改为写入课程信息
    public void WriteInformation(){
        FileOutputStream fos=null;
        BufferedWriter writer=null;
        try {
            fos=openFileOutput("ClassInformation.txt",Context.MODE_PRIVATE);
            writer=new BufferedWriter(new OutputStreamWriter(fos,"utf-8"));
            try {
                for(int i=0;i<30;i++){
                writer.append(ClassInformation[i]+"\n");
                }
                writer.flush();
                for(int i=0;i<30;i++){
                    for(int j=0;j<2;j++){
                        writer.append(String.valueOf(ClassTime[i][j]+"\n"));

                    }
                }
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            if(writer!=null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    //最初设计为读出是否初始化的标志，现改为读出课程信息
    public void ReadInformation(){
        BufferedReader br=null;
        String TempInformation=null;
        try {

            br=new BufferedReader(new InputStreamReader(openFileInput("SignOfWhetherInit.txt"),"utf-8"));
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
    private void init() {

//        webView = (WebView) findViewById(R.id.webView);

        webView.getSettings().setAppCacheEnabled(false);

//        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);

        webView.getSettings().setDatabaseEnabled(false);

        webView.getSettings().setDomStorageEnabled(true);

        webView.getSettings().setGeolocationEnabled(false);
        webView.getSettings().setLoadWithOverviewMode(true);
//        mWebView.getSettings().setPluginsEnabled(false);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setSaveFormData(false);

        webView.getSettings().setSavePassword(false);

        webView.getSettings().setJavaScriptEnabled(true); ///------- 设置javascript 可用
        //WebView加载web资源
//        if(i%2==0){
//        webView.loadUrl("https://ids.tongji.edu.cn:8443/nidp/saml2/sso?id=668&sid=0&option=credential&sid=0");
//        i++;
//        }
//        else {
//            webView.loadUrl("http://4m3.tongji.edu.cn/eams/home.action");
//            i++;
//        }
        webView.loadUrl("http://4m3.tongji.edu.cn");
//        webView.setWebViewClient(new WebViewClient() {
//
//             @Override
//             public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
//                 super.onReceivedSslError(view, handler, error);
//                 }});
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedSslError(WebView view,
                                           SslErrorHandler handler, SslError error) {
                // TODO Auto-generated method stub
                // handler.cancel();// Android默认的处理方式
//                handler.proceed();// 接受所有网站的证书
                // handleMessage(Message msg);// 进行其他处理
                if (error.getPrimaryError() == SslError.SSL_INVALID) {
                    handler.proceed();
                } else {
                    handler.cancel();
                }
            }
        });
        // android 5.0以上默认不支持Mixed Content
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webView.getSettings().setMixedContentMode(
                    WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE);
        }
        //webView.loadUrl("http://4m3.tongji.edu.cn");
        //webView.loadUrl("https://www.baidu.com/s?wd=dosonething");
        //webView.loadUrl("https://ids.tongji.edu.cn:8443/nidp/saml2/sso?id=668&sid=1&option=credential&sid=1");
        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // 重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不另跳浏览器
                // 在2.3上面不加这句话，可以加载出页面，在4.0上面必须要加入，不然出现白屏
                if (url.startsWith("http://") || url.startsWith("https://")) {
                    view.loadUrl(url);
                    webView.stopLoading();
                    return true;
                }
                return false;
            }

            @Override
            public void onReceivedError(WebView view, int errorCode,
                                        String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
            }
        });
        webView.setWebViewClient(new android.webkit.WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                //getCookie();
                return true;
            }
        });


    }

    public void getCookie() {

        android.webkit.CookieManager cookieManager = android.webkit.CookieManager.getInstance();
        //cookie = cookieManager.getCookie("cookie");
        cookie=cookieManager.getCookie("http://4m3.tongji.edu.cn/eams/home.action");
        if (cookie != null) {
            System.out.println("cookie:"+cookie+"///////////////////////////////");
        } else {
            System.out.println("cookie:error///////////////////////////////");
        }
    }

    public void setCookie() {
        android.webkit.CookieManager cookieManager = android.webkit.CookieManager.getInstance();
        cookieManager.setCookie("cookie", cookie);
    }


    public  String sendGet(String url, Map<String, String> parameters) {
        String result = "";
        BufferedReader in = null;// 读取响应输入流
        StringBuffer sb = new StringBuffer();// 存储参数
        String params = "";// 编码之后的参数
        try {
            // 编码请求参数
//            if (parameters.size() == 1) {
//                for (String name : parameters.keySet()) {
//                    sb.append(name).append("=").append(java.net.URLEncoder.encode(parameters.get(name), "UTF-8"));
//                }
//                params = sb.toString();
//            } else {
//                for (String name : parameters.keySet()) {
//                    sb.append(name).append("=").append(java.net.URLEncoder.encode(parameters.get(name), "UTF-8")).append("&");
//                }
//                String temp_params = sb.toString();
//                params = temp_params.substring(0, temp_params.length() - 1);
//            }
            String full_url = url; //+ "?" + params;
            System.out.println(full_url);
            // 创建URL对象
            java.net.URL connURL = new java.net.URL(full_url);
            // 打开URL连接
            java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) connURL.openConnection();
            // 设置通用属性
            httpConn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
            httpConn.setRequestProperty("Accept_Encoding","gzip, deflate");
            httpConn.setRequestProperty("connection", "Keep-Alive");
            httpConn.setRequestProperty("Accept-Language","zh-CN,zh;q=0.9");
            httpConn.setRequestProperty("Host","4m3.tongji.edu.cn");
            httpConn.setRequestProperty("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36");
            httpConn.setRequestProperty("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
            httpConn.setConnectTimeout(60000000);
            httpConn.setReadTimeout(60000000);
            //httpConn.setRequestProperty("cookie", "JSESSIONID=9BA82BC45D2760642CE60DF8BDA0AA63.62; SERVERNAME=s110; oiosaml-fragment=");
            httpConn.setRequestProperty("cookie",cookie);
//            httpConn.setRequestProperty("Accept", "*/*");
//            httpConn.setRequestProperty("Connection", "Keep-Alive");
//            httpConn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");
            // 建立实际的连接
            httpConn.connect();
            // 响应头部获取
            Map<String, List<String>> headers = httpConn.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : headers.keySet()) {
                System.out.println(key + "\t：\t" + headers.get(key));
            }
            // 定义BufferedReader输入流来读取URL的响应,并设置编码方式
            in = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
            String line;
            // 读取返回的内容
            while ((line = in.readLine()) != null) {
                result +='\n'+ line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
    public String sendPost(String url, Map<String, String> parameters,int i) {
        String result = "";// 返回的结果
        BufferedReader in = null;// 读取响应输入流
        PrintWriter out = null;
        StringBuffer sb = new StringBuffer();// 处理请求参数
        String params = "";// 编码之后的参数
        try {
            // 编码请求参数
            if (parameters.size() == 1) {
                for (String name : parameters.keySet()) {
                    sb.append(name).append("=").append(java.net.URLEncoder.encode(parameters.get(name), "UTF-8"));
                }
                params = sb.toString();
            } else {
                for (String name : parameters.keySet()) {
                    sb.append(name).append("=").append(java.net.URLEncoder.encode(parameters.get(name), "UTF-8"))
                            .append("&");
                }
                String temp_params = sb.toString();
                params = temp_params.substring(0, temp_params.length() - 1);
            }
            // 创建URL对象
            java.net.URL connURL = new java.net.URL(url);
            // 打开URL连接
            java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) connURL.openConnection();
            // 设置通用属性
            if(i==0||i==2)
                httpConn.setRequestProperty("Accept", "text/plain, */*; q=0.01");
            else if(i==1||i==3)
                httpConn.setRequestProperty("Accept", "*/*");
            //else
            //conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
            httpConn.setRequestProperty("Accept_Encoding","gzip, deflate");
            httpConn.setRequestProperty("connection", "Keep-Alive");
            httpConn.setRequestProperty("Accept-Language","zh-CN,zh;q=0.9");
            httpConn.setRequestProperty("Host","4m3.tongji.edu.cn");


            //httpConn.setRequestProperty("cookie", "JSESSIONID=305DE05F3992E8D2D8B4EE312FD06CF9.62; SERVERNAME=s110; oiosaml-fragment=");
            httpConn.setRequestProperty("cookie", cookie);

            httpConn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            httpConn.setRequestProperty("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36");
            httpConn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");

            // 设置POST方式
            httpConn.setDoInput(true);
            httpConn.setDoOutput(true);
            // 获取HttpURLConnection对象对应的输出流
            out = new PrintWriter(httpConn.getOutputStream());
            // 发送请求参数
            out.write(params);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应，设置编码方式
            in = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
            String line;
            // 读取返回的内容
            while ((line = in.readLine()) != null) {
                result +='\n' +line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
    public void DoPrepare(){
    Map<String,String> params = new HashMap<String,String>();
    params.put(" ", " ");
    //------------------------------------------------------------------------------------//
    //String MostImportantUrl="http://4m3.tongji.edu.cn/eams/courseTableForStd!courseTable.action ";
    String sr1=null;
    String sr2=null;
    String sr3=null;
    String url5="http://4m3.tongji.edu.cn/eams/courseTableForStd.action";
    String url6="http://4m3.tongji.edu.cn/eams/courseTableForStd!courseTable.action";
    String url7="http://4m3.tongji.edu.cn/eams/courseTableForStd.action";
    sr2 =sendGet(url5,params);
    sr3 =sendGet(url7,params);
    sr3 =FindMagicNumber(sr3);

    System.out.println(sr2);
    //String mail_regex = "\\w+@\\w+(\\.\\w+)+";
    String mail_regex = "\\w{11}\\d{9}";
    Pattern p = Pattern.compile(mail_regex);
    Matcher m = p.matcher(sr2);
//    System.out.println("////////////");
    if(m.find())
            System.out.println("ImportantThing:"+m.group()+"/////////////////////////");
    String line =m.group().substring(1);
    System.out.println(line);
    String valueNumber[]={"102","103","104","105","106","107","108","109"};
    for(int i=0;i<4;i++) {
        if (i == 0) {
            params = new HashMap<String, String>();
            params.put("tagId", line + "Semester");
            params.put("dataType", "semesterCalendar");
            params.put("value", valueNumber[index]);
            params.put("empty", "false");
        } else if (i == 1) {
            params = new HashMap<String, String>();
            params.put("dataType", "projectId");
        } else if (i == 2) {
            params = new HashMap<String, String>();
            params.put("entityId", " ");
        } else {
            params = new HashMap<String, String>();
            params.put("ignoreHead", "1");
            params.put("setting.kind", "std");
            params.put("startWeek", "1");
            params.put("semester.id", valueNumber[index]);
            params.put("ids", sr3);
        }
        if (i >= 0 && i < 3)
            sr1 = sendPost("http://4m3.tongji.edu.cn/eams/dataQuery.action", params, i);
        if (i == 3){
            sr1 = sendPost("http://4m3.tongji.edu.cn/eams/courseTableForStd!courseTable.action", params, i);
        }

    }
    FindWord(sr1);
}
    public void FindWord(String line){
        int i=0;
        System.out.print(line);
        String pattern ="TaskActivity\\(.*";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(line);
        while(m.find()){
            ClassInformation[i]=m.group(0);
            System.out.println(ClassInformation[i]);
            i++;
        }
        String pattern1="\\(.{8}\\)\",\"[^(]*";
        Pattern r1 = Pattern.compile(pattern1);
        for(int k=0;k<i;k++){
            m = r1.matcher(ClassInformation[k]);
            if(m.find()){
                ClassInformation[k]=m.group(0).substring(13,m.group(0).length());
			System.out.println(ClassInformation[k]);
            }
        }
		for(int j=0;j<i;j++){
			System.out.println(ClassInformation[j]);
		}
        String pattern2="index =\\d.*";
        r1=Pattern.compile(pattern2);
        m = r1.matcher(line);
        int j=0;//j==0标志是第一节 j==1标志是第二节
        int k=0;
        int ThrowAway=0;
        while(m.find()){
//			ClassInformation[i]=m.group(0);
            //System.out.println(m.group(0));
            if(j==0){
                //第一节节课
                ClassTime[k][0]=Integer.valueOf(m.group(0).substring(7,8));//星期
                ClassTime[k][1]=Integer.valueOf(m.group(0).substring(m.group(0).length()-2,m.group(0).length()-1));//节数

//				System.out.println("星期"+m.group(0).substring(7,8));
//				System.out.println("节数"+m.group(0).substring(m.group(0).length()-2,m.group(0).length()-1));
                j=1;
            }
            else {
                //第二节课
                ThrowAway=Integer.valueOf(m.group(0).substring(7,8));
                ThrowAway=Integer.valueOf(m.group(0).substring(m.group(0).length()-2,m.group(0).length()-1));
//				System.out.println("星期"+m.group(0).substring(7,8));
//				System.out.println("节数"+m.group(0).substring(m.group(0).length()-2,m.group(0).length()-1));
                j=0;
                k++;
            }

        }
        WriteInformation();
        SharedPreferences preferences = getSharedPreferences("isFirstUse", MODE_WORLD_READABLE);
        //实例化Editor对象
        SharedPreferences.Editor editor = preferences.edit();
        //存入数据
        editor.putBoolean("isFirstUse", false);
        //提交修改
        editor.commit();
//        for(int m1=0;m1<i;m1++){
//            for(int m2=0;m2<2;m2++){
//                System.out.println(ClassInformation[m1]+':'+String.valueOf(ClassTime[m1][m2][0])+","+String.valueOf(ClassTime[m1][m2][1]));
//            }
//        }
    }
    public static String FindMagicNumber(String line){
        String MagicNum=null;
        int i=0;
        //String pattern ="TaskActivity\\(.*";
        String pattern ="bg.form.addInput\\(form,\"ids\",\"\\d\\d*";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(line);
        if(m.find()){
            MagicNum=m.group(0);
            System.out.println(MagicNum);
            //System.out.println(ClassInformation[i]);
        }
//		String pattern1="\\(\\d{8}\\)\",\"\\D*";
        String pattern1="\\d{9}";
        Pattern r1 = Pattern.compile(pattern1);
        m = r1.matcher(MagicNum);
        if(m.find()){
//		ClassInformation[k]=m.group(0).substring(13,m.group(0).length()-1);
                MagicNum=m.group(0);
                System.out.println(MagicNum);
            }
        return MagicNum;
    }
}
