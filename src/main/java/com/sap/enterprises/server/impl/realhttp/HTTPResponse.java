package com.sap.enterprises.server.impl.realhttp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Real HTTP response class
 */
public class HTTPResponse extends AbstractHTTPResponse {
    private static final Logger logger = LogManager.getLogger(HTTPResponse.class);

    @Override
    public Integer getResponseCode() {
        logger.info("Http response generated");
        return 200;
    }
}
