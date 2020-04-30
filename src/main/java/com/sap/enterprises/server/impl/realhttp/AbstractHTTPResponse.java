package com.sap.enterprises.server.impl.realhttp;

/**
 * Abstract class for HTTP responses
 */
public abstract class AbstractHTTPResponse {
    public abstract Integer getResponseCode();
}

class FailedResponseException extends Exception {}