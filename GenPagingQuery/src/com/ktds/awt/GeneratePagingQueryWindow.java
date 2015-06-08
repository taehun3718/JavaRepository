package com.ktds.awt;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import com.ktds.chrisof.listener.TextFieldListener;
import com.ktds.christof.util.Column;
import com.ktds.christof.util.GeneratePagingQuery;
import com.ktds.christof.util.QueryType;

class FormWindow extends WindowAdapter{
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}

public class GeneratePagingQueryWindow extends Frame {

	private static final long serialVersionUID = 9068624439553898539L;
	
	private final int FIRST_WIDTH_POS	= 10;
	private final int SECOND_WIDTH_POS	= 160;
	
	private Label labelColumnType;
	private Label labelTableName;
	private Label labelMadeBy;

	private TextField txtTableName;
	private TextField txtColumnName;
	
	private Button buttonAddColumn;
	private Button buttonGenerateColumn;
	private Button buttonInitColumn;
	private Button buttonRemoveRecentColumn;
	
	private Choice choice;
	
	private List addedColumnList;
	private GeneratePagingQuery gpq;
	
	public GeneratePagingQueryWindow() {
		
		super("Generate Paging query for Oracle RDBMS ");
		
		initLabel();
		initButton();
		initSelectBox();
		initTextField();
		initList();
		
		setComponents();
		
		this.setVisible(true);
		this.addWindowListener(new FormWindow());
		
		gpq = new GeneratePagingQuery();
	}

	private void setComponents() {
		this.setLayout(null);
		this.setSize(420, 500);
		this.setResizable(false);
		
		this.add(labelTableName);
		this.add(labelColumnType);
		this.add(labelMadeBy);
		
		this.add(txtTableName);
		this.add(txtColumnName);
		this.add(choice);
		
		this.add(buttonAddColumn);
		this.add(buttonGenerateColumn);
		this.add(buttonInitColumn);
		this.add(buttonRemoveRecentColumn);
		
		this.add(addedColumnList);
		

	}
	
	private void initList() {
		this.addedColumnList = new List();
		this.addedColumnList.setSize(400, 300);
		this.addedColumnList.setLocation(FIRST_WIDTH_POS, 140);
	}


	private void initTextField() {
		txtTableName = new TextField();
		
		txtTableName.setText("TABLE_NAME");
		txtTableName.setLocation(SECOND_WIDTH_POS, 30);
		txtTableName.setSize(250, 20);
		txtTableName.addFocusListener(new TextFieldListener(txtTableName));
		
		txtColumnName = new TextField();
		
		txtColumnName.setText("COLUMN_NAME");
		txtColumnName.setLocation(SECOND_WIDTH_POS, 70);
		txtColumnName.setSize(140,20);
		txtColumnName.addFocusListener(new TextFieldListener(txtColumnName));
		
	}
	private void initButton() {
		buttonAddColumn 			= new Button();

		buttonAddColumn.setLabel(" Add Column ");
		buttonAddColumn.setLocation(FIRST_WIDTH_POS, 100);
		buttonAddColumn.setSize(400, 40);
		
		buttonAddColumn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedItemIdx = choice.getSelectedIndex();
				String columnType = "";
				String columnName = txtColumnName.getText();
				
				gpq.setTableName(txtTableName.getText());
				
				if(columnName.equals("") || columnName==null) {
					JOptionPane.showMessageDialog(null, "Column is empty");
					return;
				}
				
				switch(selectedItemIdx) {
					case 0:
						gpq.addColumn(new Column(QueryType.NUMBER, columnName));
						columnType = "NUMBER";
						break;
					case 1:
						gpq.addColumn(new Column(QueryType.VARCHAR2, columnName));
						columnType = "VARCHAR2";
						break;
					case 2:
						gpq.addColumn(new Column(QueryType.DATE, columnName));
						columnType = "DATE";
						break;
					case 3:
						gpq.addColumn(new Column(QueryType.CHAR, columnName));
						columnType = "CHAR";
						break;
					case 4:
						gpq.addColumn(new Column(QueryType.UNKNOWN_TYPE, columnName));
						columnType = "UNKNOWN_TYPE";
						break;
				}
				addedColumnList.add( columnType + " / " + columnName);
				txtColumnName.setText("");
			}
		});
		
		buttonGenerateColumn = new Button();
		
		buttonGenerateColumn.setLocation(10, 440);
		buttonGenerateColumn.setSize(140, 30);
		buttonGenerateColumn.setLabel("Generate Paging Query");
		buttonGenerateColumn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Clipboard clipboard	= Toolkit.getDefaultToolkit().getSystemClipboard();
				StringSelection stringSelection	= new StringSelection(gpq.getPagingQuery());
				clipboard.setContents(stringSelection, null);
				JOptionPane.showMessageDialog(null, "Clipboard pasted.");
			}
		});
		
		buttonInitColumn = new Button();
		
		buttonInitColumn.setLabel("Init Column list");
		buttonInitColumn.setLocation(155, 440);
		buttonInitColumn.setSize(100, 30);
		buttonInitColumn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gpq = new GeneratePagingQuery();
				txtColumnName.setText("COLUMN_NAME");
				addedColumnList.removeAll();
				JOptionPane.showMessageDialog(null, "Initialization is Completed.");
			}
		});
		
		buttonRemoveRecentColumn = new Button();
		buttonRemoveRecentColumn.setLabel("Remove recent Column");
		buttonRemoveRecentColumn.setLocation(260, 440);
		buttonRemoveRecentColumn.setSize(150, 30);
		buttonRemoveRecentColumn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(addedColumnList.getItemCount()==0) {
					JOptionPane.showMessageDialog(null, "Item is not exist.");
					return;
				}
				else {
					gpq.removeRecentColumnOne();
					addedColumnList.remove(addedColumnList.getItemCount()-1);
				}
			}
		});
	}

	private void initLabel() {
		Font font = new Font("Serif", Font.PLAIN, 15);

		labelTableName = new Label();
		labelTableName.setText("Table Name:");
		labelTableName.setFont(font);
		labelTableName.setAlignment(Label.LEFT);
		
		labelTableName.setLocation(FIRST_WIDTH_POS, 20);
		labelTableName.setSize(130, 40);
		
		labelColumnType = new Label();
		labelColumnType.setAlignment(Label.LEFT);
		labelColumnType.setText("Select COLUMN");
		labelColumnType.setFont(font);
		
		labelColumnType.setLocation(FIRST_WIDTH_POS, 60);
		labelColumnType.setSize(130, 40);
		
		labelMadeBy = new Label();
		labelMadeBy.setAlignment(Label.CENTER);
		labelMadeBy.setBackground(Color.LIGHT_GRAY);
		labelMadeBy.setLocation(FIRST_WIDTH_POS, 470);
		labelMadeBy.setSize(400, 20);
		labelMadeBy.setText("taehun3718@gmail.com Christof-kim 2015-06-08");
		labelMadeBy.setFont(font);
		
	}

	private void initSelectBox() {
		choice = new Choice();
		
		choice.add("NUMBER");
		choice.add("VARCHAR2");
		choice.add("DATE");
		choice.add("CHAR");
		choice.add("UNKNOWN_TYPE");
		
		choice.setLocation(SECOND_WIDTH_POS+150, 70);
		choice.setSize(80,80);
	}
}