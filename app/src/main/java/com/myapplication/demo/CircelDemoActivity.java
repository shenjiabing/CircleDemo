package com.myapplication.demo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.myapplication.demo.adapter.CircleAdapter;
import com.myapplication.demo.bean.CircleBean;
import com.myapplication.demo.widget.HorizontalDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CircelDemoActivity extends AppCompatActivity {

    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    String url = "https://artzz-test.oss-cn-hangzhou.aliyuncs.com/app/images/sellerLogo/2019/12/12/757c5cf7eca119e5a7908834e9e5c46c9444f9e9.png";

    private CircleAdapter mAdapter;
    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.circle_list);
        ButterKnife.bind(this);
        mContext=this;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter=new CircleAdapter(R.layout.circle_list_item);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this)
                .drawable(R.color.top_red_A62625)
                .size(10)
                .build());

        List<CircleBean.DataBean> data=new ArrayList<>();
        for (int i = 0; i <1000 ; i++) {
            CircleBean.DataBean bean=new CircleBean.DataBean();
            List<CircleBean.DataBean.CommentListBean> listBeans=new ArrayList<>();
            List<CircleBean.DataBean.ZhanListBean> zanList=new ArrayList<>();
            int k=0;

            if (i<5){
                k=2;
            }else if (i>=5&&i<10){
                k=5;
            }else if (i>=10&&i>20){
                k=10;
            }else {
                k=4;
            }
            for (int j = 0; j < k; j++) {
                CircleBean.DataBean.CommentListBean item=new CircleBean.DataBean.CommentListBean();
                item.setAvatar(url);
                item.setId(j+i);
                item.setUsername(j+i+"用户");
                item.setContent("评论的内容"+j+i);
                listBeans.add(item);
            }
            for (int j = 0; j < k; j++) {
                CircleBean.DataBean.ZhanListBean zanItem=new CircleBean.DataBean.ZhanListBean();
                zanItem.setAvatar(url);
                zanItem.setId(j+i);
                zanItem.setUsername(j+i+"用户");
                zanList.add(zanItem);
            }
            bean.setComment_list(listBeans);
            bean.setZhan_list(zanList);
            data.add(bean);
        }
        mAdapter.setNewData(data);


        mAdapter.setOnItemClickListener(new CircleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, int itemPosition) {
                Toast.makeText(mContext,position+"点击内容"+itemPosition,Toast.LENGTH_LONG).show();
            }
        });



        mAdapter.setOnItemLongClickListener(new CircleAdapter.OnItemLongClickListener() {
            @Override
            public void onItemLongClick(int position, int itemPosition) {
                Toast.makeText(mContext,position+"长按内容"+itemPosition,Toast.LENGTH_LONG).show();
            }
        });

        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.tvComment:
                        comment(position);

                        break;
                    case R.id.tvLike:
                        Toast.makeText(mContext,position+"点赞",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.tvShare:
                        Toast.makeText(mContext,position+"分享",Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });
    }


    private void comment(final int pos){
        InputCommentDialog.DialogBuilder dialogBuilder=new InputCommentDialog.DialogBuilder("");
        dialogBuilder.build(getSupportFragmentManager().beginTransaction());
        dialogBuilder.setCallBack(new InputCommentDialog.OnDialogClickListener() {
            @Override
            public void onConfirm(String input) {
                CircleBean.DataBean.CommentListBean item=new CircleBean.DataBean.CommentListBean();
                item.setAvatar(url);
                item.setId(1000+pos);
                item.setUsername(1000+pos+"用户");
                item.setContent(input);
                mAdapter.getData().get(pos).getComment_list().add(0,item);
                mAdapter.notifyDataSetChanged();
                Toast.makeText(mContext,"评论成功",Toast.LENGTH_LONG).show();
            }
        });

    }
}
