package com.kankoo.kankoo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //회원가입 선택화면으로 전환
        Button button1 = (Button)findViewById(R.id.btnRegist);
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View view) {
                Intent Intent = new Intent(getApplicationContext(), RegistChoose.class);
                startActivityForResult(Intent, 100);
            }
        });

        //로그인 검증화면으로 전환
        Button button2 = (Button)findViewById(R.id.actasdasdr);
        button2.setOnClickListener(new View.OnClickListener(){

    }


}
