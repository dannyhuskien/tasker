package com.hssn.models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by localadmin on 8/17/16.
 */
public class ErrorResponseTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateErrorResponseAndGetMessage() throws Exception {
        ErrorResponse er = new ErrorResponse("Task not found");
        assertEquals("Task not found", er.getMessage());

    }
}