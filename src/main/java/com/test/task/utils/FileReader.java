package com.test.task.utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileReader {
    public static List<Integer> readFile(String fileName) throws Exception {
        List<Integer> numbers = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(fileName));
            Iterator<Row> rowIter = workbook.getSheetAt(0).rowIterator();
            while (rowIter.hasNext()) {
                XSSFRow row = (XSSFRow) rowIter.next();
                Integer number = Math.toIntExact(Math.round(row.getCell(0).getNumericCellValue()));
                numbers.add(number);
            }
            return numbers;
        }
        catch (Exception e) {
            throw new Exception("Ошибка при чтении файла");
        }
    }
}
