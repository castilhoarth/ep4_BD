package ep4_bd;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.ParseException;
import javax.swing.*;

public class CadConflito extends JFrame {

	private JPanel contentPane;
	private JTextField txtCod;
	private JTextField txtNome;
	private JTextField txtCodPais;
	private JTextField txtNMortos;
	private JTextField txtNFeridos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadConflito frame = new CadConflito();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadConflito() {
		setTitle("Cadastro de Conflito");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCod = new JLabel("C\u00F3digo");
		lblCod.setBounds(10, 21, 46, 14);
		contentPane.add(lblCod);
		
		txtCod = new JTextField();
		txtCod.setBounds(69, 18, 28, 20);
		contentPane.add(txtCod);
		txtCod.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 55, 46, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(69, 52, 86, 20);
		contentPane.add(txtNome);
		
		JLabel lblCodPais = new JLabel("Cod pais");
		lblCodPais.setBounds(10, 88, 46, 14);
		contentPane.add(lblCodPais);
		
		txtCodPais = new JTextField();
		lblCodPais.setLabelFor(txtCodPais);
		txtCodPais.setColumns(10);
		txtCodPais.setBounds(69, 83, 86, 20);
		contentPane.add(txtCodPais);
		
		JLabel lblNumMortos = new JLabel("N. Mortos");
		lblNumMortos.setBounds(9, 113, 47, 14);
		contentPane.add(lblNumMortos);
		
		JLabel lblNumFeridos = new JLabel("N. Feridos");
		lblNumFeridos.setBounds(10, 151, 57, 14);
		contentPane.add(lblNumFeridos);
		
		txtNMortos = new JTextField();
		txtNMortos.setColumns(10);
		txtNMortos.setBounds(69, 114, 86, 20);
		contentPane.add(txtNMortos);
		
		txtNFeridos = new JTextField();
		txtNFeridos.setColumns(10);
		txtNFeridos.setBounds(69, 148, 86, 20);
		contentPane.add(txtNFeridos);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e){
				int opcao;
		         Object[] BtSair={"Sim","Não"};
		         opcao = JOptionPane.showOptionDialog(null,"Deseja incluir esse registro?","Confirmação de Inclusão", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, BtSair, BtSair[0]);
		        if(opcao == JOptionPane.YES_OPTION) {
					try {
						Connection con;
						String userName = "root";
						String password = "";
						String url = "jdbc:mysql://127.0.0.1/bd_teste";
						
						Class.forName("com.mysql.jdbc.Driver").newInstance();
						con = DriverManager.getConnection(url, userName, password);
						Statement st = con.createStatement();
						st.executeUpdate("INSERT INTO conflito (codigo, nome, cod_pais, n_mortos, n_feridos) VALUES ('"+txtCod.getText()+"','"+txtNome.getText()+"','"+txtCodPais.getText()+"','"+txtNMortos.getText()+"','"+txtNFeridos.getText()+"','"+txtNMortos.getText()+"')");
						
						st.close();
						con.close();
						JOptionPane.showMessageDialog(null, "Registro inserido com sucesso!");
						
						txtCod.setText("");
						txtNome.setText("");
						txtCodPais.setText("");
						txtNFeridos.setText("");
						txtNMortos.setText("");
					}
					catch(Exception event){
						JOptionPane.showMessageDialog(null, "Conexão não estabelecida", ""+event, JOptionPane.ERROR_MESSAGE);
					}
		        }
			}
		});
		btnInserir.setBounds(209, 147, 89, 23);
		contentPane.add(btnInserir);
	}
}
