/*
DISCLAIMER
All of the following code is mock code
Reading it may cause symptoms ranging from nauseousness to severe brain damage
 */
package com.sap.enterprises.server;

import com.sap.enterprises.server.impl.TransportationService;
import com.sap.enterprises.server.impl.math.ArithmeticAbstracter;
import com.sap.enterprises.server.impl.math.DivisionByZero;
import com.sap.enterprises.server.impl.math.Integer;
import com.sap.enterprises.server.impl.realhttp.AbstractHTTPResponse;
import com.sap.enterprises.server.impl.realhttp.HTTPResponseFactory;

import java.util.Random;

/**
 * This is the main entry-point of the program
 */
public class Main {

    public static void main(String[] args) {

        TransportThread transportThread = new TransportThread();
        transportThread.setDaemon(true);
        transportThread.start();

        HTTPThread httpThread = new HTTPThread();
        httpThread.setDaemon(true);
        httpThread.start();

        Maffs maffs = new Maffs();
        maffs.setDaemon(true);
        maffs.start();

        while (true) {
            Main.sleep(Long.MAX_VALUE);
        }
    }

    static class Maffs extends Thread {
        @Override
        public void run() {
            while (true) {

                try {
                    ArithmeticAbstracter arithmeticAbstracter = new ArithmeticAbstracter();
                    arithmeticAbstracter.addition(new Integer(10), new Integer((int) (Math.random() * 10)));
                    arithmeticAbstracter.division(new Integer(42), new Integer((int) Math.round(Math.random())));
                } catch (DivisionByZero ignored) {
                }

                Main.sleep((long) (Math.random() * 10));
            }
        }
    }

    static class HTTPThread extends Thread {

        @Override
        public void run() {
            while (true) {

                if (Math.random() < 0.2) {
                    AbstractHTTPResponse response = HTTPResponseFactory.createResponse(true);
                    response.getResponseCode();
                } else {
                    AbstractHTTPResponse response = HTTPResponseFactory.createResponse(false);

                    if (Math.random() < 0.5) {
                        response.getResponseCode();
                    }
                }

                Main.sleep((long) (Math.random() * 10));
            }
        }
    }

    static class TransportThread extends Thread {
        @Override
        public void run() {
            while (true) {
                TransportationService transportationService = new TransportationService();

                if (Math.random() < 0.3)
                    transportationService.teleport();

                String[] countries = new String[]{"Jamaica", "Hungary", "Netherlands"};
                int i = new Random().nextInt(countries.length);
                transportationService.moveToCountry(countries[i]);

                Main.sleep((long) (Math.random() * 10));
            }
        }
    }

    static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {
        }
    }
}
