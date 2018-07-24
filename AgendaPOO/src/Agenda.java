import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

public class Agenda {
	private Usuario usuario;
	
	public Agenda(Usuario usuario) {
		this.usuario = usuario;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public void adicionarNota(String titulo, String texto) {
		Nota nota = new Nota(titulo, texto);
		usuario.getNotas().add(nota);
	}
	public void adicionarLembrete(String titulo, String texto, Calendar dataInicial, String prioridade) {
		Lembrete lembrete = new Lembrete(titulo, texto, dataInicial, prioridade);
		usuario.getLembretes().add(lembrete);
		Collections.sort(usuario.getLembretes(), new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				Lembrete c1 = (Lembrete) o1;
				Lembrete c2 = (Lembrete) o2;
				return c1.getDataInicial().before(c2.getDataInicial()) ? -1 : (c1.getDataInicial().after(c2.getDataInicial()) ? +1 : 0);
			}
		});
	}
	public void adicionarCompromisso(String titulo, String texto, Calendar dataInicial, String prioridade, String local) {
		Compromisso compromisso = new Compromisso(titulo, texto, dataInicial, prioridade, local);		
		usuario.getCompromissos().add(compromisso);
		Collections.sort(usuario.getCompromissos(), new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				Compromisso c1 = (Compromisso) o1;
				Compromisso c2 = (Compromisso) o2;
				return c1.getDataInicial().before(c2.getDataInicial()) ? -1 : (c1.getDataInicial().after(c2.getDataInicial()) ? +1 : 0);
			}
		});
	}
	public void adicionarCompromisso(String titulo, String texto, Calendar dataInicial, String prioridade, Calendar dataFinal,
			String local) {
			Compromisso compromisso = new Compromisso(titulo, texto, dataInicial, prioridade, dataFinal, local);
			
		usuario.getCompromissos().add(compromisso);
		Collections.sort(usuario.getCompromissos(), new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				Compromisso c1 = (Compromisso) o1;
				Compromisso c2 = (Compromisso) o2;
				return c1.getDataInicial().before(c2.getDataInicial()) ? -1 : (c1.getDataInicial().after(c2.getDataInicial()) ? +1 : 0);
			}
		});
	}
	
	public void removerNota(Nota nota) {
		usuario.getNotas().remove(nota);
	}
	public void removerLembrete(Lembrete lembrete) {
		usuario.getLembretes().remove(lembrete);
	}
	public void removerCompromisso(Compromisso compromisso) {
		usuario.getCompromissos().remove(compromisso);
	}
}
