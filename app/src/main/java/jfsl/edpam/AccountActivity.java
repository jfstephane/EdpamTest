package jfsl.edpam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
    }


    public void toBase(View view) {
        Intent i = new Intent(this, UpNavMainActivity.class);
        startActivity(i);
    }
}
