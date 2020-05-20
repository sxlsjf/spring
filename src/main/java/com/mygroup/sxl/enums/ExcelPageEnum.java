package com.mygroup.sxl.enums;

public enum ExcelPageEnum {

    XLS(500, 60_000),
    XLSX(10, 1_000_000);

    private int pageSize;
    private int sheetMaxRow;

    ExcelPageEnum(int pageSize, int sheetMaxRow) {
        this.pageSize = pageSize;
        this.sheetMaxRow = sheetMaxRow;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getSheetMaxRow() {
        return sheetMaxRow;
    }
}
