package br.edu.unicid.bean;
public class Clinica {	
	private String NomeCliente;
	private int ClienteCPF;
	private String DtaNasc;
	private Boolean Sexo;
	private String Profissao;
	private String Endereco;
	private String Complemento;
	private String TelRes;
	private String TelCel;
	private String Email;
	private String DataAgenda;
	private String HoraAgenda;
	private String TipoConsulta;
	private int CodConsulta;
	private int DentistaCPF;
	private String NomeDentista;
	private int Dentista;
	private String Especialidade;	
	public Clinica(String NomeCliente, int ClienteCPF, String DtaNasc,
			Boolean Sexo, String Profissao, String Endereco,String Complemento,String TelRes,String TelCel,String Email) {
		this.NomeCliente=NomeCliente;
		this.ClienteCPF=ClienteCPF;
		this.DtaNasc=DtaNasc;
		this.Sexo = Sexo;
		this.Profissao=Profissao;		
		this.Endereco = Endereco;
		this.Complemento = Complemento;
		this.TelRes = TelRes;
		this.TelCel = TelCel;
		this.Email = Email;		
	}
	public Clinica(int ClienteCPF, String DataAgenda,String HoraAgenda,String TipoConsulta,int CodConsulta, int DentistaCPF) {
		this.ClienteCPF = ClienteCPF;
		this.DataAgenda = DataAgenda;	
		this.HoraAgenda = HoraAgenda;	
		this.TipoConsulta = TipoConsulta;	
		this.CodConsulta = CodConsulta;	
		this.DentistaCPF = DentistaCPF;	
	}
	
	public Clinica(String NomeDentista,int DentistaCPF,String DtaNasc,Boolean Sexo, String Especialidade,String Endereco,
			String Complemento, String TelRes, String TelCel) {
		this.NomeDentista = NomeDentista;
		this.DentistaCPF = DentistaCPF;
		this.DtaNasc = DtaNasc;
		this.Sexo = Sexo;
		this.Especialidade = Especialidade;
		this.Endereco = Endereco;
		this.Complemento = Complemento;
		this.TelRes = TelRes;
		this.TelCel = TelCel;
	}
	public String getDataAgenda() {
		return DataAgenda;
	}
	public void setDataAgenda(String dataAgenda) {
		DataAgenda = dataAgenda;
	}
	public String getHoraAgenda() {
		return HoraAgenda;
	}
	public void setHoraAgenda(String horaAgenda) {
		HoraAgenda = horaAgenda;
	}
	public String getTipoConsulta() {
		return TipoConsulta;
	}
	public void setTipoConsulta(String tipoConsulta) {
		TipoConsulta = tipoConsulta;
	}
	public int getCodConsulta() {
		return CodConsulta;
	}
	public void setCodConsulta(int codConsulta) {
		CodConsulta = codConsulta;
	}	
	public String getNomeDentista() {
		return NomeDentista;
	}
	public void setNomeDentista(String nomeDentista) {
		NomeDentista = nomeDentista;
	}
	public int getDentista() {
		return Dentista;
	}
	public void setDentista(int dentista) {
		Dentista = dentista;
	}
	public String getEspecialidade() {
		return Especialidade;
	}
	public void setEspecialidade(String especialidade) {
		Especialidade = especialidade;
	}
	public void setNomeDentista(int NomeDentista) {
		NomeDentista = NomeDentista;
	}
	public int getDentistaCPF() {
		return DentistaCPF;
	}
	public void setDentistaCPF(int dentistaCPF) {
		DentistaCPF = dentistaCPF;
	}
	public Clinica() {
	}
	public String getNomeCliente() {
		return NomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		NomeCliente = nomeCliente;
	}
	public int getClienteCPF() {
		return ClienteCPF;
	}	
	public void setClienteCPF(int clienteCPF) {
		ClienteCPF = clienteCPF;
	}
	
	public String getDtaNasc() {
		return DtaNasc;
	}
	public void setDtaNasc(String dtaNasc) {
		DtaNasc = dtaNasc;
	}
	public Boolean getSexo() {
		return Sexo;
	}
	public void setSexo(Boolean sexo) {
		Sexo = sexo;
	}
	public String getProfissao() {
		return Profissao;
	}
	public void setProfissao(String profissao) {
		Profissao = profissao;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	public String getComplemento() {
		return Complemento;
	}
	public void setComplemento(String complemento) {
		Complemento = complemento;
	}
	public String getTelRes() {
		return TelRes;
	}
	public void setTelRes(String telRes) {
		TelRes = telRes;
	}
	public String getTelCel() {
		return TelCel;
	}
	public void setTelCel(String telCel) {
		TelCel = telCel;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(getClienteCPF());
	}
		
}
