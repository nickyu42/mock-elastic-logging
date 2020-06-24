package com.sap.enterprises.server.impl.math;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class for arithmetic of numbers
 */
public class ArithmeticAbstracter {
    private static final Logger logger = LogManager.getLogger(ArithmeticAbstracter.class);
    private final IntegerFactory integerFactory;

    public ArithmeticAbstracter() {
        this.integerFactory = new IntegerFactory();
    }

    /**
     * Static method for adding Integers together
     * @param integer1 first integer
     * @param integer2 integer to add to
     * @return integers added
     */
    public Integer addition(Integer integer1, Integer integer2) {
        logger.debug("Integer addition of " + integer1.toString() + " and " + integer2.toString());

        int val = integer1.getInnerInt() + integer2.getInnerInt();
        return this.integerFactory.createInteger(val);
    }

    /**
     * Static method for dividing integers
     * @param integer1 first integer
     * @param integer2 integer to divide by
     * @return integers divided
     * @throws DivisionByZero when first integer is zero
     */
    public Integer division(Integer integer1, Integer integer2) throws DivisionByZero {
        logger.debug("Integer division of " + integer1.toString() + " and " + integer2.toString());

        if (integer2.getInnerInt() == 0) {
            logger.error("Division by zero occurred");
            throw new DivisionByZero();
        }

        int val = integer1.getInnerInt() / integer2.getInnerInt();

        logger.debug("Result of division is " + val);

        return this.integerFactory.createInteger(val);
    }
}
