package me.bello.recyclerempty;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * @Info 适配器
 * @Auth Bello
 * @Time 19-4-15 上午9:43
 * @Ver
 */
public class MyAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private ArrayList<MyData> mList;

    // 有数据的type
    private static final int TYPE_ITEM = 1;
    // 空数据的type
    private static final int TYPE_EMPTY = 0;

    public MyAdapter(ArrayList<MyData> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        mContext = viewGroup.getContext();
        // 判断是否空值
        if (i == TYPE_EMPTY){
            View emptyView = LayoutInflater.from(mContext).inflate(R.layout.lt_empty, viewGroup, false);
            EmptyViewHolder emptyHolder = new EmptyViewHolder(emptyView);
            return emptyHolder;
        } else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_list, viewGroup, false);
            MyViewHolder holder = new MyViewHolder(view);
            return holder;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        if (viewHolder instanceof MyViewHolder){
            MyViewHolder holder = (MyViewHolder) viewHolder;

            // 处理数据
            MyData data = mList.get(i);

            // item点击
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "tips=> " +i, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (null == mList || mList.isEmpty()) {
            return 1;
        } else {
            return mList.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mList.size() == 0){
            return TYPE_EMPTY;
        }
        return TYPE_ITEM;
    }


    /**
     * 自定义的viewHolder
     */
    class MyViewHolder extends RecyclerView.ViewHolder {
        // 显示UI
        ImageView _img;
        TextView _title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            _img = itemView.findViewById(R.id.image_view);
            _title = itemView.findViewById(R.id.title_view);

        }
    }

    /**
     * 空值时的viewHolder
     */
    class EmptyViewHolder extends RecyclerView.ViewHolder {

        public EmptyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
