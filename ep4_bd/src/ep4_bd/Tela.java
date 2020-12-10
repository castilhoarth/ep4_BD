package ep4_bd;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Tela extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton botao;
	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTextField NumMortos;
	private JTextField NumFeridos;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	//Frame CadConflitos
	
	public Tela() {
		setTitle("Cadastro de Conflitos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo: ");
		lblCodigo.setBounds(10, 59, 126, 17);
		contentPane.add(lblCodigo);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 87, 80, 14);
		contentPane.add(lblNome);
		
		JLabel lblCodPais = new JLabel("N\u00B0 Cod Pais:");
		lblCodPais.setBounds(10, 118, 80, 14);
		contentPane.add(lblCodPais);
		
		JLabel lblQuantidadeDeGols = new JLabel("Quantidade de Gols:");
		lblQuantidadeDeGols.setBounds(10, 143, 137, 14);
		contentPane.add(lblQuantidadeDeGols);
		
		JLabel lblNumMortos = new JLabel("NumMortos:");
		lblNumMortos.setBounds(10, 168, 126, 14);
		contentPane.add(lblNumMortos);
		
		JLabel lblNumFeridos = new JLabel("NumFeridos:");
		lblNumFeridos.setBounds(10, 34, 80, 14);
		contentPane.add(lblNumFeridos);
		
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(56, 31, 118, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		
		
		
		
	}
	

}