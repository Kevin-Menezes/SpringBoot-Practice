package com.hb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Song")
public class Song {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // This links with the db to give auto increment id
	private int sid;
	
	@Column(name="sname")
	private String sname;
	
	@Column(name="singer")
	private String singer;
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	
	@Override
	public String toString() {
		return "Song [sid=" + sid + ", sname=" + sname + ", singer=" + singer + "]";
	}


}
