import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.text.AbstractDocument;
import javax.swing.text.Document;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cadastro {
	
	private JFrame frame;
	private JTextField JIDUsuario;
	private JTextField JNomeUsuario;
	private JTextField JEmail;
	private JLabel lblSenha;
	private JPasswordField passwordField;
	private JLabel lblConfirmeASenha;
	private JPasswordField passwordField_1;
	private JButton btnCadastrar;
	private JButton btnCancelar;
	private JButton btnVerificar;

	private boolean id = false;
	private boolean senha = false;
	private boolean email = false;
	private JLabel Dígitos;
	private String pSenha;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro window = new Cadastro();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Cadastro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 280, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 100, 20, 100, 30, 0};
		gridBagLayout.rowHeights = new int[]{120, 14, 20, 20, 14, 10, 20, 20, 0, 14, 20, 0, 30, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblUsuario = new JLabel("ID do Usu\u00E1rio");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 1;
		gbc_lblUsuario.gridy = 1;
		frame.getContentPane().add(lblUsuario, gbc_lblUsuario);
		
		JIDUsuario = new JTextField();
		JIDUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(JIDUsuario.getText().length()!=0) {
					btnVerificar.setEnabled(true);
				}
				else
					btnVerificar.setEnabled(false);
			}
		});
		JIDUsuario.setColumns(10);
		GridBagConstraints gbc_JIDUsuario = new GridBagConstraints();
		gbc_JIDUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_JIDUsuario.anchor = GridBagConstraints.NORTH;
		gbc_JIDUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_JIDUsuario.gridx = 1;
		gbc_JIDUsuario.gridy = 2;
		frame.getContentPane().add(JIDUsuario, gbc_JIDUsuario);
		((AbstractDocument) JIDUsuario.getDocument()).setDocumentFilter(new RandomValidator(10, false, false, true, false));
		
		
		btnVerificar = new JButton("Verificar");
		btnVerificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnVerificar.setEnabled(false);
		GridBagConstraints gbc_btnVerificar = new GridBagConstraints();
		gbc_btnVerificar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnVerificar.insets = new Insets(0, 0, 5, 5);
		gbc_btnVerificar.gridx = 3;
		gbc_btnVerificar.gridy = 2;
		frame.getContentPane().add(btnVerificar, gbc_btnVerificar);
		
		JLabel lblNomeDoUsurio = new JLabel("Nome do Usu\u00E1rio");
		GridBagConstraints gbc_lblNomeDoUsurio = new GridBagConstraints();
		gbc_lblNomeDoUsurio.gridwidth = 3;
		gbc_lblNomeDoUsurio.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNomeDoUsurio.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomeDoUsurio.gridx = 1;
		gbc_lblNomeDoUsurio.gridy = 4;
		frame.getContentPane().add(lblNomeDoUsurio, gbc_lblNomeDoUsurio);
		
		JNomeUsuario = new JTextField();
		JNomeUsuario.setEditable(false);
		JNomeUsuario.setColumns(10);
		GridBagConstraints gbc_JNomeUsuario = new GridBagConstraints();
		gbc_JNomeUsuario.gridwidth = 3;
		gbc_JNomeUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_JNomeUsuario.anchor = GridBagConstraints.NORTH;
		gbc_JNomeUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_JNomeUsuario.gridx = 1;
		gbc_JNomeUsuario.gridy = 5;
		frame.getContentPane().add(JNomeUsuario, gbc_JNomeUsuario);
		((AbstractDocument) JNomeUsuario.getDocument()).setDocumentFilter(new RandomValidator(30, false, false, true, false,
				' ', 'á', 'é', 'í', 'ó', 'ú', 'ã', 'õ', 'â', 'ê', 'î', 'ô', 'û', 'ä', 'ë', 'ï', 'ö', 'ü', 'ç', 'ñ', '&', '-', '.'));
		
		JLabel lblEmail = new JLabel("E-mail");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.gridwidth = 3;
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 7;
		frame.getContentPane().add(lblEmail, gbc_lblEmail);
		
		JEmail = new JTextField();
		JEmail.setEditable(false);
		JEmail.setColumns(10);
		GridBagConstraints gbc_JEmail = new GridBagConstraints();
		gbc_JEmail.gridwidth = 3;
		gbc_JEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_JEmail.insets = new Insets(0, 0, 5, 5);
		gbc_JEmail.anchor = GridBagConstraints.NORTH;
		gbc_JEmail.gridx = 1;
		gbc_JEmail.gridy = 8;
		frame.getContentPane().add(JEmail, gbc_JEmail);
		((AbstractDocument) JEmail.getDocument()).setDocumentFilter(new RandomValidator(30, true, true, true, false, '@', '-', '_', '.'));
		
		lblSenha = new JLabel("Senha");
		GridBagConstraints gbc_lblSenha = new GridBagConstraints();
		gbc_lblSenha.anchor = GridBagConstraints.WEST;
		gbc_lblSenha.insets = new Insets(0, 0, 5, 5);
		gbc_lblSenha.gridx = 1;
		gbc_lblSenha.gridy = 10;
		frame.getContentPane().add(lblSenha, gbc_lblSenha);
		
		lblConfirmeASenha = new JLabel("Confirme a senha");
		GridBagConstraints gbc_lblConfirmeASenha = new GridBagConstraints();
		gbc_lblConfirmeASenha.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfirmeASenha.gridx = 3;
		gbc_lblConfirmeASenha.gridy = 10;
		frame.getContentPane().add(lblConfirmeASenha, gbc_lblConfirmeASenha);
		
		passwordField = new JPasswordField();
		passwordField.setEditable(false);
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				pSenha = passwordField.getText();
				if(pSenha.length() == 6) {
					passwordField_1.setEditable(true);
					Dígitos.setVisible(false);
				}
				else {
					passwordField_1.setEditable(false);
					Dígitos.setVisible(true);
				}
			}
		});
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 11;
		frame.getContentPane().add(passwordField, gbc_passwordField);
		((AbstractDocument) passwordField.getDocument()).setDocumentFilter(new RandomValidator(6, true, false, false, false));
		
		passwordField_1 = new JPasswordField();
		passwordField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String pcSenha = passwordField_1.getText();
				if(pcSenha.equals(pSenha)){
					senha = true;
					passwordField_1.setBackground(Color.WHITE);
				}
				else {
					passwordField_1.setBackground(Color.RED);
					senha = false;
				}
			}
		});
		passwordField_1.setEditable(false);
		GridBagConstraints gbc_passwordField_1 = new GridBagConstraints();
		gbc_passwordField_1.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField_1.gridx = 3;
		gbc_passwordField_1.gridy = 11;
		frame.getContentPane().add(passwordField_1, gbc_passwordField_1);
		((AbstractDocument) passwordField_1.getDocument()).setDocumentFilter(new RandomValidator(6, true, false, false, false));
		
		Dígitos = new JLabel("6 D\u00EDgitos");
		Dígitos.setForeground(Color.GRAY);
		Dígitos.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GridBagConstraints gbc_Dígitos = new GridBagConstraints();
		gbc_Dígitos.anchor = GridBagConstraints.NORTH;
		gbc_Dígitos.insets = new Insets(0, 0, 5, 5);
		gbc_Dígitos.gridx = 1;
		gbc_Dígitos.gridy = 12;
		frame.getContentPane().add(Dígitos, gbc_Dígitos);
		
		btnCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 1;
		gbc_btnCancelar.gridy = 13;
		frame.getContentPane().add(btnCancelar, gbc_btnCancelar);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setEnabled(false);
		GridBagConstraints gbc_btnCadastrar = new GridBagConstraints();
		gbc_btnCadastrar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCadastrar.gridx = 3;
		gbc_btnCadastrar.gridy = 13;
		frame.getContentPane().add(btnCadastrar, gbc_btnCadastrar);
	}

}
