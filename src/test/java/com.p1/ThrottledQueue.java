package com.p1;
import javax.swing.filechooser.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.Iterator;









import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/**
 * A simple throttled blocking-queue that returns elements at a constant rate (M
 * elements in N time)
 * 
 * @author Kamran Zafar
 * 
 */
public class ThrottledQueue {
    // M elements
	    private final int mElements;
    // N Time in milliseconds
    private final long nTime;
 
    // delay per queue element from last fetch
    private final long delayPerElement;
 
    // delay offset in milliseconds
    private long delayOffset = System.currentTimeMillis();
 
    // Reference start time
    private final long startTime = System.nanoTime();
 
    private final DelayQueue<DelayedElement> queue = new DelayQueue<DelayedElement>();
 
    public ThrottledQueue(int mElements, long nTime) {
        this.mElements = mElements;
        this.nTime = nTime;
 
        // calculate delay per element
        delayPerElement = (long) Math.ceil( nTime / mElements );
    }
 
    /**
     * Adds an element to the queue
     * 
     * @param item
     */
    public void add(Object element) {
        queue.put( new DelayedElement( element ) );
    }
 
    /**
     * Blocks till delay expires and sets the next offset
     * 
     * @return Object
     */
    public synchronized Object get() {
        try {
            Object obj = queue.take().getElement();
 
            // set next offset
            delayOffset = System.currentTimeMillis();
 
            return obj;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
 
        return null;
    }
 
    public boolean isEmpty() {
        return queue.isEmpty();
    }
 
    public int size() {
        return queue.size();
    }
 
    public int getMElements() {
        return mElements;
    }
 
    public long getNTime() {
        return nTime;
    }
 
    public long getDelayPerElement() {
        return delayPerElement;
    }
 
    /**
     * Start time in nanoseconds; reference point
     * 
     * @return
     */
    public long getStartTime() {
        return startTime;
    }
 
    private class DelayedElement implements Delayed {
        private final Object element;
        private final long insertTime; // relative to startTime
 
        public DelayedElement(Object element) {
            this.element = element;
 
            // elapsed time in nano seconds
            insertTime = System.nanoTime() - startTime;
        }
 
        public Object getElement() {
            return element;
        }
 
        /**
         * Returns < 0 if delay expires
         * 
         * @see java.util.concurrent.Delayed#getDelay(java.util.concurrent.TimeUnit)
         */
        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert( delayOffset + delayPerElement - System.currentTimeMillis(), TimeUnit.MILLISECONDS );
        }
 
        /**
         * Compares elements in order to return them in the same order they were
         * inserted
         * 
         * @see java.lang.Comparable#compareTo(java.lang.Object)
         */
        @Override
        public int compareTo(Delayed o) {
            DelayedElement de = (DelayedElement) o;
            if (insertTime < de.getInsertTime())
                return -1;
            if (insertTime > de.getInsertTime())
                return 1;
 
            return 0;
        }
 
        public long getInsertTime() {
            return insertTime;
        }
    }
    public static List<String> s1=new ArrayList();
    public static List<Double> s2=new ArrayList();
    public static int size1=0;
    public static int size2=0;
    public static Scanner selectTextFile() {
 	   do {
 	      JFileChooser chooser = new JFileChooser();
          FileNameExtensionFilter filter = new FileNameExtensionFilter(
             "Text/Java files", "txt", "java");
          chooser.setFileFilter(filter);
          int returnVal = chooser.showOpenDialog(null);
 			try {
             if(returnVal == JFileChooser.APPROVE_OPTION) {
 		         return new Scanner(chooser.getSelectedFile());
             } 
    		   else {
 		         return null;
 			   }
 			}
 			catch (FileNotFoundException e) {
 			   JOptionPane.showMessageDialog(null, "Invalid file!",
 				   "error", JOptionPane.ERROR_MESSAGE); 
 			}
 		} while (true);
 	}
 	/**
 	 * given a String, uses a Scanner to count the number of words
 	 * @return number of words in the String
 	 */
    public static int file(String line) {
 	   Scanner s = new Scanner(line);
 		int count = 0;
 		while (s.hasNext()) {
 		   s.next();
 			count++;
 		}
 		return count;
 	}
    
