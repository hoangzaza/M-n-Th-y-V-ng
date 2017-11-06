package ambe.com.vn.hanoi.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import ambe.com.vn.hanoi.R;
import ambe.com.vn.hanoi.activities.DetailActivity;
import ambe.com.vn.hanoi.models.inhanoi.Place;

/**
 * Created by AMBE on 16/10/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ItemViewHolder> {

    private ArrayList<Place> arrayList;
    private Context context;

    public MyAdapter(ArrayList<Place> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_view, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {


        Place place = arrayList.get(position);
        ItemViewHolder viewHolder = holder;
        viewHolder.txtName.setText(place.getName());
        viewHolder.txtType.setText(place.getType());
        viewHolder.txtKhoangCach.setText(place.getDistance() + " km");
        viewHolder.txtSlComent.setText(place.getRates().size() + " đánh giá.");
        float rate = 0;
        float sumRate = 0;
        for (int i = 0; i < place.getRates().size(); i++) {
            sumRate += place.getRates().get(i).getRating();
        }

        rate = sumRate / place.getRates().size();
        viewHolder.ratingBar.setRating(rate);

        Picasso.with(context)
                .load(place.getImages().get(0).getUrl())
                .error(R.drawable.no_image)
                .into(viewHolder.imgAvatar);


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgAvatar;
        private RatingBar ratingBar;
        private TextView txtSlComent;
        private TextView txtType;
        private TextView txtKhoangCach;
        private TextView txtName;

        public ItemViewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txt_custom_name);
            imgAvatar = itemView.findViewById(R.id.img_custom_avatar);
            ratingBar = itemView.findViewById(R.id.rate_bar_custom);
            txtSlComent = itemView.findViewById(R.id.txt_custom_sl_danh_gia);
            txtType = itemView.findViewById(R.id.txt_custom_the_loai);
            txtKhoangCach = itemView.findViewById(R.id.txt_custom_khoang_cach);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, DetailActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("ITEM", arrayList.get(getPosition()));
                    intent.putExtra("111", bundle);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    context.startActivity(intent);

                }
            });

        }
    }
}
