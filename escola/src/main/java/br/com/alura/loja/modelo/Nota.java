package br.com.alura.loja.modelo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "notas")
public class Nota {
	
	@EmbeddedId
	private NotaPK pk;
	
	private float nota1Bimestre;
	private float nota2Bimestre;
	private float nota3Bimestre;
	private float nota4Bimestre;
	
	//Vide especificação JPA 2.1, seção 2.4.1.
	@MapsId("alunoPK") // maps alunoPK attribute of embedded id
	@ManyToOne
	private Aluno aluno;
	
	@MapsId("seriePK") // maps seriePK attribute of embedded id
	@ManyToOne
	private Serie serie;
	
	@MapsId("materiaPK") // maps materiaPK attribute of embedded id
	@ManyToOne
	private Materia materia;
	
	public Nota() {
	}

	public Nota(float nota1Bimestre, float nota2Bimestre, float nota3Bimestre, float nota4Bimestre) {
		super();
		this.nota1Bimestre = nota1Bimestre;
		this.nota2Bimestre = nota2Bimestre;
		this.nota3Bimestre = nota3Bimestre;
		this.nota4Bimestre = nota4Bimestre;
	}

	public NotaPK getPk() {
		return pk;
	}

	public void setPk(NotaPK pk) {
		this.pk = pk;
	}

	public float getNota1Bimestre() {
		return nota1Bimestre;
	}

	public void setNota1Bimestre(float nota1Bimestre) {
		this.nota1Bimestre = nota1Bimestre;
	}

	public float getNota2Bimestre() {
		return nota2Bimestre;
	}

	public void setNota2Bimestre(float nota2Bimestre) {
		this.nota2Bimestre = nota2Bimestre;
	}

	public float getNota3Bimestre() {
		return nota3Bimestre;
	}

	public void setNota3Bimestre(float nota3Bimestre) {
		this.nota3Bimestre = nota3Bimestre;
	}

	public float getNota4Bimestre() {
		return nota4Bimestre;
	}

	public void setNota4Bimestre(float nota4Bimestre) {
		this.nota4Bimestre = nota4Bimestre;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	@Override
	public String toString() {
		return "Nota [nota1Bimestre=" + nota1Bimestre + ", nota2Bimestre=" + nota2Bimestre + ", nota3Bimestre="
				+ nota3Bimestre + ", nota4Bimestre=" + nota4Bimestre + "]";
	}

}
