package live.syslyncerp.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnLoginClick(View view) {
        Intent intent = new Intent(MainActivity.this, Dashboard.class);
        startActivity(intent);
        Toast.makeText(this,"Login was Clicked",Toast.LENGTH_LONG).show();
        finish();
    }
}