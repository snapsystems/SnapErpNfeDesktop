package br.com.serviceassinador.view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
 
public class Principal extends JFrame{
	private JPanel content = new JPanel();
	
	private JTextArea textArea = new JTextArea();
	
	public Principal(){
		try{
			//Configuração Frame
			setTitle("NF-e");
			setBounds(450, 200, 500, 250);
			setBackground(Color.WHITE);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setResizable(true);

			content.setLayout(new FlowLayout());
			
			textArea.setColumns(30);
			textArea.setRows(10);
			textArea.setVisible(true);
			textArea.setEditable(false);
			textArea.setAutoscrolls(true);
			
			content.add(new JScrollPane(textArea));
			
			setContentPane(content);
			
			content.setVisible(true);
			
			setVisible(true);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public JPanel getContent() {
		return content;
	}

	public void setContent(JPanel content) {
		this.content = content;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}	
}
