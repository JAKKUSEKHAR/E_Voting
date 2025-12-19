package com.evoting.util;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class VoterCardGenerator {

    public static String generateCard(String name, String token) {

        String filePath = "VoterCard" + token + ".pdf";

        try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(filePath));
            doc.open();

            doc.add(new Paragraph("***** VOTER ID CARD *****"));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph("NAME: " + name));
            doc.add(new Paragraph("TOKEN: " + token));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph("Use this card token to vote."));
            doc.add(new Paragraph("***************************"));

            doc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return filePath;
    }
}
