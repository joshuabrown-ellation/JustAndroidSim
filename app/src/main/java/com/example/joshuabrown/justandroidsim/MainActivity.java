package com.example.joshuabrown.justandroidsim;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.JavascriptInterface;
import android.content.Context;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String webData = "<!DOCTYPE html>" +
                "<head>" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">" +
                "<style>" +
                "body {" +
                "}" +
                "</style>" +
                "</head>" +
                "<body>" +
                "Damn!  We got some soft subs!!!" +
                "</body>" +
                "</html>";


        WebView myWebView = (WebView) findViewById(R.id.webview);

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        myWebView.setBackgroundColor(Color.TRANSPARENT);

        webSettings.setMediaPlaybackRequiresUserGesture(false);
        myWebView.addJavascriptInterface(new WebAppInterface(this), "kalturaPlayer");
        // this config by URL is the working method of Vilos in the webview,
        // To go from JavaScript config "obj" to properly formatted "myConfig":
        // var myConfig = window.btoa(encodeURIComponent(JSON.stringify(obj)));
//        myWebView.loadUrl("http://10.30.32.8:8080/dist/player.html#JTdCJTIyYW5hbHl0aWNzJTIyJTNBJTdCJTIyYW5vbnltb3VzX2lkJTIyJTNBJTIyNTU1NTU1NTU1NSUyMiUyQyUyMm1lZGlhX3JlcG9ydGluZ19wYXJlbnQlMjIlM0ElN0IlMjJ0eXBlJTIyJTNBJTIyc2VyaWVzJTIyJTJDJTIyaWQlMjIlM0ElMjIyMzgwMTQlMjIlMkMlMjJ0aXRsZSUyMiUzQSUyMjkxJTIwRGF5cyUyMCU3QyUyMFNlYXNvbiUyMDElMjAlN0MlMjBOdW1iZXIlMjBUd28lMjIlN0QlMkMlMjJzZWdtZW50JTIyJTNBJTdCJTIyd3JpdGVfa2V5JTIyJTNBJTIycjd3bnllVjdtZkV6Y3lscmM2TTgwRE9MY0ZWOWlxMjUlMjIlN0QlN0QlMkMlMjJtZWRpYSUyMiUzQSU3QiUyMm1ldGFkYXRhJTIyJTNBJTdCJTIydHlwZSUyMiUzQSUyMm1vdmllJTIyJTJDJTIyaWQlMjIlM0ElMjJHWVgwM1pYUFIlMjIlMkMlMjJjaGFubmVsX2lkJTIyJTNBJTIydGVzdF9jaGFubmVsJTIyJTJDJTIydGl0bGUlMjIlM0ElMjJUZXN0JTIwdGl0bGUlMjIlMkMlMjJkZXNjcmlwdGlvbiUyMiUzQSUyMlRlc3QlMjBkZXNjcmlwdGlvbiUyMiUyQyUyMmVwaXNvZGVfbnVtYmVyJTIyJTNBMSUyQyUyMmRpc3BsYXlfZXBpc29kZV9udW1iZXIlMjIlM0ElMjIxJTIyJTJDJTIyZHVyYXRpb24lMjIlM0EyODU5NDQ1JTdEJTJDJTIyc3RyZWFtcyUyMiUzQSU1QiU3QiUyMmZvcm1hdCUyMiUzQSUyMmhscyUyMiUyQyUyMmF1ZGlvX2xhbmclMjIlM0ElMjJqYUpQJTIyJTJDJTIyaGFyZHN1Yl9sYW5nJTIyJTNBJTIyZW5VUyUyMiUyQyUyMnVybCUyMiUzQSUyMmh0dHBzJTNBJTJGJTJGYml0ZGFzaC1hLmFrYW1haWhkLm5ldCUyRmNvbnRlbnQlMkZNSTIwMTEwOTIxMDA4NF8xJTJGbTN1OHMlMkZmMDhlODBkYS1iZjFkLTRlM2QtODg5OS1mMGY2MTU1ZjZlZmEubTN1OCUyMiUyQyUyMnJlc29sdXRpb24lMjIlM0ElMjJhZGFwdGl2ZSUyMiU3RCU1RCUyQyUyMnRodW1ibmFpbCUyMiUzQSU3QiUyMnVybCUyMiUzQSUyMmh0dHAlM0ElMkYlMkZzdGF0aWMuY3gtc3RhZ2luZy5jb20lMkZpbWdzcnYlMkZkaXNwbGF5JTJGdGh1bWJuYWlsJTJGMTkyMHgxMDgwJTJGY2F0YWxvZyUyRmNydW5jaHlyb2xsJTJGYzJiNGMyNWYwOWIzZmM3MTk3YjFkZmEyODdhZGYwNzQuanBnJTIyJTdEJTJDJTIyc3VidGl0bGVzJTIyJTNBJTVCJTdCJTIybGFuZ3VhZ2UlMjIlM0ElMjJlblVTJTIyJTJDJTIydXJsJTIyJTNBJTIyLi4lMkZkZXZfcmVzb3VyY2VzJTJGUGxheWVyVGVzdF92MS5hc3MlMjIlMkMlMjJ0aXRsZSUyMiUzQSUyMkVuZ2xpc2glMjIlN0QlNUQlMkMlMjJhZF9icmVha3MlMjIlM0ElNUIlN0IlMjJ0eXBlJTIyJTNBJTIycHJlcm9sbCUyMiUyQyUyMm9mZnNldCUyMiUzQTAlN0QlMkMlN0IlMjJ0eXBlJTIyJTNBJTIybWlkcm9sbCUyMiUyQyUyMm9mZnNldCUyMiUzQTIwMDAwJTdEJTJDJTdCJTIydHlwZSUyMiUzQSUyMm1pZHJvbGwlMjIlMkMlMjJvZmZzZXQlMjIlM0E0MDAwMCU3RCUyQyU3QiUyMnR5cGUlMjIlM0ElMjJtaWRyb2xsJTIyJTJDJTIyb2Zmc2V0JTIyJTNBNjAwMDAlN0QlMkMlN0IlMjJ0eXBlJTIyJTNBJTIybWlkcm9sbCUyMiUyQyUyMm9mZnNldCUyMiUzQTgwMDAwJTdEJTJDJTdCJTIydHlwZSUyMiUzQSUyMm1pZHJvbGwlMjIlMkMlMjJvZmZzZXQlMjIlM0ExMDAwMDAlN0QlMkMlN0IlMjJ0eXBlJTIyJTNBJTIybWlkcm9sbCUyMiUyQyUyMm9mZnNldCUyMiUzQTEyMDAwMCU3RCU1RCU3RCUyQyUyMnBsYXllciUyMiUzQSU3QiUyMnN0YXJ0X29mZnNldCUyMiUzQTAlMkMlMjJ0YXJnZXQlMjIlM0ElMjJrYWx0dXJhUGxheWVyJTIyJTJDJTIyYXV0b3BsYXklMjIlM0F0cnVlJTJDJTIyY3VzdG9tX3N0eWxlc2hlZXRfbGlua3MlMjIlM0ElNUIlMjJodHRwcyUzQSUyRiUyRmZvbnRzLmdvb2dsZWFwaXMuY29tJTJGY3NzJTNGZmFtaWx5JTNEUnViaWslMjIlMkMlMjIlMkZzcmMlMkZjc3MlMkZzYW1wbGVTa2luJTJGdnJ2Q3VzdG9tUGxheWVyU2tpbi5jc3MlMjIlNUQlMkMlMjJjdXN0b21fc3R5bGVzX2NsYXNzJTIyJTNBJTIydnJ2JTIyJTJDJTIycGF1c2Vfc2NyZWVuJTIyJTNBJTVCJTdCJTIyY2xhc3NlcyUyMiUzQSU1QiUyMnBhdXNlZC10ZXh0JTIyJTVEJTJDJTIydGV4dCUyMiUzQSUyMlBhdXNlZCUyMiU3RCUyQyU3QiUyMmNsYXNzZXMlMjIlM0ElNUIlMjJzZXJpZXMtbmFtZSUyMiU1RCUyQyUyMnRleHQlMjIlM0ElMjJKb2pvJ3MlMjBCaXphcnJlJTIwQWR2ZW50dXJlJTNBJTIwRGlhbW9uZCUyMGlzJTIwVW5icmVha2FibGUlMjIlN0QlNUQlN0QlMkMlMjJsYW5ndWFnZSUyMiUzQSUyMmVuVVMlMjIlN0Q=");
//        myWebView.loadUrl("http://10.30.32.8:8080/dist/testWebView.html");

        myWebView.loadData(webData, "text/html", "UTF-8");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
