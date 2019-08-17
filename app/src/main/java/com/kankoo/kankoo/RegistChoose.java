package com.kankoo.kankoo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistChoose extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist_choose);

        //학생 회원가입 화면으로 전환
        Button StdRegist = (Button) findViewById(R.id.btnRegist1);
        StdRegist.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(getApplicationContext(), RegistChoose.class);
                startActivityForResult(Intent, 100);
            }
        });

        //사업자 회원가입 화면으로 전환
        Button BsnRegist = (Button) findViewById(R.id.btnRegist2);
        BsnRegist.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(getApplicationContext(), RegistChoose.class);
                startActivityForResult(Intent, 100);
            }
        });
    }
}
