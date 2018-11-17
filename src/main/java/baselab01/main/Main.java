package baselab01.main;

import baselab01.analyzer.Analyzer;
import baselab01.fillers.Fillers;
import baselab01.output.OutputResult;
import baselab01.package01.BubbleSort;
import baselab01.package02.QuicksortSort;
import baselab01.package04.ByHalf;


public class Main {

    public static void main(String[] args) {

        OutputResult op = new OutputResult();
        op.output();

        Analyzer analyzer = new Analyzer();
        analyzer.analyze();

    }
}
