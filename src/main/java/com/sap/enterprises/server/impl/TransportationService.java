package com.sap.enterprises.server.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TransportationService {
    private static final Logger logger = LogManager.getLogger(TransportationService.class);
    private boolean transportationServiceActive;

    public TransportationService() {
        logger.info("transportation service created with id=" + Math.random() * 10);
        this.transportationServiceActive = false;
    }

    /**
     * Use the teleportation service
     */
    public void teleport() {
        if (!this.transportationServiceActive) {
            logger.warn("Attempted to teleport while Service is inactive");

            if (Math.random() < 0.5) {
                logger.error("Teleportation device critically damaged");
            }
        }
    }

    /**
     * Move to new country
     * @param country country to move to
     */
    public void moveToCountry(String country) {
        if (country.equals("Netherlands")) {
            logger.error("The netherlands is currently unavailable");
        }

        logger.info("Move service successful");
    }

    public boolean isTransportationServiceActive() {
        return transportationServiceActive;
    }

    public void setTransportationServiceActive(boolean transportationServiceActive) {
        this.transportationServiceActive = transportationServiceActive;
    }
}
