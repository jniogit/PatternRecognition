package io.swagger.fileutils;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonWriter;

import io.swagger.model.Point;

public class JSONFIle {

	/**
	 * Store method for points
	 * 
	 * @param <code>Point</code>
	 *            p
	 * @param String
	 *            path of JSON file
	 */
	public static void append(Point p, String path) {

		try {

			JsonParser parser = new JsonParser();
			Object obj = parser.parse(new FileReader(path));

			JsonObject jsonObject = (JsonObject) obj;

			// loop array
			JsonArray msg = (JsonArray) jsonObject.get("points");
			Iterator<JsonElement> iterator = msg.iterator();

			Gson gson = new Gson();
			FileWriter file = new FileWriter(path, false);
			JsonWriter jw = new JsonWriter(file);
			iterator = msg.iterator();

			Points points = new Points();
			while (iterator.hasNext()) {
				Point p2 = gson.fromJson(iterator.next().toString(), Point.class);
				if(p.getX()!=p2.getX()&&p.getY()!=p2.getY())
					points.addPoints(p2);
			}
			points.addPoints(p);

			gson.toJson(points, Points.class, jw);
			file.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Get all stored points
	 * 
	 * @param String
	 *            path of JSON file
	 * @return <code>Points</code>
	 */
	public static List<Point> read(String path) {

		Points points = new Points();

		try {

			JsonParser parser = new JsonParser();
			Object obj = parser.parse(new FileReader(path));

			JsonObject jsonObject = (JsonObject) obj;

			// loop array
			JsonArray msg = (JsonArray) jsonObject.get("points");
			Iterator<JsonElement> iterator = msg.iterator();

			Gson gson = new Gson();

			iterator = msg.iterator();

			while (iterator.hasNext()) {
				points.addPoints(gson.fromJson(iterator.next().toString(), Point.class));
			}

		}

		catch (Exception e) {

			e.printStackTrace();
		}

		return points.getPoints();
	}

	
	
	@SuppressWarnings("unchecked")
	public static void delete(String path) {



		JSONObject obj = new JSONObject();

		JSONArray points = new JSONArray();

		obj.put("points", points);


		try (FileWriter file = new FileWriter(path)) {

			file.write(obj.toJSONString());

			System.out.println("Successfully Copied JSON Object to File...");

			System.out.println("\nJSON Object: " + obj);

		} catch (IOException e) {

			e.printStackTrace();

		}

		

	}

}
