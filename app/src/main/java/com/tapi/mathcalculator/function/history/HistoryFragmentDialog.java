package com.tapi.mathcalculator.function.history;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.Toast;

import com.tapi.mathcalculator.R;
import com.tapi.mathcalculator.database.OperationDb;
import com.tapi.mathcalculator.function.adapter.AdapterHistoryRv;
import com.tapi.mathcalculator.function.dialog.DialogDeleteAllHistory;
import com.tapi.mathcalculator.model.HistoryModel;
import com.tapi.mathcalculator.utils.UtilsString;

import java.util.ArrayList;
import java.util.List;

public class HistoryFragmentDialog extends Fragment implements View.OnClickListener, DialogDeleteAllHistory.RemoveAllHistoryListner {
    private ImageView mBtnDeleteAllHistory, mBtnScrollUpHistory;
    private RecyclerView mRvHistory;
    private List<HistoryModel> historyModelsListData;
    private OperationDb operationDb;
    private AdapterHistoryRv adapterHistoryRv;
    private boolean noClosedScreen;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.history_fragment_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        funFindViewById(view);
        initData();
        initView();
    }

    private void initData() {
        historyModelsListData = new ArrayList<>();
        operationDb = new OperationDb(getActivity());
        operationDb.open();
        historyModelsListData = operationDb.getAllHistoryModel();
    }

    private void initView() {
        mBtnScrollUpHistory.setOnClickListener(this);
        mBtnDeleteAllHistory.setOnClickListener(this);
        adapterHistoryRv = new AdapterHistoryRv(historyModelsListData,getContext());
        mRvHistory.setHasFixedSize(true);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRvHistory.setLayoutManager(linearLayoutManager);
        mRvHistory.setAdapter(adapterHistoryRv);
        if (historyModelsListData.size()>0){
            linearLayoutManager.scrollToPosition(historyModelsListData.size()-1);
            noClosedScreen = true;
        }
        mRvHistory.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (!noClosedScreen){
                    if(linearLayoutManager.findLastCompletelyVisibleItemPosition() == historyModelsListData.size() -1){
                        //bottom of list!
                        if (getActivity() != null)
                            if (getActivity().getSupportFragmentManager().getBackStackEntryCount() > 0){
                                getActivity().onBackPressed();
                            }
                    }
                }
                noClosedScreen = false;
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    private void funFindViewById(View view) {
        mBtnDeleteAllHistory = view.findViewById(R.id.history_deleteall_btn);
        mBtnScrollUpHistory = view.findViewById(R.id.history_scrollup_btn);
        mRvHistory = view.findViewById(R.id.history_recycler_view);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.history_deleteall_btn:
                showDialogDeleteAllHistory();
                break;
            case R.id.history_scrollup_btn:
                getActivity().onBackPressed();
                break;
        }
    }

    private void showDialogDeleteAllHistory() {
        DialogDeleteAllHistory dialogDeleteAllHistory = new DialogDeleteAllHistory();
        dialogDeleteAllHistory.setRemoveAllHistoryListner(this);
        dialogDeleteAllHistory.setCancelable(false);
        dialogDeleteAllHistory.show(getChildFragmentManager(), UtilsString.TAG_DELETE_ALL_HISTORY_DIALOG);
    }

    @Override
    public void onRemoveAllHistoryComplete(boolean isComplete) {
        if (isComplete){
            historyModelsListData.clear();
            if (adapterHistoryRv != null){
                adapterHistoryRv.notifyDataSetChanged();
            }
        }
    }
}
