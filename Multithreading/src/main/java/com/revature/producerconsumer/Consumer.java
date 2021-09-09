package com.revature.producerconsumer;

public class Consumer {
	public Holder data;
	int max;
	
	public Consumer(Holder data, int max) {
		super();
		this.data = data;
		this.max = max;
	}
	
	public void run() {
		for(int i=0; i<max; i++) {
			int currentVal = this.data.getVal();
			
			
		}
	}
}
