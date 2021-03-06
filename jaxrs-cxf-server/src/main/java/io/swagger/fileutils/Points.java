package io.swagger.fileutils;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;

import io.swagger.model.Point;

/**
 * @author EugenioRappoccio
 *
 * Model to contain List of <code>Point</code>
 *
 */
public class Points {
	
	@Expose
	List<Point> points = new ArrayList<>();

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;	
	}
	
	public void addPoint(Point point) {
		this.points.add(point);
	}
	
	
}
