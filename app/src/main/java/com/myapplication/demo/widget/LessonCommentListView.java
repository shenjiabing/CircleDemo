package com.myapplication.demo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.myapplication.demo.R;
import com.myapplication.demo.bean.CircleBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yiwei on 16/7/9.
 */
public class LessonCommentListView extends LinearLayout {
    private int itemColor;
    private int itemSelectorColor;
    private OnItemClickListener onItemClickListener;
    private OnItemLongClickListener onItemLongClickListener;
    private onItemClickableSpan onItemClickableSpan;
    private List<CircleBean.DataBean.CommentListBean> mDatas;
    private LayoutInflater layoutInflater ;

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public OnItemLongClickListener getOnItemLongClickListener() {
        return onItemLongClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }


    public onItemClickableSpan getOnItemClickableSpan() {
        return onItemClickableSpan;
    }

    public void setOnItemClickableSpan(onItemClickableSpan onItemClickableSpan) {
        this.onItemClickableSpan = onItemClickableSpan;
    }

    public void setDatas(List<CircleBean.DataBean.CommentListBean> datas){
        if(datas == null ){
            datas = new ArrayList<CircleBean.DataBean.CommentListBean>();
        }
        mDatas = datas;
        notifyDataSetChanged();
    }

    public List<CircleBean.DataBean.CommentListBean> getDatas(){
        return mDatas;
    }

    public LessonCommentListView(Context context) {
        super(context);
    }

    public LessonCommentListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(attrs);
    }

    public LessonCommentListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(attrs);
    }

    protected void initAttrs(AttributeSet attrs) {
        TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.PraiseListView, 0, 0);


        try {
            //textview的默认颜色
            itemColor = typedArray.getColor(R.styleable.PraiseListView_item_color, getResources().getColor(R.color.praise_item_default));
            itemSelectorColor = typedArray.getColor(R.styleable.PraiseListView_item_selector_color, getResources().getColor(R.color.praise_item_selector_default));

        }finally {
            typedArray.recycle();
        }
    }

    public void notifyDataSetChanged(){

        removeAllViews();
        if(mDatas == null || mDatas.size() == 0){
            return;
        }
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        for(int i=0; i<mDatas.size(); i++){
            final int index = i;
            View view = getView(index);
            if(view == null){
                throw new NullPointerException("listview item layout is null, please check getView()...");
            }

            addView(view, index, layoutParams);
        }

    }

    private View getView(final int position){
        if(layoutInflater == null){
            layoutInflater = LayoutInflater.from(getContext());
        }
        View convertView = layoutInflater.inflate(R.layout.circle_details_item_comment, null, false);

        TextView commentTv = (TextView) convertView.findViewById(R.id.commentTv);
        final CircleMovementMethod circleMovementMethod = new CircleMovementMethod(itemSelectorColor, itemSelectorColor);


        final CircleBean.DataBean.CommentListBean bean = mDatas.get(position);
        SpannableStringBuilder builder = new SpannableStringBuilder();
        String fromUserName = bean.getUsername();
        builder.append(setClickableSpan(fromUserName, bean.getId()));
        builder.append("回复");
//        if (bean.getType()==2){
//            builder.append(setClickableSpan(fromUserName, bean.getFromUser().getUserId()));
//            builder.append("回复");
//            if ((bean.getToUser() != null)) {
//                builder.append(setClickableSpan("@"+bean.getToUser().getUserName(), bean.getToUser().getUserId()));
//            }
//        }else if (bean.getType()==1){
//            builder.append(setClickableSpan(fromUserName+":", bean.getFromUser().getUserId()));
//
//        }
        builder.append(""+bean.getContent());

        commentTv.setText(builder);

        commentTv.setMovementMethod(circleMovementMethod);
        commentTv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (circleMovementMethod.isPassToTv()) {
                    if(onItemClickListener!=null){
                        onItemClickListener.onItemClick(position);
                    }
                }
            }
        });
        commentTv.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (circleMovementMethod.isPassToTv()) {
                    if(onItemLongClickListener!=null){
                        onItemLongClickListener.onItemLongClick(position);
                    }
                    return true;
                }
                return false;
            }
        });

        return convertView;
    }

    @NonNull
    private SpannableString setClickableSpan(final String textStr, final int id) {
        SpannableString subjectSpanText = new SpannableString(textStr);
        subjectSpanText.setSpan(new SpannableClickable(itemColor){
                                    @Override
                                    public void onClick(View widget) {
                                        if (onItemClickableSpan!=null){
                                            onItemClickableSpan.onItemClickableSpan(textStr,id);
                                        }
//                                        ToastUtils.showMessage(textStr + " &id = " + id);
                                    }
                                }, 0, subjectSpanText.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

//        subjectSpanText.setSpan(new ForegroundColorSpan(itemColor), 0, subjectSpanText.length(),
//                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return subjectSpanText;
    }

    public static interface OnItemClickListener{
        public void onItemClick(int position);
    }

    public static interface OnItemLongClickListener{
        public void onItemLongClick(int position);
    }

    public interface onItemClickableSpan{
        public void onItemClickableSpan(String textStr, int id);
    }



}
