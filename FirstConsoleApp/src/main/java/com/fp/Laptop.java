package com.fp;

import org.springframework.stereotype.Component;

@Component("lap1")
public class Laptop {
	
	private int lid;
	private String lbrand;
	private String lcpu;
	private int lram;
	
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLbrand() {
		return lbrand;
	}
	public void setLbrand(String lbrand) {
		this.lbrand = lbrand;
	}
	public String getLcpu() {
		return lcpu;
	}
	public void setLcpu(String lcpu) {
		this.lcpu = lcpu;
	}
	public int getLram() {
		return lram;
	}
	public void setLram(int lram) {
		this.lram = lram;
	}
	
	public void compile() {
		System.out.println("Compiling Laptop");
	}
	
	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", lbrand=" + lbrand + ", lcpu=" + lcpu + ", lram=" + lram + "]";
	}
	

}
