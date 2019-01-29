package xls;

import analyzer.SortNSizeMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;

public class TableSortsFiller {

    private static int maxArrSize = 100_000;

    public static void sortedFiller(Sheet sheet) {

        SortNSizeMap sortedArray = new SortNSizeMap();
        sortedArray.sortSortedArray(maxArrSize);

        createTable(sheet, sortedArray);

    }

    public static void reverseFiller(Sheet sheet){

        SortNSizeMap sortedArray = new SortNSizeMap();
        sortedArray.sortReversArray(maxArrSize);

        createTable(sheet, sortedArray);

    }

    public static void randFiller(Sheet sheet){

        SortNSizeMap sortedArray = new SortNSizeMap();
        sortedArray.sortRandArray(maxArrSize);

        createTable(sheet, sortedArray);

    }

    public static void randLastFiller(Sheet sheet){

        SortNSizeMap sortedArray = new SortNSizeMap();
        sortedArray.sortRandLastElementArray(maxArrSize);

        createTable(sheet, sortedArray);

    }

    private static void createTable (Sheet sheet, SortNSizeMap sortedArray) {

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
        Cell celTime, cellTineName;

        row2 = sheet.createRow(2);
        row3 = sheet.createRow(3);
        row4 = sheet.createRow(4);
        row5 = sheet.createRow(5);

        rowTime = sheet.createRow(1);

        celTime = rowTime.createCell(2);
        celTime.setCellValue((double) 1);

        celTime = rowTime.createCell(3);
        celTime.setCellValue((double)10);

        celTime = rowTime.createCell(4);
        celTime.setCellValue((double)100);

        celTime = rowTime.createCell(5);
        celTime.setCellValue((double)1_000);

        celTime = rowTime.createCell(6);
        celTime.setCellValue((double)10_000);

//        celTime = rowTime.createCell(7);
//        celTime.setCellValue((double)100_000);


        rowTimeName = sheet.createRow(0);
        cellTineName = rowTimeName.createCell(5);
        cellTineName.setCellValue("Time");


        Cell bsSortCell = row2.createCell(1);
        bsSortCell.setCellValue("Bubble Sort");

        sheet.setColumnWidth(1, 5500);

        for (int rowIndex = 0; rowIndex < bss_list.size(); rowIndex++) {
            fillCells(row2, bss_list);
        }


        Cell bsReverseSortCell = row3.createCell(1);
        bsReverseSortCell.setCellValue("Bubble Reverse Sort");

        for (int rowIndex = 0; rowIndex < brs_list.size(); rowIndex++) {
            fillCells(row3, brs_list);
        }


        Cell myArCell = row4.createCell(1);
        myArCell.setCellValue("MyArrays Sort");

        for (int rowIndex = 0; rowIndex < brs_list.size(); rowIndex++) {
            fillCells(row4, myArray_list);
        }


        Cell qsortCell = row5.createCell(1);
        qsortCell.setCellValue("Qsort");

        for (int rowIndex = 0; rowIndex < brs_list.size(); rowIndex++) {
            fillCells(row5, q_list);
        }
    }

    private static void fillCells(Row row, ArrayList<Double> list) {

        Cell cell2, cell3, cell4, cell5, cell6, cell7;

        try {

            cell2 = row.createCell(2);
            cell3 = row.createCell(3);
            cell4 = row.createCell(4);
            cell5 = row.createCell(5);
            cell6 = row.createCell(6);
            //cell7 = row.createCell(7);

            double d1 = list.get(0);
            double d2 = list.get(1);
            double d3 = list.get(2);
            double d4 = list.get(3);
            double d5 = list.get(4);
            //double d6 = list.get(5);

            cell2.setCellValue(d1);
            cell3.setCellValue(d2);
            cell4.setCellValue(d3);
            cell5.setCellValue(d4);
            cell6.setCellValue(d5);
            //cell7.setCellValue(d6);

        } catch (IndexOutOfBoundsException boundEx){
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException for package xls class createTable");
        }
    }
}
