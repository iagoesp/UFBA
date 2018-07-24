import java.util.Calendar;

public class Lembrete extends Textual{
	private Calendar dataInicial;
	private String prioridade;
	
	public Lembrete(String titulo, String texto, Calendar dataInicial, String prioridade) {
		super(titulo, texto);
		this.dataInicial = dataInicial;
		this.prioridade = prioridade;
	}
	public Calendar getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(Calendar dataInicial) {
		this.dataInicial = dataInicial;
	}
	public void getDataInicial(Calendar data) {
		this.dataInicial = data;
	}
	public String getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}
}
