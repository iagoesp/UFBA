import java.util.ArrayList;

public class Usuario {
	private String nome;
	private String id;
	private String senha;
	private String email;
	
	public Usuario(String id, String nome, String email, String senha) {
		this.nome = nome;
		this.id = id;
		this.senha = senha;
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUsuario() {
		return id;
	}
	public void setUsuario(String id) {
		this.id = id;
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
