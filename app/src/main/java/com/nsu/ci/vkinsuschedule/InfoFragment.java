package com.nsu.ci.vkinsuschedule;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Andrew on 24.06.2016.
 */
public class InfoFragment extends Fragment {
    private TextView dateView;
    private TextView typeOfWeekView;
    private Date date;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.info_fragment, container, false);

        dateView = (TextView)v.findViewById(R.id.date_view);
        date = new Date();
        android.text.format.DateFormat dateFormat = new android.text.format.DateFormat();
        dateView.setText(dateFormat.format("yyyy-MM-dd", date));

        typeOfWeekView = (TextView)v.findViewById(R.id.typeOfWeek);
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        typeOfWeekView.setText("Числитель");
        if (((day / 7) % 2) == 1 ) typeOfWeekView.setText("Знаменатель");

        return v;
    }
}
