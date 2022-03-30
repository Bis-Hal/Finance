package com.example.finance.validation;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.finance.R;
import com.example.finance.database.Connection;
import com.example.finance.database.LoginDatabaseOperations;

public class LoginValidation {
    private TextView validationMsg;
    private EditText passwordInput, usernameInput;
    private View view;
    private  String un, pwd;
    private Connection connection;
    private Context context;

    private String validUsername = "Admin";
    private String validPassword = "Admin";

    public LoginValidation(View view, Context context) {
        this.view = view;
        this.context = context;
    }


    public Boolean validation(){
        connection = new Connection(context);
        usernameInput = view.findViewById(R.id.usernameInput);
        passwordInput = view.findViewById(R.id.passwordInput);
        validationMsg = view.findViewById(R.id.validationMsg);



        un = usernameInput.getText().toString();
        pwd = passwordInput.getText().toString();



        if(un.equals(validUsername) && pwd.equals(validPassword)){
            validationMsg.setVisibility(View.GONE);
            return true;
        }
//        if(loginDatabaseOperations.fetchUser()){
//            return  true;
//        }
        else if(un.equals("") || pwd.equals(" ")){

            errorMsgDisplay(R.string.empty_fields);
            return false;
        }
        else{
            errorMsgDisplay(R.string.invalid);
            return false;
        }
    }

    private void errorMsgDisplay(int msg){
        usernameInput.setText("");
        passwordInput.setText("");
        validationMsg.setVisibility(View.VISIBLE);
        validationMsg.setText(msg);
    }
}
