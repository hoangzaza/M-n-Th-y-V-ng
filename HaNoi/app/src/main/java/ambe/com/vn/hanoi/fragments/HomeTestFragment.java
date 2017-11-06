package ambe.com.vn.hanoi.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ecloud.pulltozoomview.PullToZoomScrollViewEx;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import ambe.com.vn.hanoi.R;
import ambe.com.vn.hanoi.activities.GioiThieuHaNoiActivity;
import ambe.com.vn.hanoi.adapters.ImageAdapter;
import ambe.com.vn.hanoi.adapters.MyAdapter;
import ambe.com.vn.hanoi.adapters.WeatherAdapter;
import ambe.com.vn.hanoi.models.inhanoi.Image;
import ambe.com.vn.hanoi.models.inhanoi.Place;
import ambe.com.vn.hanoi.models.inhanoi.Rate;
import ambe.com.vn.hanoi.models.inhanoi.User;
import ambe.com.vn.hanoi.models.weather.ListItem;
import ambe.com.vn.hanoi.models.weather.WeatherJson;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeTestFragment extends Fragment implements View.OnClickListener {

    private NumberFormat format = new DecimalFormat("#0");


    private PullToZoomScrollViewEx zoomScrollViewEx;
    private View view;
    private View zoomView;
    private View contentView;
    private TextView txtXemTatCaGoiY;
    private TextView txtXemTatCaKhachSan;
    private TextView txtXemTatMuaSam;
    private TextView txtXemThemRed;
    private TextView txtXemThemBlack;
    private TextView txtGioiThieuHn;
    private RecyclerView rcvGoiY;
    private RecyclerView rcvKhachSan;
    private RecyclerView rcvMuaSam;
    private RecyclerView rcvGioiThieuHn;
    private RecyclerView rcvThoiTiet;
    private MyAdapter myAdapter;
    private MyAdapter myAdapter1;
    private MyAdapter myAdapter2;
    private ImageAdapter imageAdapter;

    private ImageView imgIconThoiTiet;
    private TextView txtNhietDo;
    private TextView txtMoTaThoiTiet;

    private ArrayList<ListItem> arrListItem;
    private WeatherAdapter weatherAdapter;

    public HomeTestFragment() {
        // Required empty public constructor
    }

    public static HomeTestFragment newInstance() {
        HomeTestFragment homeTestFragment = new HomeTestFragment();
        return homeTestFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home_test, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        addControls();
        loadWether();
        addEvents();

    }

    private void showTemp() {
        NumberFormat format = new DecimalFormat("#0");
        String temp = format.format(arrListItem.get(0).getTemp().getEve() - 273.15) + " °C";

        String idIcon = arrListItem.get(0).getWeather().get(0).getIcon();
        String urlIcon = "http://openweathermap.org/img/w/" + idIcon + ".png";

        txtNhietDo.setText(temp);

        Picasso.with(getActivity()).load(urlIcon)
                .error(R.drawable.no_image)
                .into(imgIconThoiTiet);

        String detail = arrListItem.get(0).getWeather().get(0).getDescription();
        txtMoTaThoiTiet.setText(detail);


    }

    private void addEvents() {


        txtXemThemBlack.setOnClickListener(this);
        txtGioiThieuHn.post(new Runnable() {
            @Override
            public void run() {
                final int x = txtGioiThieuHn.getLineCount();
                txtGioiThieuHn.setMaxLines(2);
                txtXemThemRed.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (txtXemThemRed.getText().equals("Xem thêm")) {
                            txtGioiThieuHn.setMaxLines(x);
                            txtXemThemRed.setText(getActivity().getResources().getString(R.string.thu_gon));
                        } else {
                            txtGioiThieuHn.setMaxLines(2);
                            txtXemThemRed.setText(getActivity().getResources().getString(R.string.xem_them));

                        }

                    }
                });
            }
        });

    }

    private void loadWether() {

        String url = "http://api.openweathermap.org/data/2.5/forecast/daily?q=Hà Nội Việt Nam&cnt=7&appid=fd5108f8d06956d7fd051970aee763b8";
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response != null) {
                    WeatherJson weatherJson = new Gson().fromJson(response, WeatherJson.class);
                    arrListItem.addAll(weatherJson.getList());
                    showTemp();
                    weatherAdapter.notifyDataSetChanged();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.d("LOI", error.getMessage());

            }
        });

        requestQueue.add(stringRequest);

    }

    private void addControls() {
        zoomScrollViewEx = view.findViewById(R.id.pull_zoom_view);
        zoomView = LayoutInflater.from(getActivity()).inflate(R.layout.image_zoom_view, null, false);
        contentView = LayoutInflater.from(getActivity()).inflate(R.layout.content_zoom_view, null, false);

        txtXemTatCaGoiY = contentView.findViewById(R.id.txt_xem_tat_ca_goi_y);
        txtGioiThieuHn = contentView.findViewById(R.id.txt_gioi_thieu_tong_quan_ve_ha_noi);
        txtXemTatCaKhachSan = contentView.findViewById(R.id.txt_xem_tat_ca_khach_san);
        txtXemTatMuaSam = contentView.findViewById(R.id.txt_xem_tat_ca_mua_sam);
        txtXemThemBlack = contentView.findViewById(R.id.txt_xem_them_black);
        txtXemThemRed = contentView.findViewById(R.id.txt_xem_them_red);
        txtMoTaThoiTiet = zoomView.findViewById(R.id.txt_mo_ta_thoi_tiet);
        txtNhietDo = zoomView.findViewById(R.id.txt_nhiet_do_image);

        imgIconThoiTiet = zoomView.findViewById(R.id.img_icon_thoi_tiet);

        rcvGoiY = contentView.findViewById(R.id.rcv_goi_y);
        rcvKhachSan = contentView.findViewById(R.id.rcv_khạch_san);
        rcvMuaSam = contentView.findViewById(R.id.rcv_mua_sam);
        rcvGioiThieuHn = contentView.findViewById(R.id.rcv_tim_hieu_ve_ha_noi);
        rcvThoiTiet = contentView.findViewById(R.id.rcv_thoi_tiet);


        rcvGoiY.setHasFixedSize(true);
        rcvKhachSan.setHasFixedSize(true);
        rcvMuaSam.setHasFixedSize(true);
        rcvGioiThieuHn.setHasFixedSize(true);
        rcvThoiTiet.setHasFixedSize(true);

        GridLayoutManager gridGoiY = new GridLayoutManager(getActivity(), 1);
        gridGoiY.setOrientation(LinearLayoutManager.HORIZONTAL);

        GridLayoutManager gridGoiY1 = new GridLayoutManager(getActivity(), 1);
        gridGoiY1.setOrientation(LinearLayoutManager.HORIZONTAL);

        GridLayoutManager gridGoiY2 = new GridLayoutManager(getActivity(), 1);
        gridGoiY2.setOrientation(LinearLayoutManager.HORIZONTAL);

        GridLayoutManager gridGoiY3 = new GridLayoutManager(getActivity(), 1);
        gridGoiY3.setOrientation(LinearLayoutManager.HORIZONTAL);

        rcvGoiY.setLayoutManager(gridGoiY);
        rcvMuaSam.setLayoutManager(gridGoiY1);
        rcvThoiTiet.setLayoutManager(gridGoiY2);
        rcvKhachSan.setLayoutManager(gridGoiY3);

        GridLayoutManager gridGtHaNoi = new GridLayoutManager(getActivity(), 2);
        gridGtHaNoi.setOrientation(LinearLayoutManager.HORIZONTAL);
        rcvGioiThieuHn.setLayoutManager(gridGtHaNoi);

        arrListItem = new ArrayList<ListItem>();


        ArrayList<Image> images = new ArrayList<Image>();
        images.add(new Image("1", "https://cdn3.ivivu.com/2017/10/quan-bun-rieu-sang-chanh-ben-hong-cho-ben-thanh-ivivu-1-370x215.jpg"));

        ArrayList<Image> arrImgKhachSans = new ArrayList<>();
        arrImgKhachSans.add(new Image("1", "https://lottecenter.com.vn/upload/MAINIMAGE/EN/MAINIMAGE_4.jpg"));

        ArrayList<Image> arrImgMuaSam = new ArrayList<>();
        arrImgMuaSam.add(new Image("1", "http://media.tiin.vn//archive/images/2016/12/20/103224_anh-2.jpg"));

        ArrayList<Image> arrImages = new ArrayList<>();
        arrImages.add(new Image("1", "https://baomoi-photo-2.zadn.vn/17/02/27/47/21622237/1_268390.jpg"));
        arrImages.add(new Image("8", "https://i.ytimg.com/vi/lW2akEzn4r8/maxresdefault.jpg"));
        arrImages.add(new Image("7", "http://cms.kienthuc.net.vn/zoom/1000/uploaded/ngoclinh/2017_01_22/tan-chay-truoc-bo-anh-dep-4-mua-o-ha-noi.jpg"));
        arrImages.add(new Image("2", "http://anh.24h.com.vn/upload/4-2012/images/2012-11-28/1354058896-dia-diem-chup-anh--10-.jpg"));
        arrImages.add(new Image("3", "http://hinhdep.com.vn/wp-content/uploads/2016/03/hinh-anh-dep-ve-chua-mot-cot-18.jpg"));
        arrImages.add(new Image("4", "http://media.thethaovanhoa.vn/2013/08/07/17/23/ganhhanghoa17.jpg"));
        arrImages.add(new Image("5", "https://znews-photo-td.zadn.vn/w1024/Uploaded/nokarz/2014_10_08/cau_vinh_tuy_anh_Xuan_Chinh.jpg"));
        arrImages.add(new Image("6", "http://cuocsongmuonmau.net/wp-content/uploads/2015/06/Ho%C3%A0ng-th%C3%A0nh-Th%C4%83ng-Long-m%E1%BB%99t-trong-%C4%91%E1%BB%8Ba-%C4%91i%E1%BB%83m-ch%E1%BB%A5p-%E1%BA%A3nh-%C4%91%E1%BA%B9p-%E1%BB%9F-H%C3%A0-N%E1%BB%99i-e1435636132708.jpg"));

        ArrayList<User> users = new ArrayList<>();
        ArrayList<Place> placeArrayList = new ArrayList<>();
        users.add(new User("qazqaz", "qazqaz", "Duong cuong", "duong", placeArrayList));
        users.add(new User("123", "qazqaz", "Duong cuong", "duong", placeArrayList));
        ArrayList<Rate> rates = new ArrayList<>();
        rates.add(new Rate("123", users.get(0), "Max hay", 3, "2017"));
        rates.add(new Rate("456", users.get(1), "Max hay", 4, "2017"));

        ArrayList<Place> places = new ArrayList<>();
        places.add(new Place("123", "Phở bát đàn", "Xã đàn", "Đồ ăn sáng", images, "max ngon", rates, "1", "2", "3", "4", "5"));
        places.add(new Place("123", "Phở bát đàn", "Xã đàn", "Đồ ăn sáng", images, "max ngon", rates, "1", "2", "3", "4", "5"));
        places.add(new Place("123", "Phở bát đàn", "Xã đàn", "Đồ ăn sáng", images, "max ngon", rates, "1", "2", "3", "4", "5"));
        places.add(new Place("123", "Phở bát đàn", "Xã đàn", "Đồ ăn sáng", images, "max ngon", rates, "1", "2", "3", "4", "5"));
        places.add(new Place("123", "Phở bát đàn", "Xã đàn", "Đồ ăn sáng", images, "max ngon", rates, "1", "2", "3", "4", "5"));

        ArrayList<Place> arrKhachSans = new ArrayList<>();
        arrKhachSans.add(new Place("123", "Lotte Center", "Liễu Giai", "Khách sạn", arrImgKhachSans, "max ngon", rates, "1", "2", "3", "4", "5"));
        arrKhachSans.add(new Place("123", "Lotte Center", "Liễu Giai", "Khách sạn", arrImgKhachSans, "max ngon", rates, "1", "2", "3", "4", "5"));
        arrKhachSans.add(new Place("123", "Lotte Center", "Liễu Giai", "Khách sạn", arrImgKhachSans, "max ngon", rates, "1", "2", "3", "4", "5"));
        arrKhachSans.add(new Place("123", "Lotte Center", "Liễu Giai", "Khách sạn", arrImgKhachSans, "max ngon", rates, "1", "2", "3", "4", "5"));
        arrKhachSans.add(new Place("123", "Lotte Center", "Liễu Giai", "Khách sạn", arrImgKhachSans, "max ngon", rates, "1", "2", "3", "4", "5"));


        ArrayList<Place> arrMuaSams = new ArrayList<>();
        arrMuaSams.add(new Place("123", "Tràng Tiền Plaza", "Hoàn Kiếm", "Trung tâm thương mại", arrImgMuaSam, "max ngon", rates, "1", "2", "3", "4", "5"));
        arrMuaSams.add(new Place("123", "Tràng Tiền Plaza", "Hoàn Kiếm", "Trung tâm thương mại", arrImgMuaSam, "max ngon", rates, "1", "2", "3", "4", "5"));
        arrMuaSams.add(new Place("123", "Tràng Tiền Plaza", "Hoàn Kiếm", "Trung tâm thương mại", arrImgMuaSam, "max ngon", rates, "1", "2", "3", "4", "5"));
        arrMuaSams.add(new Place("123", "Tràng Tiền Plaza", "Hoàn Kiếm", "Trung tâm thương mại", arrImgMuaSam, "max ngon", rates, "1", "2", "3", "4", "5"));
        arrMuaSams.add(new Place("123", "Tràng Tiền Plaza", "Hoàn Kiếm", "Trung tâm thương mại", arrImgMuaSam, "max ngon", rates, "1", "2", "3", "4", "5"));

        zoomScrollViewEx.setZoomView(zoomView);
        zoomScrollViewEx.setScrollContentView(contentView);

        myAdapter = new MyAdapter(places, getActivity());
        rcvGoiY.setAdapter(myAdapter);


        myAdapter1 = new MyAdapter(arrKhachSans, getActivity());
        rcvKhachSan.setAdapter(myAdapter1);

        myAdapter2 = new MyAdapter(arrMuaSams, getActivity());
        rcvMuaSam.setAdapter(myAdapter2);

        imageAdapter = new ImageAdapter(arrImages, getActivity());
        rcvGioiThieuHn.setAdapter(imageAdapter);

        weatherAdapter = new WeatherAdapter(arrListItem, getActivity());
        rcvThoiTiet.setAdapter(weatherAdapter);


        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        int mScreenHeight = localDisplayMetrics.heightPixels;
        int mScreenWidth = localDisplayMetrics.widthPixels;
        LinearLayout.LayoutParams localObject = new LinearLayout.LayoutParams(mScreenWidth, (int) (9.0F * (mScreenWidth / 16.0F)));
        zoomScrollViewEx.setHeaderLayoutParams(localObject);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.txt_xem_them_black:
                xuLyXemThemBlack();
                break;
        }
    }

    private void xuLyXemThemBlack() {
        Intent intent =new Intent(getActivity(), GioiThieuHaNoiActivity.class);
        startActivity(intent);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    }
}
