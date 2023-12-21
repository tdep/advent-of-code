package com.tdep.aoc2023;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import jdk.jshell.Snippet.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Day01 {
  private static final Logger LOG = LoggerFactory.getLogger(Day01.class);
  public static void main(final String... args) {

    // Creates the JSONParser object
    JSONParser jsonParser = new JSONParser();
    try {
      // Parse the contents of the JSON file
      JSONObject day01Input = (JSONObject) jsonParser.parse(new FileReader("./lib/aoc-2023/day01.json"));
      String input = (String) day01Input.get("ID");
      System.out.println(input);
    } catch (IOException | ParseException e) {
      LOG.error(String.valueOf(e.getMessage()));
    }
  }
}