 public void method()
 {
	 System.out.println("Deepthi");
 }
 public static ListRequest lp = new ListRequest();
    // Test
    public void main1() throws Exception {
        // Create a throttled queue that returns 2 elements in 1 second
        
    	
    	final ThrottledQueue q = new ThrottledQueue( 4, 1000 );
        size1=0;
        size2=0;
        String obj11 = null;
        Object obj = null;
        String line1 = null;
        String line = null;
        ArrayList l = new ArrayList();
        
    	try {
 		   UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
 		}
 		catch (Exception e) { // ignore exceptions and continue
 		}
 	   Scanner lineScanner = ThrottledQueue.selectTextFile();
 		int numberOfWords = 0;
 		int u = 0;
 		if (lineScanner!=null) {
 	     while (lineScanner.hasNextLine()) {
 		      line=lineScanner.nextLine();
 		      if(line.length()>1){
 		     u=u+1;
             q.add(line);
             int tmp=line.indexOf("timePlaced");
             System.out.println(tmp);
             String tmp2=line.substring(tmp);
             System.out.println(tmp2);
             s1.add(tmp2.substring(tmp2.indexOf(":")+3, tmp2.indexOf(",")-1));
             System.out.println(line);
             int tmp1 = line.indexOf("amountBuy");
              Double t2=Double.parseDouble(line.substring(tmp1).substring(line.substring(tmp1).indexOf(":")+1,line.substring(tmp1).indexOf(",")));
               s2.add(t2);
             System.out.println(q);
             size1=size1+1;
             size2=size2+1;
        }		      
 		   }
 	  
 		}
                   // some elements, e.g. SMS records
                 
        System.out.println( "Delay per element: " + q.getDelayPerElement() );
    	
        // A thread that consumes elements in the queue
        Thread consumer = new Thread( new Runnable() {
         	  List<Msg> listMsg = new ArrayList<Msg>(); 
              List<Double> listMsg1 = new ArrayList<Double>();
              List<String> listMsg2 = new ArrayList<String>(); 
        	  int j=0;
        	
        	           @Override
                        public void run() {
        	        	   
            	                             LinkedHashSet<Msg> lhs = new LinkedHashSet<Msg>();
                                                 while (!q.isEmpty()) {
                                                j=j+1; 
                                                 System.out.println(j);                                                    
                                                           // Do something. e.g. send SMS
                                                               
                                                               JSONObject json = null;
                                                                           try {
                  	                                                                    Object temp=q.get();
                  	                                                                   json = (JSONObject) new JSONParser().parse(temp.toString());
                       
                                                                               } catch (ParseException e) {
                                                                                  e.printStackTrace();
                                                                                   }
                                                                                   
                                                                                        JSONObject jsonObject = (JSONObject) json;
                                                                                        String userId = (String) jsonObject.get("userId");
                                                                                        String currencyFrom = (String) jsonObject.get("currencyFrom");
                                                                                        String currencyTo = (String) jsonObject.get("currencyTo");
                                                                                        Long amountSell = (Long) jsonObject.get("amountSell");
                                                                                        Double amountBuy = (Double) jsonObject.get("amountBuy");
                                                                                     	Double rate = (Double) jsonObject.get("rate");
                                                                                       	String timePlaced= (String) jsonObject.get("timePlaced");
                                                                                      	String originatingCountry = (String) jsonObject.get("originatingCountry");
                                                                                        
                                                                                      	lhs.add(new Msg(userId,currencyFrom,currencyTo,amountSell,amountBuy,rate,timePlaced,originatingCountry));
                                                                                    	listMsg.add(new Msg(userId,currencyFrom,currencyTo,amountSell,amountBuy,rate,timePlaced,originatingCountry));
                                                                                    	listMsg1.add(amountBuy);
                                                                                    	listMsg2.add(timePlaced);
                                                                                    	
                                                                                     
                                                                                                                                                                   	                              
                                                            }
                                                             
                                             	Persistance p = new Persistance();
                                                try {
													p.main1(listMsg,listMsg1,listMsg2);
												} catch (JAXBException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}    
                                                                  }  
        	           
        	           
        	         });
        
      
        
        
        
        
        
        
        consumer.start();
        consumer.join();
    }


	public List<String> getS1() {
		return s1;
	}

	public void setS1(List<String> s1) {
		this.s1 = s1;
	}

	public List<Double> getS2() {
		return s2;
	}

	public void setS2(List<Double> s2) {
		this.s2 = s2;
	}
}
