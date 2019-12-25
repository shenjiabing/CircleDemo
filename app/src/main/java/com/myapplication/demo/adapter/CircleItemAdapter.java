package com.myapplication.demo.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.myapplication.demo.R;
import com.myapplication.demo.bean.CircleBean;

import java.util.List;

public class CircleItemAdapter extends BaseQuickAdapter<CircleBean.DataBean.CommentListBean, BaseViewHolder> {

    public CircleItemAdapter(int layoutResId, @Nullable List<CircleBean.DataBean.CommentListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull final BaseViewHolder helper, CircleBean.DataBean.CommentListBean item) {
        TextView commentTv=helper.getView(R.id.commentTv);

//        helper.setText(R.id.commentTv,item.getUsername()+"回复:"+item.getContent());

        SpannableStringBuilder builder = new SpannableStringBuilder();
        builder.append(item.getUsername());
        builder.setSpan(new ForegroundColorSpan(mContext.getResources().getColor(R.color.top_red_A62625)),
                0, builder.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        builder.append("回复:"+item.getContent());
        commentTv.setText(builder);
        helper.addOnClickListener(R.id.commentTv).addOnLongClickListener(R.id.commentTv);
    }

}
