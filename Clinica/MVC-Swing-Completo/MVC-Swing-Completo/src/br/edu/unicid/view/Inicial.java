package br.edu.unicid.view;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Image;

public class Inicial extends JFrame {

	private JPanel contentPane;
	private JButton btnEntrar;
	private JButton btnCadastrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicial frame = new Inicial();
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
	public Inicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 288, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login l = new Login();
				l.show();
			}
		});
		btnEntrar.setBounds(83, 260, 108, 23);
		contentPane.add(btnEntrar);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastrarCliente CC = new CadastrarCliente();
				CC.show();
			}
		});
		btnCadastrar.setBounds(83, 298, 108, 23);
		contentPane.add(btnCadastrar);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/icone.png")).getImage();
		Image imagemMenor = img.getScaledInstance(170, 170, 100);
		lblNewLabel.setIcon(new ImageIcon(imagemMenor));		
		lblNewLabel.setBounds(54, 51, 162, 177);
		contentPane.add(lblNewLabel);
	}
}
