package com.ktds.chrisof.listener;

import java.awt.TextField;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class TextFieldListener 
implements FocusListener{
	
	private TextField textField;
	
	public TextFieldListener(TextField textField) {
		this.textField = textField;
	}
	@Override
	public void focusGained(FocusEvent e) {
		this.textField.selectAll();
	}

	@Override
	public void focusLost(FocusEvent e) {
	}
}
