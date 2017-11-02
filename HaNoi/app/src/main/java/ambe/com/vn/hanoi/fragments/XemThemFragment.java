package ambe.com.vn.hanoi.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ambe.com.vn.hanoi.R;
import ambe.com.vn.hanoi.adapters.TienIchAdpater;
import ambe.com.vn.hanoi.models.others.TienIch;


/**
 * A simple {@link Fragment} subclass.
 */
public class XemThemFragment extends Fragment {

    private View view;
    private RecyclerView rcvTienIch;
    private ArrayList<TienIch> arrTienIch;
    private TienIchAdpater adpater;





    public XemThemFragment() {
        // Required empty public constructor
    }

    public static XemThemFragment newInstance(){
        XemThemFragment xemThemFragment=new XemThemFragment();
        return xemThemFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_xem_them, container, false);
        return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        rcvTienIch=view.findViewById(R.id.rcv_tien_ich);
        GridLayoutManager grid=new GridLayoutManager(getActivity(),3);
        grid.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTienIch.setLayoutManager(grid);
        arrTienIch=new ArrayList<>();

        arrTienIch.add(new TienIch(R.drawable.atm,"ATM"));
        arrTienIch.add(new TienIch(R.drawable.hospital,"Bệnh viện"));
        arrTienIch.add(new TienIch(R.drawable.parking,"Bãi đỗ xe"));
        arrTienIch.add(new TienIch(R.drawable.bus,"Bến xe"));
        arrTienIch.add(new TienIch(R.drawable.bank,"Ngân hàng"));



        adpater=new TienIchAdpater(getActivity(),arrTienIch);
        rcvTienIch.setAdapter(adpater);


    }
}
