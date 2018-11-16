package parser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Libro implements Serializable{

	
	String titulo;
	int anyo;
	ArrayList <String> autores;
	String editor;
	int paginas;
	
	public Libro () {
		
	}
	
	public Libro (String titulo, int anyo, ArrayList <String> autores, String editor, int paginas) {
		
		this.titulo = titulo;
		this.anyo = anyo;
		this.autores = autores;
		this.editor = editor;
		this.paginas = paginas;
		
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}


	public ArrayList<String> getAutores() {
		return autores;
	}

	public void setAutores(ArrayList<String> autores) {
		this.autores = autores;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	@Override
	public String toString() {
		String res = null;
		res = "Titulo: " + titulo + "\nAño: " + anyo+ "\n";
		res += "Autores: ";
		Iterator it = autores.iterator();
		while (it.hasNext()) {
			res+= "" + (String) it.next() + ", ";
		}
		res += "\nEditor: " + editor + "\nPáginas:" + paginas;
		res += "\n---------------------------------";
		return res;
	}
	
	
}
