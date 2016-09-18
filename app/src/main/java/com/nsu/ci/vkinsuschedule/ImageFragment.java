package com.nsu.ci.vkinsuschedule;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by Andrew on 24.06.2016.
 */
public class ImageFragment extends Fragment {
    private static final String TAG = "schedile.ImageFragment";
    private static final String DAY_EXTRA = "com.nsu.nsu_schedule.day_of_week";
    private ImageView schedulePicture;
    private int day_of_week;
    private Callbacks callbacks;

    public interface Callbacks {
        void OnCloseButtonPressed();
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

        View v = inflater.inflate(R.layout.image_fragment, container, false);


        ImageButton closeButton = (ImageButton)v.findViewById(R.id.close_button);
        closeButton.setImageResource(android.R.drawable.ic_menu_close_clear_cancel);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Pressed");
                callbacks.OnCloseButtonPressed();
            }
        });

        schedulePicture = (ImageView)v.findViewById(R.id.schedule_picture);
        day_of_week = getArguments().getInt(DAY_EXTRA, 1);
        String imageName = "sh_" + day_of_week;
        int idImage = getResources().getIdentifier(imageName, "drawable", getActivity().getPackageName());

        schedulePicture.setImageResource(idImage);

        return v;
    }

    public static ImageFragment newInstance(int day) {

        Bundle args = new Bundle();
        args.putInt(DAY_EXTRA, day);

        ImageFragment fragment = new ImageFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
