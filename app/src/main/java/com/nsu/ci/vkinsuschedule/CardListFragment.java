package com.nsu.ci.vkinsuschedule;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nsu.ci.vkinsuschedule.dto.ScheduleDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrew on 22.09.2016.
 */
public class CardListFragment extends Fragment {

    private List<ScheduleDTO> data;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_activity, container, false);

        return v;
    }
////MOCK
    public List<ScheduleDTO> createMockScheduleListData() {
        List<ScheduleDTO> data = new ArrayList<>();
        data.add(new ScheduleDTO("102 каб.", "Элементы высшей математики", "Викентьев А.А."));
        data.add(new ScheduleDTO("102 каб.", "Элементы высшей математики", "Викентьев А.А."));
        data.add(new ScheduleDTO("102 каб.", "Элементы высшей математики", "Викентьев А.А."));
        data.add(new ScheduleDTO("102 каб.", "Элементы высшей математики", "Викентьев А.А."));
        data.add(new ScheduleDTO("102 каб.", "Элементы высшей математики", "Викентьев А.А."));
        return data;
    }
////MOCK
    public static CardListFragment getInstance(List<ScheduleDTO> data) {
        CardListFragment fragment = new CardListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        fragment.setData(data);
        return fragment;
    }

    public void setData(List<ScheduleDTO> data) {
        this.data = data;
    }
}
