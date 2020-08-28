package br.edu.unicid.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JLabel lblLogin;
	private JLabel lblSenha;
	private JTextField txtLogin;
	private JTextField txtSenha;
	private JButton btnProximo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 269, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblLogin = new JLabel("Login");
		lblLogin.setBounds(30, 146, 46, 14);
		contentPane.add(lblLogin);

		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(30, 179, 46, 14);
		contentPane.add(lblSenha);

		txtLogin = new JTextField();
		txtLogin.setBounds(70, 143, 135, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);

		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(70, 176, 135, 20);
		contentPane.add(txtSenha);

		btnProximo = new JButton("Proximo");
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnProximo.setBounds(86, 228, 71, 55);
		contentPane.add(btnProximo);
	}
}
