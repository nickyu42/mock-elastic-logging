package com.sap.enterprises.server.impl.realhttp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HTTPResponseFactory {
    private static final Logger logger = LogManager.getLogger(HTTPResponseFactory.class);

    /**
     * Creates a new HTTPResponse
     * @param failed if it is a failed response
     * @return HTTPResponse object
     */
    public static AbstractHTTPResponse createResponse(boolean failed) {
        logger.info("Created new " + failed + " response");

        if (failed) {
            return new FailedResponse();
        }

        return new HTTPResponse();
    }
}
