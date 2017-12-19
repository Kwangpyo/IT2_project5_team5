package com.example.it2_project;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SurveyController2 extends AppCompatActivity {

    Button next;
    boolean questioncheck=true;
    HexagonGraph hexagonGraph;
    double hexFac1=0;
    double hexFac2=0;
    double hexFac3=0;
    double hexFac4=0;
    RadioGroup rg11,rg12,rg13,rg14,rg15,rg16,rg17,rg18,rg19,rg20;
    //Student nowStudent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Log.d("gyurie", "Sc2.1");
        setContentView(R.layout.activity_survey2);
        Log.d("gyurie", "Sc2.2");

        //nowStudent = (Student)getIntent().getSerializableExtra("student_key");



        hexFac1=SurveyController1.nowStudent.getHexagonGraph().getQT1();
        hexFac2=SurveyController1.nowStudent.getHexagonGraph().getQT2();
        hexFac3=SurveyController1.nowStudent.getHexagonGraph().getQT3();
        hexFac4=SurveyController1.nowStudent.getHexagonGraph().getQT4();

        /*hexFac1=SurveyController1.nowStudent.getHistory().get(SurveyController1.nowStudent.getHistory().size()-1).getQT1();
        hexFac2=SurveyController1.nowStudent.getHistory().get(SurveyController1.nowStudent.getHistory().size()-1).getQT2();
        hexFac3=SurveyController1.nowStudent.getHistory().get(SurveyController1.nowStudent.getHistory().size()-1).getQT3();
        hexFac4=SurveyController1.nowStudent.getHistory().get(SurveyController1.nowStudent.getHistory().size()-1).getQT4();
        */

        Log.d("gyurie", String.valueOf(hexFac1));

        ImageButton back = (ImageButton)findViewById(R.id.survery2_back);
        TextView logout = (TextView)findViewById(R.id.survey2_logout);

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
                Toast.makeText(SurveyController2.this, "로그아웃", Toast.LENGTH_SHORT).show();
                finish();

            }
        });

        next = (Button)findViewById(R.id.NEXT2);
        rg11 = (RadioGroup)findViewById(R.id.radioGroupQ11);
        rg12 = (RadioGroup)findViewById(R.id.radioGroupQ12);
        rg13 = (RadioGroup)findViewById(R.id.radioGroupQ13);
        rg14 = (RadioGroup)findViewById(R.id.radioGroupQ14);
        rg15 = (RadioGroup)findViewById(R.id.radioGroupQ15);
        rg16 = (RadioGroup)findViewById(R.id.radioGroupQ16);
        rg17 = (RadioGroup)findViewById(R.id.radioGroupQ17);
        rg18 = (RadioGroup)findViewById(R.id.radioGroupQ18);
        rg19 = (RadioGroup)findViewById(R.id.radioGroupQ19);
        rg20 = (RadioGroup)findViewById(R.id.radioGroupQ20);


        rg11.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.Q11_1){
                    Question q11 = new Question(getString(R.string.Q11), 1, true);
                    SurveyController1.nowStudent.getSurvey()[11]=q11;
                    hexFac3=hexFac3+1;
                }

                else if(checkedId == R.id.Q11_2){
                    Question q11 = new Question(getString(R.string.Q11), 2, true);
                    SurveyController1.nowStudent.getSurvey()[11]=q11;
                    hexFac3=hexFac3+2;
                }
                else if(checkedId == R.id.Q11_3){
                    Question q11 = new Question(getString(R.string.Q11), 3, true);
                    SurveyController1.nowStudent.getSurvey()[11]=q11;
                    hexFac3=hexFac3+3;
                }
                else if(checkedId == R.id.Q11_4){
                    Question q11 = new Question(getString(R.string.Q11), 4, true);
                    SurveyController1.nowStudent.getSurvey()[11]=q11;
                    hexFac3=hexFac3+4;
                }
            }
        });


        rg12.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.Q12_1){
                    Question q12 = new Question(getString(R.string.Q12), 1, true);
                    SurveyController1.nowStudent.getSurvey()[12]=q12;
                    hexFac3=hexFac3+1;
                }
                else if(checkedId == R.id.Q12_2){
                    Question q12 = new Question(getString(R.string.Q12), 2, true);
                    SurveyController1.nowStudent.getSurvey()[12]=q12;
                    hexFac3=hexFac3+2;
                }
                else if(checkedId == R.id.Q12_3){
                    Question q12 = new Question(getString(R.string.Q12), 3, true);
                    SurveyController1.nowStudent.getSurvey()[12]=q12;
                    hexFac3=hexFac3+3;
                }
                else if(checkedId == R.id.Q12_4){
                    Question q12 = new Question(getString(R.string.Q12), 4, true);
                    SurveyController1.nowStudent.getSurvey()[12]=q12;
                    hexFac3=hexFac3+4;
                }
            }
        });

        rg13.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.Q13_1){
                    Question q13 = new Question(getString(R.string.Q13), 1, true);
                    SurveyController1.nowStudent.getSurvey()[13]=q13;
                    hexFac3=hexFac3+1;
                }
                else if(checkedId == R.id.Q13_2){
                    Question q13 = new Question(getString(R.string.Q13), 2, true);
                    SurveyController1.nowStudent.getSurvey()[13]=q13;
                    hexFac3=hexFac3+2;
                }
                else if(checkedId == R.id.Q13_3){
                    Question q13 = new Question(getString(R.string.Q13), 3, true);
                    SurveyController1.nowStudent.getSurvey()[13]=q13;
                    hexFac3=hexFac3+3;
                }
                else if(checkedId == R.id.Q13_4){
                    Question q13 = new Question(getString(R.string.Q13), 4, true);
                    SurveyController1.nowStudent.getSurvey()[13]=q13;
                    hexFac3=hexFac3+4;
                }
            }
        });

        rg14.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.Q14_1){
                    Question q14 = new Question(getString(R.string.Q14), 1, true);
                    SurveyController1.nowStudent.getSurvey()[14]=q14;
                    hexFac3=hexFac3+1;
                }
                else if(checkedId == R.id.Q14_2){
                    Question q14 = new Question(getString(R.string.Q14), 2, true);
                    SurveyController1.nowStudent.getSurvey()[14]=q14;
                    hexFac3=hexFac3+2;
                }
                else if(checkedId == R.id.Q14_3){
                    Question q14 = new Question(getString(R.string.Q14), 3, true);
                    SurveyController1.nowStudent.getSurvey()[14]=q14;
                    hexFac3=hexFac3+3;
                }
                else if(checkedId == R.id.Q14_4){
                    Question q14 = new Question(getString(R.string.Q14), 4, true);
                    SurveyController1.nowStudent.getSurvey()[14]=q14;
                    hexFac3=hexFac3+4;
                }
            }
        });

        rg15.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.Q15_1){
                    Question q15 = new Question(getString(R.string.Q15), 1, true);
                    SurveyController1.nowStudent.getSurvey()[15]=q15;
                    hexFac3=hexFac3+1;
                }
                else if(checkedId == R.id.Q15_2){
                    Question q15 = new Question(getString(R.string.Q15), 2, true);
                    SurveyController1.nowStudent.getSurvey()[15]=q15;
                    hexFac3=hexFac3+2;
                }
                else if(checkedId == R.id.Q15_3){
                    Question q15 = new Question(getString(R.string.Q15), 3, true);
                    SurveyController1.nowStudent.getSurvey()[15]=q15;
                    hexFac3=hexFac3+3;
                }
                else if(checkedId == R.id.Q15_4){
                    Question q15 = new Question(getString(R.string.Q15), 4, true);
                    SurveyController1.nowStudent.getSurvey()[15]=q15;
                    hexFac3=hexFac3+4;

                }
            }
        });

        rg16.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.Q16_1){
                    Question q16 = new Question(getString(R.string.Q16), 1, true);
                    SurveyController1.nowStudent.getSurvey()[16]=q16;
                    hexFac3=hexFac3+1;
                }
                else if(checkedId == R.id.Q16_2){
                    Question q16 = new Question(getString(R.string.Q16), 2, true);
                    SurveyController1.nowStudent.getSurvey()[16]=q16;
                    hexFac3=hexFac3+2;
                }
                else if(checkedId == R.id.Q16_3){
                    Question q16 = new Question(getString(R.string.Q16), 3, true);
                    SurveyController1.nowStudent.getSurvey()[16]=q16;
                    hexFac3=hexFac3+3;
                }
                else if(checkedId == R.id.Q16_4){
                    Question q16 = new Question(getString(R.string.Q16), 4, true);
                    SurveyController1.nowStudent.getSurvey()[16]=q16;
                    hexFac3=hexFac3+4;
                }
            }
        });

        rg17.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.Q17_1){
                    Question q17 = new Question(getString(R.string.Q17), 1, true);
                    SurveyController1.nowStudent.getSurvey()[17]=q17;
                    hexFac3=hexFac3+1;
                }
                else if(checkedId == R.id.Q17_2){
                    Question q17 = new Question(getString(R.string.Q17), 2, true);
                    SurveyController1.nowStudent.getSurvey()[17]=q17;
                    hexFac3=hexFac3+2;
                }
                else if(checkedId == R.id.Q17_3){
                    Question q17 = new Question(getString(R.string.Q17), 3, true);
                    SurveyController1.nowStudent.getSurvey()[17]=q17;
                    hexFac3=hexFac3+3;
                }
                else if(checkedId == R.id.Q17_4){
                    Question q17 = new Question(getString(R.string.Q17), 4, true);
                    SurveyController1.nowStudent.getSurvey()[17]=q17;
                    hexFac3=hexFac3+4;
                }
            }
        });
        rg18.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.Q18_1){
                    Question q18 = new Question(getString(R.string.Q18), 1, true);
                    SurveyController1.nowStudent.getSurvey()[18]=q18;
                    hexFac3=hexFac3+1;
                }
                else if(checkedId == R.id.Q18_2){
                    Question q18 = new Question(getString(R.string.Q18), 2, true);
                    SurveyController1.nowStudent.getSurvey()[18]=q18;
                    hexFac3=hexFac3+2;
                }
                else if(checkedId == R.id.Q18_3){
                    Question q18 = new Question(getString(R.string.Q18), 3, true);
                    SurveyController1.nowStudent.getSurvey()[18]=q18;
                    hexFac3=hexFac3+3;
                }
                else if(checkedId == R.id.Q18_4){
                    Question q18 = new Question(getString(R.string.Q18), 4, true);
                    SurveyController1.nowStudent.getSurvey()[18]=q18;
                    hexFac3=hexFac3+4;
                }
            }
        });
        rg19.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.Q19_1){
                    Question q19 = new Question(getString(R.string.Q19), 1, true);
                    SurveyController1.nowStudent.getSurvey()[19]=q19;
                    hexFac2=hexFac2+4;
                }
                else if(checkedId == R.id.Q19_2){
                    Question q19 = new Question(getString(R.string.Q19), 2, true);
                    SurveyController1.nowStudent.getSurvey()[19]=q19;
                    hexFac2=hexFac2+3;
                }
                else if(checkedId == R.id.Q19_3){
                    Question q19 = new Question(getString(R.string.Q19), 3, true);
                    SurveyController1.nowStudent.getSurvey()[19]=q19;
                    hexFac2=hexFac2+2;
                }
                else if(checkedId == R.id.Q19_4){
                    Question q19 = new Question(getString(R.string.Q19), 4, true);
                    SurveyController1.nowStudent.getSurvey()[19]=q19;
                    hexFac2=hexFac2+1;
                }
            }
        });
        rg20.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.Q20_1){
                    Question q20 = new Question(getString(R.string.Q20), 1, true);
                    SurveyController1.nowStudent.getSurvey()[20]=q20;
                    hexFac2=hexFac2+4;
                }
                else if(checkedId == R.id.Q20_2){
                    Question q20 = new Question(getString(R.string.Q20), 2, true);
                    SurveyController1.nowStudent.getSurvey()[20]=q20;
                    hexFac2=hexFac2+3;
                }
                else if(checkedId == R.id.Q20_3){
                    Question q20= new Question(getString(R.string.Q20), 3, true);
                    SurveyController1.nowStudent.getSurvey()[20]=q20;
                    hexFac2=hexFac2+2;
                }
                else if(checkedId == R.id.Q20_4){
                    Question q20= new Question(getString(R.string.Q20), 4, true);
                    SurveyController1.nowStudent.getSurvey()[20]=q20;
                    hexFac2=hexFac2+1;
                }
            }
        });


        next.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                for(int i=11; i<=20;i++){
                    if(SurveyController1.nowStudent.getSurvey()[i].isQuestionCheck()==false){
                        questioncheck=false;

                    }

                }

                if(questioncheck==false){
                    AlertDialog.Builder alert = new AlertDialog.Builder(SurveyController2.this);
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
                    SurveyController1.nowStudent.getHexagonGraph().setQT1(hexFac1);
                    SurveyController1.nowStudent.getHexagonGraph().setQT2(hexFac2);
                    SurveyController1.nowStudent.getHexagonGraph().setQT3(hexFac3);
                    SurveyController1.nowStudent.getHexagonGraph().setQT4(hexFac4);

                    Log.d("gyurie", "sc2.3");
                    Intent intent1 = new Intent(getApplicationContext(), SurveyController3.class);

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
