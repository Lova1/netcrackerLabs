package xls;

import analyzer.SortNSizeArray;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;

public class TableSortsFiller {


    public static void sortedFiller(Sheet sheet) {

        SortNSizeArray sortedArray = new SortNSizeArray();
        sortedArray.sortSortedArray(100_000);

        createTable(sheet, sortedArray);

    }

    public static void reverseFiller(Sheet sheet){

        SortNSizeArray sortedArray = new SortNSizeArray();
        sortedArray.sortReversArray(100_000);

        createTable(sheet, sortedArray);

    }

    public static void randFiller(Sheet sheet){

        SortNSizeArray sortedArray = new SortNSizeArray();
        sortedArray.sortRandArray(100_000);

        createTable(sheet, sortedArray);

    }

    public static void randLastFiller(Sheet sheet){

        SortNSizeArray sortedArray = new SortNSizeArray();
        sortedArray.sortRandLastElementArray(100_000);

        createTable(sheet, sortedArray);

    }

    private static void createTable (Sheet sheet, SortNSizeArray sortedArray){

        ArrayList<Double> bss_list = sortedArray.getnBubbleSortTimeList();
        ArrayList<Double> brs_list = sortedArray.getnReverseBubbleSortTimeList();
        ArrayList<Double> myArray_list = sortedArray.getnMyArraysTimeList();
        ArrayList<Double> q_list = sortedArray.getnQsortTimeList();

        System.out.println(bss_list.size());

        if (!bss_list.isEmpty()) {
            for (int i = 0; i < bss_list.size(); i++) {
                double d = bss_list.get(i);
                System.out.println(d);
            }
        }

        System.out.println(brs_list.size());

        if (!brs_list.isEmpty()) {
            for (int i = 0; i < brs_list.size(); i++) {
                System.out.println(brs_list.get(i));
            }
        }

        System.out.println(myArray_list.size());

        if (!myArray_list.isEmpty()) {
            for (int i = 0; i < myArray_list.size(); i++) {
                System.out.println(myArray_list.get(i));
            }
        }

        System.out.println(q_list.size());

        if (!q_list.isEmpty()) {
            for (int i = 0; i < q_list.size(); i++) {
                System.out.println(q_list.get(i));
            }
        }

        // Create a row and put some cells in it. Rows are 0 based.
        Row rowTime, rowTimeName, row2, row3, row4, row5;
        Cell celTime, cellTineName, cell2, cell3, cell4, cell5, cell6;

        row2 = sheet.createRow(2);
        row3 = sheet.createRow(3);
        row4 = sheet.createRow(4);
        row5 = sheet.createRow(5);

        rowTime = sheet.createRow(1);

        celTime = rowTime.createCell(2);
        celTime.setCellValue("1");

        celTime = rowTime.createCell(3);
        celTime.setCellValue("10");

        celTime = rowTime.createCell(3);
        celTime.setCellValue("100");

        celTime = rowTime.createCell(4);
        celTime.setCellValue("1_000");

        celTime = rowTime.createCell(5);
        celTime.setCellValue("10_000");

        celTime = rowTime.createCell(6);
        celTime.setCellValue("100_000");


        rowTimeName = sheet.createRow(0);
        cellTineName = rowTimeName.createCell(4);
        cellTineName.setCellValue("Time");


        Cell bsSortCell = row2.createCell(1);
        bsSortCell.setCellValue("Bubble Sort");

        sheet.setColumnWidth(1, 5500);

        for (int rowIndex = 0; rowIndex < bss_list.size(); rowIndex++) {

            cell2 = row2.createCell(2);
            cell3 = row2.createCell(3);
            cell4 = row2.createCell(4);
            cell5 = row2.createCell(5);
            cell6 = row2.createCell(6);

            double d1 = bss_list.get(0);
            double d2 = bss_list.get(1);
            double d3 = bss_list.get(2);
            double d4 = bss_list.get(3);
            double d5 = bss_list.get(4);

            cell2.setCellValue(d1);
            cell3.setCellValue(d2);
            cell4.setCellValue(d3);
            cell5.setCellValue(d4);
            cell6.setCellValue(d5);

        }


        Cell bsReverseSortCell = row3.createCell(1);
        bsReverseSortCell.setCellValue("Bubble Reverse Sort");

        for (int rowIndex = 0; rowIndex < brs_list.size(); rowIndex++) {

            cell2 = row3.createCell(2);
            cell3 = row3.createCell(3);
            cell4 = row3.createCell(4);
            cell5 = row3.createCell(5);
            cell6 = row3.createCell(6);


            double d1 = brs_list.get(0);
            double d2 = brs_list.get(1);
            double d3 = brs_list.get(2);
            double d4 = brs_list.get(3);
            double d5 = brs_list.get(4);

            cell2.setCellValue(d1);
            cell3.setCellValue(d2);
            cell4.setCellValue(d3);
            cell5.setCellValue(d4);
            cell6.setCellValue(d5);

        }


        Cell myArCell = row4.createCell(1);
        myArCell.setCellValue("MyArrays Sort");

        for (int rowIndex = 0; rowIndex < brs_list.size(); rowIndex++) {

            cell2 = row4.createCell(2);
            cell3 = row4.createCell(3);
            cell4 = row4.createCell(4);
            cell5 = row4.createCell(5);
            cell6 = row4.createCell(6);


            double d1 = myArray_list.get(0);
            double d2 = myArray_list.get(1);
            double d3 = myArray_list.get(2);
            double d4 = myArray_list.get(3);
            double d5 = myArray_list.get(4);

            cell2.setCellValue(d1);
            cell3.setCellValue(d2);
            cell4.setCellValue(d3);
            cell5.setCellValue(d4);
            cell6.setCellValue(d5);

        }


        Cell qsortCell = row5.createCell(1);
        qsortCell.setCellValue("Qsort");

        for (int rowIndex = 0; rowIndex < brs_list.size(); rowIndex++) {

            cell2 = row5.createCell(2);
            cell3 = row5.createCell(3);
            cell4 = row5.createCell(4);
            cell5 = row5.createCell(5);
            cell6 = row5.createCell(6);


            double d1 = q_list.get(0);
            double d2 = q_list.get(1);
            double d3 = q_list.get(2);
            double d4 = q_list.get(3);
            //double d5 = q_list.get(4);

            cell2.setCellValue(d1);
            cell3.setCellValue(d2);
            cell4.setCellValue(d3);
            cell5.setCellValue(d4);
            cell6.setCellValue(/*"IndexOutOfBoundsException"*/"-");

        }

    }

}
