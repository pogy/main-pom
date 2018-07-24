package com.shigu.main4.packages.util;

public class UtilCharacter {
  public UtilCharacter() {
	super();
  }
  public static final String BLANK_SPACE = " ";
  public static final String EMPTY = "";
  public static final String DOT = ".";
  public static final String COMMA = ",";
  public static final String WINDOWS_FILE_SEPARATOR = "/"; 
  public static final String UNIX_FILE_SEPARATOR = "/";
  public static final String URL_SEPARATOR = "/";
  public static final String FILE_ENCODING = System.getProperty("file.encoding");
  public static final String LINE_SEPARATOR = System.getProperty("line.separator");
  public static final String FILE_SEPARATOR = System.getProperty("file.separator");
  public static final String PATH_SEPARATOR = System.getProperty("path.separator");
  public static final String CURRENT_ENCODING = EncodingType.UTF_8.getEncodingName();

}

