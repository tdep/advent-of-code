package com.tdep.aoc2023;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Day01Part2 {
  private static final Logger LOG = LoggerFactory.getLogger(Day01Part2.class);

  public static void main(final String... args) {
    JSONParser jsonParser = new JSONParser();

    try {
      JSONObject day01Part02Input = (JSONObject) jsonParser.parse(new FileReader("src/main/lib/aoc-2023/day02.json"));
      JSONArray alphaInput = (JSONArray) day01Part02Input.get("alpha");
      JSONArray numericInput = (JSONArray) day01Part02Input.get("numeric");
      JSONArray inputList = (JSONArray) day01Part02Input.get("input");

      // 1. take each item from the JSON array and turn it into a string
      for (Object listItem:day01Part02Input) {
        try {
          String item = listItem.toString();
          if (alphaInput.contains(item)) {

          }
        }
      }

      // 2. step through the string and see if either:
      //      a. there is a substring that matches one of the keys in the alpha Array
      //          i. if there is, add the (value * 10) of that key to the calibrationValue int
      //      b. there is a character that matches one of the keys in the numeric Array
      //          i. if there is, add the (value* 10) of that key to the calibrationValue int
      // 3. apply step 2. to the reverse version of the stringified item so that:
      //      a. there is a substring that matches the reverse of the keys in the alpha Array
      //            i. if there is, add the value of that key to the calibrationValue int
      //      b. there is a character that matches one of the keys in the numeric Array
      //            i. if there is, add the value of that key to the calibrationValue int
      //4. sum each calibrationValue int to the totalValue int
      //5. print the totalValue int

    } catch (IOException | ParseException e) {
      LOG.error(String.valueOf(e.getMessage()));
    }
  }
}

