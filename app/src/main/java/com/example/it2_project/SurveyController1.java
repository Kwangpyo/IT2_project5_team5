package com.example.it2_project;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.os.Parcelable;
import android.widget.TextView;
import android.widget.Toast;

public class SurveyController1 extends AppCompatActivity {


    boolean questioncheck=true;
    HexagonGraph hexagonGraph;
    double hexFac1=0;
    double hexFac2=0;
    double hexFac3=0;
    double hexFac4=0;
    RadioGroup rg1,rg2,rg3,rg4,rg5,rg6,rg7,rg8,rg9,rg10;
    public static Student nowStudent;

    //public static ArrayList<Question> survey = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_survey1);
        Button next=(Button)findViewById(R.id.NEXT);
        nowStudent=(Student)getIntent().getSerializableExtra("student_key");


        ImageButton back = (ImageButton)findViewById(R.id.survery1_back);
        TextView logout = (TextView)findViewById(R.id.survey1_logout);

        back.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {

                Intent bck = new Intent(getApplicationContext(),Studentstart.class);
                bck.putExtra("student_key", nowStudent);
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
                Toast.makeText(SurveyController1.this, "로그아웃", Toast.LENGTH_SHORT).show();
                finish();

            }
        });

        //next = (Button)findViewById(R.id.NEXT);
        rg1 = (RadioGroup)findViewById(R.id.radioGroupQ1);
        rg2 = (RadioGroup)findViewById(R.id.radioGroupQ2);
        rg3 = (RadioGroup)findViewById(R.id.radioGroupQ3);
        rg4 = (RadioGroup)findViewById(R.id.radioGroupQ4);
        rg5 = (RadioGroup)findViewById(R.id.radioGroupQ5);
        rg6 = (RadioGroup)findViewById(R.id.radioGroupQ6);
        rg7 = (RadioGroup)findViewById(R.id.radioGroupQ7);
        rg8 = (RadioGroup)findViewById(R.id.radioGroupQ8);
        rg9 = (RadioGroup)findViewById(R.id.radioGroupQ9);
        rg10 = (RadioGroup)findViewById(R.id.radioGroupQ10);

        Question q=new Question(null, 0, false);

        for(int i=0 ; i<33;i++){
            nowStudent.getSurvey()[i]=q;
        }


        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.Q1_1){
                    Question q1 = new Question(getString(R.string.Q1), 1, true);
                    nowStudent.getSurvey()[1]=q1;
                    //SurveyList.getInstance().getSurvey()[1]=q1;
                    hexFac1=hexFac1+1;
                }
                else if(checkedId == R.id.Q1_2){
                    Question q1 = new Question(getString(R.string.Q1), 2, true);
                    nowStudent.getSurvey()[1]=q1;
                    hexFac1=hexFac1+2;
                }
                else if(checkedId == R.id.Q1_3){
                    Question q1 = new Question(getString(R.string.Q1), 3, true);
                    nowStudent.getSurvey()[1]=q1;
                    hexFac1=hexFac1+3;
                }
                else if(checkedId == R.id.Q1_4){
                    Question q1 = new Question(getString(R.string.Q1), 4, true);
                    nowStudent.getSurvey()[1]=q1;
                    hexFac1=hexFac1+4;
                }
            }
        });
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.Q2_1){
                    Question q2 = new Question(getString(R.string.Q2), 1, true);
                    nowStudent.getSurvey()[2]=q2;
                    hexFac1=hexFac1+1;
                }
                else if(checkedId == R.id.Q2_2){
                    Question q2 = new Question(getString(R.string.Q2), 2, true);
                    nowStudent.getSurvey()[2]=q2;
                    hexFac1=hexFac1+2;
                }
                else if(checkedId == R.id.Q2_3){
                    Question q2 = new Question(getString(R.string.Q2), 3, true);
                    nowStudent.getSurvey()[2]=q2;
                    hexFac1=hexFac1+3;
                }
                else if(checkedId == R.id.Q2_4){
                    Question q2 = new Question(getString(R.string.Q2), 4, true);
                    nowStudent.getSurvey()[2]=q2;
                    hexFac1=hexFac1+4;
                }
            }
        });

        rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.Q3_1){
                    Question q3 = new Question(getString(R.string.Q3), 1, true);
                    nowStudent.getSurvey()[3]=q3;
                    hexFac1=hexFac1+1;
                }
                else if(checkedId == R.id.Q3_2){
                    Question q3 = new Question(getString(R.string.Q3), 2, true);
                    nowStudent.getSurvey()[3]=q3;
                    hexFac1=hexFac1+2;
                }
                else if(checkedId == R.id.Q3_3){
                    Question q3 = new Question(getString(R.string.Q3), 3, true);
                    nowStudent.getSurvey()[3]=q3;
                    hexFac1=hexFac1+3;
                }
                else if(checkedId == R.id.Q3_4){
                    Question q3 = new Question(getString(R.string.Q3), 4, true);
                    nowStudent.getSurvey()[3]=q3;
                    hexFac1=hexFac1+4;
                }
            }
        });

        rg4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.Q4_1){
                    Question q4 = new Question(getString(R.string.Q4), 1, true);
                    nowStudent.getSurvey()[4]=q4;
                    hexFac1=hexFac1+1;
                }
                else if(checkedId == R.id.Q4_2){
                    Question q4 = new Question(getString(R.string.Q4), 2, true);
                    nowStudent.getSurvey()[4]=q4;
                    hexFac1=hexFac1+2;
                }
                else if(checkedId == R.id.Q4_3){
                    Question q4 = new Question(getString(R.string.Q4), 3, true);
                    nowStudent.getSurvey()[4]=q4;
                    hexFac1=hexFac1+3;
                }
                else if(checkedId == R.id.Q4_4){
                    Question q4 = new Question(getString(R.string.Q4), 4, true);
                    nowStudent.getSurvey()[4]=q4;
                    hexFac1=hexFac1+4;
                }
            }
        });

        rg5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.Q5_1){
                    Question q5 = new Question(getString(R.string.Q5), 1, true);
                    nowStudent.getSurvey()[5]=q5;
                    hexFac1=hexFac1+1;
                }
                else if(checkedId == R.id.Q5_2){
                    Question q5 = new Question(getString(R.string.Q5), 2, true);
                    nowStudent.getSurvey()[5]=q5;
                    hexFac1=hexFac1+1;
                }
                else if(checkedId == R.id.Q5_3){
                    Question q5 = new Question(getString(R.string.Q5), 3, true);
                    nowStudent.getSurvey()[5]=q5;
                    hexFac1=hexFac1+1;
                }
                else if(checkedId == R.id.Q5_4){
                    Question q5 = new Question(getString(R.string.Q5), 4, true);
                    nowStudent.getSurvey()[5]=q5;
                    hexFac1=hexFac1+1;
                }
            }
        });

        rg6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.Q6_1){
                    Question q6 = new Question(getString(R.string.Q6), 1, true);
                    nowStudent.getSurvey()[6]=q6;
                    hexFac2=hexFac2+1;
                }
                else if(checkedId == R.id.Q6_2){
                    Question q6 = new Question(getString(R.string.Q6), 2, true);
                    nowStudent.getSurvey()[6]=q6;
                    hexFac2=hexFac2+2;
                }
                else if(checkedId == R.id.Q6_3){
                    Question q6 = new Question(getString(R.string.Q6), 3, true);
                    nowStudent.getSurvey()[6]=q6;
                    hexFac2=hexFac2+3;
                }
                else if(checkedId == R.id.Q6_4){
                    Question q6 = new Question(getString(R.string.Q6), 4, true);
                    nowStudent.getSurvey()[6]=q6;
                    hexFac2=hexFac2+4;
                }
            }
        });

        rg7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.Q7_1){
                    Question q7 = new Question(getString(R.string.Q7), 1, true);
                    nowStudent.getSurvey()[7]=q7;
                    hexFac3=hexFac3+1;
                }
                else if(checkedId == R.id.Q7_2){
                    Question q7 = new Question(getString(R.string.Q7), 2, true);
                    nowStudent.getSurvey()[7]=q7;
                    hexFac3=hexFac3+2;
                }
                else if(checkedId == R.id.Q7_3){
                    Question q7 = new Question(getString(R.string.Q7), 3, true);
                    nowStudent.getSurvey()[7]=q7;
                    hexFac3=hexFac3+3;
                }
                else if(checkedId == R.id.Q7_4){
                    Question q7 = new Question(getString(R.string.Q7), 4, true);
                    nowStudent.getSurvey()[7]=q7;
                    hexFac4=hexFac4+4;
                }
            }
        });
        rg8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.Q8_1){
                    Question q8 = new Question(getString(R.string.Q8), 1, true);
                    nowStudent.getSurvey()[8]=q8;
                    hexFac2=hexFac2+1;
                }
                else if(checkedId == R.id.Q8_2){
                    Question q8 = new Question(getString(R.string.Q8), 2, true);
                    nowStudent.getSurvey()[8]=q8;
                    hexFac2=hexFac2+2;
                }
                else if(checkedId == R.id.Q8_3){
                    Question q8 = new Question(getString(R.string.Q8), 3, true);
                    nowStudent.getSurvey()[8]=q8;
                    hexFac2=hexFac2+3;
                }
                else if(checkedId == R.id.Q8_4){
                    Question q8 = new Question(getString(R.string.Q8), 4, true);
                    nowStudent.getSurvey()[8]=q8;
                    hexFac2=hexFac2+4;
                }
            }
        });
        rg9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.Q9_1){
                    Question q9 = new Question(getString(R.string.Q9), 1, true);
                    nowStudent.getSurvey()[9]=q9;
                    hexFac3=hexFac3+1;
                }
                else if(checkedId == R.id.Q9_2){
                    Question q9 = new Question(getString(R.string.Q9), 2, true);
                    nowStudent.getSurvey()[9]=q9;
                    hexFac3=hexFac3+2;
                }
                else if(checkedId == R.id.Q9_3){
                    Question q9 = new Question(getString(R.string.Q9), 3, true);
                    nowStudent.getSurvey()[9]=q9;
                    hexFac3=hexFac3+3;
                }
                else if(checkedId == R.id.Q9_4){
                    Question q9 = new Question(getString(R.string.Q9), 4, true);
                    nowStudent.getSurvey()[9]=q9;
                    hexFac3=hexFac3+4;
                }
            }
        });
        rg10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.Q10_1){
                    Question q10 = new Question(getString(R.string.Q10), 1, true);
                    nowStudent.getSurvey()[10]=q10;
                    hexFac2=hexFac2+1;
                }
                else if(checkedId == R.id.Q10_2){
                    Question q10 = new Question(getString(R.string.Q10), 2, true);
                    nowStudent.getSurvey()[10]=q10;
                    hexFac3=hexFac3+2;
                }
                else if(checkedId == R.id.Q10_3){
                    Question q10= new Question(getString(R.string.Q10), 3, true);
                    nowStudent.getSurvey()[10]=q10;
                    hexFac3=hexFac3+3;
                }
                else if(checkedId == R.id.Q10_4){
                    Question q10= new Question(getString(R.string.Q10), 4, true);
                    nowStudent.getSurvey()[10]=q10;
                    hexFac3=hexFac3+4;
                }
            }
        });


        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                for(int i=1; i<=10;i++){
                    if(nowStudent.getSurvey()[i].isQuestionCheck()==false){
                        questioncheck=false;

                    }

                }


                if(questioncheck==false){
                    AlertDialog.Builder alert = new AlertDialog.Builder(SurveyController1.this);
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
                    Log.d("gyurie", "고파");
                    Log.d("kkp",String.valueOf(hexFac1));
                    Log.d("kkp1",String.valueOf(hexFac2));
                    Log.d("kkp2",String.valueOf(hexFac3));
                    Log.d("kkp3",String.valueOf(hexFac4));
                    hexagonGraph = new HexagonGraph(hexFac1,hexFac2,hexFac3,hexFac4,0,0);
                   /*     hexagonGraph.setQT1(hexFac1);
                        hexagonGraph.setQT2(hexFac2);
                        hexagonGraph.setQT3(hexFac3);
                        hexagonGraph.setQT4(hexFac4); */

                    Log.d("gyurie", "배가");

                    nowStudent.setHexagonGraph(hexagonGraph);
                    Log.d("gyurie", "흑흑");

                    Intent intent1 = new Intent(getApplicationContext(),SurveyController2.class);
                    intent1.putExtra("student_key",nowStudent);
                    Log.d("gyurie","요건?");
                    startActivity(intent1);
                }
            }
        });

    }


    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}
