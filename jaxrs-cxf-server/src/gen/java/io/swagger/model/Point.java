package io.swagger.model;

import java.util.HashMap;
import java.util.List;

import com.google.gson.annotations.Expose;

import io.swagger.annotations.ApiModelProperty;


/**
 * @author EugenioRappoccio
 * 
 * Model of Point for bidimensional plane
 *
 */
public class Point {
	
	@Expose
	@ApiModelProperty(value = "")
	private Double x = null;
	@Expose
	@ApiModelProperty(value = "")
	private Double y = null;

	
	public  HashMap<Double, List<Point>> map = new HashMap<>();
	
	
	/**
	 * @return the map
	 */
	public  HashMap<Double, List<Point>> getMap() {
		return map;
	}

	/**
	 * @param map the map to set
	 */
	public void setMap(HashMap<Double, List<Point>> map) {
		this.map = map;
	}

	/**
	 * Get x
	 * 
	 * @return x
	 **/
	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Point x(Double x) {
		this.x = x;
		return this;
	}

	/**
	 * Get y
	 * 
	 * @return y
	 **/
	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public Point y(Double y) {
		this.y = y;
		return this;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Point {\n");

		sb.append("    x: ").append(toIndentedString(x)).append("\n");
		sb.append("    y: ").append(toIndentedString(y)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private static String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
	
	

	
	/**
	 *  
	 *  
	 * @param <code>Point</code> that
	 * @return <code>Double</code>
	 */
	public Double toTip(Point that) {
		
		if (that == null) {
            throw new NullPointerException();
        }
        if (that.x == x) {
            if (that.y == y) {
                return Double.NEGATIVE_INFINITY;
            }
            return Double.POSITIVE_INFINITY;
        }
        if (that.y == y) {
            return 0.0;
        }
        return (Double) (that.y - this.y) / (that.x - this.x);
				
	}
	
	
}
