import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

public class Agenda {
	private Usuario usuario;
	private ArrayList<Nota> listaNotas;
	private ArrayList<Lembrete> listaLembretes;
	private ArrayList<Compromisso> listaCompromissos;
	private ArrayList<Textual> listaAgenda; 
	
	public Agenda(Usuario usuario) {
		this.usuario = usuario;
		listaNotas = null;
		listaLembretes = null;
		listaCompromissos = null;
		listaAgenda = null;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public void ordenarCompromissos(ArrayList<Compromisso> listaCompromissos) {
		Collections.sort(listaCompromissos, new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				Compromisso c1 = (Compromisso) o1;
				Compromisso c2 = (Compromisso) o2;
				return c1.getDataInicial().before(c2.getDataInicial()) ? -1 : (c1.getDataInicial().after(c2.getDataInicial()) ? +1 : 0);
			}
		});		
	}
	public void ordenarLembretes(ArrayList<Lembrete> listaLembretes) {
		Collections.sort(listaLembretes, new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				Lembrete c1 = (Lembrete) o1;
				Lembrete c2 = (Lembrete) o2;
				return c1.getDataInicial().before(c2.getDataInicial()) ? -1 : (c1.getDataInicial().after(c2.getDataInicial()) ? +1 : 0);
			}
		});
	}
	public void adicionarNota(String titulo, String texto) {
		Nota nota = new Nota(titulo, texto);
		listaNotas.add(nota);
	}
	public void adicionarLembrete(String titulo, String texto, Calendar dataInicial, String prioridade) {
		Lembrete lembrete = new Lembrete(titulo, texto, dataInicial, prioridade);
		listaLembretes.add(lembrete);
		ordenarLembretes(listaLembretes);
	}
	public void adicionarCompromisso(String titulo, String texto, Calendar dataInicial, String prioridade, String local) {
		Compromisso compromisso = new Compromisso(titulo, texto, dataInicial, prioridade, local);		
		listaCompromissos.add(compromisso);
		listaLembretes.add(compromisso);
		ordenarLembretes(listaLembretes);
		ordenarCompromissos(listaCompromissos);
	}
	public void adicionarCompromisso(String titulo, String texto, Calendar dataInicial, String prioridade, Calendar dataFinal,
			String local) {
			Compromisso compromisso = new Compromisso(titulo, texto, dataInicial, prioridade, dataFinal, local);
			
		listaCompromissos.add(compromisso);
		Collections.sort(listaCompromissos, new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				Compromisso c1 = (Compromisso) o1;
				Compromisso c2 = (Compromisso) o2;
				return c1.getDataInicial().before(c2.getDataInicial()) ? -1 : (c1.getDataInicial().after(c2.getDataInicial()) ? +1 : 0);
			}
		});
	}
	public void removerNota(Nota nota) {
		this.listaNotas.remove(nota);
	}
	public void removerLembrete(Lembrete lembrete) {
		this.listaLembretes.remove(lembrete);
	}
	public void removerCompromisso(Compromisso compromisso) {
		this.listaCompromissos.remove(compromisso);
	}
	public ArrayList<Nota> getNotas() {
		return listaNotas;
	}
	public ArrayList<Lembrete> getLembretes() {
		return listaLembretes;
	}
	public ArrayList<Compromisso> getCompromissos() {
		return listaCompromissos;
	}
}


