package org.neo4art.htmlparser.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class WriteSentimentCSV
{
  File file;

  public WriteSentimentCSV()
  {
    file = new File("/home/larus/Progetti/Git_Old/htmlparser/htmlparser/src/main/resources/result.csv");
  }

  public void createCSV()
  {
    try
    {
      FileOutputStream fileOut = new FileOutputStream(file);
      HSSFWorkbook workbook = new HSSFWorkbook();
      HSSFSheet worksheet = workbook.createSheet("Result");
      HSSFRow row1 = worksheet.createRow((short) 0);

      HSSFCell cellA1 = row1.createCell(0);
      HSSFCell cellA2 = row1.createCell(1);

      cellA1.setCellValue("TITLE");
      cellA2.setCellValue("RESULT");

      workbook.write(fileOut);
      workbook.close();
      fileOut.flush();
      fileOut.close();
    }
    catch (Exception e)
    {

    }
  }

  public void writeResult(String title, int result)
  {
    try
    {
      FileInputStream inp = new FileInputStream(file);// Apro il file in lettura
      HSSFWorkbook workbook = new HSSFWorkbook(inp);
      HSSFSheet worksheet = workbook.getSheet("Result");// Leggo il foglio di lavoro
      HSSFRow row = worksheet.createRow(worksheet.getLastRowNum() + 1);// Prendo l'ultima riga libera

      HSSFCell cell1 = row.createCell(0);// creo una cella sulla colonna 0
      HSSFCell cell2 = row.createCell(1);

      cell1.setCellValue(title);// scrivo dentro la cella 0
      cell2.setCellValue(result);
      FileOutputStream fileOut = new FileOutputStream(file);// Scrivo su file
      workbook.write(fileOut);
      workbook.close();
    }
    catch (Exception e)
    {

    }
  }

}
