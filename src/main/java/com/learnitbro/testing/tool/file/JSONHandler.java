package com.learnitbro.testing.tool.file;

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONHandler {
	
	/**
	 * Writes the JSON string into a file
	 * 
	 * @param name - location of the file to be written to
	 * @param body - JSON string
	 */
	public static void write(File name, String body) {
		name.getParentFile().mkdirs();
        try (FileWriter file = new FileWriter(name)) {
 
            file.write(body);
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	/**
	 * Returns the JSON as a string
	 * 
	 * @param file
	 * @return string
	 * @throws Exception
	 */
	public static String read(File file) throws Exception  {
	    String content = FileUtils.readFileToString(file, "utf-8");
	    return content;
	}
	
	/**
	 * Returns true if the body is a valid JSON
	 * 
	 * @param body
	 * @return boolean
	 */
	public static boolean isJSONValid(String body) {
	    try {
	        new JSONObject(body);
	    } catch (JSONException ex1) {
	        try {
	            new JSONArray(body);
	        } catch (JSONException ex2) {
	            return false;
	        }
	    }
	    return true;
	}
}