package com.example.ca3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    // UI references.
    SharedPreferences sharedpreferences;
    private EditText mEmailView;
    private EditText mPasswordView;
    Button mEmailSignInButton;
    EditText username;
    private CheckBox checkBoxRememberMe;
    public static final String mypreference = "mysharedpref";
    public static final String Name = "nameKey";
    public static final String Email = "emailKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        mEmailView = findViewById(R.id.email);
        mPasswordView = findViewById(R.id.password);
        username=findViewById(R.id.username);
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        if (sharedpreferences.contains("Name")) {
            mEmailView.setText(sharedpreferences.getString(Name, ""));
        }
        if (sharedpreferences.contains("Email")) {
            mPasswordView.setText(sharedpreferences.getString(Email, ""));

        }
        if(sharedpreferences.contains("User")){
            username.setText(sharedpreferences.getString("User",""));
        }

        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        mEmailSignInButton = findViewById(R.id.logButton);
        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        checkBoxRememberMe = findViewById(R.id.checkBoxRememberMe);
//Here we will validate saved preferences


    }
    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {

// Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

// Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

// Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError("invalid_password");
            focusView = mPasswordView;
            cancel = true;
        }

// Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError("error_field_required");
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmailView.setError("error_invalid_email");
            focusView = mEmailView;
            cancel = true;
        }

        if (cancel) {
// There was an error; don't attempt login and focus the first
// form field with an error.
            focusView.requestFocus();
        } else {
// save data in local shared preferences
            if (checkBoxRememberMe.isChecked()) {
                mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Save();
                        startHomeActivity();
                    }
                });

            }
        }
    }

    private void startHomeActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();


    }
    public void Save() {
        String n =mEmailView.getText().toString();
        String e = mPasswordView.getText().toString();
        String u=username.getText().toString();
        SharedPreferences mPrefs = getSharedPreferences("IDvalue", 0);
//Give any name for //preference as I have given "IDvalue" and value 0.
        SharedPreferences.Editor editor = mPrefs.edit();
        editor.putString("Name", n);
        editor.putString("Password", e);
        editor.putString("User", u);
        editor.putString("LoggedIn", "true");
        editor.commit();
    }
    public void clear(View view) {
       // name = findViewById(R.id.etName);
       //email = findViewById(R.id.etEmail);
        mEmailView.setText("");
        mPasswordView.setText("");

    }




    private boolean isEmailValid(String email) {
//TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
//TODO: Replace this with your own logic
        return password.length() > 4;
    }
}
