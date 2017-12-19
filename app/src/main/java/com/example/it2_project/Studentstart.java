package com.example.it2_project;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.List;

public class Studentstart extends AppCompatActivity {

    LinearLayout survey_start;
    LinearLayout SOS;
    LinearLayout singo;
    LinearLayout consult;
    TextView text_id;
    TextView text_name;
    Student login_student;
    TextView logout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.studentstart);

        survey_start = (LinearLayout)findViewById(R.id.studentstart_survey);
        SOS = (LinearLayout)findViewById(R.id.studentstart_sos);
        singo = (LinearLayout)findViewById(R.id.studentstart_declare);
        consult = (LinearLayout)findViewById(R.id.studentstart_consult);
        text_id = (TextView)findViewById(R.id.studentstart_user);
        text_name = (TextView)findViewById(R.id.studentstart_name);
        logout = (TextView)findViewById(R.id.studentstart_logout);
        login_student = (Student)getIntent().getSerializableExtra("student_key");
        text_id.setText("ID : " + login_student.getId());
        text_name.setText("name : " + login_student.getName());


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent1);
                SharedPreferences auto = getSharedPreferences("auto", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor  = auto.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(Studentstart.this, "로그아웃", Toast.LENGTH_SHORT).show();
                finish();

            }
        });

        survey_start.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {

                Intent intent2 = new Intent(getApplicationContext(),SurveyController1.class);
                intent2.putExtra("student_key",login_student);
                startActivity(intent2);
            }
        });

        SOS.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {

                call();

            }
        });

        singo.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {

                Intent dec = new Intent(getApplicationContext(),GPSController.class);
                dec.putExtra("student_key", login_student);
                startActivity(dec);
                finish();


            }
        });

        consult.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                chattingcontroller();

            }
        });


    }


    public void call() {


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int permissionResult = checkSelfPermission(Manifest.permission.CALL_PHONE);

            if (permissionResult == PackageManager.PERMISSION_DENIED) {
                if (shouldShowRequestPermissionRationale(Manifest.permission.CALL_PHONE)) {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(Studentstart.this);
                    dialog.setTitle("권한이 필요합니다")
                            .setMessage("이 기능을 사용하기 위해서느 단말기의 \"전화걸기\" 권한이 필요합니다. 계속 하시겠습니까?")
                            .setPositiveButton("네", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                        requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1000);
                                    }

                                }
                            })
                            .setNegativeButton("아니요", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(Studentstart.this, "기능을 취소했습니다", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .create()
                            .show();
                } else {
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1000);
                }

            } else {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:010-1111-1111"));
                startActivity(intent);
            }
        } else {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:010-1111-1111"));
            startActivity(intent);
        }

    }

    @Override
    public void onBackPressed() {
        // super.onBackPressed();
    }


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
