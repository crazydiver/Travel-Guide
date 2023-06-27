package com.example.laba6;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.yandex.mapkit.MapKitFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapKitFactory.setApiKey("784fd365-a8b5-41f6-ae4f-ab24896740e0");
    }

    public void nextEvent(View v){
        EditText name = findViewById(R.id.Name);
        EditText secName = findViewById(R.id.secName);
        EditText email = findViewById(R.id.email);

        if (!name.getText().toString().matches("") && !secName.getText().toString().matches("") && !email.getText().toString().matches("")) {
            User user = new User(secName.getText().toString(),name.getText().toString(),email.getText().toString());
            Intent i = new Intent(MainActivity.this, ListActivity.class);
            i.putExtra("user", user);
            startActivity(i);
        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Важное сообщение!")
                    .setMessage("Вы не ввеели все нужные данные(ВСЕ)")
                    .setPositiveButton("ОК, иду исправлять....", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            builder.show();
        }
    }
}