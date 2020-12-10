package ep4_bd;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CadLiderPolitico extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeL;
	private JTextField txtApoios;
	private JTextField txtCodGrupoArmado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadLiderPolitico frame = new CadLiderPolitico();
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
	public CadLiderPolitico() {
		setTitle("Cadastro de L\u00EDder Pol\u00EDtico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeL = new JLabel("Nome L\u00EDder");
		lblNomeL.setBounds(10, 25, 53, 14);
		contentPane.add(lblNomeL);
		
		JLabel lblApoios = new JLabel("Apoios");
		lblApoios.setBounds(10, 58, 46, 14);
		contentPane.add(lblApoios);
		
		JLabel lblCodGrupoArmado = new JLabel("C\u00F3d. Grupo Armado");
		lblCodGrupoArmado.setBounds(10, 93, 95, 14);
		contentPane.add(lblCodGrupoArmado);
		
		txtNomeL = new JTextField();
		txtNomeL.setBounds(116, 22, 86, 20);
		contentPane.add(txtNomeL);
		txtNomeL.setColumns(10);
		
		txtApoios = new JTextField();
		txtApoios.setBounds(116, 55, 86, 20);
		contentPane.add(txtApoios);
		txtApoios.setColumns(10);
		
		txtCodGrupoArmado = new JTextField();
		txtCodGrupoArmado.setBounds(116, 90, 86, 20);
		contentPane.add(txtCodGrupoArmado);
		txtCodGrupoArmado.setColumns(10);
	}
}
