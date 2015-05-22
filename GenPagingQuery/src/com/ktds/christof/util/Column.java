package com.ktds.christof.util;

public class Column {
	private QueryType queryType;
	private String columnName;

	public Column(QueryType queryType
				, String columnName) {
		
		this.queryType	= queryType;
		this.columnName	= columnName;
	}
	
	public Column getColumn() {
		return new Column(this.queryType, this.columnName);
	}
	
	public QueryType getQueryType() {
		return this.queryType;
	}

	public String getColumnName() {
		return this.columnName;
	}
}
