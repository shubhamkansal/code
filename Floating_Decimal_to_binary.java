package com.kansal.testprj;

public class DecimalToBinary {
	
	static String Dec_to_Binary(double num, int k) {
		String binary = ""; 
		int n = (int) num;
		double d = num-n;
		while(n > 0) {
			binary += (char) (n%2 + '0');
			n=n/2;
		}
		
		StringBuilder str = new StringBuilder();
		str.append(binary);
		str.reverse();
		binary=str.toString();
		binary += ".";
		
        while(k>0) {
        	d = d * 2;
        	int bit = (int)d;
        	if(bit == 1) {
            	binary += (char)(bit + '0');
            	d = d - bit;
        	}
        	else {
        		binary += (char)(bit + '0');
        	}
        	
        	k--;
        }
		return binary;
		
	}
	
	public static void main(String args[]) {
		System.out.println(Dec_to_Binary(4.47, 3));
		System.out.println(Dec_to_Binary(6.986, 5));
	}

}
