package ep4_bd;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class CadGrupoArmado extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeGrupo;
	private JTextField txtCodigoG;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadGrupoArmado frame = new CadGrupoArmado();
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
	public CadGrupoArmado() {
		setTitle("Grupo Armado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCdGrupo = new JLabel("C\u00F3d. Grupo");
		lblCdGrupo.setBounds(10, 14, 55, 14);
		contentPane.add(lblCdGrupo);
		
		JLabel lblNome = new JLabel("Nome ");
		lblNome.setBounds(10, 47, 46, 14);
		contentPane.add(lblNome);
		
		txtNomeGrupo = new JTextField();
		txtNomeGrupo.setColumns(10);
		txtNomeGrupo.setBounds(116, 44, 86, 20);
		contentPane.add(txtNomeGrupo);
		
		txtCodigoG = new JTextField();
		txtCodigoG.setColumns(10);
		txtCodigoG.setBounds(116, 11, 86, 20);
		contentPane.add(txtCodigoG);
		
		JButton button = new JButton("Inserir");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcao;
		         Object[] BtSair={"Sim","Não"};
		         opcao = JOptionPane.showOptionDialog(null,"Deseja incluir esse registro?","Confirmação de Inclusão", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, BtSair, BtSair[0]);
		        if(opcao == JOptionPane.YES_OPTION) {
					try {
						Connection con;
						String userName = "root";
						String password = "";
						String url = "jdbc:mysql://127.0.0.1/bd_teste?useTimezone=true&serverTimezone=UTC";
						
						Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
						con = DriverManager.getConnection(url, userName, password);
						Statement st = con.createStatement();
						st.executeUpdate("INSERT INTO grupo_armado (codigo_g, nome_grupo) VALUES ('"+txtCodigoG.getText()+"','"+txtNomeGrupo.getText()+"')");
						
						st.close();
						con.close();
						JOptionPane.showMessageDialog(null, "Registro inserido com sucesso!");
						
						txtNomeGrupo.setText("");
						txtCodigoG.setText("");
					}
					catch(Exception event){
						JOptionPane.showMessageDialog(null, "Conexão não estabelecida"+event, ""+event, JOptionPane.ERROR_MESSAGE);
					}
		        }

			}
		});
		button.setBounds(10, 125, 89, 23);
		contentPane.add(button);
	}

}
