package io.swagger.api.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import io.swagger.fileutils.JSONFIle;
import io.swagger.model.Point;

public class Main {

	public static void main(String[] args) {
		
		
//		Point p = new Point();
//		
//		p.setX(6.3);
//		p.setY(311.8);
//		
//		JSONFIle.append(p, "src/json.json");
//		
//		List<Point> pl = JSONFIle.read("src/json.json");
//		
//		Iterator<Point> it = pl.iterator();
//		
//		while(it.hasNext())
//		{
//			System.out.println(it.next().toString());
//		}
//		
//		JSONFIle.delete("src/json.json");
//		
//		
//		String[] args2 = new String[1];
//		
//		args2[0] = "ciao";
//		
//		System.out.println(args2[0]);
		
		
		List<Point> lp = JSONFIle.read("src/json.json");
    	
    	List<Point> lp2 = new ArrayList<Point>();
    	
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
    			
    			if(line.size()>=3)
    			{
    				System.out.println(p.toString());
    			}
    			
    		}
    		
    		
    		
    	}
    	
    	System.out.println(lp2.size());

	}

}
