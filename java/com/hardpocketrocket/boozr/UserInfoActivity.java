package com.hardpocketrocket.boozr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.realm.Realm;

public class UserInfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        EditText firstName = findViewById(R.id.first_name_edit);
        EditText lastName = findViewById(R.id.last_name_edit);
        Button update = findViewById(R.id.update_button);

        User user = Realm.getDefaultInstance().where(User.class).findFirst();
        firstName.setText(user.getFirstName());
        lastName.setText(user.getLastName());

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Realm.getDefaultInstance().beginTransaction();
                User user = Realm.getDefaultInstance().where(User.class).findFirst();
                user.setFirstName(firstName.getText().toString());
                user.setLastName(lastName.getText().toString());
                Realm.getDefaultInstance().commitTransaction();
                finish();
            }
        });
    }
}
