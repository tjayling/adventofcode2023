package code.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
  public List<String> readFile(String inputFile) {
    System.out.println("Reading file: " + inputFile);
    List<String> result = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new java.io.FileReader(inputFile))) {
      String line;

      while ((line = br.readLine()) != null) {
        result.add(line);
      }
    } catch (IOException e) {
      throw new RuntimeException("Error reading file " + inputFile, e);
    }
    return result;
  }
}

