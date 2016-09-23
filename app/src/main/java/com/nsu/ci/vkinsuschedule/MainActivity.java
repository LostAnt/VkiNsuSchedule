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
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.nsu.ci.vkinsuschedule.dto.ScheduleDTO;

import java.util.List;

/**
 * Created by Andrew on 10.09.2016.
 */
public class MainActivity extends AbstractSignature
{

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;

    private List<ScheduleDTO> data;

    private CardListFragment fragment = new CardListFragment();

    @Override
    protected Fragment createFragment() {
        return CardListFragment.getInstance(fragment.createMockScheduleListData());
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        initToolbar();
        initNavigationView();

        RecyclerView rv = (RecyclerView)findViewById(R.id.recycler_view);
        rv.setLayoutManager(new LinearLayoutManager(this));
        ScheduleListAdapter adapter = new ScheduleListAdapter(fragment.createMockScheduleListData());
        rv.setAdapter(adapter);
    }

    @SuppressWarnings("deprecation")
    private void initNavigationView() {
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toogle =
                new ActionBarDrawerToggle(this,
                        drawerLayout,
                        toolbar,
                        R.string.view_navigation_open,
                        R.string.view_navigation_close);
        drawerLayout.setDrawerListener(toogle);
        toogle.syncState();

        NavigationView navigationView = (NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }


    private void initToolbar() {
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Расписание");
    }
}
