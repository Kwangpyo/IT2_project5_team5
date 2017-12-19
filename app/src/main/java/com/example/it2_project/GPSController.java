package com.example.it2_project;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.location.Address;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

public class GPSController extends AppCompatActivity {

   // TextView lon;
   // TextView lat;
   // TextView address_txt;
    Button dec;
    public Student login_student;
    Geocoder geocoder;
    String address;
    List<Address> address_list;
    Location address_loc;

    ImageButton back;
    TextView logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_gpscontroller);
        login_student = (Student)getIntent().getSerializableExtra("student_key");
      //  lon = (TextView)findViewById(R.id.gpslon);
      //  lat = (TextView)findViewById(R.id.gpslat);
        dec = (Button)findViewById(R.id.gpscontroller_Dec);
       // address_txt = (TextView)findViewById(R.id.gpscontroller_location);
        back = (ImageButton)findViewById(R.id.gpscontroller_back);
        logout = (TextView)findViewById(R.id.gpscontroller_logout);

        geocoder= new Geocoder(this, Locale.getDefault());


        getLocation();



        dec.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {

                dialog();

            }
        });

        back.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {

                Intent bck = new Intent(getApplicationContext(),Studentstart.class);
                bck.putExtra("student_key", login_student);
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
                Toast.makeText(GPSController.this, "로그아웃", Toast.LENGTH_SHORT).show();
                finish();

            }
        });


    }

    public void getLocation(){

        Dexter.withActivity(GPSController.this)
                .withPermissions(
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION
                ).withListener(new MultiplePermissionsListener() {
            @Override public void onPermissionsChecked(MultiplePermissionsReport report) {

                if(report.areAllPermissionsGranted())
                {
                    requestLocation();
                }

                    /* ... */}

            @Override public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                    /* ... */}

        }).check();

    }


    private FusedLocationProviderClient mLocationClient;

    private void requestLocation()
    {
        Log.d("qwe2","asd2");
        mLocationClient = LocationServices.getFusedLocationProviderClient(GPSController.this);
        mLocationClient.getLastLocation().addOnSuccessListener(GPSController.this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                Log.d("qwe3","asd3");
                if(location != null)
                {
                    Log.d("qwe","asd");
/*
                    OpenLocationAPI getLoc = new OpenLocationAPI();

                    try{

                        Declaration dec = new Declaration(login_student.getId(),location.getLongitude(),location.getLatitude());
                        int i = getLoc.execute(dec).get();

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
                    } */
     //               lat.setText("latitude : "+location.getLatitude());
       //             lon.setText("longitude : "+location.getLongitude());

                    address_loc = location;

                    List<Address> list = null;
                    try {
                        list = geocoder.getFromLocation(
                                location.getLatitude(), // 위도
                                location.getLongitude(), // 경도
                                10); // 얻어올 값의 개수

                        address_list = list;

                    } catch (IOException e) {
                        e.printStackTrace();
                        Log.e("test", "입출력 오류 - 서버에서 주소변환시 에러발생");
                    }
                    if (list != null) {
                        if (list.size()==0) {
         //                   address_txt.setText("해당되는 주소 정보는 없습니다");
                        } else {

           //                 address_txt.setText(list.get(0).getAddressLine(0));
                            address = list.get(0).getAddressLine(0);

                        }
                    }
                    //Toast.makeText(getApplicationContext(),"신고가 접수되었습니다",Toast.LENGTH_SHORT).show();

                }


                }

        });
    }


    public void dialog()
    {
        AlertDialog.Builder dialog = new AlertDialog.Builder(GPSController.this);
        dialog.setTitle("신고하기")
                .setMessage("지금 주소는 "+ address + "입니다. 신고하시겠습니까?" )
                .setPositiveButton("네", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {



                        long now=System.currentTimeMillis();
                        Date date=new Date(now);
                        SimpleDateFormat mFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

                        OpenLocationAPI getLoc = new OpenLocationAPI();

                        try{

                            Declaration dec = new Declaration(login_student.getId(),address_loc.getLongitude(),address_loc.getLatitude(),address,mFormat.format(date));
                            int i = getLoc.execute(dec).get();

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

                        Toast.makeText(GPSController.this, "신고가 접수되었습니다", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(getApplicationContext(),Studentstart.class);
                        intent1.putExtra("student_key", login_student);
                        startActivity(intent1);

                    }
                })
                .setNegativeButton("아니요", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(GPSController.this, "신고를 취소하였습니다", Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(getApplicationContext(),Studentstart.class);
                        intent2.putExtra("student_key", login_student);
                        startActivity(intent2);
                    }
                })
                .create()
                .show();
    }



    @Override
    public void onBackPressed() {
        // super.onBackPressed();
    }

}
