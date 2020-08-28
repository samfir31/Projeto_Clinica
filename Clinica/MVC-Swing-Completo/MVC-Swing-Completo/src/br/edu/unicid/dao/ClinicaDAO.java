package br.edu.unicid.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.edu.unicid.bean.Clinica;
import br.edu.unicid.util.ConnectionFactory;
import br.edu.unicid.view.CadastrarCliente;

public class ClinicaDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs; // é a minha tabela
	private Clinica clinica;

	public ClinicaDAO() throws Exception {
		// chama a classe ConnectionFactory e estabele uma conexão
		try {			
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro: \n" + e.getMessage());
		}
	}

	// método de salvar

	public void salvar(Clinica clinica) throws Exception {
		if (clinica == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "INSERT INTO `tbcadastrocliente` (`NomeCliente`, `ClienteCPF`, `DtaNasc`, `Sexo`,`Profissao`, `Endereco`, `Complemento`, `TelRes`, `TelCel`, `Email`)"
					+ "values (?, ?, ?,?,?,?,?,?,?,?)";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setString(1, clinica.getNomeCliente());
			ps.setInt(2, clinica.getClienteCPF());
			ps.setString(3, clinica.getDtaNasc());
			ps.setBoolean(4, clinica.getSexo());
			ps.setString(5, clinica.getProfissao());
			ps.setString(6, clinica.getEndereco());
			ps.setString(7, clinica.getComplemento());
			ps.setString(8, clinica.getTelRes());
			ps.setString(9, clinica.getTelCel());
			ps.setString(10, clinica.getEmail());			
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	public void salvarDentista(Clinica clinica) throws Exception {
		if (clinica == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "INSERT INTO `tbcadastrodentista` (`NomeDentista`, `DentistaCPF`, `DtaNasc`, `Sexo`,`Especialidade`, `Endereco`, `Complemento`, `TelRes`, `TelCel`)"
					+ "values (?, ?, ?,?,?,?,?,?,?)";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setString(1, clinica.getNomeDentista());
			ps.setInt(2, clinica.getDentistaCPF());
			ps.setString(3, clinica.getDtaNasc());
			ps.setBoolean(4, clinica.getSexo());
			ps.setString(5, clinica.getProfissao());
			ps.setString(6, clinica.getEndereco());
			ps.setString(7, clinica.getComplemento());
			ps.setString(8, clinica.getTelRes());
			ps.setString(9, clinica.getTelCel());					
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	public void salvarAgenda(Clinica clinica) throws Exception {
		if (clinica == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "INSERT INTO `tbagendar` (`ClienteCPF`, `DataAgenda`, `HoraAgenda`,`TipoConsulta`, `DentistaCPF`)"
					+ "values (?, ?, ?,?,?)";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, clinica.getClienteCPF());
			ps.setString(2, clinica.getDataAgenda());
			ps.setString(3, clinica.getHoraAgenda());			
			ps.setString(4, clinica.getTipoConsulta());
			ps.setInt(5, clinica.getDentistaCPF());				
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
	// Procurar Aluno
		public Clinica procurarClinica(int ClienteCPF) throws Exception {
			try {
				String SQL = "SELECT  * FROM tbcadastrocliente WHERE ClienteCPF=?";
				conn = this.conn;
				ps = conn.prepareStatement(SQL);
				ps.setInt(1, ClienteCPF);				
				rs = ps.executeQuery();
				if (rs.next()) {
					int ca = rs.getInt(1);
					String NomeCliente = rs.getString("NomeCliente");
					String DtaNasc = rs.getString("DtaNasc");
					Boolean Sexo = rs.getBoolean("Sexo");
					String Profissao = rs.getString("Profissao");
					String Endereco = rs.getString("Endereco");
					String Complemento = rs.getString("Complemento");
					String TelRes= rs.getString("TelRes");
					String TelCel = rs.getString("TelCel");
					String Email = rs.getString("Email");					
					clinica = new Clinica (NomeCliente,ca,DtaNasc,Sexo,Profissao,Endereco,Complemento,TelRes,TelCel,Email);
				}
				return clinica;
			} catch (SQLException sqle) {
				throw new Exception(sqle);
			} finally {
				ConnectionFactory.closeConnection(conn, ps, rs);
			}
		}
		public Clinica procurarAgenda(int CodConsulta) throws Exception {
			try {
				String SQL = "SELECT  * FROM tbcadastrocliente WHERE CodConsulta=?";
				conn = this.conn;
				ps = conn.prepareStatement(SQL);
				ps.setInt(1, CodConsulta);				
				rs = ps.executeQuery();
				if (rs.next()) {
					int ca = rs.getInt(1);
					int ClienteCPF = rs.getInt("ClienteCPF");
					String DataAgenda = rs.getString("DataAgenda");
					String HoraAgenda = rs.getString("HoraAgenda");
					String TipoConsulta = rs.getString("TipoConsulta");					
					int DentistaCPF = rs.getInt("DentistaCPF");									
					clinica = new Clinica (ClienteCPF,DataAgenda,HoraAgenda,TipoConsulta,ca,DentistaCPF);
				}
				return clinica;
			} catch (SQLException sqle) {
				throw new Exception(sqle);
			} finally {
				ConnectionFactory.closeConnection(conn, ps, rs);
			}
		}
		
		public void excluir(int ClienteCPF) throws Exception {
			try {
				String SQL = "DELETE FROM tbCadastroCliente WHERE ClienteCPF=?";
				conn = this.conn;
				ps = conn.prepareStatement(SQL);
				ps.setInt(1, ClienteCPF);			
				ps.executeUpdate();
			} catch (SQLException sqle) {
				throw new Exception(sqle);
			} finally {
				ConnectionFactory.closeConnection(conn, ps, rs);
			}
		}
		public void excluirDentista(int DentistaCPF) throws Exception {
			try {
				String SQL = "DELETE FROM tbCadastroDentista WHERE DentistaCPF=?";
				conn = this.conn;
				ps = conn.prepareStatement(SQL);
				ps.setInt(1, DentistaCPF);			
				ps.executeUpdate();
			} catch (SQLException sqle) {
				throw new Exception(sqle);
			} finally {
				ConnectionFactory.closeConnection(conn, ps, rs);
			}
		}
		public void excluirAgenda(int CodConsulta) throws Exception {
			try {
				String SQL = "DELETE FROM tbAgendar WHERE CodConsulta=?";
				conn = this.conn;
				ps = conn.prepareStatement(SQL);
				ps.setInt(1, CodConsulta);			
				ps.executeUpdate();
			} catch (SQLException sqle) {
				throw new Exception(sqle);
			} finally {
				ConnectionFactory.closeConnection(conn, ps, rs);
			}
		}
		
		// método de atualizar

		public void atualizar(Clinica clinica) throws Exception {
			if (clinica == null)
				throw new Exception("O valor passado nao pode ser nulo");
			try {
				String SQL = "UPDATE tbcadastrocliente set NomeCliente=?,"
						+ " DtaNasc=?, Sexo=?, "
						+ " Profissao=?, Endereco=?, "
						+ " Complemento=?, TelRes=?, "						
						+ "TelCel=?,Email=? "
						+ "WHERE ClienteCPF = ?";
				conn = this.conn;
				ps = conn.prepareStatement(SQL);
				ps.setString(1, clinica.getNomeCliente());				
				ps.setString(2, clinica.getDtaNasc());							
				ps.setBoolean(3, clinica.getSexo());
				ps.setString(4, clinica.getProfissao());
				ps.setString(5, clinica.getEndereco());
				ps.setString(6, clinica.getComplemento());
				ps.setString(7, clinica.getTelRes());
				ps.setString(8, clinica.getTelCel());
				ps.setString(9, clinica.getEmail());
				ps.setInt(10, clinica.getClienteCPF());
				ps.executeUpdate();
			} catch (SQLException sqle) {
				throw new Exception("Erro ao alterar dados " + sqle);
			} finally {
				ConnectionFactory.closeConnection(conn, ps);
			}
		}
		public void atualizarDentista(Clinica clinica) throws Exception {
			if (clinica == null)
				throw new Exception("O valor passado nao pode ser nulo");
			try {
				String SQL = "UPDATE tbcadastrodentista set NomeDentista=?,"
						+ " DtaNasc=?, Sexo=?, "
						+ " Especialidade=?, Endereco=?, "
						+ " Complemento=?, TelRes=?, "						
						+ "TelCel=?,Email=? "
						+ "WHERE DentistaCPF = ?";
				conn = this.conn;
				ps = conn.prepareStatement(SQL);
				ps.setString(1, clinica.getNomeDentista());				
				ps.setString(2, clinica.getDtaNasc());							
				ps.setBoolean(3, clinica.getSexo());
				ps.setString(4, clinica.getEspecialidade());
				ps.setString(5, clinica.getEndereco());
				ps.setString(6, clinica.getComplemento());
				ps.setString(7, clinica.getTelRes());
				ps.setString(8, clinica.getTelCel());
				ps.setString(9, clinica.getEmail());
				ps.setInt(10, clinica.getDentistaCPF());
				ps.executeUpdate();
			} catch (SQLException sqle) {
				throw new Exception("Erro ao alterar dados " + sqle);
			} finally {
				ConnectionFactory.closeConnection(conn, ps);
			}
		}
		public List<Clinica> ler(){
			ConnectionFactory con = new ConnectionFactory();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			List<Clinica> lista = new ArrayList<>();
			try {
				stmt = conn.prepareStatement("Select * from tbcadastrocliente");
				rs = stmt.executeQuery();
				while(rs.next()) {
					Clinica clinica = new Clinica();
					clinica.setNomeCliente(rs.getString("NomeCliente"));
					clinica.setClienteCPF(rs.getInt("ClienteCPF"));
					clinica.setDtaNasc(rs.getString("DtaNasc"));
					clinica.setSexo(rs.getBoolean("Sexo"));
					clinica.setProfissao(rs.getString("Profissao"));
					clinica.setEndereco(rs.getString("Endereco"));
					clinica.setComplemento(rs.getString("Complemento"));
					clinica.setTelRes(rs.getString("TelRes"));
					clinica.setTelCel(rs.getString("TelCel"));
					clinica.setEmail(rs.getString("Email"));
					lista.add(clinica);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					ConnectionFactory.closeConnection(conn, stmt, rs);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
			
			return lista;
		}

		public List<Clinica> lerAgenda(){
			ConnectionFactory con = new ConnectionFactory();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			List<Clinica> lista = new ArrayList<>();
			try {
				stmt = conn.prepareStatement("Select * from tbagendar");
				rs = stmt.executeQuery();
				while(rs.next()) {
					Clinica clinica = new Clinica();					
					clinica.setClienteCPF(rs.getInt("ClienteCPF"));
					clinica.setDataAgenda(rs.getString("DataAgenda"));
					clinica.setHoraAgenda(rs.getString("HoraAgenda"));
					clinica.setTipoConsulta(rs.getString("TipoConsulta"));
					clinica.setCodConsulta(rs.getInt("CodConsulta"));					
					clinica.setDentistaCPF(rs.getInt("DentistaCPF"));					
					lista.add(clinica);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					ConnectionFactory.closeConnection(conn, stmt, rs);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
			
			return lista;
		}
		public List<Clinica> lerClienteCPF(){
			ConnectionFactory con = new ConnectionFactory();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			List<Clinica> lista = new ArrayList<>();
			try {
				stmt = conn.prepareStatement("Select * from tbcadastrocliente");
				rs = stmt.executeQuery();
				while(rs.next()) {
					Clinica clinica = new Clinica();					
					clinica.setClienteCPF(rs.getInt("ClienteCPF"));										
					lista.add(clinica);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					ConnectionFactory.closeConnection(conn, stmt, rs);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
			
			return lista;
		}
		public List<Clinica> lerDentistaCPF(){
			ConnectionFactory con = new ConnectionFactory();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			List<Clinica> lista = new ArrayList<>();
			try {
				stmt = conn.prepareStatement("Select * from tbcadastrodentista");
				rs = stmt.executeQuery();
				while(rs.next()) {
					Clinica clinica = new Clinica();					
					clinica.setClienteCPF(rs.getInt("DentistaCPF"));										
					lista.add(clinica);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					ConnectionFactory.closeConnection(conn, stmt, rs);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
			
			return lista;
		}
		
		
}