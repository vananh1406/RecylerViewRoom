package com.example.recylerviewroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.recylerviewroom.Database.UserDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText edtname;
    private EditText edtage;
    private EditText edtphone;
    private EditText edtmail;
    private EditText edtaddress;
    private Button btnAdd;
    private RecyclerView rcyUser;

    private UserAdapter userAdapter;
    private List<User>list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUi();

        userAdapter = new UserAdapter();
        list= new ArrayList<>();
        userAdapter.setData(list);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rcyUser.setLayoutManager(layoutManager);

        rcyUser.setAdapter(userAdapter);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 addUser();
            }
        });

    }

    private void addUser() {

        String strUserName = edtname.getText().toString().trim();
        String strAge = edtage.getText().toString().trim();
        String strPhone = edtphone.getText().toString().trim();
        String strMail = edtmail.getText().toString().trim();
        String strAddress = edtaddress.getText().toString().trim();

        if(TextUtils.isEmpty(strUserName) || TextUtils.isEmpty(strAge) || TextUtils.isEmpty(strPhone) || TextUtils.isEmpty(strMail) ||
                TextUtils.isEmpty(strAddress)){
            return;

        }
        User user = new User(strUserName,strAge,strPhone,strMail,strAddress);
        UserDatabase.getInstance(this).userDao().insertName(user);
        Toast.makeText(this, "Add IMFOMTAION SUCCESSFULLY", Toast.LENGTH_SHORT).show();

        edtname.setText("");
        edtage.setText("");
        edtphone.setText("");
        edtmail.setText("");
        edtaddress.setText("");
//AN BAN PHIM
      hideSoftKeyboard();
      list =UserDatabase.getInstance(this).userDao().getListUser();
      userAdapter.setData(list);

    }
    public void hideSoftKeyboard(){
        try{
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);

        }catch (NullPointerException ex){
            ex.printStackTrace();
        }
    }

    private void initUi(){
        edtname = findViewById(R.id.edtUserName);
        edtage = findViewById(R.id.edtAge);
        edtphone = findViewById(R.id.edtphone);
        edtmail = findViewById(R.id.edtMail);
        edtaddress = findViewById(R.id.edtAddress);
        btnAdd = findViewById(R.id.btnAdd);
        rcyUser = findViewById(R.id.rcyUser);
    }
}