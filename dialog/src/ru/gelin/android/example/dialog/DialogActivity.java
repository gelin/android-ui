package ru.gelin.android.example.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DialogActivity extends Activity implements DialogInterface.OnClickListener {

    static final int DIALOG = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void showDialog(View view) {
        showDialog(DIALOG);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DIALOG:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Dialog")
                       .setMessage("Message")
                       .setPositiveButton(android.R.string.ok, this)
                       .setNegativeButton(android.R.string.cancel, this);
                return builder.create();
            default:
                return super.onCreateDialog(id);
        }
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case DialogInterface.BUTTON_POSITIVE:
                Toast.makeText(this, "OK!", Toast.LENGTH_LONG).show();
                return;
            case DialogInterface.BUTTON_NEGATIVE:
                Toast.makeText(this, "Cancel!", Toast.LENGTH_LONG).show();
                return;
        }
    }

}
