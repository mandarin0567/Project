package com.example.lifemedicalinfo.ui.sign;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.lifemedicalinfo.R;
import com.example.lifemedicalinfo.databinding.ActivityRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterAcitivity extends AppCompatActivity {

    ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register);
        binding.setActivity(this);
    }

    public void register() {
        FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(binding.etId.getText().toString(), binding.etPass.getText().toString())
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                        onRegisterSuccess();
                    else
                        onRegisterFailure();
                }
            });
    }

    private void onRegisterSuccess() {
        Toast.makeText(this,"회원가입에 성공하였습니다. 로그인해주세요", Toast.LENGTH_SHORT).show();

        finish();
    }

    private void onRegisterFailure() {
        Toast.makeText(this,"회원가입할 수 없습니다.", Toast.LENGTH_SHORT).show();
    }
}
