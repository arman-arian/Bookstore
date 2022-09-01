package com.tosan.bookstore.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseService {
    protected Logger logger;

    protected BaseService()
    {
        logger = LoggerFactory.getLogger(this.getClass());
    }
}
