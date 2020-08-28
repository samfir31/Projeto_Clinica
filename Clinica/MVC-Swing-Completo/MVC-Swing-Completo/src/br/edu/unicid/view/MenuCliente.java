package br.edu.unicid.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.unicid.bean.Clinica;
import br.edu.unicid.dao.ClinicaDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import datechooser.beans.DateChooserCombo;
import javax.swing.ImageIcon;

public class MenuCliente extends JFrame {

	private JPanel contentPane;
	private final JInternalFrame internalFrame = new JInternalFrame("Cadastro Dentista");
	private JLabel label;
	private JTextField txtNome;
	private JTextField txtCPF;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JRadioButton rdbMasculino;
	private JRadioButton rdbFeminino;
	private JTextField txtEspecialidade;
	private JLabel lblEspecializao;
	private JTextField txtEndereco;
	private JTextField txtComplemento;
	private JTextField txtTelRes;
	private JTextField txtTelCel;
	private JTextField txtEmail;
	private JLabel lblCadastroDentista;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private JButton btnCadastrarDentista;
	private DateChooserCombo txtDtaNasc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuCliente frame = new MenuCliente();
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
	public MenuCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		internalFrame.setBounds(519, 51, 545, 413);
		contentPane.add(internalFrame);
		internalFrame.setClosable(true);// Se o frame vai poder ser fechado pelo botão fechar
		internalFrame.setIconifiable(true);// Se o frame vai poder ser minimizado.
		internalFrame.setResizable(true);// Pemite editar o tamanho.
		internalFrame.setVisible(false);
		internalFrame.getContentPane().setLayout(null);

		label = new JLabel("Nome:");
		label.setBounds(10, 57, 46, 14);
		internalFrame.getContentPane().add(label);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(87, 54, 135, 20);
		internalFrame.getContentPane().add(txtNome);

		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		txtCPF.setBounds(87, 80, 135, 20);
		internalFrame.getContentPane().add(txtCPF);

		label_1 = new JLabel("CPF");
		label_1.setBounds(10, 83, 46, 14);
		internalFrame.getContentPane().add(label_1);

		label_2 = new JLabel("Data de nasc:");
		label_2.setBounds(10, 108, 85, 14);
		internalFrame.getContentPane().add(label_2);

		label_3 = new JLabel("Sexo:");
		label_3.setBounds(10, 133, 46, 14);
		internalFrame.getContentPane().add(label_3);

		rdbMasculino = new JRadioButton("Masculino");
		rdbMasculino.setBounds(77, 129, 85, 23);
		internalFrame.getContentPane().add(rdbMasculino);

		rdbFeminino = new JRadioButton("Feminino");
		rdbFeminino.setBounds(164, 129, 98, 23);
		internalFrame.getContentPane().add(rdbFeminino);

		txtEspecialidade = new JTextField();
		txtEspecialidade.setColumns(10);
		txtEspecialidade.setBounds(87, 155, 135, 20);
		internalFrame.getContentPane().add(txtEspecialidade);

		lblEspecializao = new JLabel("Especialização");
		lblEspecializao.setBounds(10, 158, 60, 14);
		internalFrame.getContentPane().add(lblEspecializao);

		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(87, 180, 135, 20);
		internalFrame.getContentPane().add(txtEndereco);

		txtComplemento = new JTextField();
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(87, 211, 135, 20);
		internalFrame.getContentPane().add(txtComplemento);

		txtTelRes = new JTextField();
		txtTelRes.setColumns(10);
		txtTelRes.setBounds(87, 236, 135, 20);
		internalFrame.getContentPane().add(txtTelRes);

		txtTelCel = new JTextField();
		txtTelCel.setColumns(10);
		txtTelCel.setBounds(87, 259, 135, 20);
		internalFrame.getContentPane().add(txtTelCel);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(87, 281, 135, 20);
		internalFrame.getContentPane().add(txtEmail);

		lblCadastroDentista = new JLabel("Cadastro Dentista");
		lblCadastroDentista.setBounds(185, 11, 155, 14);
		internalFrame.getContentPane().add(lblCadastroDentista);

