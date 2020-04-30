package com.sap.enterprises.server.impl.realhttp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FailedResponse extends AbstractHTTPResponse {
    private static final Logger logger = LogManager.getLogger(FailedResponse.class);

    @Override
    public Integer getResponseCode() {
        logger.warn(new FailedResponseException().getStackTrace());
        return 404;
    }
}
