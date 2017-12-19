package com.example.it2_project;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    EditText idInput, passwordInput;
    TextView signup;
    Button login;
    SharedPreferences auto;
    SharedPreferences.Editor autoLogin;

    public static ArrayList<Student> user = new ArrayList<>();

    Student login_student;

    String id;
    String psw;

    String loginId;
    String loginPwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.login);
        setTheme(R.style.Theme_AppCompat_NoActionBar);

        idInput = (EditText) findViewById(R.id.login_emailInput);
        passwordInput = (EditText) findViewById(R.id.login_passwordInput);
        signup = (TextView) findViewById(R.id.login_signupButton);
        login = (Button) findViewById(R.id.login_loginButton);

        auto = getSharedPreferences("auto", Activity.MODE_PRIVATE);

        loginId = auto.getString("inputId",null);
        loginPwd = auto.getString("inputPwd",null);

        OpenGetAPITask t = new OpenGetAPITask();

        try
        {
            ArrayList<Student> ps = new ArrayList<>();
            ps = t.execute().get();

            user = ps;

        }

        catch (InterruptedException e) {
            Intent error1 = new Intent(getApplicationContext(), ErrorPage.class);
            startActivity(error1);
            e.printStackTrace();

        }
        catch (ExecutionException e) {
            Intent error2 = new Intent(getApplicationContext(), ErrorPage.class);
            startActivity(error2);
            e.printStackTrace();
        }


        signup.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(getApplicationContext(), signup.class);
                startActivity(intent1);

            }
        });

        if (loginId != null && loginPwd != null) {


            for(int i=0; i<user.size();i++)
            {
                if(user.get(i).getId().equals(loginId) && user.get(i).getPassword().equals(loginPwd))
                {
                    Toast.makeText(MainActivity.this, loginId + "님 자동로그인 입니다.", Toast.LENGTH_SHORT).show();
                    Student st = user.get(i);
                    login_student = st;
                    Intent intent1 = new Intent(MainActivity.this, Studentstart.class);
                    intent1.putExtra("student_key", st);
                    startActivity(intent1);
                    finish();
                }
            }


        }
        else if (loginId == null && loginPwd == null) {

            login.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    id = idInput.getText().toString();
                    psw = passwordInput.getText().toString();
                    int check = 0;


                    for (int i = 0; i < user.size(); i++) {
                        if (user.get(i).getId().equals(id)) {
                            if (user.get(i).getPassword().equals(psw)) {
                                Student st = user.get(i);

                                auto = getSharedPreferences("auto", Activity.MODE_PRIVATE);
                                autoLogin = auto.edit();
                                autoLogin.putString("inputId", id);
                                autoLogin.putString("inputPwd", psw);
                                autoLogin.commit();

                                Intent intent2 = new Intent(getApplicationContext(), Studentstart.class);
                                intent2.putExtra("student_key", st);
                                startActivity(intent2);
                                check = 1;
                                finish();
                            }
                            if (check == 0) {
                                Toast.makeText(getApplicationContext(), "비밀번호를 다르게 입력했습니다", Toast.LENGTH_SHORT).show();
                                check = 1;
                            }
                        }
                    }
                    if (check == 0) {
                        Toast.makeText(getApplicationContext(), "그러한 학생 ID가 없습니다", Toast.LENGTH_SHORT).show();
                    }


                }
            });

        }


    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }




}
