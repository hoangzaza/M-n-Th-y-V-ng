package ambe.com.vn.hanoi.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

import ambe.com.vn.hanoi.R;
import ambe.com.vn.hanoi.models.inhanoi.GioiThieuHn;

public class ChiTietGtHaNoiActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private WebView webView;
    private GioiThieuHn gioiThieuHn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_gt_ha_noi);
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
        toolbar = findViewById(R.id.tb_chi_tiet_gt_hn);
        webView = findViewById(R.id.web_view);


        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("BGT");
        if (bundle != null) {
            gioiThieuHn = (GioiThieuHn) bundle.getSerializable("GT");
        }

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(gioiThieuHn.getTxtName());


        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        String txtContent=gioiThieuHn.getUrlContent();
        String url="file:///android_asset/"+txtContent+".html";
        webView.loadUrl(url);

    }
}
