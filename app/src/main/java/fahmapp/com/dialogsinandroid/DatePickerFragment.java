package fahmapp.com.dialogsinandroid;

/**
 * Created by FahmApps.com on 26-09-2016.
 */

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment {
    private DatePickerDialog.OnDateSetListener ondateSet;
    private DatePickerDialog datePickerDialog;
    final Calendar c = Calendar.getInstance();

    private int year = c.get(Calendar.YEAR);
    private int month = c.get(Calendar.MONTH);
    private int day = c.get(Calendar.DAY_OF_MONTH);

    private String mTitle ="Select Date";
    public DatePickerDialog.OnDateSetListener getDateSetListener() {
        return ondateSet;
    }

    public void setDateSetListener(DatePickerDialog.OnDateSetListener dateSetListener) {
        this.ondateSet = dateSetListener;
    }

    public DatePickerFragment()
    { }

    public void setCallBack(DatePickerDialog.OnDateSetListener ondate) {
        ondateSet = ondate;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        //Use the current date as the default date in the date picker
        datePickerDialog = new DatePickerDialog(getActivity(),ondateSet,year,month,day);
        datePickerDialog.setTitle(mTitle);
        return datePickerDialog; //Return the DatePickerDialog in app window
    }


}