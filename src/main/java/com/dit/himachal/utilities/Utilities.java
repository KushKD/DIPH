package com.dit.himachal.utilities;



import org.springframework.util.Base64Utils;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.nio.charset.Charset;
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




    public static final String getPhotoUrl(String imageName){
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(imageName)
                .toUriString();
        return fileDownloadUri;
    }

    public static String base64Encode(String token) {
        byte[] encodedBytes = Base64Utils.encode(token.getBytes());
        return new String(encodedBytes, Charset.forName("UTF-8"));
    }


    public static String base64Decode(String token) {
        byte[] decodedBytes = Base64Utils.decode(token.getBytes());
        return new String(decodedBytes, Charset.forName("UTF-8"));
    }


}
