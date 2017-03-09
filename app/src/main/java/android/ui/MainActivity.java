package android.ui;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.ui.ios.IosActivity;
import android.view.View;

public class MainActivity extends IosActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void testClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder
                .setTitle("IosAlertDialog")
                .setMessage("IosAlertDialogMessage")
                .setPositiveButton("OK", null)
                .setNegativeButton("Cancel", null)
                .setNeutralButton("No", null)
                .show();

//        startActivity(new Intent(this,MainActivity.class));
    }
}