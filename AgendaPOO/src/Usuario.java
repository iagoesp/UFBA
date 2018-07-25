import java.util.ArrayList;

public class Usuario {
	private String nome;
	private String usuario;
	private String senha;
	private String email;
	
	public Usuario(String nome, String usuario, String senha, String email) {
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
		this.email = email;
		this.nota = null;
		this.lembrete = null;
		this.compromisso = null;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
}
