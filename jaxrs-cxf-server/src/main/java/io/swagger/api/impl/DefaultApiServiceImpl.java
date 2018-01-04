package io.swagger.api.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import io.swagger.api.DefaultApi;
import io.swagger.fileutils.JSONFIle;
import io.swagger.model.Point;

public class DefaultApiServiceImpl implements DefaultApi {
	
	public static String path = "";
	
	
    /* (non-Javadoc)
     * @see io.swagger.api.DefaultApi#linesGet(java.lang.Integer)
     */
    public List<List<Point>> linesGet(Integer N) {
        
    	
    	List<Point> lp = JSONFIle.read(path);
    	
    	List<Point> lp2 = new ArrayList<Point>();
    	
    	List<List<Point>> result = new ArrayList<List<Point>>();    	
    	
    	int dimension = lp.size();
    	
    	for(int i=0; i<dimension; i++)
    	{
   		
    		Point p = lp.get(i);
    		
    		for(int j=i+1; j<dimension; j++)
    			{
    				
    			Point p2 = lp.get(j);
    			
    				Double tip = p.toTip(p2);
    				
    				List<Point> points = p.getMap().get(tip);
    				
    				if(points!=null)
    				{
    					
    					points.add(p2);
    					
    				}
    				else {
    					
    					points = new ArrayList<Point>();
    					points.add(p2);
    				}
    				
    				p.getMap().put(tip, points);
    			}
    			
    			lp2.add(p);
    		
    	}
    	
    	for(Point p:lp2)
    	{
    		Collection<List<Point>> clp = p.getMap().values();
    		
    		Iterator<List<Point>> ilp = clp.iterator();
    		
    		while(ilp.hasNext())
    		{
    			
    			List<Point> line = ilp.next();
    			
    			if(line.size()>=N)
    			{
    				result.add(line);
    			}
    			
    		}
    		
    		
    	}
    	
    	
		return result;
    	   	
    }
    
    /* (non-Javadoc)
     * @see io.swagger.api.DefaultApi#pointPost(java.lang.Double, java.lang.Double)
     */
    public void pointPost(Double x, Double y) {
        
    	
    	Point p = new Point();
    	
    	p.setX(x);
    	p.setY(y);
    	
    	JSONFIle.append(p, path);
    	        
        
    }
    
    /* (non-Javadoc)
     * @see io.swagger.api.DefaultApi#spaceDelete()
     */
    public void spaceDelete() {
        
    	JSONFIle.delete(path);
        
    }
    
    /* (non-Javadoc)
     * @see io.swagger.api.DefaultApi#spaceGet()
     */
    public List<Point> spaceGet() {
    	
      	return JSONFIle.read(path);
      	
    }
    
}

