package com.uglyeagle;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRCodeGenerator {

    public static void main(String[] args) {
        try {
            String text = """
                          sjzhgdfshfghjxdgfdhghjxfdgjhfdgjh
                          xdfghbdxghbdgbdfjgbdfjxhgbfgbjhxdfgb
                          d,mgbdxhgbdghbdfjgbdfhgbjhfdgbjhdgb
                          kjdxhvudfhguidshgudhfgudfhgudhgudhg
                          dskfjghdfhgdhgjdhfgjfdgjdhgjhdgjhxdgjhxd
                          """;
            generateQRCodeImage(text, 400, 400, "QR.png");
            System.out.println("QR Code Generated.");
        } catch (WriterException | IOException e) {
            System.err.println("Could not generate QR Code: " + e.getMessage());
        }
    }

    public static void generateQRCodeImage(String text, int width, int height, String filePath)
            throws WriterException, IOException {

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }

}
