package jfsl.edpam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void toAccount(View view) {
        Intent i = new Intent(this, AccountActivity.class);
        startActivity(i);
    }

    public void toSignup(View view) {
        Intent i = new Intent(this, SignUpActivity.class);
        startActivity(i);

    }
}
