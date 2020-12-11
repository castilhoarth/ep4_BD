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

public class ListarTraficantes extends JFrame {

	private JPanel contentPane;
	private JTextField txtArma;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarTraficantes frame = new ListarTraficantes();
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
	public ListarTraficantes() {
		setTitle("Listar Traficantes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtArma.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Digite o nome da arma na caixa de texto!", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
				}
				else {
					try {
						Connection con;
						String userName = "root";
						String password = "";
						String url = "jdbc:mysql://127.0.0.1/bd_teste?useTimezone=true&serverTimezone=UTC";
						
						Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
						con = DriverManager.getConnection(url, userName, password);
						Statement st = con.createStatement();
					
						ResultSet rs = st.executeQuery("SELECT traficante.nome_traf,  FROM traficante INNER JOIN pode_fornecer ON traficante.nome_traf = pode_fornecer.nome_traf_fk  WHERE pode_fornecer.nome_arma_fk = 'm200%'");
						rs.next();
						
						//txtArma.setText(rs.getString("nome_traf"));
					
						
						st.close();
						//con.close();
					}
					catch(Exception event){
						JOptionPane.showMessageDialog(null, event, "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
						txtArma.setText("");
					}
				}
				
			}
		});
		btnNewButton.setBounds(301, 210, 89, 23);
		contentPane.add(btnNewButton);
		
		txtArma = new JTextField();
		txtArma.setHorizontalAlignment(SwingConstants.LEFT);
		txtArma.setBounds(80, 21, 86, 20);
		contentPane.add(txtArma);
		txtArma.setColumns(10);
		
		JLabel lblArma = new JLabel("Arma");
		lblArma.setBounds(10, 24, 34, 14);
		contentPane.add(lblArma);
	}
}
