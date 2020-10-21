package cn.xfn.recyclerviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context context;
    private List<MyEntity> myEntityList;
    public OnItemClickListener onItemClickListener;

    public MyAdapter(Context context, List<MyEntity> myEntityList) {
        this.context = context;
        this.myEntityList = myEntityList;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, final int position) {
        holder.item_img.setImageResource(myEntityList.get(position).getImgResource());
        holder.item_title.setText(myEntityList.get(position).getTitle());
        holder.item_content.setText(myEntityList.get(position).getContent());
        if (!myEntityList.get(position).isClick()) {
            holder.item_islike.setImageResource(R.drawable.dislike);
        } else {
            holder.item_islike.setImageResource(R.drawable.like);
        }
        holder.item_islike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return myEntityList == null ? 0 : myEntityList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView item_img;
        public TextView item_title;
        public TextView item_content;
        public ImageView item_islike;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_img = itemView.findViewById(R.id.item_img);
            item_title = itemView.findViewById(R.id.item_title);
            item_content = itemView.findViewById(R.id.item_content);
            item_islike = itemView.findViewById(R.id.item_islike);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setMyEntityList(List<MyEntity> myEntityList) {
        this.myEntityList = myEntityList;
        notifyDataSetChanged();
    }

}
