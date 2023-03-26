package src.webdrivertechniques;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelDataReading {

    public static FileInputStream fis2;

    public static XSSFWorkbook wb;
    public static XSSFSheet sheet;
    public static XSSFRow row;
    public static XSSFCell cell;

    public static String text = "Automation";

    public static void main(String[] args) throws Exception {

        String cellvalue = getCellData(1, 1);

        System.out.println(cellvalue);

        text = "Selenium Automation";

        setCellData(2, 1, text);

        //System.out.println(getCellData(1,2));


    }

    public static String getCellData(int i, int j) throws Exception {

        fis2 = new FileInputStream("D://Book1.xlsx");
        wb = new XSSFWorkbook(fis2);
        //sheet=wb.getSheet("FIRSTXCELNAME");
        sheet = wb.getSheetAt(0);
        row = sheet.getRow(i);
        cell = row.getCell(j);

        return cell.getStringCellValue();

    }

    public static void setCellData(int i, int j, String text) throws Exception {

        fis2 = new FileInputStream("D://Book1.xlsx");
        wb = new XSSFWorkbook(fis2);
        sheet = wb.getSheet("FIRSTXCELNAME");
        row = sheet.getRow(i);
        cell = row.getCell(j);
        cell.setCellValue(text);

        //sheet.getRow(i).getCell(j).getStringCellValue();

        System.out.println(getCellData(i, j));


    }

}
