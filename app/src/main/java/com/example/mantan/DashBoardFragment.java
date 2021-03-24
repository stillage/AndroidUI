package com.example.mantan;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mantan.DRVinterface.LoadMore;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DashBoardFragment extends Fragment {

    private RecyclerView recyclerView;
    private StaticRvAdapter staticRvAdapter;
    List<DynamicRVModel> items = new ArrayList<>();
    ArrayList<StaticRvModel> item = new ArrayList<>();
    DynamicRVAdapter dynamicRVAdapter;
    ImageView Profil;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.dashboard_fragment, container, false);

        Profil = root.findViewById(R.id.profil);
        Profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToMain = new Intent(getActivity(), ProfilActivity.class);
                startActivity(intToMain);
            }
        });

        item.add(new StaticRvModel(R.drawable.ayamgeprek, "ayam geprek"));
        item.add(new StaticRvModel(R.drawable.miegoreng, "mie goreng"));
        item.add(new StaticRvModel(R.drawable.nasigoreng, "nasi goreng"));
        item.add(new StaticRvModel(R.drawable.kentanggoreng, "kentang goreng"));
        item.add(new StaticRvModel(R.drawable.siomay, "siomay"));
        item.add(new StaticRvModel(R.drawable.sosisbakar, "sosis bakar"));

        recyclerView = root.findViewById(R.id.rv_1);
        staticRvAdapter = new StaticRvAdapter(item);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(staticRvAdapter);

        items.add(new DynamicRVModel("jus Stroberi"));
        items.add(new DynamicRVModel("jus Stroberi"));
        items.add(new DynamicRVModel("jus Stroberi"));
        items.add(new DynamicRVModel("jus Stroberi"));
        items.add(new DynamicRVModel("jus Stroberi"));
        items.add(new DynamicRVModel("jus Stroberi"));
        items.add(new DynamicRVModel("jus Stroberi"));
        items.add(new DynamicRVModel("jus Stroberi"));
        items.add(new DynamicRVModel("jus Stroberi"));

        RecyclerView drv = root.findViewById(R.id.rv_2);
        drv.setLayoutManager(new LinearLayoutManager(getActivity()));
        dynamicRVAdapter = new DynamicRVAdapter(drv, getActivity(),items);
        drv.setAdapter(dynamicRVAdapter);

        dynamicRVAdapter.setLoadMore(new LoadMore() {
            @Override
            public void onLoadMore() {
                if (items.size()<=5){
                    item.add(null);
                    dynamicRVAdapter.notifyItemInserted(items.size()-1);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            items.remove(items.size()-1);
                            dynamicRVAdapter.notifyItemRemoved(items.size());
                            int index = items.size();
                            int end = index + 10;
                            for (int i = index; i < end; i++){
                                String name = UUID.randomUUID().toString();
                                DynamicRVModel item = new DynamicRVModel(name);
                                items.add(item);
                            }
                            dynamicRVAdapter.notifyDataSetChanged();
                            dynamicRVAdapter.setLoaded();
                        }
                    }, 4000);
                }
                else
                    Toast.makeText(getActivity(), "Telah Terbaca Semua", Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }
}
