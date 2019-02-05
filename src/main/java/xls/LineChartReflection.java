package xls;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;


import abstracter.AbstractBubbleSorter;
import abstracter.AbstractSorter;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xddf.usermodel.PresetColor;
import org.apache.poi.xddf.usermodel.XDDFColor;
import org.apache.poi.xddf.usermodel.XDDFLineProperties;
import org.apache.poi.xddf.usermodel.XDDFShapeProperties;
import org.apache.poi.xddf.usermodel.XDDFSolidFillProperties;
import org.apache.poi.xddf.usermodel.chart.*;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import reflection.Reflection;

/**
 * Line chart example.
 */
public class LineChartReflection {

    static Reflection reflection = new Reflection();

    public static void createChart() throws IOException {
        try (XSSFWorkbook wb = new XSSFWorkbook()) {

            for (Method methods: reflection.getFillersAnnotatedMethods()) {
                XSSFSheet sheetSort = wb.createSheet("Fillers." + methods.getName());
                TableReflectionSortsFiller.createTable(sheetSort,methods.getName());
                createGraphics(sheetSort);
            }

            // Write the output to a file
            try (FileOutputStream fileOut = new FileOutputStream("ReflectionSortChart.xlsx")) {
                wb.write(fileOut);
            }
        }
    }

    private static void createGraphics(XSSFSheet sheet) {

        XSSFDrawing drawing = sheet.createDrawingPatriarch();
        XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 12, 22, 40);

        XSSFChart chart = drawing.createChart(anchor);
        XDDFChartLegend legend = chart.getOrAddLegend();
        legend.setPosition(LegendPosition.TOP_RIGHT);

        // Use a category axis for the bottom axis.
        XDDFCategoryAxis bottomAxis = chart.createCategoryAxis(AxisPosition.BOTTOM);
        bottomAxis.setTitle("NUMBER OF ELEMENTS"); // https://stackoverflow.com/questions/32010765
        XDDFValueAxis leftAxis = chart.createValueAxis(AxisPosition.LEFT);
        leftAxis.setTitle("TIME OF SORTING");
        leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);

        XDDFDataSource<Double> xs = XDDFDataSourcesFactory.fromNumericCellRange(sheet, new CellRangeAddress(1, 1, 2, TableReflectionSortsFiller.getNumUpToCount()));

        XDDFLineChartData data = (XDDFLineChartData) chart.createData(ChartTypes.LINE, bottomAxis, leftAxis);
        XDDFLineChartData.Series series1;

        int firstRow = 2;
        int lastRow = 2;

        ArrayList<String> aStringList = TableReflectionSortsFiller.getListAbstractSorterNames();
        ArrayList<AbstractSorter> aList = reflection.getAbstractSorter();

        int aListSize = aList.size();

        for (int i=0; i<aListSize; i++) {
            for (AbstractSorter abstractSorter : aList) {
                if (aStringList.get(i).equals(abstractSorter.getClass().getSimpleName())) {

                    XDDFNumericalDataSource<Double> ys1 = XDDFDataSourcesFactory.fromNumericCellRange(sheet, new CellRangeAddress(firstRow, lastRow, 2, TableReflectionSortsFiller.getNumUpToCount()));
                    firstRow++;
                    lastRow++;

                    series1 = (XDDFLineChartData.Series) data.addSeries(xs, ys1);
                    series1.setTitle("Time/" + abstractSorter.getClass().getSimpleName(), null); // https://stackoverflow.com/questions/21855842
                    series1.setSmooth(false); // https://stackoverflow.com/questions/29014848
                    series1.setMarkerStyle(MarkerStyle.STAR); // https://stackoverflow.com/questions/39636138
                }
            }
        }

        ArrayList<String> abStringList = TableReflectionSortsFiller.getListAbstractBubbleSorterNames();
        ArrayList<AbstractBubbleSorter> abList = reflection.getAbstractBubbleSorter();

        int abListSize = abList.size();

        for (int i=0; i<abListSize; i++) {
            for (AbstractBubbleSorter abstractBubbleSorter : abList) {
                if (abStringList.get(i).equals(abstractBubbleSorter.getClass().getSimpleName())) {

                    XDDFNumericalDataSource<Double> ys2 = XDDFDataSourcesFactory.fromNumericCellRange(sheet, new CellRangeAddress(firstRow, lastRow, 2, TableReflectionSortsFiller.getNumUpToCount()));
                    firstRow++;
                    lastRow++;

                    series1 = (XDDFLineChartData.Series) data.addSeries(xs, ys2);
                    series1.setTitle("Time/" + abstractBubbleSorter.getClass().getSimpleName() + "Reverse", null); // https://stackoverflow.com/questions/21855842
                    series1.setSmooth(false); // https://stackoverflow.com/questions/29014848
                    series1.setMarkerStyle(MarkerStyle.STAR); // https://stackoverflow.com/questions/39636138
                }
            }
        }

        chart.plot(data);


        // if your series have missing values like https://stackoverflow.com/questions/29014848
        chart.displayBlanksAs(DisplayBlanks.GAP);

        // https://stackoverflow.com/questions/24676460
        solidLineSeries(data, 0, PresetColor.CHARTREUSE);
        solidLineSeries(data, 1, PresetColor.TURQUOISE);
    }

    private static void solidLineSeries(XDDFChartData data, int index, PresetColor color) {
        XDDFSolidFillProperties fill = new XDDFSolidFillProperties(XDDFColor.from(color));
        XDDFLineProperties line = new XDDFLineProperties();
        line.setFillProperties(fill);
        XDDFChartData.Series series = data.getSeries().get(index);
        XDDFShapeProperties properties = series.getShapeProperties();
        if (properties == null) {
            properties = new XDDFShapeProperties();
        }
        properties.setLineProperties(line);
        series.setShapeProperties(properties);
    }
}
