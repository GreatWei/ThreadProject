package com.five.parallersearch;

import static com.five.parallersearch.CurrentSearch.search;

import java.util.concurrent.Callable;

public class SearchTask implements Callable<Integer> {

	int begin, end, searchValue;

	public SearchTask(int searchValue, int begin, int end) {
		// TODO Auto-generated constructor stub
		this.begin = begin;
		this.end = end;
		this.searchValue = searchValue;
	}

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		int re = search(searchValue, begin, end);
		return re;
	}

}
