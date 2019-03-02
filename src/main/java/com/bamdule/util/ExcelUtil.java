package com.bamdule.util;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author MW
 */
public class ExcelUtil {

    public ExcelUtil() {
    }

    //디폴트 헤더 네임을 생성한다.
    private List<String> createDefultHeaderNames(Map<String, Object> data) {
        List<String> names = new ArrayList<>();
        for (String key : data.keySet()) {
            names.add(key);
        }
        return names;
    }

    public Workbook create(List<Map<String, Object>> list, List<String> headerNames) {
        return createWorkbook(list, headerNames);
    }

    public Workbook create(List<Map<String, Object>> list) {
        return create(list, createDefultHeaderNames(list.get(0)));
    }

    private Workbook createWorkbook(List<Map<String, Object>> list, List<String> headerNames) {
        Workbook xlsxWb = new XSSFWorkbook();
        Sheet sheet1 = xlsxWb.createSheet("firstSheet");

//        sheet1.setColumnWidth(0, 10000);
//        sheet1.setColumnWidth(1, 10000);
//        sheet1.setColumnWidth(2, 10000);
        Row row = null;
        Cell cell = null;
        int rowNum = 0;

        inputHeaderCell(sheet1.createRow(rowNum++), headerNames);

        for (Map<String, Object> data : list) {

            row = sheet1.createRow(rowNum);
            for (int cellNum = 0; cellNum < headerNames.size(); cellNum++) {
                String headerName = headerNames.get(cellNum);

                cell = row.createCell(cellNum);
                setCellValue(cell, data.get(headerName));

            }
            rowNum++;
        }

        return xlsxWb;
    }

    //header Cell을 입력한다.
    private void inputHeaderCell(Row row, List<String> headerNames) {
        for (int cellNum = 0; cellNum < headerNames.size(); cellNum++) {
            Cell cell = row.createCell(cellNum);
            cell.setCellValue(headerNames.get(cellNum));
        }
    }

    private void setCellValue(Cell cell, Object value) {
//        System.out.println(value.getClass().getName());

        if (Objects.isNull(value)) {
            cell.setCellValue("");
        } else if (value instanceof String) {
            cell.setCellValue((String) value);
        } else if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else if (value instanceof Double) {
            cell.setCellValue((Double) value);

        } else if (value instanceof Timestamp) {
            cell.setCellValue(((Timestamp) value).toString());
        } else if (value instanceof Date) {
            cell.setCellValue((Date) value);
        } else if (value instanceof BigInteger) {
            cell.setCellValue((Integer) ((BigInteger) value).intValue());
        } else if (value instanceof LocalDateTime) {
            cell.setCellValue(((LocalDateTime) value).toString());
        }

    }
}
