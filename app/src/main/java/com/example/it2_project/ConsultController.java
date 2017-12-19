package com.example.it2_project;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ConsultController extends AppCompatActivity {

    public void chattingcontroller()
    {
        Uri.Builder uri = new Uri.Builder()
                .scheme("http")
                .encodedAuthority("192.168.0.33:3000")
                .appendPath("client04");

        Uri url = uri.build();

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(url);
        intent.setPackage("com.android.chrome");
        startActivity(intent);
    }


}
