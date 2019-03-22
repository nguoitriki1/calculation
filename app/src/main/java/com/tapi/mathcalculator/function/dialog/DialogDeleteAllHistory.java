package com.tapi.mathcalculator.function.dialog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tapi.mathcalculator.R;
import com.tapi.mathcalculator.database.OperationDb;

public class DialogDeleteAllHistory extends DialogFragment implements View.OnClickListener {
    private TextView mBtnYes, mBtnNo;
    private RemoveAllHistoryListner removeAllHistoryListner;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.DialogTitle);
    }

    public void setRemoveAllHistoryListner(RemoveAllHistoryListner removeAllHistoryListner) {
        this.removeAllHistoryListner = removeAllHistoryListner;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.delete_all_history_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mBtnNo = view.findViewById(R.id.history_deleteall_btn_no);
        mBtnYes = view.findViewById(R.id.history_deleteall_btn_yes);
        mBtnNo.setOnClickListener(this);
        mBtnYes.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.history_deleteall_btn_no:
                dismiss();
                break;
            case R.id.history_deleteall_btn_yes:
                //clear db history
                OperationDb operationDb = new OperationDb(getContext());
                operationDb.open();
                operationDb.removeAllHistory();
                operationDb.close();
                removeAllHistoryListner.onRemoveAllHistoryComplete(true);
                dismiss();
                break;
        }
    }
    public interface RemoveAllHistoryListner {
        void onRemoveAllHistoryComplete(boolean isComplete);
    }
}
