package com.myapplication.demo;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class InputCommentDialog extends BaseDialogFragment {
    public static final String KEY_INPUT = "input";
    @BindView(R.id.edit_comment)
    EditText editComment;
    @BindView(R.id.image_btn_comment_send)
    ImageView imageBtnCommentSend;
    Unbinder unbinder;
    private InputMethodManager inputMethodManager;
    private OnDialogClickListener onDialogClickListener;

    private static InputCommentDialog newInstance(String input) {
        InputCommentDialog dialog = new InputCommentDialog();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_INPUT, input);
        dialog.setArguments(bundle);
        return dialog;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.dialog_fragment);
    }

    @Override
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams layoutParams;
        getDialog().setCanceledOnTouchOutside(true);
        getDialog().getWindow().getAttributes().windowAnimations = R.style.dialog_scale_animstyle;
        if (window != null) {
            layoutParams = window.getAttributes();
            layoutParams.gravity = Gravity.BOTTOM;
            int screenWidth = getResources().getDisplayMetrics().widthPixels;
            layoutParams.width = screenWidth;
            window.setAttributes(layoutParams);
        }
//        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);
//        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_fragment_comment_layout, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setSoftKeyboard();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.image_btn_comment_send)
    public void onViewClicked() {
        String input=editComment.getText().toString().trim();
        if (TextUtils.isEmpty(input)){
            return;
        }

        dismiss();
        if (onDialogClickListener!=null){
            onDialogClickListener.onConfirm(input);
        }

    }

    private void setSoftKeyboard() {
        editComment.setFocusable(true);
        editComment.setFocusableInTouchMode(true);
        editComment.requestFocus();

        // 为 commentEditText 设置监听器，在 DialogFragment 绘制完后立即呼出软键盘，呼出成功后即注销
        editComment.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                if (inputMethodManager.showSoftInput(editComment, 0)) {
                    editComment.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            }
        });
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);

    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);

    }

    public interface OnDialogClickListener {
        void onConfirm(String input);
    }


    public void setOnDialogClickListener(OnDialogClickListener onDialogClickListener) {
        this.onDialogClickListener = onDialogClickListener;
    }

    public static class DialogBuilder {

        private InputCommentDialog dialog;

        private String mTag;

        public DialogBuilder(String inputText) {
            dialog = InputCommentDialog.newInstance(inputText);
        }

        public DialogBuilder setCallBack(OnDialogClickListener onDialog) {
            dialog.setOnDialogClickListener(onDialog);
            return this;
        }

        public DialogBuilder setTag(String tag) {
            this.mTag = tag;
            return this;
        }

        public void build(FragmentTransaction fragmentTransaction) {
            fragmentTransaction.add(dialog, mTag);
            fragmentTransaction.commitAllowingStateLoss();
        }
    }

}
