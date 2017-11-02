package ambe.com.vn.hanoi.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;

import ambe.com.vn.hanoi.R;
import ambe.com.vn.hanoi.adapters.WeatherAdapter;
import ambe.com.vn.hanoi.models.weather.ListItem;
import ambe.com.vn.hanoi.models.weather.WeatherJson;


/**
 * A simple {@link Fragment} subclass.
 */
public class DiemDenFragment extends Fragment {

    private View view;
    private RecyclerView rcvThoiTiet;
    private ArrayList<ListItem> arrayList;
    private WeatherAdapter adapter;


    public DiemDenFragment() {
        // Required empty public constructor
    }

    public static DiemDenFragment newInstance(){
        DiemDenFragment diemDenFragment=new DiemDenFragment();
        return diemDenFragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_diem_den, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        rcvThoiTiet=view.findViewById(R.id.rcv_thoi_tiet_test);

        GridLayoutManager manager=new GridLayoutManager(getActivity(),1);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rcvThoiTiet.setLayoutManager(manager);

        arrayList=new ArrayList<>();
        adapter=new WeatherAdapter(arrayList,getActivity());
        rcvThoiTiet.setAdapter(adapter);

        loadWether();


    }

    private void loadWether() {

        String url="http://api.openweathermap.org/data/2.5/forecast/daily?q=H%C3%A0%20N%E1%BB%99i&cnt=7&appid=fd5108f8d06956d7fd051970aee763b8";
        RequestQueue requestQueue= Volley.newRequestQueue(getActivity());
        StringRequest stringRequest= new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response != null){
                    WeatherJson weatherJson=new Gson().fromJson(response,WeatherJson.class);
                    arrayList.addAll(weatherJson.getList());
                    Log.d("LOI",arrayList.get(0).getWeather().get(0).getIcon());
                    adapter.notifyDataSetChanged();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.d("LOI",error.getMessage());

            }
        });

        requestQueue.add(stringRequest);

    }

}
