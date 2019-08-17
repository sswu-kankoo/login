package com.kankoo.kankoo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class RegistActivity1_auth_dialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist_activity1_auth_dialog);
    }
}


//인증번호 맞으면 가입정보 입력값 return
//인증번호 틀리면 오류 팝업과 메인화면 return