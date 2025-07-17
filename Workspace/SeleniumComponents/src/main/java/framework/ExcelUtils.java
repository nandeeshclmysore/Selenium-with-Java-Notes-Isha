package framework;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ExcelUtils {

    /**
     * Reads an Excel sheet and returns the data as a List of Maps.
     * First row is used as headers (keys), and each row is a Map of key-value pairs.
     *
     * @param filePath  Absolute path to Excel file (.xlsx)
     * @param sheetName Sheet to read
     * @return List of Maps containing row data
     */


    public static List<Map<String, String>> readExcelAsMap(String path, String sheetName, String filterKey, String filterValue) {
        List<Map<String, String>> dataList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(new File(path));
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            Row headerRow = sheet.getRow(0);
            int totalRows = sheet.getPhysicalNumberOfRows();

            for (int i = 1; i < totalRows; i++) {
                Row row = sheet.getRow(i);
                Map<String, String> rowMap = new HashMap<>();

                for (int j = 0; j < headerRow.getLastCellNum(); j++) {
                    String key = headerRow.getCell(j).getStringCellValue().trim();
                    String value = row.getCell(j).toString().trim();
                    rowMap.put(key, value);
                }

                if (rowMap.get(filterKey).equalsIgnoreCase(filterValue)) {
                    dataList.add(rowMap);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataList;
    }


    private static boolean isRowEmpty(Row row) {
        DataFormatter formatter = new DataFormatter();
        if (row == null) return true;

        Iterator<Cell> cellIterator = row.cellIterator();
        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            if (!formatter.formatCellValue(cell).trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
