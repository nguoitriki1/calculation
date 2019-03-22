package com.tapi.mathcalculator.function.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tapi.mathcalculator.R;
import com.tapi.mathcalculator.model.HistoryModel;
import com.tapi.mathcalculator.utils.UtilsString;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AdapterHistoryRv extends RecyclerView.Adapter<AdapterHistoryRv.ViewHolder> {
    private List<HistoryModel> historyModelList;
    private Context context;
    private Calendar calendar = Calendar.getInstance();

    public AdapterHistoryRv(List<HistoryModel> historyModelList, Context context) {
        this.historyModelList = historyModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int type) {
        if (type == 0) {
            return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.history_header_rv, viewGroup, false));
        } else {
            return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.history_item_rv, viewGroup, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        HistoryModel historyModel = historyModelList.get(position);
        if (historyModel.isHeader()) {
            if (!TextUtils.isEmpty(historyModel.getHisDate())) {
                String dateToday = calendar.get(Calendar.DAY_OF_MONTH)+"/"+calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.YEAR);
                if (dateToday.contains(historyModel.getHisDate()))
                viewHolder.txtHeader.setText("Today");
            } else {
                viewHolder.txtHeader.setText(historyModel.getHisDate());
            }
        } else {
            viewHolder.txtResultBig.setText(historyModel.getTxtResult());
            viewHolder.txtResultSmall.setText(historyModel.getTxtResult());
        }

    }

    @Override
    public int getItemViewType(int position) {
        HistoryModel historyModel = historyModelList.get(position);
        if (historyModel.isHeader()) {
            return UtilsString.RECYCLERVIEW_TYPE_HEADER;
        } else {
            return UtilsString.RECYCLERVIEW_TYPE_ITEM;
        }
    }

    @Override
    public int getItemCount() {
        return historyModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtResultBig, txtResultSmall;
        private TextView txtHeader;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtHeader = itemView.findViewById(R.id.history_rv_header_txt);
            txtResultBig = itemView.findViewById(R.id.history_item_txt_big);
            txtResultSmall = itemView.findViewById(R.id.history_item_txt_small);

        }
    }
}
