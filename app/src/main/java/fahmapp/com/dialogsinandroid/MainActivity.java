package fahmapp.com.dialogsinandroid;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener ,DatePickerDialog.OnDateSetListener{

    LinearLayout root_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        root_layout=(LinearLayout)findViewById(R.id.root_layout);

    }



    public  void showSimpleDialog(View view) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(false);
        builder.setTitle("AlertDialog Title");

        builder.setMessage("Simple Dialog Message")
                .setPositiveButton("OK!!!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        ////
                    }
                })
        .setNegativeButton("Cancel ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        })
               ;
        // Create the AlertDialog object and return it
         builder.create().show();
    }


    public void showListDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("pick a color")
                .setItems(R.array.colors_array, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        switch (which) {
                            case 0:
                                root_layout.setBackgroundColor(Color.RED);
                                break;
                            case 1:
                                root_layout.setBackgroundColor(Color.GREEN);
                                break;
                            case 2:
                                root_layout.setBackgroundColor(Color.BLUE);
                                break;

                        }
                        //Toast.makeText(MainActivity.this," "+which ,Toast.LENGTH_SHORT).show();
                    }
                });
         builder.create().show();
    }

    public void showSingleChoiceDialog(View view) {
        AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
        builder.setSingleChoiceItems(R.array.single_choice_array, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }
    public void showMultiChoiceDialog(View view) {
        AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
        builder.setMultiChoiceItems(R.array.single_choice_array, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

            }
        });
        builder.create().show();
    }
    public void showCustomDialog(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        // Get the layout inflater
        LayoutInflater inflater = MainActivity.this.getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.login_dialog, null))
                // Add action buttons
                .setPositiveButton("Sign in ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                })
               ;
         builder.create().show();
    }

    public void showHProgressDialog(View view)
    {

        final ProgressDialog dialog = new ProgressDialog(MainActivity.this);
        dialog.setMax(200);
        dialog.setTitle("Dialog Title");
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

        // Update the progress bar
        Handler handler = new Handler();
        handler.post(new Runnable() {
            public void run() {
                dialog.setProgress(150);
            }
        });

    dialog.show();

    }

    public void showVProgressDialog(View view)
    {   ProgressDialog dialog=new ProgressDialog(MainActivity.this);
        dialog.setTitle("Dialog Title");
        dialog.setMessage("Please wait while we process");

        dialog.show();

    }

/** Recomended Way to do  ***/
    public void showDatePickerDialogFragment(View view) {
        DatePickerFragment datePicker = new DatePickerFragment();
        datePicker.setCallBack(this);
        datePicker.show(MainActivity.this.getFragmentManager(), "Date Picker");

    }
/**  Recomended Way to do ***/
    public void showTimePickerDialogFragment(View view) {

        TimePickerFragment timePicker = new TimePickerFragment();
        timePicker.setCallBack(this);
        timePicker.show(MainActivity.this.getFragmentManager(), "Time Picker");
    }

    public void showTimePickerDialog(View view) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        Dialog timePickerDialog= new TimePickerDialog(MainActivity.this, this, hour, minute,
                DateFormat.is24HourFormat(MainActivity.this));
        timePickerDialog.show();
    }

    public void showDatePickerDialog(View view) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        Dialog datePickerDialog= new DatePickerDialog(MainActivity.this, this, year, month, day);
        datePickerDialog.show();
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        // Do something with the date chosen by the user
        Context context = getApplicationContext();
        CharSequence text = "Time Selected! "+hourOfDay+" : "+minute;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        // Do something with the date chosen by the user
        Context context = getApplicationContext();
        CharSequence text = "Date Selected! Year="+year+" month"+month+" day"+dayOfMonth;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }


}
