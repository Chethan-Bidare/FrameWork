package excelManager;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ExcelWriter {

    private XSSFWorkbook workbook;
    private FileOutputStream fileOutputStream;
    private XSSFSheet sheet;


    public ExcelWriter(final String path)  {
        try {
            fileOutputStream = new FileOutputStream(path);
            workbook = new XSSFWorkbook();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createResultSheet(final String sheetName,HashMap<Integer, ArrayList<String>> resultMap){
        sheet = workbook.createSheet(sheetName);
        createHeaderRow();
        writeResults(resultMap);
        try {
            workbook.write(fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createHeaderRow(){
        XSSFRow headerRow = sheet.createRow(0);
        headerRow.createCell(0, CellType.STRING).setCellValue("Test Case ID");
        headerRow.createCell(1, CellType.STRING).setCellValue("Test Case Name");
        headerRow.createCell(2, CellType.STRING).setCellValue("Result");
        headerRow.createCell(3, CellType.STRING).setCellValue("Comments");
    }

    public void writeResults(HashMap<Integer, ArrayList<String>> resultMap){
        Set<Integer> keySet = resultMap.keySet();
        Iterator<Integer> it = keySet.iterator();
        for (int i=1; i<=resultMap.size(); i++){
            int testId = it.next();
            XSSFRow row = sheet.createRow(i);
            for (int j=0; j<3; j++){
                row.createCell(j,CellType.STRING).setCellValue(String.valueOf(resultMap.get(testId).get(j)));
            }
        }
    }
}
