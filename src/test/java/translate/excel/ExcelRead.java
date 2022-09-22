package translate.excel;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;

public class ExcelRead {

@Test
        public void readExcelFile() throws Exception {
    //identify the path:
    String path = "Translation_file.xlsx";

//to read from Excel file I need to load it into FileInput Stream:
    FileInputStream fis = new FileInputStream(path);

    //workbook>sheet>row>cell
    //1. create workbook:
    XSSFWorkbook workbook = new XSSFWorkbook(fis);

    //2. get a specific sheet
    XSSFSheet sheet = workbook.getSheet("Source_for_translation");

        //3. select row and cell:
        //indexes start from 0
        String german = String.valueOf(sheet.getRow(1).getCell(0));//German
        System.out.println(sheet.getRow(1).getCell(1));//Spanish
        System.out.println(sheet.getRow(1).getCell(2));//Demokratien
        System.out.println(sheet.getRow(1).getCell(3));//Democracias



}


}
