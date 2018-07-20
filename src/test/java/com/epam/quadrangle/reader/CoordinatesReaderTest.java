package com.epam.quadrangle.reader;

import org.testng.Assert;
import org.testng.annotations.*;
import java.util.ArrayList;
import java.util.List;

public class CoordinatesReaderTest {
    private CoordinatesReader coordinatesReader;

    @BeforeClass
    public void beforeClass() {
        coordinatesReader = new CoordinatesReader();
    }

    @Test
    public void shouldReturnListWhenReadCoordinatesFromFile() {
        final List actualList = coordinatesReader.readCoordinatesFromFileToList();
        List<String> expectedList = new ArrayList<>();
        expectedList.add("1.0 -3.6 2.4 6.0 -1.5 3.3 1.2 4.0");
        expectedList.add("1.5 -12.0 2.4 6.0 1.2");
        expectedList.add("4.1 2.6 -1.4 8.1 2.5 -2.3 1.4 3.1");

        Assert.assertEquals(expectedList, actualList);
    }

    @Test
    public void shouldReturnDoubleOfOneLineFromListToDoubleArray() {
        Double[] actualArray = coordinatesReader.parseOneLineFromListToDoubleArray(0);
        Double[] expectedArray = new Double[]{1.0, -3.6, 2.4, 6.0, -1.5, 3.3, 1.2, 4.0};

        Assert.assertEquals(expectedArray, actualArray);
    }

    @AfterClass
    public void afterClass() {
        coordinatesReader = null;
    }
}