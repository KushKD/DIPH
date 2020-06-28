package com.dit.himachal.utilities;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Utilities {

    public static Date convertStringToDate(String date) throws ParseException {
        String sDate1 = date;
        Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(sDate1);
        System.out.println(sDate1 + "\t" + date1);

        return date1;
    }

    public static final String createOtpMessage(String OTP) {

        return Constants.otp_Message + OTP;
    }

    /*
	This method takes the text to be encoded, the width and height of the QR Code,
	and returns the QR Code in the form of a byte array.
	*/
    public static byte[] getQRCodeImage(String object, int width, int height) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(object, BarcodeFormat.QR_CODE, width, height);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        byte[] pngData = pngOutputStream.toByteArray();
        return pngData;
    }


}
