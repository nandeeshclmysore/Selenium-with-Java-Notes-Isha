package framework;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
    public static List<Map<String, String>> readExcelAsMap(String filePath, String sheetName, String filterKey, String filterValue) {
        List<Map<String, String>> dataList = new ArrayList<>();
        DataFormatter formatter = new DataFormatter();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("❌ Sheet '" + sheetName + "' not found in file: " + filePath);
            }

            Row headerRow = sheet.getRow(0);
            if (headerRow == null) {
                throw new IllegalArgumentException("❌ First row is empty, cannot use as header.");
            }

            List<String> headers = new ArrayList<>();
            for (Cell headerCell : headerRow) {
                headers.add(formatter.formatCellValue(headerCell).trim());
            }

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null || isRowEmpty(row)) continue;

                Map<String, String> rowData = new LinkedHashMap<>();
                for (int j = 0; j < headers.size(); j++) {
                    Cell cell = row.getCell(j);
                    String cellValue = formatter.formatCellValue(cell).trim();
                    rowData.put(headers.get(j), cellValue.isEmpty() ? "[NULL]" : cellValue);
                }
                dataList.add(rowData);
            }

        } catch (IOException e) {
            System.err.println("❌ Error reading Excel: " + e.getMessage());
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
