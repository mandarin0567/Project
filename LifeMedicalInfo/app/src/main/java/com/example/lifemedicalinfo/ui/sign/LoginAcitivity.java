package com.example.lifemedicalinfo.ui.sign;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.lifemedicalinfo.R;
import com.example.lifemedicalinfo.databinding.ActivityLoginBinding;
import com.example.lifemedicalinfo.ui.main.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginAcitivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setActivity(this);
    }

    public void login() {
//        onLoginSuccess();
        FirebaseAuth.getInstance()
            .signInWithEmailAndPassword(
                binding.etId.getText().toString(),
                binding.etPass.getText().toString()
            )
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                        onLoginSuccess();
                    else
                        onLoginFailed();
                }
            });
    }

    private void onLoginSuccess() {
        Toast.makeText(this, "로그인에 성공하였습니다.", Toast.LENGTH_SHORT).show();

        Intent intentLogin = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intentLogin);
    }

    private void onLoginFailed() {
        Toast.makeText(LoginAcitivity.this, "잘못된 이메일 혹은 비밀번호입니다.", Toast.LENGTH_SHORT).show();
    }

    public void register() {
        Intent intentRegister = new Intent(getApplicationContext(), RegisterAcitivity.class);
        startActivity(intentRegister);
    }
}
