import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
	private JFrame frmMagenda;
	private JTextField textField;
	private JLabel lblSenha;
	private JPasswordField passwordField;
	private JLabel lblSair;
	
	private static ArrayList<Agenda> listaAgendas;
	private Cadastro cadastro; 
	private Arquivo arquivo;
	private Scanner scanner;
	private static File Login;
	private Path loginPath;
	private Path usuarioPath;
	private List<String> loginFileContent;
	private List<String> usuarioFileContent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmMagenda.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		this.listaAgendas = new ArrayList<Agenda>();
		
		initialize();
		
	}

	public void antiinitialize() {
		loginPath = Paths.get(System.getProperty("user.home"), "eclipse-workspace", "Agenda",
				"Logins");
		try {
			loginFileContent = new ArrayList<>(Files.readAllLines(loginPath));
			for(String allLogin : loginFileContent) {
				usuarioPath = Paths.get(System.getProperty("user.home"), "eclipse-workspace", "Agenda",
						allLogin);
				usuarioFileContent = new ArrayList<>(Files.readAllLines(usuarioPath));
				String id, nome, email, senha;
				Usuario usuario;
				Agenda agenda;
				id = usuarioFileContent.get(0);
				nome = usuarioFileContent.get(1);
				email = usuarioFileContent.get(2);
				senha = usuarioFileContent.get(3);
				usuario = new Usuario(id, nome, email, senha);
				
			}
		}catch(NullPointerException g) {
			JOptionPane.showMessageDialog(null,
		        "Não há usuários cadastros! Para inicializar a Agenda, cadastre-se!",
		        "Não há usuários cadastros!",
		        JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
		        "Não há usuários cadastros! Para inicializar a Agenda, cadastre-se!",
		        "Não há usuários cadastros!",
		        JOptionPane.ERROR_MESSAGE);
		}

	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMagenda = new JFrame();
		frmMagenda.setTitle("Magenda");
		frmMagenda.setBounds(100, 100, 400, 460);
		frmMagenda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		lblSenha = new JLabel("Senha");
		
		passwordField = new JPasswordField();
		
		JButton btnEntrar = new JButton("Entrar");
		
		JLabel lblEsqueceuASenha = new JLabel("Esqueceu a senha?");
		lblEsqueceuASenha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEsqueceuASenha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblEsqueceuASenha.setFont(new Font("Tahoma", Font.BOLD, 11));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblEsqueceuASenha.setFont(new Font("Tahoma", Font.PLAIN, 11));
			}
		});
		
		JButton btnCadastro = new JButton("Cadastro");
		btnCadastro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cadastro cadastro = new Cadastro();
				cadastro.main(null);
			}
		});
		
		lblSair = new JLabel("Sair");
		lblSair.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton debug = new JButton("Debug");
		debug.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					for(Agenda lista : listaAgendas) {					
						System.out.println(lista.getUsuario());
					}
				}catch (NullPointerException e1){
					System.out.println("Não há usuários");
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmMagenda.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addComponent(lblUsurio, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
					.addGap(154))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(lblSair, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(108)
					.addComponent(debug, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCadastro, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addGap(32))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblEsqueceuASenha)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblSenha)
							.addGap(25)
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(btnEntrar, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(240)
							.addComponent(lblUsurio))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(237)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(4)
									.addComponent(lblSenha))
								.addComponent(btnEntrar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(19)
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(2)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblEsqueceuASenha)
					.addGap(58)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(7)
							.addComponent(lblSair))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnCadastro)
							.addComponent(debug)))
					.addGap(23))
		);
		frmMagenda.getContentPane().setLayout(groupLayout);
	}

	public static ArrayList<Agenda> getListaAgendas() {
		return listaAgendas;
	}
}
