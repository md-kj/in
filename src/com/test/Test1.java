package com.test;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
	 int i ;
	    static int j;
	     
	    public Test1() {
	    }
	     
	    public Test1(int i) {
	        this.i = i;
	    }
	     
	    public static void main(String[] args) throws Exception {
	        System.gc();
	        List<Object> list = new ArrayList<Object>();
	        for(int i = 0;i<10;i++){
	            list.add(new Test1(i));
	        }
	        list = null;
	         
	        System.gc();
	         
	        Thread.sleep(1000);
	        System.out.println("******************"+j);
	    }
	     
	    @Override
	    protected void finalize() throws Throwable {
	        j++;
	        System.out.println("Over"+i+"->"+this.hashCode());
	        super.finalize();
	    }
}
