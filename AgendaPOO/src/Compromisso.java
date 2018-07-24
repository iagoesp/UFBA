import java.util.Calendar;

public class Compromisso extends Lembrete {
	private Calendar dataFinal;
	private String local;
	private boolean diaInteiro;
	
	public Compromisso(String titulo, String texto, Calendar dataInicial, String prioridade, Calendar dataFinal,
			String local) {
		super(titulo, texto, dataInicial, prioridade);
		this.local = local;
		this.diaInteiro = false;
		this.dataFinal = dataFinal;
	}
	public Compromisso(String titulo, String texto, Calendar dataInicial, String prioridade, String local) {
		super(titulo, texto, dataInicial, prioridade);
		this.local = local;
		this.diaInteiro = true;
		this.dataFinal = dataInicial;
	}
	
	public boolean isDiaInteiro() {
		return diaInteiro;
	}
	public void setDiaInteiro(boolean diaInteiro) {
		this.diaInteiro = diaInteiro;
	}
	public Calendar getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Calendar dataFinal) {
		this.dataFinal = dataFinal;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}	
}
