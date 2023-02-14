package org.nitk.it112.lab9;
class Dummy{
	private int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
}

public class TestComplexity {
	
	public boolean testMethod(String name) {
		boolean verify = false;
		if(name.equalsIgnoreCase("Java")) {
			verify=true;
		}
		return verify;
	}

	public static void main(String[] args) {
		TestComplexity tc = new TestComplexity();
		for(int i=0;i<5;i++) {
			Dummy dum = new Dummy();
			dum.setNumber(i);
			System.out.println(dum.getNumber());
		}
		
		boolean returnVal = false;
		returnVal = tc.testMethod("Java");
		System.out.println();

	}

}
