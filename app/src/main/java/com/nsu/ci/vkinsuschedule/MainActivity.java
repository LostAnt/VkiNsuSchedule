package com.nsu.ci.vkinsuschedule;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by Andrew on 10.09.2016.
 */
public class MainActivity extends AppCompatActivity implements
        ButtonsFragment.Callbacks
        ,ImageFragment.Callbacks {

    private Toolbar toolbar;

    @Override
    public void OnCloseButtonPressed() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment infoFragment = fm.findFragmentById(R.id.infoFragmentContainer);
        infoFragment = new InfoFragment();
        fm.beginTransaction()
                .remove(fm.findFragmentById(R.id.infoFragmentContainer))
                .add(R.id.infoFragmentContainer, infoFragment)
                .commit();
    }

    @Override
    public void OnButtonPressed(int number) {
        FragmentManager fm = getSupportFragmentManager();
        Fragment imageFragment = fm.findFragmentById(R.id.infoFragmentContainer);
        imageFragment = ImageFragment.newInstance(number);

        fm.beginTransaction()
                .remove(fm.findFragmentById(R.id.infoFragmentContainer))
                .add(R.id.infoFragmentContainer, imageFragment)
                .commit();

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        initToolbar();
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment infoFragment = fragmentManager.findFragmentById(R.id.infoFragmentContainer);
        Fragment buttonsFragment = fragmentManager.findFragmentById(R.id.buttonsFragmentContainer);

        if (infoFragment == null) {
            infoFragment = new InfoFragment();
            buttonsFragment = new ButtonsFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.infoFragmentContainer, infoFragment)
                    .add(R.id.buttonsFragmentContainer, buttonsFragment)
                    .commit();
        }
    }

    private void initToolbar() {
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
    }
}
