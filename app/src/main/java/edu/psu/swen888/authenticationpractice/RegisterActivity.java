package edu.psu.swen888.authenticationpractice;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    FirebaseAuth mFireBaseAuth;
    Button registerMe;
    EditText email;
    EditText password;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        email = findViewById(R.id.editTextCreateEmailAddress);
        password = findViewById(R.id.editTextCreateNumberPassword);
        registerMe = findViewById(R.id.createAccountbutton);
        mFireBaseAuth = FirebaseAuth.getInstance();

        registerMe.setOnClickListener(view ->{
            createUser(email.getText().toString(), password.getText().toString());
        });
    }

    private void createUser(String email, String password){
        mFireBaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(RegisterActivity.this, "Registration Complete", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, BooksActivity.class);
                    startActivity(intent);
                }
            }
        });


    }
}
