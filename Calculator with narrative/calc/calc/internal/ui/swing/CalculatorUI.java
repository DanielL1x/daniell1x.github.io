/*******************************************************************************
 * Copyright (C) 2010, Matthias Sohn <matthias.sohn@sap.com>
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.example.calc.internal.ui.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import org.eclipse.example.calc.Operations;
import org.eclipse.example.calc.internal.Calculator;
import org.eclipse.example.calc.internal.TextProvider;

/*
 * A simple calculator featuring a Swing UI.
 */
public class CalculatorUI extends JFrame implements TextProvider,
		ActionListener {
	private static final long serialVersionUID = 1L;

	private Calculator calculator;

	private JTextField display;

	private JPanel buttonsPanel;

	private JPanel numberButtonsPanel;

	private JPanel cmdButtonsPanel;

	private JButton numberButtons[];

	private JButton cmdButtons[];

	public static void main(String args[]) {
		new CalculatorUI().setVisible(true);
	}

	public CalculatorUI() {
		calculator = new Calculator(this);
		setupGUI();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	private void setupGUI() {
		setTitle(Calculator.NAME);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		setLocationByPlatform(true);

		setupDisplay(c);
		setupButtonsPanel(c);
		setupNumberButtons();
		setupCommandButtons();

		pack();
	}

	//getContentPane allows ability to add objects to container
	//Start up screen of calculator
	private void setupDisplay(Container c) {
		display = new JTextField("0");
		display.setHorizontalAlignment(JTextField.TRAILING);
		c.add(display, BorderLayout.NORTH);
		// initially clear the display
		calculator.setClearText(true);
	}

	//allows app to attach other components
	//Sets up layout for numbers and operands below
	private void setupButtonsPanel(Container c) {
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(2, 1));
		c.add(buttonsPanel);
	}

	//Set the way the numbers appear in GUI
	private void setupNumberButtons() {
		numberButtonsPanel = new JPanel();
		numberButtonsPanel.setLayout(new GridLayout(4, 3));
		buttonsPanel.add(numberButtonsPanel, BorderLayout.CENTER);
		numberButtons = new JButton[11];

		for (int i = 1; i < numberButtons.length - 1; i++) {
			addNumberButton(i, Integer.valueOf(i).toString());
		}
		addNumberButton(9, Integer.valueOf(0).toString());
		addNumberButton(0, ".");
		
	}

	private void addNumberButton(int i, String name) {
		numberButtons[i] = new JButton();
		numberButtons[i].setText(name);
		numberButtons[i].addActionListener(this);
		numberButtonsPanel.add(numberButtons[i]);
	}

	private void setupCommandButtons() {
		// command buttons
		cmdButtonsPanel = new JPanel();
		cmdButtonsPanel.setLayout(new GridLayout(4, 4));
		buttonsPanel.add(cmdButtonsPanel, BorderLayout.CENTER);
		TitledBorder title = BorderFactory.createTitledBorder("Operations");
		cmdButtonsPanel.setBorder(title);
		cmdButtons = new JButton[Operations.INSTANCE.size()];

		// make the buttons, set ActionListener and add to panel
		for (int i = 0; i < cmdButtons.length; i++) {
			addCommandButton(i);
		}
	}

	//Add the command buttons to interface 
	private void addCommandButton(int i) {
		cmdButtons[i] = new JButton();
		cmdButtons[i].setText(Operations.INSTANCE.getOperationName(i));
		cmdButtons[i].addActionListener(this);
		cmdButtonsPanel.add(cmdButtons[i]);
	}

	
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		calculator.handleButtonClick(str);
	}

	@Override
	public void setDisplayText(String text) {
		display.setText(text);
	}

	@Override
	public String getDisplayText() {
		return display.getText();
	}

}
