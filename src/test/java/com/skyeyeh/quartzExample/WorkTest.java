package com.skyeyeh.quartzExample;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by TV6015 on 2016/2/25.
 * Quartz 單元測試。
 */
public class WorkTest {
    Work work;

    @Before
    public void setUp() throws Exception {
        work = new Work();
    }

    @Test
    public void testDoWork() throws Exception {
        work.doWork();
        System.out.print(work.getTrigger().getNextFireTime());
        Assert.assertNotEquals(null, work.getTrigger().getNextFireTime());
    }
}