package com.kankoo.kankoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btnCancel, btnDone;
    private EditText etasdasd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_go = (Button) findViewByID(R.id.btn_go);
        btn_go.setOnClickListener(
            new Button.OnClickListener() {
                public void onClick(View v) {
                    //SubActivity로 가는 인텐트를 생성
                    Intent intent = new Intent(this, RegistChoose.class);
                    //액티비티 시작!
                    startActivity(intent);
                }
            }
        );



    }
}