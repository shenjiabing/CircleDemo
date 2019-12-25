package com.myapplication.demo.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.myapplication.demo.BaseApplication;
import com.myapplication.demo.R;
import com.myapplication.demo.bean.CircleBean;
import com.myapplication.demo.widget.PraiseListView;

public class CircleAdapter extends BaseQuickAdapter<CircleBean.DataBean, BaseViewHolder> {
    public CircleAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NonNull final BaseViewHolder helper, final CircleBean.DataBean item) {
        RecyclerView commentListView=helper.getView(R.id.mRecyclerView);
//        commentListView.setDatas(item.getComment_list());
        commentListView.setLayoutManager(new LinearLayoutManager(mContext));
        CircleItemAdapter itemAdapter=new CircleItemAdapter(R.layout.item_comment,item.getComment_list());
        commentListView.setAdapter(itemAdapter);

        itemAdapter.setOnItemChildLongClickListener(new BaseQuickAdapter.OnItemChildLongClickListener() {
            @Override
            public boolean onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.commentTv:
                        if (onItemLongClickListener!=null){
                            onItemLongClickListener.onItemLongClick(helper.getAdapterPosition(),position);
                        }
                        break;
                }
                return true;
            }

        });
        itemAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.commentTv:
                        if (onItemClickListener!=null){
                            onItemClickListener.onItemClick(helper.getAdapterPosition(),position);
                        }
                        break;
                }
            }
        });

        PraiseListView praiseListView = helper.getView(R.id.praiseListView);
        praiseListView.setDatas(item.getZhan_list());
        praiseListView.setOnItemClickListener(new PraiseListView.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                String userName = item.getZhan_list().get(position).getUsername();
                int userId = item.getZhan_list().get(position).getId();
                Toast.makeText(BaseApplication.getInstance(), userName + " &id = " + userId, Toast.LENGTH_SHORT).show()


              ;
            }
        });
        helper.addOnClickListener(R.id.tvComment)
                .addOnClickListener(R.id.tvLike)
                .addOnClickListener(R.id.tvShare);
    }


    private OnItemClickListener onItemClickListener;
    private OnItemLongClickListener onItemLongClickListener;



    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }



    public static interface OnItemClickListener{
        public void onItemClick(int position,int itemPosition);
    }

    public static interface OnItemLongClickListener{
        public void onItemLongClick(int position,int itemPosition);
    }

}
