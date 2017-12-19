package com.example.it2_project;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class SurveyController3 extends AppCompatActivity {

    Button finish;
    boolean questioncheck=true;
    RadioGroup rg21,rg22,rg23,rg24,rg25,rg26,rg27,rg28,rg29,rg30,rg31, rg32;

    HexagonGraph hexagonGraph;
    double hexFac1=0;
    double hexFac2=0;
    double hexFac3=0;
    double hexFac4=0;
    double hexFac5=0;
    double hexFac6=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_survey3);
        Log.d("gyurie", "SC3");

        //final Student nowStudent=(Student)getIntent().getSerializableExtra("student_key");

        hexFac1=SurveyController1.nowStudent.getHexagonGraph().getQT1();
        hexFac2=SurveyController1.nowStudent.getHexagonGraph().getQT2();
        hexFac3=SurveyController1.nowStudent.getHexagonGraph().getQT3();
        hexFac4=SurveyController1.nowStudent.getHexagonGraph().getQT4();

        //hexFac1=SurveyController1.nowStudent.getHistory().get(SurveyController1.nowStudent.getHistory().size()-1).getQT1();
        //hexFac2=SurveyController1.nowStudent.getHistory().get(SurveyController1.nowStudent.getHistory().size()-1).getQT2();
        //hexFac3=SurveyController1.nowStudent.getHistory().get(SurveyController1.nowStudent.getHistory().size()-1).getQT3();
        //hexFac4=SurveyController1.nowStudent.getHistory().get(SurveyController1.nowStudent.getHistory().size()-1).getQT4();
        Log.d("gyurie", "안녕");

        ImageButton back = (ImageButton)findViewById(R.id.survery3_back);
        TextView logout = (TextView)findViewById(R.id.survey3_logout);

        back.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {

                Intent bck = new Intent(getApplicationContext(),Studentstart.class);
                bck.putExtra("student_key", SurveyController1.nowStudent);
                startActivity(bck);


            }
        });

        logout.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent1);
                SharedPreferences auto = getSharedPreferences("auto", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor  = auto.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(SurveyController3.this, "로그아웃", Toast.LENGTH_SHORT).show();
                finish();

            }
        });

        finish = (Button)findViewById(R.id.FINISH);
        rg21 = (RadioGroup)findViewById(R.id.radioGroupQ21);
        rg22 = (RadioGroup)findViewById(R.id.radioGroupQ22);
        rg23 = (RadioGroup)findViewById(R.id.radioGroupQ23);
        rg24 = (RadioGroup)findViewById(R.id.radioGroupQ24);
        rg25 = (RadioGroup)findViewById(R.id.radioGroupQ25);
        rg26 = (RadioGroup)findViewById(R.id.radioGroupQ26);
        rg27 = (RadioGroup)findViewById(R.id.radioGroupQ27);
        rg28 = (RadioGroup)findViewById(R.id.radioGroupQ28);
        rg29 = (RadioGroup)findViewById(R.id.radioGroupQ29);
        rg30 = (RadioGroup)findViewById(R.id.radioGroupQ30);
        rg31 = (RadioGroup)findViewById(R.id.radioGroupQ31);
        rg32 = (RadioGroup)findViewById(R.id.radioGroupQ32);
        Log.d("gyurie", "안녕2");


        rg21.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.Q21_1){
                    Question q21 = new Question(getString(R.string.Q21), 1, true);
                    SurveyController1.nowStudent.getSurvey()[21]=q21;
                    hexFac2=hexFac2+1;
                }
                else if(checkedId == R.id.Q21_2){
                    Question q21 = new Question(getString(R.string.Q21), 2, true);
                    SurveyController1.nowStudent.getSurvey()[21]=q21;
                    hexFac2=hexFac2+2;
                }
                else if(checkedId == R.id.Q21_3){
                    Question q21 = new Question(getString(R.string.Q21), 3, true);
                    SurveyController1.nowStudent.getSurvey()[21]=q21;
                    hexFac2=hexFac2+3;
                }
                else if(checkedId == R.id.Q21_4){
                    Question q21 = new Question(getString(R.string.Q21), 4, true);
                    SurveyController1.nowStudent.getSurvey()[21]=q21;
                    hexFac2=hexFac2+4;
                }

            }
        });


        rg22.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.Q22_1){
                    Question q22 = new Question(getString(R.string.Q22), 1, true);
                    SurveyController1.nowStudent.getSurvey()[22]=q22;
                    hexFac4=hexFac4+1;
                }
                else if(checkedId == R.id.Q22_2){
                    Question q22 = new Question(getString(R.string.Q22), 2, true);
                    SurveyController1.nowStudent.getSurvey()[22]=q22;
                    hexFac4=hexFac4+2;
                }
                else if(checkedId == R.id.Q22_3){
                    Question q22 = new Question(getString(R.string.Q22), 3, true);
                    SurveyController1.nowStudent.getSurvey()[22]=q22;
                    hexFac4=hexFac4+3;
                }
                else if(checkedId == R.id.Q22_4){
                    Question q22 = new Question(getString(R.string.Q22), 4, true);
                    SurveyController1.nowStudent.getSurvey()[22]=q22;
                    hexFac4=hexFac4+4;
                }
            }
        });

        rg23.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.Q23_1){
                    Question q23 = new Question(getString(R.string.Q23), 1, true);
                    SurveyController1.nowStudent.getSurvey()[23]=q23;
                    hexFac2=hexFac2+1;
                }
                else if(checkedId == R.id.Q23_2){
                    Question q23 = new Question(getString(R.string.Q23), 2, true);
                    SurveyController1.nowStudent.getSurvey()[23]=q23;
                    hexFac2=hexFac2+2;
                }
                else if(checkedId == R.id.Q23_3){
                    Question q23 = new Question(getString(R.string.Q23), 3, true);
                    SurveyController1.nowStudent.getSurvey()[23]=q23;
                    hexFac2=hexFac2+3;
                }
                else if(checkedId == R.id.Q23_4){
                    Question q23 = new Question(getString(R.string.Q23), 4, true);
                    SurveyController1.nowStudent.getSurvey()[23]=q23;
                    hexFac2=hexFac2+4;
                }
            }
        });

        rg24.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.Q24_1){
                    Question q24 = new Question(getString(R.string.Q24), 1, true);
                    SurveyController1.nowStudent.getSurvey()[24]=q24;
                    hexFac2=hexFac2+1;
                }
                else if(checkedId == R.id.Q24_2){
                    Question q24 = new Question(getString(R.string.Q24), 2, true);
                    SurveyController1.nowStudent.getSurvey()[24]=q24;
                    hexFac2=hexFac2+2;
                }
                else if(checkedId == R.id.Q24_3){
                    Question q24 = new Question(getString(R.string.Q24), 3, true);
                    SurveyController1.nowStudent.getSurvey()[24]=q24;
                    hexFac2=hexFac2+3;
                }
                else if(checkedId == R.id.Q24_4){
                    Question q24 = new Question(getString(R.string.Q24), 4, true);
                    SurveyController1.nowStudent.getSurvey()[24]=q24;
                    hexFac2=hexFac2+4;
                }
            }
        });

        rg25.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.Q25_1){
                    Question q25 = new Question(getString(R.string.Q25), 1, true);
                    SurveyController1.nowStudent.getSurvey()[25]=q25;
                    hexFac4=hexFac4+1;
                }
                else if(checkedId == R.id.Q25_2){
                    Question q25 = new Question(getString(R.string.Q25), 2, true);
                    SurveyController1.nowStudent.getSurvey()[25]=q25;
                    hexFac4=hexFac4+2;
                }
                else if(checkedId == R.id.Q25_3){
                    Question q25 = new Question(getString(R.string.Q25), 3, true);
                    SurveyController1.nowStudent.getSurvey()[25]=q25;
                    hexFac4=hexFac4+3;
                }
                else if(checkedId == R.id.Q25_4){
                    Question q25 = new Question(getString(R.string.Q25), 4, true);
                    SurveyController1.nowStudent.getSurvey()[25]=q25;
                    hexFac4=hexFac4+4;
                }
            }
        });

        rg26.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.Q26_1){
                    Question q26 = new Question(getString(R.string.Q26), 1, true);
                    SurveyController1.nowStudent.getSurvey()[26]=q26;
                    hexFac4=hexFac4+1;
                }
                else if(checkedId == R.id.Q26_2){
                    Question q26 = new Question(getString(R.string.Q26), 2, true);
                    SurveyController1.nowStudent.getSurvey()[26]=q26;
                    hexFac4=hexFac4+2;
                }
                else if(checkedId == R.id.Q26_3){
                    Question q26 = new Question(getString(R.string.Q26), 3, true);
                    SurveyController1.nowStudent.getSurvey()[26]=q26;
                    hexFac4=hexFac4+3;
                }
                else if(checkedId == R.id.Q26_4){
                    Question q26 = new Question(getString(R.string.Q26), 4, true);
                    SurveyController1.nowStudent.getSurvey()[26]=q26;
                    hexFac4=hexFac4+4;
                }
            }
        });

        rg27.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.Q27_1){
                    Question q27 = new Question(getString(R.string.Q27), 1, true);
                    SurveyController1.nowStudent.getSurvey()[27]=q27;
                    hexFac4=hexFac4+1;
                }
                else if(checkedId == R.id.Q27_2){
                    Question q27 = new Question(getString(R.string.Q27), 2, true);
                    SurveyController1.nowStudent.getSurvey()[27]=q27;
                    hexFac4=hexFac4+2;
                }
                else if(checkedId == R.id.Q27_3){
                    Question q27 = new Question(getString(R.string.Q27), 3, true);
                    SurveyController1.nowStudent.getSurvey()[27]=q27;
                    hexFac4=hexFac4+3;
                }
                else if(checkedId == R.id.Q27_4) {
                    Question q27 = new Question(getString(R.string.Q27), 4, true);
                    SurveyController1.nowStudent.getSurvey()[27]=q27;
                    hexFac4=hexFac4+4;
                }
            }
        });
        rg28.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.Q28_1){
                    Question q28 = new Question(getString(R.string.Q28), 1, true);
                    SurveyController1.nowStudent.getSurvey()[28]=q28;
                    hexFac4=hexFac4+1;
                }
                else if(checkedId == R.id.Q28_2){
                    Question q28 = new Question(getString(R.string.Q28), 2, true);
                    SurveyController1.nowStudent.getSurvey()[28]=q28;
                    hexFac4=hexFac4+2;
                }
                else if(checkedId == R.id.Q28_3){
                    Question q28 = new Question(getString(R.string.Q28), 3, true);
                    SurveyController1.nowStudent.getSurvey()[28]=q28;
                    hexFac4=hexFac4+3;
                }
                else if(checkedId == R.id.Q28_4){
                    Question q28 = new Question(getString(R.string.Q28), 4, true);
                    SurveyController1.nowStudent.getSurvey()[28]=q28;
                    hexFac4=hexFac4+4;
                }
            }
        });
        rg29.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.Q29_1){
                    Question q29 = new Question(getString(R.string.Q29), 1, true);
                    SurveyController1.nowStudent.getSurvey()[29]=q29;
                    hexFac4=hexFac4+1;
                }
                else if(checkedId == R.id.Q29_2){
                    Question q29 = new Question(getString(R.string.Q29), 2, true);
                    SurveyController1.nowStudent.getSurvey()[29]=q29;
                    hexFac4=hexFac4+2;
                }
                else if(checkedId == R.id.Q29_3){
                    Question q29 = new Question(getString(R.string.Q29), 3, true);
                    SurveyController1.nowStudent.getSurvey()[29]=q29;
                    hexFac4=hexFac4+3;
                }
                else if(checkedId == R.id.Q29_4){
                    Question q29 = new Question(getString(R.string.Q29), 4, true);
                    SurveyController1.nowStudent.getSurvey()[29]=q29;
                    hexFac4=hexFac4+4;
                }
            }
        });
        rg30.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.Q30_1){
                    Question q30 = new Question(getString(R.string.Q30), 1, true);
                    SurveyController1.nowStudent.getSurvey()[30]=q30;
                    hexFac2=hexFac2+1;
                }
                else if(checkedId == R.id.Q30_2){
                    Question q30 = new Question(getString(R.string.Q30), 2, true);
                    SurveyController1.nowStudent.getSurvey()[30]=q30;
                    hexFac2=hexFac2+2;
                }
                else if(checkedId == R.id.Q30_3){
                    Question q30= new Question(getString(R.string.Q30), 3, true);
                    SurveyController1.nowStudent.getSurvey()[30]=q30;
                    hexFac2=hexFac2+3;
                }
                else if(checkedId == R.id.Q30_4){
                    Question q30= new Question(getString(R.string.Q30), 4, true);
                    SurveyController1.nowStudent.getSurvey()[30]=q30;
                    hexFac2=hexFac2+4;
                }
            }
        });
        rg31.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.Q31_1){
                    Question q31 = new Question(getString(R.string.Q31), 1, true);
                    SurveyController1.nowStudent.getSurvey()[31]=q31;
                    hexFac5=hexFac5+4;
                }
                else if(checkedId == R.id.Q31_2){
                    Question q31 = new Question(getString(R.string.Q31), 2, true);
                    SurveyController1.nowStudent.getSurvey()[31]=q31;
                    hexFac5=hexFac5+3;
                }
                else if(checkedId == R.id.Q31_3){
                    Question q31= new Question(getString(R.string.Q31), 3, true);
                    SurveyController1.nowStudent.getSurvey()[31]=q31;
                    hexFac5=hexFac5+2;
                }
                else if(checkedId == R.id.Q31_4){
                    Question q31= new Question(getString(R.string.Q31), 4, true);
                    SurveyController1.nowStudent.getSurvey()[31]=q31;
                    hexFac5=hexFac5+1;
                }
            }
        });
        rg32.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.Q32_1){
                    Question q32 = new Question(getString(R.string.Q32), 1, true);
                    SurveyController1.nowStudent.getSurvey()[32]=q32;
                    hexFac6=hexFac6+4;
                }
                else if(checkedId == R.id.Q32_2){
                    Question q32 = new Question(getString(R.string.Q32), 2, true);
                    SurveyController1.nowStudent.getSurvey()[32]=q32;
                    hexFac6=hexFac6+3;
                }
                else if(checkedId == R.id.Q32_3){
                    Question q32= new Question(getString(R.string.Q32), 3, true);
                    SurveyController1.nowStudent.getSurvey()[32]=q32;
                    hexFac6=hexFac6+2;
                }
                else if(checkedId == R.id.Q32_4){
                    Question q32= new Question(getString(R.string.Q32), 4, true);
                    SurveyController1.nowStudent.getSurvey()[32]=q32;
                    hexFac6=hexFac6+1;
                }
            }
        });


        finish.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                for(int i=21; i<=32;i++){
                    if(SurveyController1.nowStudent.getSurvey()[i].isQuestionCheck()==false){
                        questioncheck=false;

                    }

                }

                if(questioncheck==false){
                    AlertDialog.Builder alert = new AlertDialog.Builder(SurveyController3.this);
                    alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    alert.setMessage("설문조사가 완료되지 않았습니다.");
                    alert.show();
                    questioncheck=true;
                }
                else{

                    SurveyController1.nowStudent.getHexagonGraph().setQT1(hexFac1/5);
                    SurveyController1.nowStudent.getHexagonGraph().setQT2(hexFac2/9);
                    SurveyController1.nowStudent.getHexagonGraph().setQT3(hexFac3/10);
                    SurveyController1.nowStudent.getHexagonGraph().setQT4(hexFac4/6);
                    SurveyController1.nowStudent.getHexagonGraph().setQT5(hexFac5);
                    SurveyController1.nowStudent.getHexagonGraph().setQT6(hexFac6);

                    /*SurveyController1.nowStudent.getHistory().get(SurveyController1.nowStudent.getHistory().size()-1).setQT1(hexFac1/5);

                    SurveyController1.nowStudent.getHistory().get(SurveyController1.nowStudent.getHistory().size()-1).setQT2(hexFac2/9);
                    SurveyController1.nowStudent.getHistory().get(SurveyController1.nowStudent.getHistory().size()-1).setQT3(hexFac3/10);
                    SurveyController1.nowStudent.getHistory().get(SurveyController1.nowStudent.getHistory().size()-1).setQT4(hexFac4/6);
                    */
                    OpenSurveyAPI updateSurvey = new OpenSurveyAPI();

                    try{

                        int i = updateSurvey.execute(SurveyController1.nowStudent).get();

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

                    Log.d("gyurie", "sc2.3");

                    OpenHexagonAPI updateHexagon = new OpenHexagonAPI();


                    try{

                        int i = updateHexagon.execute(SurveyController1.nowStudent).get();

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

                    Toast.makeText(getApplicationContext(), "설문조사를 완료했습니다.", Toast.LENGTH_SHORT).show();


                    Intent intent=new Intent(getApplicationContext(), Studentstart.class);
                    intent.putExtra("student_key", SurveyController1.nowStudent);
                    startActivity(intent);
                }


            }
        });

    }
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}
