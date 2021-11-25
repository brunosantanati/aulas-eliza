package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

public class Daily {
	
	List<Data> data = new ArrayList<>();

	public List<Data> getData() {
		return data;
	}

	public void setData(List<Data> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Daily [data=" + data + "]";
	}

}
