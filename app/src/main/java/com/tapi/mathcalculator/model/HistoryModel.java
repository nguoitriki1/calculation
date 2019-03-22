package com.tapi.mathcalculator.model;

public class HistoryModel {
    private long idHis;
    private String txtResult;
    private String edtResult;
    private String hisDate;
    private boolean isHeader;

    public HistoryModel() {
    }

    public HistoryModel(long idHis, String txtResult, String edtResult, String hisDate) {
        this.idHis = idHis;
        this.txtResult = txtResult;
        this.edtResult = edtResult;
        this.hisDate = hisDate;
    }

    public HistoryModel(String txtResult, String edtResult, String hisDate) {
        this.txtResult = txtResult;
        this.edtResult = edtResult;
        this.hisDate = hisDate;
    }

    public boolean isHeader() {
        return isHeader;
    }

    public void setHeader(boolean header) {
        isHeader = header;
    }

    public long getIdHis() {
        return idHis;
    }

    public void setIdHis(long idHis) {
        this.idHis = idHis;
    }

    public String getTxtResult() {
        return txtResult;
    }

    public void setTxtResult(String txtResult) {
        this.txtResult = txtResult;
    }

    public String getEdtResult() {
        return edtResult;
    }

    public void setEdtResult(String edtResult) {
        this.edtResult = edtResult;
    }

    public String getHisDate() {
        return hisDate;
    }

    public void setHisDate(String hisDate) {
        this.hisDate = hisDate;
    }
    public String toString (){
        return "idHis: "+getIdHis()+ "\n" +
                "txtResult: "+getTxtResult() + "\n" +
                "edtResult: "+getEdtResult() + "\n" +
                "hisDate : "+getHisDate();
    }
}
