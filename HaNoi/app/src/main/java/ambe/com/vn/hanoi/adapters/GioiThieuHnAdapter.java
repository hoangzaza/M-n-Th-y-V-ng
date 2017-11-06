package ambe.com.vn.hanoi.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import ambe.com.vn.hanoi.R;
import ambe.com.vn.hanoi.activities.ChiTietGtHaNoiActivity;
import ambe.com.vn.hanoi.models.inhanoi.GioiThieuHn;

/**
 * Created by AMBE on 04/11/2017.
 */

public class GioiThieuHnAdapter extends RecyclerView.Adapter<GioiThieuHnAdapter.ItemViewHolder> {

    private Context context;
    private ArrayList<GioiThieuHn> arrayList;
    private GioiThieuHn gioiThieuHn;

    public GioiThieuHnAdapter(Context context, ArrayList<GioiThieuHn> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_view_gioi_thieu_ha_noi, parent, false);
        ItemViewHolder viewHolder = new ItemViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {


        gioiThieuHn = arrayList.get(position);
        holder.txtName.setText(gioiThieuHn.getTxtName());
        Picasso.with(context).load(gioiThieuHn.getUrlImage())
                .error(R.drawable.no_image)
                .into(holder.imgView);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView txtName;
        private ImageView imgView;


        public ItemViewHolder(View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txt_custom_view_name_gt_hn);
            imgView = itemView.findViewById(R.id.img_custom_view_gt_hn);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(context, ChiTietGtHaNoiActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("GT",arrayList.get(getPosition()));
                    intent.putExtra("BGT",bundle);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);

                }
            });
        }
    }
}
