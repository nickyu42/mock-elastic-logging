package com.sap.enterprises.server.impl.math;

/**
 * Base exception for math related exceptions
 */
class MathException extends Exception {}

/**
 * Occurs if an integer is divided by zero
 */
public class DivisionByZero extends MathException {}
