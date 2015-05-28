/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

/**
 *
 * @author Andreas
 */
public class Print implements Printable, Runnable {

    private String s = "Test";

    /**
     *
     * @param g
     * @param page
     */
    public void createPrintObject(Graphics g, int page) {
        s = "Dette er et print " + page;
        g.drawString(s, 20, 20);

    }

    /**
     *
     */
    public void printClick() {
        PrinterJob job = PrinterJob.getPrinterJob();
        Printable doc = this;
        job.setPrintable(doc);
        boolean accept = job.printDialog();
        if (accept) {
            try {
                job.print();
            } catch (PrinterException e) {
                System.out.println("PrinterException: " + e.getMessage());
            }
        }
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        int printResult = 0;
        if (pageIndex > 3) {   //Hardcodet, prøv at finde en erstatning!!
            printResult = NO_SUCH_PAGE;
        } else {
            createPrintObject(graphics, pageIndex);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {

            }
            printResult = PAGE_EXISTS;
        }
        return printResult;
    }

    /**
     *
     * @return
     */
    public String getS() {
        return s;
    }

    @Override
    public void run() {
        printClick();
    }

}
