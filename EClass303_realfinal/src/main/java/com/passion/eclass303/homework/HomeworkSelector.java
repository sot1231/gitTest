package com.passion.eclass303.homework;

public class HomeworkSelector {
	private String search;
	private String category;
	private int start;
	private int end;

	public HomeworkSelector() {
		// TODO Auto-generated constructor stub
	}

	public HomeworkSelector(String search, String category, int start, int end) {
		super();
		this.search = search;
		this.category = category;
		this.start = start;
		this.end = end;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	
}
