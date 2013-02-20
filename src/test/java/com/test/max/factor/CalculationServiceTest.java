package com.test.max.factor;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.easymock.classextension.EasyMock.*;

public class CalculationServiceTest {

    private Storage storageMock;
    private String[] factors = new String[]{"1.2", "10", "11"};

    @Before
    public void setUp() throws Exception {
        storageMock = createStrictMock(Storage.class);
    }

    @Test
    public void retrieveFactor() throws Exception {
        expect(storageMock.readFactors()).andReturn(factors).anyTimes();
        replay(storageMock);
        CalculationService service = new CalculationService(storageMock);

        assertEquals(service.getFactor(0), 1.2D);
        assertEquals(service.getFactor(1), 10D);
        assertEquals(service.getFactor(2), 1D);
    }

    @Test
    public void calculateMeetsCondition() throws Exception {
        expect(storageMock.readFactors()).andReturn(factors);
        storageMock.writeResult(0, 19.9D);
        replay(storageMock);
        CalculationService service = new CalculationService(storageMock);

        assertEquals(service.calculateResult(8.7D, 0, 0), 0);
    }

    @Test
    public void calculateNotMeetsCondition() throws Exception {
        expect(storageMock.readFactors()).andReturn(factors);
        storageMock.writeResult(0, 10.0D);
        replay(storageMock);
        CalculationService service = new CalculationService(storageMock);

        assertEquals(service.calculateResult(0D, 1, 0), 1);
    }
}
