package com.springernature.cafe.generator;

import com.springernature.cafe.model.BillDetails;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BillGenerator {

    public static void generate(BillType billType, BillDetails billDetails, String path) {
        String billContent = "";
        String suffix = "";

        if (billType == BillType.TEXT) {
            TextContentGenerator textContentGenerator = new TextContentGenerator();
            billContent = textContentGenerator.generate(billDetails);
            suffix = ".txt";
        } else if (billType == BillType.HTML) {
            HtmlContentGenerator htmlContentGenerator = new HtmlContentGenerator();
            billContent = htmlContentGenerator.generate(billDetails);
            suffix = ".html";
        }
        generateFile(path, billContent, suffix);
    }

    private static void generateFile(String path, String billContent, String suffix) {
        try {
            File filePath = File.createTempFile("bill_", suffix, new File(path));
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
                bw.write(billContent);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public enum BillType {HTML, TEXT}
}
