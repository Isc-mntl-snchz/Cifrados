package Cesar;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
/**
 * @class Cifrado Cesar 
 * @autor Isaac Montiel Y Salvador Ramos
 * @descrip esta clase convierte una cadena o texto en el cifrado Cesar 
 * 
 */

public class Cesar 
{
	JFrame appWindow = new JFrame();
	JLabel tituloApp , numLettras
	JRadioButton optCifrar = new JRadioButton("Cifrar",true);
	JRadioButton optDescifrar = new JRadioButton("Decifrar",false);
 
	
	public Cesar() 
	{
		
		tituloApp = new JLabel();
		tituloApp.setText(" CIFRADO CESAR ");
		tituloApp.setFont(new Font("Serif",Font.BOLD,30));
		tituloApp.setForeground(Color.white);
		tituloApp.setBounds(130, 10, 480, 25);
		
		labelLetras = new JLabel();
		labelLetras.setText(" Saltos ");
		labelLetras.setForeground(Color.white);
		labelLetras.setFont(new Font("Serif",Font.BOLD,20));
		labelLetras.setBounds(50, 50, 150, 25);
		
		numLetras = new JTextField(20);
		numLetras.setBounds(120, 50, 200, 25);
		numLetras.setFont(new Font("Serif",Font.BOLD,20));
		
		optCifrar.setBounds(340, 50, 100, 25);
		optCifrar.setText(" Cifrar ");
		optCifrar.setForeground(Color.white);
		optCifrar.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e){    
						if(optCifrar.isSelected()){    
							btnCifrar.setText( " Cifrar " );
						}    
						if(optDescifrar.isSelected()){    
							btnCifrar.setText(" Descifrar ");    
						}    
					}   	
				}
		);
		optDescifrar.setText(" Descifrar ");
		optDescifrar.setForeground(Color.white);
		optDescifrar.setBounds(500, 50, 100, 25);
		optDescifrar.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e){    
						if(optCifrar.isSelected()){    
							btnCifrar.setText( " Cifrar " );
						}    
						if(optDescifrar.isSelected()){    
							btnCifrar.setText(" Descifrar ");    
						}    
					}   	
				}
		);
		
		ButtonGroup OpcionesGrupo = new ButtonGroup();
		
		OpcionesGrupo.add(optCifrar);
		OpcionesGrupo.add(optDescifrar);
		
		
		labelInputText = new JLabel();
		labelInputText.setText(" Ingrese su mensaje ");
		labelInputText.setForeground(Color.white);
		labelInputText.setBounds(50, 80, 400, 25);
		labelInputText.setFont(new Font("Serif",Font.BOLD,20));
		
		texto = new JTextArea();
		texto.setBounds(50, 110 , 400,200);
		texto.setEditable(true);
		
		
		btnCifrar = new JButton(" Cifrar ");
		btnCifrar.setFont(new Font("Serif",Font.BOLD,20));
		btnCifrar.setBounds(50, (texto.getLocation().y+220) , 400,35);
		btnCifrar.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						String num = numLetras.getText();
						String mensaje = texto.getText();
						int menLong = mensaje.length();
						
						if(isNumber(num)) 
						{	
							int i = Integer.parseInt(num) ;
							if(i >0  && i <= (abcTotal) ) 
							{
								if(mensaje.isEmpty()) {
									JOptionPane.showMessageDialog(null," Mensaje invalido ");
								}else {
									msgCifrado.setText(cifrar(mensaje,i));
									JOptionPane.showMessageDialog(null," Mensaje Cifrado ");
								}
							}else{
								JOptionPane.showMessageDialog(null," Ingrese un numero en un rango de 1 a " + abcTotal );
							}
						}else{
							JOptionPane.showMessageDialog(null," Ingrese un numero en un rango de 1 a " + abcTotal );
						}
					}
				}
		);
		
		msgCifrado = new JTextArea();
		msgCifrado.setBounds((texto.getLocation().x+420), (texto.getLocation().y) , 400,200);
		msgCifrado.setEditable(true);
		
		appWindow = new JFrame(" CESAR ");
		appWindow.setBounds(100, 50, 1024, 500);
		appWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		appWindow.getContentPane().setBackground( Color.BLACK );
		appWindow.setVisible(true);
		appWindow.getContentPane().setLayout(null);
		
		
		appWindow.add(tituloApp);
		appWindow.add(labelLetras);
		appWindow.add(numLetras);
		appWindow.add(labelInputText);
		appWindow.add(texto);
		appWindow.add(btnCifrar);
		appWindow.add(msgCifrado); 
		appWindow.add(optCifrar);
		appWindow.add(optDescifrar);
				
	}
	 
	
	public boolean isNumber(String n) {
		try {
			int ee = Integer.parseInt(n);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public void printl(String texto)
	{
		System.out.println(texto);
	}
	
	public String cifrar(String mensaje,int brincos) 
	{
		String cifrando="";
		for(char let : mensaje.toCharArray()) 
		{
			if(!isNumber(let+"") && (let!='\n') && (let!='\t') && (let!=' ')) 
			{
				int index = charEnArray(let,ABC);
				if(index > -1)
				{	
					int dex = index+brincos;
					cifrando = cifrando+ returnChCryp(dex);					
				}
			}else {
				cifrando = cifrando+let;
			}
			
		}
		return cifrando;
	}
	
	public int charEnArray(char ch, char array[]) 
	{
		int i=0;
		for(char chIter: array) 
		{
			if(chIter == ch)
			{
				UPPER= true;
				return i;
			}
			char lowerChar = Character.toLowerCase(chIter);
			if(lowerChar == ch ) 
			{
				UPPER= false;
				return i;	
			}
			i++;
		}

		return -1;
	}
	public char returnChCryp(int index )
	{
		
		if(index > (ABC.length-1)) 
		{
			int i = index-(ABC.length-1);
			return ABC[i-1];
			
		}else {
			return ABC[index];
		}
	}
	
	
}
