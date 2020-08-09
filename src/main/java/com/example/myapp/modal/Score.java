package com.example.myapp.modal;

public class Score {

	private long unique_id;
	private String date;
	private String team1;
	private String team2;	
	private boolean matchStarted;
	private String matchType;
	private String score;
	private String stat;
	public Score(long unique_id, String date,String team1, String team2, boolean matchStarted, String matchType, String score, String stat) {
		super();
		this.unique_id = unique_id;
		this.date = date;
		this.team1 = team1;
		this.team2 = team2;
		this.matchStarted = matchStarted;
		this.matchType = matchType;
		this.score = score;
		this.stat = stat;
	}
	
	public String getScore() {
		return score;
	}
	public String getStat() {
		return stat;
	}
	public long getUnique_id() {
		return unique_id;
	}
	public String getTeam1() {
		return team1;
	}
	public String getTeam2() {
		return team2;
	}
	public String getDate() {
		return date;
	}
	public boolean getMatchStarted() {
		return matchStarted;
	}
	public String getMatchType() {
		return matchType;
	}
	
	
}
