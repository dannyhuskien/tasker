package com.hssn.models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;

import static org.hamcrest.CoreMatchers.*;

import static org.junit.Assert.*;

public class TaskTest {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateAnInstanceOfTask() throws Exception {
        Task t = new Task();
        assertThat(t, instanceOf(Task.class));
        assertTrue(t.getCreatedAt().getTime() > 0);
        assertTrue(t.getUpdatedAt().getTime() > 0);
    }

    @Test
    public void shouldGetAndSetIdOnTask() throws Exception {
        Task t = new Task();
        t.setId(3);

        assertEquals(3, t.getId());
    }

    @Test
    public void shouldGetAndSetNameonTask() throws Exception {
        Task t = new Task();
        t.setName("getMilk");

        assertEquals("getMilk", t.getName());
    }

    @Test
    public void shouldGetAndSetCategoryonTask() throws Exception {
        Task t = new Task();
        t.setCategory("home");

        assertEquals("home", t.getCategory());
    }

    @Test
    public void shouldGetAndSetDueDateOnTask() throws Exception {
        Task t = new Task();
        t.setDue( format.parse("2013-03-11"));

        assertEquals("Mon Mar 11 00:00:00 CDT 2013", t.getDue().toString());
    }

    @Test
    public void shouldGetAndSetIsCompleteOnTask() throws Exception {
        Task t = new Task();
        t.setIsComplete(true);

        assertTrue(t.getIsComplete());
    }

    @Test
    public void shouldGetAndSetCreatedAtOnTask() throws Exception {
        Task t = new Task();
        t.setCreatedAt( format.parse("2013-03-11"));

        assertEquals("Mon Mar 11 00:00:00 CDT 2013", t.getCreatedAt().toString());
    }

    @Test
    public void shouldGetAndSetUpdatedAtOnTask() throws Exception {
        Task t = new Task();
        t.setUpdatedAt( format.parse("2013-03-11"));

        assertEquals("Mon Mar 11 00:00:00 CDT 2013", t.getUpdatedAt().toString());
    }

    @Test
    public void shouldUpdateTheTimeOnTask() throws Exception {
        Task t = new Task();
        t.setUpdatedAt(null);
        t.updateTime();

        assertTrue(t.getUpdatedAt().getTime() > 0);
    }

}