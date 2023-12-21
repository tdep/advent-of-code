package com.tdep.aoc2023;

import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Day01 {
  private static final Logger LOG = LoggerFactory.getLogger(Day01.class);
  public static void main(final String... args) {

    // Set the regex pattern to compare each string to
    Pattern pattern = Pattern.compile("[0-9]");

    // Creates the JSONParser object
    JSONParser jsonParser = new JSONParser();

    // Set the total to add to
    int calibrationValueTotal = 0;
    try {
      // Parse the contents of the JSON file
      JSONObject day01Input = (JSONObject) jsonParser.parse(new FileReader("src/main/lib/aoc-2023/day01.json"));
      JSONArray inputList = (JSONArray) day01Input.get("input");

      for (Object listItem : inputList) {
        try {
          String calibrationValue = ""; // string to hold the first and last number of each string
          String item = listItem.toString(); // original stringified version of each item in the array
          StringBuilder itemReversed = new StringBuilder(); // Initialize the String builder
          itemReversed.append(item).reverse(); // Reversed version of the original string (to grab the last number)
          Matcher matcherF = pattern.matcher(item); // Compare each char in the string to the regex pattern
          Matcher matcherR = pattern.matcher(itemReversed); // Compare each char (of the reversed string) to the regex pattern

          if(matcherF.find()) {
            calibrationValue = calibrationValue.concat(matcherF.group()); // Finds the first number and adds it to the calibrationValue string
          }
          if(matcherR.find()) {
            calibrationValue = calibrationValue.concat(matcherR.group()); // Finds the last number and adds it to the calibrationValue string
          }

          int calibrationValueInt = Integer.parseInt(calibrationValue); // Converts the calibrationValue string into an integer
          calibrationValueTotal += calibrationValueInt; // Adds the integer of the calibrationValue to the total

        } catch (ArrayIndexOutOfBoundsException e) { // Catch any time there is an index issue, for laughs
          System.out.println("Ain't no index there fool!");
        }
      }
      System.out.println(calibrationValueTotal);

    } catch (IOException | ParseException e) { // Catch any other errors associated with the JSON file
      LOG.error(String.valueOf(e.getMessage()));
    }
  }
}
