package br.edu.unicid.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import br.edu.unicid.bean.Clinica;
import br.edu.unicid.dao.ClinicaDAO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;
import datechooser.beans.DateChooserCombo;
import datechooser.view.WeekDaysStyle;
import datechooser.model.multiple.MultyModelBehavior;

public class CadastrarCliente extends JFrame {

	private JPanel contentPane;
	private JLabel lblNome;
	private JLabel lblCpf;
	private JLabel lblDataDeNasc;
	private JLabel lblSexo;
	private JLabel lblProfisso;
	private JLabel lblEndereo;
	private JLabel lblComplemento;
	private JLabel lblTelResidencial;
	private JLabel lblTelCelular;
	private JLabel lblEmail;
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtProfissao;
	private JTextField txtEndereco;
	private JTextField txtComplemento;
	private JTextField txtTelRes;
	private JTextField txtTelCel;
	private JTextField txtEmail;
	private JLabel lblCadastro;
	private JButton btnCadastrar;
	private JRadioButton rdbMasculino;
	private JRadioButton rdbFeminino;
	private ButtonGroup bg = new ButtonGroup();
	private JTable tbCliente;
	private JButton btnRefresh;
	private JScrollPane scrollPane;
	private JButton button;
	private JButton btnExcluir;
	private JButton btnProcurar;
	private JScrollPane scrollPane_1;
	private DateChooserCombo txtDtaNasc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarCliente frame = new CadastrarCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) tbCliente.getModel();
		modelo.setNumRows(0);
		try {
			ClinicaDAO clinidao = new ClinicaDAO();
			for (Clinica c : clinidao.ler()) {
				modelo.addRow(new Object[] { c.getNomeCliente(), c.getClienteCPF(), c.getDtaNasc(), c.getSexo(),
						c.getProfissao(), c.getEndereco(), c.getComplemento(), c.getTelRes(), c.getTelCel(),
						c.getEmail(), });

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */

	public CadastrarCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		contentPane.setLayout(null);
		rdbFeminino = new JRadioButton("Feminino");
		rdbFeminino.setBounds(176, 140, 98, 23);
		contentPane.add(rdbFeminino);

		lblNome = new JLabel("Nome:");
		lblNome.setBounds(22, 68, 46, 14);
		contentPane.add(lblNome);

		lblCpf = new JLabel("CPF");
		lblCpf.setBounds(22, 94, 46, 14);
		contentPane.add(lblCpf);

		lblDataDeNasc = new JLabel("Data de nasc:");
		lblDataDeNasc.setBounds(22, 119, 85, 14);
		contentPane.add(lblDataDeNasc);

		lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(22, 144, 46, 14);
		contentPane.add(lblSexo);

		lblProfisso = new JLabel("Profissão:");
		lblProfisso.setBounds(22, 169, 60, 14);
		contentPane.add(lblProfisso);

		lblEndereo = new JLabel("Endereço:");
		lblEndereo.setBounds(280, 68, 60, 14);
		contentPane.add(lblEndereo);

		lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(280, 94, 75, 14);
		contentPane.add(lblComplemento);

		lblTelResidencial = new JLabel("Tel. Residencial:");
		lblTelResidencial.setBounds(280, 119, 85, 14);
		contentPane.add(lblTelResidencial);

		lblTelCelular = new JLabel("Tel. Celular:");
		lblTelCelular.setBounds(280, 144, 60, 14);
		contentPane.add(lblTelCelular);

		lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(296, 172, 46, 14);
		contentPane.add(lblEmail);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(99, 65, 135, 20);
		contentPane.add(txtNome);

		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		txtCPF.setBounds(99, 91, 135, 20);
		contentPane.add(txtCPF);

		txtProfissao = new JTextField();
		txtProfissao.setColumns(10);
		txtProfissao.setBounds(99, 166, 135, 20);
		contentPane.add(txtProfissao);

		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(366, 65, 135, 20);
		contentPane.add(txtEndereco);

		txtComplemento = new JTextField();
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(366, 91, 135, 20);
		contentPane.add(txtComplemento);

		txtTelRes = new JTextField();
		txtTelRes.setColumns(10);
		txtTelRes.setBounds(366, 116, 135, 20);
		contentPane.add(txtTelRes);

		txtTelCel = new JTextField();
		txtTelCel.setColumns(10);
		txtTelCel.setBounds(366, 141, 135, 20);
		contentPane.add(txtTelCel);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(366, 166, 135, 20);
		contentPane.add(txtEmail);

		lblCadastro = new JLabel("Cadastro Cliente");
		lblCadastro.setBounds(280, 22, 95, 14);
		contentPane.add(lblCadastro);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Clinica clinica = new Clinica();
					clinica.setNomeCliente(txtNome.getText());
					clinica.setClienteCPF(Integer.parseInt(txtCPF.getText()));
					clinica.setDtaNasc(txtDtaNasc.getText());
					clinica.setProfissao(txtProfissao.getText());
					clinica.setEndereco(txtEndereco.getText());
					clinica.setComplemento(txtComplemento.getText());
					clinica.setTelRes(txtTelRes.getText());
					clinica.setTelCel(txtTelCel.getText());
					clinica.setEmail(txtEmail.getText());
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
					dao.salvar(clinica);
					JOptionPane.showMessageDialog(null, "Salvo com sucesso");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				readJTable();
			}

		});
		btnCadastrar.setBounds(521, 64, 119, 23);
		contentPane.add(btnCadastrar);

		rdbMasculino = new JRadioButton("Masculino");
		rdbMasculino.setBounds(89, 140, 85, 23);
		contentPane.add(rdbMasculino);
		bg.add(rdbFeminino);
		bg.add(rdbMasculino);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 212, 646, 201);
		contentPane.add(scrollPane_1);

		scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);

		tbCliente = new JTable();
		scrollPane.setViewportView(tbCliente);
		tbCliente.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "NomeCliente", "ClienteCPF",
				"DtaNasc", "Sexo", "Profissao", "Endereco", "Complemento", "TelRes", "TelCel", "Email" }));

		btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				readJTable();
			}
		});
		btnRefresh.setBounds(521, 90, 119, 23);
		contentPane.add(btnRefresh);

		button = new JButton("Atualizar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clinica clinica = new Clinica();
				clinica.setNomeCliente(txtNome.getText());
				clinica.setClienteCPF(Integer.parseInt(txtCPF.getText()));			
				clinica.setDtaNasc(txtDtaNasc.getText());
				Boolean SEXO_ALU = null;
				if (rdbMasculino.isSelected()) {
					SEXO_ALU = false;
				}
				if (rdbFeminino.isSelected()) {
					SEXO_ALU = true;
				}
				clinica.setSexo(SEXO_ALU);
				clinica.setProfissao(txtProfissao.getText());
				clinica.setEndereco(txtEndereco.getText());
				clinica.setComplemento(txtComplemento.getText());
				clinica.setTelRes(txtTelRes.getText());
				clinica.setTelCel(txtTelCel.getText());
				clinica.setEmail(txtEmail.getText());
				try {
					// chamar a classe AlunoDAO
					ClinicaDAO dao = new ClinicaDAO();
					dao.atualizar(clinica);
					JOptionPane.showMessageDialog(null, "Alterado com sucesso");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				readJTable();
			}

		});
		button.setBounds(521, 115, 119, 23);
		contentPane.add(button);

		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ClinicaDAO dao = new ClinicaDAO();
					int ca = Integer.parseInt(txtCPF.getText());
					dao.excluir(ca);
					JOptionPane.showMessageDialog(null, "Excluido");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				readJTable();
			}
		});
		btnExcluir.setBounds(521, 140, 119, 23);
		contentPane.add(btnExcluir);

		btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Clinica clinica = new Clinica();
					ClinicaDAO dao = new ClinicaDAO();
					int ca = Integer.parseInt(txtCPF.getText());
					clinica = dao.procurarClinica(ca);
					// mostrar dados
					txtNome.setText(clinica.getNomeCliente());
					txtCPF.setText(String.valueOf(clinica.getClienteCPF()));
					txtDtaNasc.setText(clinica.getDtaNasc());
					if (clinica.getSexo() == false) {
						rdbMasculino.setSelected(false);
					}
					if (clinica.getSexo() == true) {
						rdbMasculino.setSelected(true);
					}
					txtProfissao.setText(clinica.getProfissao());
					txtEndereco.setText(clinica.getEndereco());
					txtComplemento.setText(clinica.getComplemento());
					txtTelRes.setText(clinica.getTelRes());
					txtTelCel.setText(clinica.getTelCel());
					txtEmail.setText(clinica.getEmail());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro de Consulta");
				}
			}
		});
		btnProcurar.setBounds(521, 165, 119, 23);
		contentPane.add(btnProcurar);
		
		txtDtaNasc = new DateChooserCombo();
		txtDtaNasc.setText("2019-05-29");		
		txtDtaNasc.setWeekStyle(WeekDaysStyle.SHORT);
		txtDtaNasc.setFormat(3);
		txtDtaNasc.setBounds(99, 113, 155, 20);
		contentPane.add(txtDtaNasc);
	}
}
