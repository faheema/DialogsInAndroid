package fahmapp.com.dialogsinandroid;

/**
 * Created by FahmApps.com on 26-09-2016.
 */

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment {
    private TimePickerDialog.OnTimeSetListener onTimeSet;
    private TimePickerDialog
            timePickerDialog;

    final Calendar c = Calendar.getInstance();
    int hour = c.get(Calendar.HOUR_OF_DAY);
    int minute = c.get(Calendar.MINUTE);

    private String mTitle ="Select Date";
    public TimePickerDialog.OnTimeSetListener getDateSetListener() {
        return onTimeSet;
    }

    public void setTimeSetListener(TimePickerDialog.OnTimeSetListener timeSetListener) {
        this.onTimeSet = timeSetListener;
    }

    public TimePickerFragment()
    { }

    public void setCallBack(TimePickerDialog.OnTimeSetListener onTime) {
        onTimeSet = onTime;
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
        timePickerDialog= new TimePickerDialog(getActivity(), onTimeSet, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
        timePickerDialog.setTitle(mTitle);
        return timePickerDialog; //Return the DatePickerDialog in app window
    }


}