package com.nano.html;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    String myText = "<h1> This is Heading h1</h1>\n"+
            "<h2> This is Heading h2 </h2>\n"+
            "<h3> This is Heading h3 </h3>\n"+
            "<p> This is paragraph </p>\n"+
            "<p> <u>This is underline </u> </p>\n"+
            "<p> <b>This is bold </b> </p>\n"+
            "<p> <i>This is Italic </u> </p>\n"+
            "Programming language\n"+
            "<ol>\n " +
            "<li> C </li>\n" +
            "<li> C ++ </li>\n" +
            "<li> java </li>\n" +
            "</ol>\n\n"+
            "(a+b) <sup> 2 </sup> = a <sup> 2 </sup> + 2ab + b <sup>2 </sup>";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        webView = (WebView) findViewById ( R.id.webViewId );

        webView.loadDataWithBaseURL ( null,myText,"text/html","utf-8",null );


    }
}
