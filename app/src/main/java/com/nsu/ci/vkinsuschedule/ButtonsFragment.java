package com.nsu.ci.vkinsuschedule;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;

/**
 * Created by Andrew on 24.06.2016.
 */
public class ButtonsFragment extends Fragment {
    private Callbacks callbacks;

    public interface Callbacks {
        void OnButtonPressed(int number);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        callbacks = (Callbacks)activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callbacks = null;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.buttons_fragment, container, false);

        View.OnClickListener buttonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int buttonId = v.getId();
                callbacks.OnButtonPressed(buttonId);
            }
        };


        TableLayout tableLayout = (TableLayout)v.findViewById(R.id.main_layout);
        int count;
        count = 1;
        for (int i = 0; i < tableLayout.getChildCount() - 1; i++) {
            TableRow tableRow = (TableRow)tableLayout.getChildAt(i);
            for (int j = 0; j <tableRow.getChildCount(); j++) {
                ImageButton imageButton = (ImageButton)tableRow.getChildAt(j);
                String imageName = "button_" + count;
                int resId = getResources().getIdentifier(imageName, "drawable", getActivity().getPackageName());
                imageButton.setBackgroundResource(resId);
                imageButton.setOnClickListener(buttonClickListener);
                imageButton.setId(count);
                count++;

            }

        }

        return v;
    }
}
