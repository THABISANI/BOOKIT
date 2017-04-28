package com.example.justin.librarybooks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import landing_pages.LandingPage;


public class Login extends AppCompatActivity implements View.OnClickListener
{
    //Declare variables//
    private EditText userID;
    public static String username;

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        /*
         The state is passed back to onCreate if the activity needs to be recreated (e.g., orientation change)
         so that you don't lose any prior information. If no data was supplied, savedInstanceState is null.
       */
        super.onCreate(savedInstanceState);

        //Set the layout for the activity//
        setContentView(R.layout.activity_login);

        //Instantiate declared variables//
        userID = (EditText) findViewById(R.id.usernname);
        Button loginButton = (Button) findViewById(R.id.btn_login);

        //Prevent Crash if button does not display on screen//
        if (loginButton != null)
            loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_login:

                //Added later maybe a loading animation after the user presses login//
                /*

                final ProgressDialog progressDialog = new ProgressDialog(Login.this,
                        R.style.AppTheme_Dark_Dialog);
                progressDialog.setIndeterminate(true);
                progressDialog.setMessage("Authenticating...");
                progressDialog.show();
        try {
            new android.os.Handler().postDelayed(
            new Runnable() {
                public void run() {
                    // On complete call either onLoginSuccess or onLoginFailed
                    progressDialog.dismiss();
                }
            }, 3000);
        }
    catch (IllegalArgumentException e)
    {
        Log.i("progressDialog", e.getMessage());
    }
*/
                username = userID.getText().toString();

                //Validate if the user typed in the correct information//
                if(username.contains("STU")){
                    startActivity(new Intent(this, LandingPage.class));
                    finish();}
                else
                {
                    Toast.makeText(this,"INVALID LOGIN CHECK PREFIX STU for student",Toast.LENGTH_LONG).show();
                }


                //pop up message//
                Toast toastMessage = new Toast(getApplicationContext());
                //Set positioning of the pop up message//
                toastMessage.setGravity(Gravity.TOP | Gravity.START, 0, 0);

                break;

        }
    }

}
