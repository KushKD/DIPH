package com.dit.himachal.utilities;

import com.dit.himachal.entities.VehicleOwnerEntries;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GeneratePdfReport {


    public static ByteArrayInputStream generateIdCard(VehicleOwnerEntries data) throws JsonProcessingException {
        VehicleOwnerEntries vehicleOwnerEntries = null;
        ObjectMapper objectMapper = new ObjectMapper();

        vehicleOwnerEntries = data;
        String postJson = objectMapper.writeValueAsString(vehicleOwnerEntries);
        System.out.println("43434" + postJson);
        Document document = new Document(new Rectangle(200f, 315f).rotate(), 5f, 5f, 5f, 5f);
        document.addTitle(vehicleOwnerEntries.getIdCardNumber());

        ByteArrayOutputStream out = new ByteArrayOutputStream();


        try {

            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);
            float[] columnWidths = {1f, 1f};
            table.setWidths(columnWidths);


            PdfPCell cell;
            cell = new PdfPCell(new Phrase(vehicleOwnerEntries.getIdCardNumber()));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            BarcodeQRCode barcodeQRCode = new BarcodeQRCode(postJson, 1000, 1000, null);
            Image codeQrImage = barcodeQRCode.getImage();
            codeQrImage.scaleAbsolute(100, 100);

            cell = new PdfPCell();
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(codeQrImage);




            Image image = Image.getInstance(new URL(Utilities.getPhotoUrl(vehicleOwnerEntries.getVehicleOwnerImageName())));

            PdfWriter.getInstance(document, out);
            document.open();

            document.add(table);
            document.add(image);

            document.close();

        } catch (DocumentException | MalformedURLException ex) {

            Logger.getLogger(GeneratePdfReport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

}
