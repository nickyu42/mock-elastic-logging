package com.sap.enterprises.server.impl.math;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Factory class for creating interfaces.Integer objects from int
 */
public class IntegerFactory {
    private static final Logger logger = LogManager.getLogger(IntegerFactory.class);

    public IntegerFactory() {
        logger.info("New IntegerFactory constructed");
    }

    @Override
    public String toString() {
        return "IntegerFactory{}";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public Integer createInteger(int value) {
        return new Integer(value);
    }
}
