package br.edu.unicid.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.edu.unicid.bean.Clinica;
import br.edu.unicid.dao.ClinicaDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import datechooser.beans.DateChooserCombo;

public class AgendarConsulta extends JFrame {

	private JPanel contentPane;
	private JLabel lblAgendarConsulta;
	private JButton btnAdicionar;
	private JButton btnEditar;
	private JButton btnExcluir;
	private JScrollPane tbAgendar_1;
	private JTable tbAgendar;
	private JButton btnRefresh;
	private JLabel lblClientecpf;
	private JLabel lblDataagenda;
	private JLabel lblHoraagenda;
	private JLabel lblTipoDaConsulta;
	private JLabel lblCodigoDaConsulta;
	private JLabel lblCpfDoDentista;
	private JTextField txtHora;
	private JComboBox cbCPFCliente;
	private JComboBox cbCPFDentista;
	private JTextField txtTipoConsulta;
	private JTextField txtCodConsulta;
	private DateChooserCombo txtData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgendarConsulta frame = new AgendarConsulta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) tbAgendar.getModel();
		modelo.setNumRows(0);
		ClinicaDAO clinicadao;
		try {
			clinicadao = new ClinicaDAO();
			for (Clinica c1 : clinicadao.lerClienteCPF()) {
				cbCPFCliente.addItem(c1);
			}
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		try {
			clinicadao = new ClinicaDAO();
			for (Clinica c2 : clinicadao.lerDentistaCPF()) {
				cbCPFDentista.addItem(c2);
			}
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		try {
			ClinicaDAO clinidao = new ClinicaDAO();
			for (Clinica c : clinidao.lerAgenda()) {
				modelo.addRow(new Object[] { c.getClienteCPF(), c.getDataAgenda(), c.getHoraAgenda(),
						c.getTipoConsulta(), c.getCodConsulta(), c.getDentistaCPF() });
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public AgendarConsulta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblAgendarConsulta = new JLabel("Agendamento");
		lblAgendarConsulta.setBounds(264, 11, 89, 14);
		contentPane.add(lblAgendarConsulta);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Clinica clinica = new Clinica();
					String value = cbCPFCliente.getSelectedItem().toString();
					String value1 = cbCPFDentista.getSelectedItem().toString();
					clinica.setClienteCPF(Integer.parseInt(value));
					clinica.setDataAgenda(txtData.getText());
					clinica.setHoraAgenda(txtHora.getText());
					clinica.setDentistaCPF(Integer.parseInt(value1));
					clinica.setTipoConsulta(txtTipoConsulta.getText());
					// chamar a classe AlunoDAO
					ClinicaDAO dao = new ClinicaDAO();
					dao.salvarAgenda(clinica);
					JOptionPane.showMessageDialog(null, "Salvo com sucesso");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				readJTable();
			}
		});
		btnAdicionar.setBounds(525, 99, 89, 23);
		contentPane.add(btnAdicionar);

		btnEditar = new JButton("Editar");
		btnEditar.setBounds(525, 53, 89, 23);
		contentPane.add(btnEditar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ClinicaDAO dao = new ClinicaDAO();
					int ca = Integer.parseInt(txtCodConsulta.getText());
					dao.excluirAgenda(ca);
					JOptionPane.showMessageDialog(null, "Excluido");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				readJTable();
			}
		});
		btnExcluir.setBounds(525, 30, 89, 23);
		contentPane.add(btnExcluir);

		tbAgendar = new JTable();

		tbAgendar_1 = new JScrollPane();
		tbAgendar_1.setBounds(10, 162, 604, 199);
		contentPane.add(tbAgendar_1);
		tbAgendar_1.setViewportView(tbAgendar);
		tbAgendar.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ClienteCPF", "DataAgenda",
				"HoraAgenda", "TipoConsulta", "CodConsulta", "DentistaCPF" }));

		btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				readJTable();
			}
		});
		btnRefresh.setBounds(525, 75, 89, 23);
		contentPane.add(btnRefresh);

		lblClientecpf = new JLabel("CPF do cliente: ");
		lblClientecpf.setBounds(10, 62, 79, 14);
		contentPane.add(lblClientecpf);

		lblDataagenda = new JLabel("Data:");
		lblDataagenda.setBounds(10, 79, 65, 14);
		contentPane.add(lblDataagenda);

		lblHoraagenda = new JLabel("Hora:");
		lblHoraagenda.setBounds(10, 99, 65, 14);
		contentPane.add(lblHoraagenda);

		lblTipoDaConsulta = new JLabel("Tipo da Consulta:");
		lblTipoDaConsulta.setBounds(281, 79, 102, 14);
		contentPane.add(lblTipoDaConsulta);

		lblCodigoDaConsulta = new JLabel("Codigo :");
		lblCodigoDaConsulta.setBounds(10, 34, 117, 14);
		contentPane.add(lblCodigoDaConsulta);

		lblCpfDoDentista = new JLabel("CPF do Dentista:");
		lblCpfDoDentista.setBounds(281, 57, 102, 14);
		contentPane.add(lblCpfDoDentista);

		cbCPFCliente = new JComboBox();
		cbCPFCliente.setToolTipText("");
		cbCPFCliente.setBounds(99, 54, 117, 20);
		contentPane.add(cbCPFCliente);

		txtHora = new JTextField();
		txtHora.setColumns(10);
		txtHora.setBounds(99, 100, 86, 20);
		contentPane.add(txtHora);

		cbCPFDentista = new JComboBox();
		cbCPFDentista.setToolTipText("");
		cbCPFDentista.setBounds(383, 54, 117, 20);
		contentPane.add(cbCPFDentista);

		txtTipoConsulta = new JTextField();
		txtTipoConsulta.setColumns(10);
		txtTipoConsulta.setBounds(383, 76, 102, 20);
		contentPane.add(txtTipoConsulta);

		txtCodConsulta = new JTextField();
		txtCodConsulta.setColumns(10);
		txtCodConsulta.setBounds(99, 31, 47, 20);
		contentPane.add(txtCodConsulta);
		
		txtData = new DateChooserCombo();
		txtData.setBounds(98, 75, 155, 20);
		contentPane.add(txtData);
	}
}
