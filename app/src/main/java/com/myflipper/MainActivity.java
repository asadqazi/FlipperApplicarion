package com.myflipper;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ViewFlipper;


public class MainActivity extends AppCompatActivity implements OnClickListener {

    Button btnSignIn, btnSignUp;
    TextInputLayout tiEmail, tiPassword;
    private ViewFlipper vf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vf = (ViewFlipper) findViewById(R.id.viewflipper);

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View login = inflater.inflate(R.layout.layout_sign_in, null);
        View signUp = inflater.inflate(R.layout.layout_sign_up, null);
        vf.addView(login);
        vf.addView(signUp);

        btnSignIn = (Button) findViewById(R.id.btn_signin);
        btnSignUp = (Button) findViewById(R.id.btn_signup);
        Button btnBackToSignIN = (Button) findViewById(R.id.btn_back_to_signin);

        tiEmail = (TextInputLayout) findViewById(R.id.ti_email);
        tiPassword = (TextInputLayout) findViewById(R.id.ti_password);


        btnSignIn.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);

        btnBackToSignIN.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_signin:
                Snackbar.make(v, tiEmail.getEditText().getText().toString() + "  " + tiPassword.getEditText().getText().toString(), Snackbar.LENGTH_SHORT).show();
                break;

            case R.id.btn_signup:
                vf.setInAnimation(this, R.anim.left_in);
                vf.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.left_out));
                vf.showNext();
                break;

            case R.id.btn_back_to_signin:
                vf.setInAnimation(this, R.anim.right_in);
                vf.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.right_out));
                vf.showPrevious();
                break;
        }

    }
}
