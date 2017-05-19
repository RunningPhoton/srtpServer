package com.demo.database.data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.tomcat.jni.Time;

public class TDemoImplCircle  implements Serializable {
	private String circleName;
	private int userCounts;
	private long opertime;
	private int circleMarks;
	private String graphName;
	public TDemoImplCircle(String circleName, int userCounts, Date opertime) {
		this.circleName = circleName;
		this.userCounts = userCounts;
		this.opertime = opertime.getTime();
	}
	
	public TDemoImplCircle(String circleName, int userCounts, Date opertime,
			Integer circleMarks, String graphName) {
		this.circleName = circleName;
		this.userCounts = userCounts;
		this.opertime = opertime.getTime();
		this.circleMarks = circleMarks;
		this.graphName = graphName;
	}

	public int getCircleMarks() {
		return circleMarks;
	}

	public void setCircleMarks(int circleMarks) {
		this.circleMarks = circleMarks;
	}

	public String getGraphName() {
		return graphName;
	}

	public void setGraphName(String graphName) {
		this.graphName = graphName;
	}

	public String getCircleName() {
		return circleName;
	}
	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}
	public int getUserCounts() {
		return userCounts;
	}
	public void setUserCounts(int userCounts) {
		this.userCounts = userCounts;
	}

	public long getOpertime() {
		return opertime;
	}

	public void setOpertime(long opertime) {
		this.opertime = opertime;
	}
	
}
