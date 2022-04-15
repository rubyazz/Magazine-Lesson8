package com.example.magazine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView androidPhone, iosPhone;
    RadioButton bankRadio, cashRadio, kaspi, forte;
    CheckBox syilykCheckBox, mekenCheckBox;
    Button jiberuBtn;

    String tolemTuri, jetkizuText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        androidPhone = findViewById(R.id.androidPhone);
        iosPhone = findViewById(R.id.iosPhone);

        bankRadio = findViewById(R.id.bankRadio);
        cashRadio = findViewById(R.id.cashRadio);
        kaspi = findViewById(R.id.kaspi);
        forte = findViewById(R.id.forte);

        syilykCheckBox = findViewById(R.id.syilykCheckBox);
        mekenCheckBox = findViewById(R.id.mekenCheckBox);

        jiberuBtn = findViewById(R.id.jiberuBtn);

        registerForContextMenu(iosPhone);
        registerForContextMenu(androidPhone);


        jiberuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bankRadio.isChecked()){
                    tolemTuri = "Payed with Bank card";
                }else if(cashRadio.isChecked()){
                    tolemTuri = "Payed With Cash";
                }
                else if(kaspi.isChecked()){
                    tolemTuri = "Payed With kaspi";
                }
                else if(forte.isChecked()){
                    tolemTuri = "Payed With forte";
                }

                if(syilykCheckBox.isChecked()){
                    jetkizuText = "Give as a gift";
                }
                if(mekenCheckBox.isChecked()){
                    jetkizuText = "Delivery";
                }
                String result = "Android: "+androidPhone.getText()+"\n"+
                        "Ios: "+iosPhone.getText()+"\n"+
                        "Type of pay: "+tolemTuri+"\n"+
                        "type od deliver: "+jetkizuText;

                Toast.makeText(MainActivity.this,result, Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if(v == androidPhone){
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.android_menu, menu);
        }
        if(v == iosPhone){
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.ios_menu, menu);
        }

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.samsungPhone:
                androidPhone.setText("Samsung");
                break;
            case R.id.mi9Phone:
                androidPhone.setText("MI9");
                break;
            case R.id.huaweiPhone:
                androidPhone.setText("Huawei");
                break;
            case R.id.xiaomiPhone:
                androidPhone.setText("Xiaomi");
                break;

            case R.id.iPhoneX:
                iosPhone.setText("Iphone X");
                break;
            case R.id.iPhone11:
                iosPhone.setText("iPhone 11");
                break;
            case R.id.iPhone12:
                iosPhone.setText("IPhone 12");
                break;
            case R.id.iPhone13:
                iosPhone.setText("IPhone 13");
                break;
            case R.id.iPhone13pro:
                iosPhone.setText("IPhone 13 Pro");
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_setting:
                Toast.makeText(this, "Setting menu basildy", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_exit:
                Toast.makeText(this, "Exit menu basildy", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_save:
                Toast.makeText(this, "Save menu basildy", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_cut:
                Toast.makeText(this, "Cut menu basildy", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}