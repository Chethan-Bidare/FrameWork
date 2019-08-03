package excelManager;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
    private XSSFCellStyle cellStyle;
    private Font font ;


    public ExcelWriter(final String path)  {
        try {
            fileOutputStream = new FileOutputStream(path);
            workbook = new XSSFWorkbook();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createResultSheet(final String sheetName,HashMap<Integer, ArrayList<Object>> resultMap){
        sheet = workbook.createSheet(sheetName);
        cellStyle = workbook.createCellStyle();
        font = workbook.createFont();
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
        XSSFCell cell1 = headerRow.createCell(0, CellType.STRING);
        cell1.setCellValue("Test Case ID");
        cell1.setCellStyle(createHeaderCellStyle());
        XSSFCell cell2 = headerRow.createCell(1, CellType.STRING);
        cell2.setCellValue("Test Case Name");
        cell2.setCellStyle(createHeaderCellStyle());
        XSSFCell cell3 = headerRow.createCell(2, CellType.STRING);
        cell3.setCellValue("Result");
        cell3.setCellStyle(createHeaderCellStyle());
        XSSFCell cell4 = headerRow.createCell(3, CellType.STRING);
        cell4.setCellValue("Execution Date");
        cell4.setCellStyle(createHeaderCellStyle());
        XSSFCell cell5 = headerRow.createCell(4, CellType.STRING);
        cell5.setCellValue("Duration");
        cell5.setCellStyle(createHeaderCellStyle());
        XSSFCell cell6 = headerRow.createCell(5, CellType.STRING);
        cell6.setCellStyle(createHeaderCellStyle());
        cell6.setCellValue("Comments");
    }
    
    private CellStyle createHeaderCellStyle() {
    	font.setBold(true);
    	font.setItalic(true);
    	cellStyle.setFont(font);
    	cellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
    	cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    	cellStyle.setWrapText(true);
    	cellStyle.setAlignment(HorizontalAlignment.CENTER);
    	cellStyle.setBorderBottom(BorderStyle.MEDIUM);
    	cellStyle.setBorderTop(BorderStyle.MEDIUM);
    	cellStyle.setBorderLeft(BorderStyle.MEDIUM);
    	cellStyle.setBorderRight(BorderStyle.MEDIUM);
    	return cellStyle;
	}
    
    private CellStyle createCellStyle() {
    	
    	return cellStyle;
    }

    private void writeResults(HashMap<Integer, ArrayList<Object>> resultMap){
        Set<Integer> keySet = resultMap.keySet();
        Iterator<Integer> it = keySet.iterator();
        for (int i=1; i<=resultMap.size(); i++){
            int testId = it.next();
            XSSFRow row = sheet.createRow(i);
            for (int j=0; j<=5; j++){
                row.createCell(j,CellType.STRING).setCellValue(String.valueOf(resultMap.get(testId).get(j)));
                sheet.autoSizeColumn(j);
            }
        }
        
    }
}
