package ambe.com.vn.hanoi.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

import ambe.com.vn.hanoi.R;
import ambe.com.vn.hanoi.adapters.GioiThieuHnAdapter;
import ambe.com.vn.hanoi.models.inhanoi.GioiThieuHn;

public class GioiThieuHaNoiActivity extends AppCompatActivity {
    private RecyclerView rcvTongQuan;
    private RecyclerView rcvCamNang;
    private Toolbar toolbar;
    private ArrayList<GioiThieuHn> arrCamNang;
    private ArrayList<GioiThieuHn> arrTongQuan;
    private GioiThieuHnAdapter adapterTongQuan;
    private GioiThieuHnAdapter adapterCamNang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gioi_thieu_ha_noi);
        addControls();
        addEvents();
    }

    private void addEvents() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void addControls() {

        toolbar = findViewById(R.id.tb_test);
        rcvCamNang = findViewById(R.id.rcv_cam_nang_du_lich);
        rcvTongQuan = findViewById(R.id.rcv_tong_quan_ve_ha_noi);

        GridLayoutManager gr=new GridLayoutManager(this,1);
        gr.setOrientation(LinearLayoutManager.HORIZONTAL);


        GridLayoutManager gr1=new GridLayoutManager(this,2);
        gr.setOrientation(LinearLayoutManager.HORIZONTAL);


        rcvTongQuan.setLayoutManager(gr);
        rcvCamNang.setLayoutManager(gr1);


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Giới thiệu Hà Nội quyến rũ");

        arrTongQuan=new ArrayList<>();
        arrTongQuan.add(new GioiThieuHn("Lịch sử","http://media.tinmoi.vn/2011/12/09/62_22_1323448595_87_nhahatlon_anhbac.jpg","lich_su"));
        arrTongQuan.add(new GioiThieuHn("Phong tục","https://cdn3.ivivu.com/2013/10/Ha-Noi-mua-thu.jpg","phong_tuc"));
        arrTongQuan.add(new GioiThieuHn("Văn hóa","http://everesttravel.vn/Upload/News/du-lich-ha-noi.png","van_hoa"));

        adapterTongQuan=new GioiThieuHnAdapter(this,arrTongQuan);
        rcvTongQuan.setAdapter(adapterTongQuan);

        arrCamNang=new ArrayList<>();
        arrCamNang.add(new GioiThieuHn("Cẩm nang du lịch Hà Nội: Từ A đến Z","https://cdn3.ivivu.com/2013/10/ha-noi6.jpg","cam_nang"));
        arrCamNang.add(new GioiThieuHn("Nghe 6 nhiếp ảnh nổi tiếng hướng dẫn cách chụp ảnh Hà Nội sao cho đẹp!","http://vivuhanoi.com/wp-content/uploads/2016/04/pho-co-ha-noi-nay.jpg","chup_anh"));
        arrCamNang.add(new GioiThieuHn("Những đường cong hút hồn ở chùa Tây Phương","https://static.mytour.vn/upload_images/Image/Ninh/List%206/32%20Ch%C3%B9a%20T%C3%A2y%20Ph%C6%B0%C6%A1ng/39375396.jpg", "chua_tay_phuong"));
        arrCamNang.add(new GioiThieuHn("10 món ngon Hà Nội cho người sành ăn","http://gomsu.divashop.vn/wp-content/uploads/2016/06/photo-3-1464080379575.jpg","mon_ngon"));
        arrCamNang.add(new GioiThieuHn("Hấp dẫn món ăn vặt vỉa hè Hà Nội","https://dantricdn.com/thumb_w/640/2016/anh-1-1481848391685.jpg","an_vat"));


        adapterCamNang=new GioiThieuHnAdapter(this,arrCamNang);
        rcvCamNang.setAdapter(adapterCamNang);


    }
}
