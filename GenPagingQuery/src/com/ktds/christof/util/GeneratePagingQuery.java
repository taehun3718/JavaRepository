package com.ktds.christof.util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class GeneratePagingQuery {
	
	public class InitializeException extends RuntimeException {
		private static final long serialVersionUID = 5046417442282718571L;

		public InitializeException() {
			super();
		}
		
		public InitializeException(String msg) {
			super(msg);
		}
		
		public InitializeException(Throwable t) {
			super(t);
		}
		
		public InitializeException(String msg, Throwable t) {
			super(msg, t);
		}
	}
	private String tableName;
	private int numOfColunms;
	private List<Column> columns;
	
	public GeneratePagingQuery() {
		this.numOfColunms = 0;
		this.columns = new ArrayList<Column>();
	}
	
	public GeneratePagingQuery(String tableName) {
		this.tableName = tableName;
		this.numOfColunms = 0;
		this.columns = new ArrayList<Column>();
	}
	
	public void addColumn(Column column) {
		columns.add(column);
		numOfColunms++;
	}
	
	public void refreshColumns() {
		columns.removeAll(columns);
	}
	
	public void removeRecentColumnOne() {
		columns.remove(columns.size()-1);
	}
	
	public String getSelectQuery() {
		
		String q = "SELECT";
		int i;
		int columnSize = columns.size();
		Column col;
		for(i=0; i<columnSize; i++) {
			col = columns.get(i);
			if(i==0) {
				q += "\t" + col.getColumnName() + "\n";
			}
			else {
				q += "\t, " + col.getColumnName() + "\n";
			}
		}
		q += "FROM\t" + this.tableName;
		return q;
	}
	
	public String getPagingQuery() {
		String q = "SELECT";
		String q2 = "\t\t\tSELECT\tROWNUM AS RNUM, A.*\n";
		String q3 = "\t\t\t\t\t\tSELECT";
		
		String firstColumn="";
		int i;
		int columnSize = columns.size();
		Column col;
		for(i=0; i<columnSize; i++) {
			col = columns.get(i);
			if(i==0) {
				firstColumn = col.getColumnName();
				q += "\t" + col.getColumnName() + "\n";
			}
			else {
				q += "\t, " + col.getColumnName() + "\n";
			}
		}
		q += "FROM\t(\n";
		
		q2 += "\t\t\tFROM\t(\n";
		
		//SUB QUERY
		for(i=0; i<columnSize; i++) {
			col = columns.get(i);
			if(i==0) {
				q3 += "\t" + col.getColumnName() + "\n";
			}
			else {
				q3 += "\t\t\t\t\t\t\t, " + col.getColumnName() + "\n";
			}
		}
		q3 += "\t\t\t\t\t\tFROM\t" + this.tableName+"\n";
		q3 += "\t\t\t\t\t\tORDER\tBY\t"+firstColumn+"\tDESC\n";
		q3 += "\t\t\t\t\t) A\n";
		q3 += "\t\t\tWHERE\tROWNUM <![CDATA[<=]]> #{endPagingNumber}\n";
		q3 += "\t\t)\n";
		q += q2 + q3;
		q +="WHERE\tRNUM >= #{startPagingNumber}\n";
		
		return q;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}
