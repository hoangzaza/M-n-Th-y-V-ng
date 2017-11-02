package ambe.com.vn.hanoi.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ambe.com.vn.hanoi.R;
import ambe.com.vn.hanoi.models.others.TienIch;

/**
 * Created by AMBE on 02/11/2017.
 */

public class TienIchAdpater extends RecyclerView.Adapter<TienIchAdpater.ItemViewHolder> {

    private Context context;
    private ArrayList<TienIch> arrayList;

    public TienIchAdpater(Context context, ArrayList<TienIch> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_rcv_tien_ich, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {

        TienIch tienIch = arrayList.get(position);
        ItemViewHolder viewHolder = holder;
        viewHolder.imageView.setImageResource(tienIch.getIdImage());
        viewHolder.textView.setText(tienIch.getName()+"");

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;

        public ItemViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.img_custom_tien_ich);
            textView = itemView.findViewById(R.id.txt_name_custom_tien_ich);
        }
    }
}
