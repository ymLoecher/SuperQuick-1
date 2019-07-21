package com.example.androidb.superquick.entities;

import com.example.androidb.superquick.utils.EnumsUtils;
import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Row")
public class Row extends ParseObject {
    private int rowId;
    private int row_columnId;
    private EnumsUtils.StatusRow rowStatus;
    private boolean rowShow;

    public Row() {
    }

    public Row(int rowId, int row_columnId, EnumsUtils.StatusRow rowStatus, boolean rowShow) {
        setRowId(rowId);
        setRow_columnId(row_columnId);
        this.rowStatus = rowStatus;
        setRowShow(rowShow);
    }

    public int getRowId() {
        return getInt("rowId");
    }

    public void setRowId(int rowId) {
        put("rowId", rowId);
    }

    public int getRow_columnId() {
        return getInt("row_columnId");
    }

    public void setRow_columnId(int row_columnId) {
        put("row_columnId ", row_columnId);
    }

    public EnumsUtils.StatusRow getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(EnumsUtils.StatusRow rowStatus) {
        this.rowStatus = rowStatus;
    }

    public boolean isRowShow() {
        return getBoolean("rowShow");
    }

    public void setRowShow(boolean rowShow) {
        put("rowShow", rowShow);
    }
}
