import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class JesqueceuSenha {

	JFrame frame;
	private JTextField loginTF;
	private JLabel novaSenha;
	private JLabel cNovaSenha;
	private JLabel lblAltereASua;
	private JLabel lblDgitos;
	private JButton cancelar;
	private JButton confirmar;
	private JButton btnVerificar;
	static String aux = "", passAux = "", s, change;
	static String userAndPass[], senhaLogin = null;
	String local = System.getProperty("user.home");

	int passCount = 0;
	int loginaux = -1;
	private JPasswordField novaSenhaTF;
	private JPasswordField cNovaSenhaTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JesqueceuSenha window = new JesqueceuSenha();
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
	public JesqueceuSenha() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(local + "\\eclipse-workspace\\Agenda\\icones_imgs\\pixil-frame-0.png"));
		frame.setResizable(false);
		frame.setBounds(100, 100, 500, 350);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblAltereASua = new JLabel("Altere a sua senha:");
		lblAltereASua.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltereASua.setBounds(126, 11, 250, 40);
		lblAltereASua.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		frame.getContentPane().add(lblAltereASua);

		JLabel loginLB = new JLabel("Insira o login:");
		loginLB.setHorizontalAlignment(SwingConstants.RIGHT);
		loginLB.setBounds(105, 77, 100, 20);
		loginLB.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		frame.getContentPane().add(loginLB);

		loginTF = new JTextField();
		loginTF.setBounds(215, 77, 219, 22);
		loginTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				novaSenhaTF.setEnabled(false);
				cNovaSenhaTF.setEnabled(false);
				novaSenhaTF.setText("");
				cNovaSenhaTF.setText("");
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER && loginaux != loginTF.getText().length()) {
					btnVerificar.doClick();
					loginaux = loginTF.getText().length();
				}
			}
		});
		loginTF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frame.getContentPane().add(loginTF);
		loginTF.setColumns(10);

		btnVerificar = new JButton("Verificar");
		btnVerificar.setBounds(282, 110, 80, 25);
		btnVerificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Scanner scanner = new Scanner(new File("Logins"));
					if (scanner != null) {
						FileReader arq = new FileReader("Logins");
						BufferedReader lerArq = new BufferedReader(arq);
						boolean valido = false;
						while (true) {
							change = s = lerArq.readLine();
							if (s == null) {
								break;
							}
							String userAndPass[] = s.split(":");
							if ((loginTF.getText().matches(userAndPass[0]))) {
								valido = true;
								break;
							}
						}

						if (valido) {
							String usuarioEsenha[] = s.split(":");
							if (loginTF.getText().matches(usuarioEsenha[0])) {
								novaSenhaTF.setEnabled(true);
								senhaLogin = usuarioEsenha[1];
							}
						} else {
							JOptionPane.showMessageDialog(null, "Não existe esse usuário cadastrado.", "Login inválido",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				} catch (FileNotFoundException e2) {
					JOptionPane.showMessageDialog(null, "Não há usuários cadastrados ou não está cadastrado.",
							"Login inválido", JOptionPane.ERROR_MESSAGE);
					e2.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnVerificar);

		novaSenha = new JLabel("Insira a sua nova senha:");
		novaSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		novaSenha.setBounds(55, 152, 150, 20);
		novaSenha.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		frame.getContentPane().add(novaSenha);

		/*
		 * while(s!=null) { s = lerArq.readLine(); }
		 */

		novaSenhaTF = new JPasswordField();
		novaSenhaTF.setBounds(215, 154, 219, 20);
		novaSenhaTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				cNovaSenhaTF.setText("");
				if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) {
					passCount = 0;
					novaSenhaTF.setText("");
				} else if (e.getKeyCode() == KeyEvent.VK_0 || e.getKeyCode() == KeyEvent.VK_1
						|| e.getKeyCode() == KeyEvent.VK_2 || e.getKeyCode() == KeyEvent.VK_3
						|| e.getKeyCode() == KeyEvent.VK_4 || e.getKeyCode() == KeyEvent.VK_5
						|| e.getKeyCode() == KeyEvent.VK_6 || e.getKeyCode() == KeyEvent.VK_7
						|| e.getKeyCode() == KeyEvent.VK_8 || e.getKeyCode() == KeyEvent.VK_9
						|| e.getKeyCode() == KeyEvent.VK_NUMPAD0 || e.getKeyCode() == KeyEvent.VK_NUMPAD1
						|| e.getKeyCode() == KeyEvent.VK_NUMPAD2 || e.getKeyCode() == KeyEvent.VK_NUMPAD3
						|| e.getKeyCode() == KeyEvent.VK_NUMPAD4 || e.getKeyCode() == KeyEvent.VK_NUMPAD5
						|| e.getKeyCode() == KeyEvent.VK_NUMPAD6 || e.getKeyCode() == KeyEvent.VK_NUMPAD7
						|| e.getKeyCode() == KeyEvent.VK_NUMPAD8 || e.getKeyCode() == KeyEvent.VK_NUMPAD9) {
					passCount++;
					passAux = new String(novaSenhaTF.getPassword());
				} else if (!(e.getKeyCode() == KeyEvent.VK_0 || e.getKeyCode() == KeyEvent.VK_1
						|| e.getKeyCode() == KeyEvent.VK_2 || e.getKeyCode() == KeyEvent.VK_3
						|| e.getKeyCode() == KeyEvent.VK_4 || e.getKeyCode() == KeyEvent.VK_5
						|| e.getKeyCode() == KeyEvent.VK_6 || e.getKeyCode() == KeyEvent.VK_7
						|| e.getKeyCode() == KeyEvent.VK_8 || e.getKeyCode() == KeyEvent.VK_9
						|| e.getKeyCode() == KeyEvent.VK_NUMPAD0 || e.getKeyCode() == KeyEvent.VK_NUMPAD1
						|| e.getKeyCode() == KeyEvent.VK_NUMPAD2 || e.getKeyCode() == KeyEvent.VK_NUMPAD3
						|| e.getKeyCode() == KeyEvent.VK_NUMPAD4 || e.getKeyCode() == KeyEvent.VK_NUMPAD5
						|| e.getKeyCode() == KeyEvent.VK_NUMPAD6 || e.getKeyCode() == KeyEvent.VK_NUMPAD7
						|| e.getKeyCode() == KeyEvent.VK_NUMPAD8 || e.getKeyCode() == KeyEvent.VK_NUMPAD9)) {
					novaSenhaTF.setText(passAux);
				}
				if (passCount < 6 || passCount > 6) {
					novaSenhaTF.setBackground(Color.RED);
					cNovaSenhaTF.setEnabled(false);
				} else if (passCount == 6) {
					aux = new String(novaSenhaTF.getPassword());
					novaSenhaTF.setBackground(Color.WHITE);
					cNovaSenhaTF.setEnabled(true);
				}
			}
		});
		novaSenhaTF.setEnabled(false);
		frame.getContentPane().add(novaSenhaTF);
		lblDgitos = new JLabel("6 d\u00EDgitos");
		lblDgitos.setBounds(301, 180, 34, 11);
		lblDgitos.setFont(new Font("Tahoma", Font.PLAIN, 9));
		frame.getContentPane().add(lblDgitos);

		cNovaSenha = new JLabel("Confirme a sua nova senha:");
		cNovaSenha.setBounds(35, 221, 170, 20);
		cNovaSenha.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		frame.getContentPane().add(cNovaSenha);

		cancelar = new JButton("Cancelar");
		cancelar.setBounds(87, 265, 150, 30);
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});

		cNovaSenhaTF = new JPasswordField();
		cNovaSenhaTF.setBounds(215, 223, 219, 20);
		cNovaSenhaTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				passAux = new String((cNovaSenhaTF).getPassword());
				if (aux.equals(passAux)) {
					confirmar.setEnabled(true);
					for (int i = 0; i < s.length(); i++) {
						if (s.charAt(i) == ':') {
							s = s.replace(s.substring(i + 1, i + 7), aux);
						}
					}
					System.out.println("senha confirmada");
					novaSenhaTF.setBackground(Color.WHITE);
					cNovaSenhaTF.setBackground(Color.WHITE);
				} else {
					confirmar.setEnabled(false);
					novaSenhaTF.setBackground(Color.RED);
					cNovaSenhaTF.setBackground(Color.RED);
				}
			}
		});
		cNovaSenhaTF.setEnabled(false);
		frame.getContentPane().add(cNovaSenhaTF);
		cancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frame.getContentPane().add(cancelar);

		confirmar = new JButton("Confirmar");
		confirmar.setBounds(247, 265, 150, 30);
		confirmar.setEnabled(false);
		confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Path loginsPath = Paths.get(System.getProperty("user.home"), "eclipse-workspace", "Agenda", "Logins");

				List<String> loginFileContent;

				try {
					loginFileContent = new ArrayList<>(Files.readAllLines(loginsPath));

					for (int i = 0; i < loginFileContent.size(); i++) {
						if (loginFileContent.get(i).equals(change)) {
							loginFileContent.set(i, s);
							break;
						}
					}

					Files.write(loginsPath, loginFileContent);

				} catch (IOException e) {
					e.printStackTrace();
				}

				Path usuarioPath = Paths.get(System.getProperty("user.home"), "eclipse-workspace", "Agenda",
						loginTF.getText());

				try {
					List<String> userFileContent = new ArrayList<>(Files.readAllLines(usuarioPath));
					for (int i = 0; i < userFileContent.size(); i++) {
						if (userFileContent.get(i).equals(senhaLogin)) {
							userFileContent.set(i, passAux);
							break;
						}
					}

					Files.write(usuarioPath, userFileContent);
					JOptionPane.showMessageDialog(null, "Senha alterada.", "Senha alterada",
							JOptionPane.INFORMATION_MESSAGE);
					frame.setVisible(false);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		confirmar.setFont(new Font("Tahoma", Font.BOLD, 12));
		frame.getContentPane().add(confirmar);
	}

}
