package xls;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.charts.ChartAxis;
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


/**
 * Line chart example.
 */
public class LineChart {

    public static void main(String[] args) throws IOException {
        try (XSSFWorkbook wb = new XSSFWorkbook()) {
            XSSFSheet sheetSort = wb.createSheet("Fillers.sorted");
           // XSSFSheet sheetReverseSort = wb.createSheet("Fillers.reverseSorted");
          //  XSSFSheet sheetRandArray = wb.createSheet("Fillers.randArraySorted");
          //  XSSFSheet sheetRandLastElement = wb.createSheet("Fillers.randLastElementSorted");

            TableSortsFiller.sortedFiller(sheetSort);
          //  TableSortsFiller.reverseFiller(sheetReverseSort);
          //  TableSortsFiller.randFiller(sheetRandArray);
          //  TableSortsFiller.randLastFiller(sheetRandLastElement);

            XSSFDrawing drawing = sheetSort.createDrawingPatriarch();
            XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 10, 15, 20);

            XSSFChart chart = drawing.createChart(anchor);
            XDDFChartLegend legend = chart.getOrAddLegend();
            legend.setPosition(LegendPosition.TOP_RIGHT);

            // Use a category axis for the bottom axis.
            XDDFCategoryAxis bottomAxis = chart.createCategoryAxis(AxisPosition.BOTTOM);
            bottomAxis.setTitle("x"); // https://stackoverflow.com/questions/32010765
            XDDFValueAxis leftAxis = chart.createValueAxis(AxisPosition.LEFT);
            leftAxis.setTitle("f(x)");
            leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);

            XDDFDataSource<Double> xs = XDDFDataSourcesFactory.fromNumericCellRange(sheetSort, new CellRangeAddress(1, 1, 2, 6));
            XDDFNumericalDataSource<Double> ys1 = XDDFDataSourcesFactory.fromNumericCellRange(sheetSort, new CellRangeAddress(2, 2, 2, 6));
            XDDFNumericalDataSource<Double> ys2 = XDDFDataSourcesFactory.fromNumericCellRange(sheetSort, new CellRangeAddress(3, 3, 2, 6));

            XDDFLineChartData data = (XDDFLineChartData) chart.createData(ChartTypes.LINE, bottomAxis, leftAxis);
            XDDFLineChartData.Series series1 = (XDDFLineChartData.Series) data.addSeries(xs, ys1);
            series1.setTitle("2x", null); // https://stackoverflow.com/questions/21855842
            series1.setSmooth(true); // https://stackoverflow.com/questions/29014848
            series1.setMarkerStyle(MarkerStyle.STAR); // https://stackoverflow.com/questions/39636138
            XDDFLineChartData.Series series2 = (XDDFLineChartData.Series) data.addSeries(xs, ys2);
            series2.setTitle("3x", null);
            series2.setSmooth(true);
            series2.setMarkerSize((short) 6);
            series2.setMarkerStyle(MarkerStyle.TRIANGLE); // https://stackoverflow.com/questions/39636138
            chart.plot(data);

            // if your series have missing values like https://stackoverflow.com/questions/29014848
            chart.displayBlanksAs(DisplayBlanks.GAP);

            // https://stackoverflow.com/questions/24676460
            solidLineSeries(data, 0, PresetColor.CHARTREUSE);
            solidLineSeries(data, 1, PresetColor.TURQUOISE);

            // Write the output to a file
            try (FileOutputStream fileOut = new FileOutputStream("My-line-chart.xlsx")) {
                wb.write(fileOut);
            }
        }
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