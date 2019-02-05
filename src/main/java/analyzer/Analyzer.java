package analyzer;

import xls.LineChartReflection;
import java.io.IOException;

public class Analyzer {

    public static void analyze() {

        try {
            LineChartReflection.createChart();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

