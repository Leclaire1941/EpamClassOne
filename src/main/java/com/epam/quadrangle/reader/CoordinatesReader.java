package com.epam.quadrangle.reader;

import com.epam.quadrangle.exceptions.NoFileException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoordinatesReader {
    private static final Logger LOG = LogManager.getLogger(CoordinatesReader.class);
    private static final String FILENAME = "./src/main/resources/DataFile";

    public List<String> readCoordinatesFromFileToList() {
        List<String> coordinatesList = new ArrayList<>();
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(FILENAME));
            String oneLineFromFile;
            while ((oneLineFromFile = bufferedReader.readLine()) != null) {
                coordinatesList.add(oneLineFromFile);
            }

        } catch (NoFileException e) {
            LOG.error("File not found", e);
        } catch (IOException e) {
            LOG.error("Error while reading coordinates from file", e);
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                LOG.error("You've got an error instead of BufferedReader.close()", e);
            }
        }

        return coordinatesList;
    }

    public Double[] parseOneLineFromListToDoubleArray(int numberOfLine) {
        List<String> coordinatesFromFileToList = readCoordinatesFromFileToList();
        String lineToSplit = coordinatesFromFileToList.get(numberOfLine);

        List<String> list = Arrays.asList(lineToSplit.split(" "));
        List<String> listToSplitCoordinates = new ArrayList<>();
        listToSplitCoordinates.addAll(list);

        Double[] separatedCoordinatesInDouble = new Double[listToSplitCoordinates.size()];
        for (int i = 0; i < listToSplitCoordinates.size(); i++) {
            separatedCoordinatesInDouble[i] = Double.parseDouble(listToSplitCoordinates.get(i));
        }

        return separatedCoordinatesInDouble;
    }
}