		button = new JButton("Cadastrar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Clinica clinica = new Clinica();
					clinica.setNomeDentista(txtNome.getText());
					clinica.setDentistaCPF(Integer.parseInt(txtCPF.getText()));
					clinica.setDtaNasc(txtDtaNasc.getText());
					clinica.setEspecialidade(txtEspecialidade.getText());
					clinica.setEndereco(txtEndereco.getText());
					clinica.setComplemento(txtComplemento.getText());
					clinica.setTelRes(txtTelRes.getText());
					clinica.setTelCel(txtTelCel.getText());					
					Boolean SEXO_ALU = null;
					if (rdbMasculino.isSelected()) {
						SEXO_ALU = false;
					}
					if (rdbFeminino.isSelected()) {
						SEXO_ALU = true;
					}
					clinica.setSexo(SEXO_ALU);

					// chamar a classe AlunoDAO
					ClinicaDAO dao = new ClinicaDAO();
					dao.salvarDentista(clinica);
					JOptionPane.showMessageDialog(null, "Salvo com sucesso");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		button.setBounds(280, 53, 119, 23);
		internalFrame.getContentPane().add(button);

		button_1 = new JButton("Atualizar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clinica clinica = new Clinica();
				clinica.setNomeDentista(txtNome.getText());
				clinica.setDentistaCPF(Integer.parseInt(txtCPF.getText()));
				clinica.setDtaNasc(txtDtaNasc.getText());
				Boolean SEXO_ALU = null;
				if (rdbMasculino.isSelected()) {
					SEXO_ALU = false;
				}
				if (rdbFeminino.isSelected()) {
					SEXO_ALU = true;
				}
				clinica.setSexo(SEXO_ALU);
				clinica.setEspecialidade(txtEspecialidade.getText());
				clinica.setEndereco(txtEndereco.getText());
				clinica.setComplemento(txtComplemento.getText());
				clinica.setTelRes(txtTelRes.getText());
				clinica.setTelCel(txtTelCel.getText());				
				try {
					// chamar a classe AlunoDAO
					ClinicaDAO dao = new ClinicaDAO();
					dao.atualizarDentista(clinica);
					JOptionPane.showMessageDialog(null, "Alterado com sucesso");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		button_1.setBounds(280, 79, 119, 23);
		internalFrame.getContentPane().add(button_1);

		button_2 = new JButton("Excluir");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ClinicaDAO dao = new ClinicaDAO();
					int ca = Integer.parseInt(txtCPF.getText());
					dao.excluirDentista(ca);
					JOptionPane.showMessageDialog(null, "Excluido");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		button_2.setBounds(280, 104, 119, 23);
		internalFrame.getContentPane().add(button_2);

		label_6 = new JLabel("Endereço:");
		label_6.setBounds(10, 183, 60, 14);
		internalFrame.getContentPane().add(label_6);

		label_7 = new JLabel("Complemento:");
		label_7.setBounds(10, 209, 75, 14);
		internalFrame.getContentPane().add(label_7);

		label_8 = new JLabel("Tel. Residencial:");
		label_8.setBounds(10, 234, 85, 14);
		internalFrame.getContentPane().add(label_8);

		label_9 = new JLabel("Tel. Celular:");
		label_9.setBounds(10, 259, 60, 14);
		internalFrame.getContentPane().add(label_9);

		label_10 = new JLabel("E-mail:");
		label_10.setBounds(10, 284, 46, 14);
		internalFrame.getContentPane().add(label_10);
		
		txtDtaNasc = new DateChooserCombo();
		txtDtaNasc.setBounds(87, 111, 155, 20);
		internalFrame.getContentPane().add(txtDtaNasc);

		JButton btnCCliente = new JButton("\r\nCliente");
		btnCCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarCliente cc = new CadastrarCliente();
				cc.show();
			}
		});
		btnCCliente.setBounds(289, 296, 99, 100);
		contentPane.add(btnCCliente);

		JButton btnAgendar = new JButton("Agendar");
		btnAgendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgendarConsulta ag = new AgendarConsulta();
				ag.show();
			}
		});
		btnAgendar.setBounds(44, 296, 100, 100);
		contentPane.add(btnAgendar);

		btnCadastrarDentista = new JButton("Dentista");
		btnCadastrarDentista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				internalFrame.setVisible(true);
			}
		});
		btnCadastrarDentista.setBounds(168, 296, 99, 100);
		contentPane.add(btnCadastrarDentista);
		
		ImageIcon icon = new ImageIcon("C:\\Users\\Samuel\\Desktop\\MVC-Swing-Completo\\Imagem\\icone.png"); //Somente esta linha foi alterada
		icon.setImage(icon.getImage().getScaledInstance(10, 10, 100));		
		JLabel iconImagem = new JLabel("");		
		iconImagem.setIcon(icon);		
		iconImagem.setBounds(76, 11, 405, 396);
		contentPane.add(iconImagem);

	}
}
