package main;

import analyzer.Analyzer;
import fillers.Fillers;
import output.OutputResult;
import package01.BubbleSort;
import package02.QuicksortSort;
import package04.ByHalf;


public class Main {

    public static void main(String[] args) {

        OutputResult op = new OutputResult();
        op.output();

        Analyzer analyzer = new Analyzer();
        analyzer.analyze();

    }
}
