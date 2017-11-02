package ambe.com.vn.hanoi.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.StringRequest;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import ambe.com.vn.hanoi.R;
import ambe.com.vn.hanoi.models.weather.ListItem;
import ambe.com.vn.hanoi.models.weather.WeatherJson;
import ambe.com.vn.hanoi.utils.ConvertDateToDay;

/**
 * Created by AMBE on 17/10/2017.
 */

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ItemViewHolder> {

    private ArrayList<ListItem> arrayList;
    private Context context;

    public WeatherAdapter(ArrayList<ListItem> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_thoi_tiet, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        ListItem listItem = arrayList.get(position);
        ItemViewHolder itemViewHolder = holder;
        NumberFormat format = new DecimalFormat("#0");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        String idIcon = listItem.getWeather().get(0).getIcon();
        String urlIcon = "http://openweathermap.org/img/w/" + idIcon + ".png";

        String maxtemp = format.format(listItem.getTemp().getMax() - 273.15) + " °C";
        String mintemp = format.format(listItem.getTemp().getMin() - 273.15);

        Date date = new Date(listItem.getDt() * 1000);
        String day = sdf.format(date);
        String[] x = day.split("/");
        int ngay = Integer.parseInt(x[0]);
        int thang = Integer.parseInt(x[1]);
        int nam = Integer.parseInt(x[2]);

        ConvertDateToDay convertDateToDay = new ConvertDateToDay();

        String dayOfWeek = convertDateToDay.convert(ngay, thang, nam);


        Picasso.with(context).load(urlIcon)
                .error(R.drawable.no_image)
                .into(itemViewHolder.imgIcon);

        itemViewHolder.txtNhietDo.setText(mintemp + " - " + maxtemp);

        itemViewHolder.txtNgay.setText(dayOfWeek);
        ListItem test = arrayList.get(3);
        ListItem t=arrayList.get(4);
        Date date1=new Date(test.getDt()*1000);
        Date date2 = new Date(test.getDt()*1000);

        Log.d("TT",  sdf.format(date1)+" - "+sdf.format(date2));


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView txtNgay;
        private TextView txtNhietDo;
        private ImageView imgIcon;

        public ItemViewHolder(View itemView) {
            super(itemView);

            txtNgay = itemView.findViewById(R.id.txt_custom_ngay);
            txtNhietDo = itemView.findViewById(R.id.txt_custom_nhiet_do);
            imgIcon = itemView.findViewById(R.id.img_custom_thoi_tiet);
        }
    }
}
