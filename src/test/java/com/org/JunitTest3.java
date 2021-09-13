package com.org;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;

public class JunitTest3 {


    final Logger LOGGER = LogManager.getLogger(JunitTest3.class);  //com.org.JunitTest1

    @Before
    public void before(){
        PropertyConfigurator.configure("log4j.properties") ;
    }

    @Test
    public void test1(){


        LOGGER.debug("some debug messsge");
        LOGGER.info("this is an info message");
        LOGGER.warn("some warn messsge");
        LOGGER.error("some err messsge");
        LOGGER.fatal("some fatal messsge");
    }
}
