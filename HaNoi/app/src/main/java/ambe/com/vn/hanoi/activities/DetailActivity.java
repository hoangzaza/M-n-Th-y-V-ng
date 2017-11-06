package ambe.com.vn.hanoi.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import ambe.com.vn.hanoi.R;

public class DetailActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private ImageView imgToolbar;
    private LinearLayout lnlLienHe;
    private LinearLayout lnlThich;
    private LinearLayout lnlDanhGia;
    private LinearLayout lnlLuuLai;
    private TextView txtTheLoai;
    private RatingBar ratingBar;
    private TextView txtSoLuongDanhGia;
    private TextView txtWeb;
    private TextView txtEmail;
    private TextView txtDiaChi;
    private TextView txtXemThem;
    private TextView txtTongQuan;
    private ListView listDanhGia;
    private RecyclerView rcvAnhDep;
    private RecyclerView rcvDiaDiemGanDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
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
        toolbar = findViewById(R.id.toolbar);
        imgToolbar = findViewById(R.id.img_detail);
        lnlLienHe = findViewById(R.id.lnl_lien_he);
        lnlThich = findViewById(R.id.lnl_thich);
        lnlDanhGia = findViewById(R.id.lnl_danh_gia);
        lnlLuuLai = findViewById(R.id.lnl_luu_lai);

        txtTheLoai = findViewById(R.id.txt_the_loai);
        ratingBar = findViewById(R.id.rate_bar_detail);
        txtSoLuongDanhGia = findViewById(R.id.txt_sl_danh_gia_detail);
        txtWeb = findViewById(R.id.txt_trang_web);
        txtEmail = findViewById(R.id.txt_email);
        txtDiaChi = findViewById(R.id.txt_dia_chi);
        txtXemThem = findViewById(R.id.txt_xem_them_activity_detail);
        txtTongQuan = findViewById(R.id.txt_tong_quan);
        listDanhGia = findViewById(R.id.list_danh_gia);
        rcvAnhDep = findViewById(R.id.rcv_anh_dep);
        rcvDiaDiemGanDay = findViewById(R.id.rcv_dia_diem_gan_day);


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}
