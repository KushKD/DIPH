package com.dit.himachal.utilities;

import com.dit.himachal.entities.VehicleOwnerEntries;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.core.io.ClassPathResource;

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
        Document document = new Document(new Rectangle(300f, 500f).rotate(), 5f, 5f, 5f, 5f);
        document.addTitle(vehicleOwnerEntries.getIdCardNumber());

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
        Font boldFont2 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);

        try {

            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            float[] columnWidths = {1f, 1f, 1f, 1f};
            table.setWidths(columnWidths);


            PdfPCell cell;

//            cell = new PdfPCell(new Phrase("Shimla District Police",boldFont2));
//            cell.setColspan(1);
//            cell.setRowspan(2);
//
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(cell);


            cell = new PdfPCell(new Phrase("Shimla District Police",boldFont2));
            cell.setColspan(4);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(vehicleOwnerEntries.getIdCardNumber(),boldFont2));
            cell.setColspan(4);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);



            cell = new PdfPCell(new Phrase("ID Card for Apple Season 2020 (only)",boldFont));
            cell.setColspan(4);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPadding(10);
            table.addCell(cell);


            // Create a new Table
            PdfPTable childTable1 = new PdfPTable(2);
            float[] columnWidthsnested = {150f, 150f};
            childTable1.setWidths(columnWidthsnested);
            childTable1.addCell("Name:");
            childTable1.addCell(new Phrase(vehicleOwnerEntries.getVehicleOwnerName(),boldFont2));
            childTable1.addCell("Chassis Number:");
            childTable1.addCell(new Phrase(vehicleOwnerEntries.getVehicleOwnerChassisNumber(),boldFont2));
            childTable1.addCell("Driving Licence Number:");
            childTable1.addCell(new Phrase(vehicleOwnerEntries.getVehicleOwnerDrivingLicence(),boldFont2));
            childTable1.addCell("Engine Number:");
            childTable1.addCell(new Phrase(vehicleOwnerEntries.getVehicleOwnerEngineNumber(),boldFont2));
            childTable1.addCell("Chassis Number:");
            childTable1.addCell(new Phrase(vehicleOwnerEntries.getVehicleOwnerChassisNumber(),boldFont2));
            childTable1.addCell("Mobile Number:");
            childTable1.addCell(new Phrase(String.valueOf(vehicleOwnerEntries.getVehicleOwnerMobileNumber()),boldFont2));
            childTable1.addCell("Valid Upto:");
            childTable1.addCell(new Phrase(vehicleOwnerEntries.getIsValidUpto(),boldFont2));
            // Add the new table to the Cell of parent table
            // table.addCell(childTable1);

            cell = new PdfPCell(childTable1);
            cell.setColspan(3);
            cell.setBorder(0);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            //postJson
            BarcodeQRCode barcodeQRCode = new BarcodeQRCode("Kush Dhawan", 100, 100, null);
            Image codeQrImage = barcodeQRCode.getImage();
            codeQrImage.setAbsolutePosition(50f, 50f);
            codeQrImage.setBorder(0);
            //codeQrImage.scalePercent(10, 10);


           // Image image = Image.getInstance(new URL(Utilities.getPhotoUrl(vehicleOwnerEntries.getVehicleOwnerImageName())));



            // Create a new Table
            PdfPTable childTable2 = new PdfPTable(1);

            float[] columnWidthsnested2 = {10f};
            childTable2.setWidths(columnWidthsnested2);

              childTable2.addCell(codeQrImage);
            childTable2.getDefaultCell().setBorder(0);
           // childTable2.addCell(image);


            cell = new PdfPCell(childTable2);
            cell.setColspan(1);
            cell.setBorder(0);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
//

//
//            cell = new PdfPCell(codeQrImage);
//            cell.setColspan(2);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(cell);


            cell = new PdfPCell(new Phrase("Aadhaar Number:"));
            cell.setColspan(2);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(vehicleOwnerEntries.getVehicleOwnerAadhaarNumber(),boldFont2));
            cell.setColspan(2);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);


            cell = new PdfPCell(new Phrase("Place:"));
            cell.setColspan(2);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(String.valueOf(vehicleOwnerEntries.getVehicleBarrierId()),boldFont2));
            cell.setColspan(2);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Date:"));
            cell.setColspan(2);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(vehicleOwnerEntries.getIsValidFrom(),boldFont2));
            cell.setColspan(2);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("If found Please handover to Shimla Police"));
            cell.setColspan(4);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);


            PdfWriter.getInstance(document, out);
            document.open();

            document.add(table);
            //    document.add(image);

            document.close();

        } catch (DocumentException ex) {  // | MalformedURLException ex

            Logger.getLogger(GeneratePdfReport.class.getName()).log(Level.SEVERE, null, ex);
        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }

        return new ByteArrayInputStream(out.toByteArray());
    }

}
