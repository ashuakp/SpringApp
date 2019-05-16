package com.sapiens.policy;

public class Policy {
	private int pid;
	private String riskloc;
	public int getId() {
		return pid;
	}
	public void setId(int id) {
		this.pid = pid;
	}
	public String getRiskloc() {
		return riskloc;
	}
	public void setRiskloc(String riskloc) {
		this.riskloc = riskloc;
	}
	public String toString() 
    { 
        return pid + " " + riskloc; 
    } 
}
