package ambe.com.vn.hanoi.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import ambe.com.vn.hanoi.R;
import ambe.com.vn.hanoi.models.inhanoi.Image;

/**
 * Created by AMBE on 16/10/2017.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ItemViewHolder> {

    private ArrayList<Image> arrayList;
    private Context context;

    public ImageAdapter(ArrayList<Image> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_image_view, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {

        Image image = arrayList.get(position);
        Picasso.with(context).load(image.getUrl())
                .error(R.drawable.no_image)
                .into(holder.imgView);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            imgView = itemView.findViewById(R.id.img_custom_img_view);
        }
    }
}
