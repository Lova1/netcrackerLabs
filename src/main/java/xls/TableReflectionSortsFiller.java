package xls;

import abstracter.AbstractBubbleSorter;
import abstracter.AbstractSorter;
import fillers.Fillers;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import reflection.Reflection;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class TableReflectionSortsFiller {

    //todo set the max array value for Fillers
    private static int upToSize = 100/*_000*/;

    private static ArrayList<String> aNameList = new ArrayList<>();
    private static ArrayList<String> abNameList = new ArrayList<>();

    public static ArrayList<String> getListAbstractSorterNames(){
        return aNameList;
    }
    public static ArrayList<String> getListAbstractBubbleSorterNames(){
        return abNameList;
    }


    public static void createTable(Sheet sheet,String fillerName) {

        setSortsTable(sheet,fillerName,upToSize);
        setNumOfElements(sheet,upToSize);

    }

    private static void setSortsTable(Sheet sheet,String fillerName,int upToSize) {

        Reflection reflection = new Reflection();

        ArrayList<AbstractSorter> aList = reflection.getAbstractSorter();
        ArrayList<AbstractBubbleSorter> abList = reflection.getAbstractBubbleSorter();

        int rowNumber = 2;
        int start = 2;

        sheet.setColumnWidth(1, 5500);

        for (AbstractSorter abstractSorter : aList) {

            Row rowName = sheet.createRow(rowNumber);
            Cell cellName = rowName.createCell(1);
            cellName.setCellValue(abstractSorter.getClass().getSimpleName());
            rowNumber++;

            aNameList.add(abstractSorter.getClass().getSimpleName());

            ArrayList<Method> fillers = reflection.getFillersAnnotatedMethods();
            int[] ar = new int[0];

            for(int size = 1; size <= upToSize; size*=10) {
                for (Method filler : fillers) {

                    if (filler.getName().equals(fillerName)) {
                        if (filler.getName().equals("sort")) {
                            ar = Fillers.sort(size);
                            System.out.println("sort\n");

                        } else if (filler.getName().equals("randLastElement")) {
                            ar = Fillers.randLastElement(size);
                            System.out.println("randLastElement\n");

                        } else if (filler.getName().equals("reverseSort")) {
                            ar = Fillers.reverseSort(size);
                            System.out.println("reverseSort\n");

                        } else if (filler.getName().equals("randArray")) {
                            ar = Fillers.randArray(size);
                            System.out.println("randArray\n");
                        } else {
                            return;
                        }
                    }
                }

                abstractSorter.sort(ar);

                Cell newCell = rowName.createCell(start);
                newCell.setCellValue(abstractSorter.getTime());

                start++;
            }
            start=2;
        }


        for (AbstractBubbleSorter abSorts : abList) {

            Row rowName = sheet.createRow(rowNumber);
            Cell cellName = rowName.createCell(1);
            cellName.setCellValue(abSorts.getClass().getSimpleName() + "Reverse");
            rowNumber++;

            abNameList.add(abSorts.getClass().getSimpleName());

            ArrayList<Method> fillers = reflection.getFillersAnnotatedMethods();
            int[] ar = new int[0];

            for(int size = 1; size <= upToSize; size*=10) {
                for (Method filler : fillers) {

                    if (filler.getName().equals(fillerName)) {
                        if (filler.getName().equals("sort")) {
                            ar = Fillers.sort(size);
                            System.out.println("sort\n");

                        } else if (filler.getName().equals("randLastElement")) {
                            ar = Fillers.randLastElement(size);
                            System.out.println("randLastElement\n");

                        } else if (filler.getName().equals("reverseSort")) {
                            ar = Fillers.reverseSort(size);
                            System.out.println("reverseSort\n");

                        } else if (filler.getName().equals("randArray")) {
                            ar = Fillers.randArray(size);
                            System.out.println("randArray\n");
                        } else {
                            return;
                        }
                    }
                }

                abSorts.reverseSort(ar);

                Cell newCell = rowName.createCell(start);
                newCell.setCellValue(abSorts.getTime());

                start++;
            }
            start=2;
        }

    }

    private static void setNumOfElements(Sheet sheet, int upTo){

        int cellBegin = 2;

        Row rowName = sheet.createRow(1);

        for (int i = 1; i <= upTo; i*=10){
            Cell cellName = rowName.createCell(cellBegin);
            cellName.setCellValue(i);
            cellBegin++;
        }

    }

    public static int getNumUpToCount() {

        int count = 2;
        for (int i = 1; i < upToSize; i*=10) {
            count++;
        }
        return count;
    }
}
