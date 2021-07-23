package br.com.alura.loja.modelo;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class NotaPK implements Serializable {
	
	private static final long serialVersionUID = -2306183897180172279L;
	private long alunoPK;

	public NotaPK() {
	}

	public NotaPK(long alunoPK) {
		super();
		this.alunoPK = alunoPK;
	}

	public long getAlunoPK() {
		return alunoPK;
	}

	public void setAlunoPK(long alunoPK) {
		this.alunoPK = alunoPK;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (alunoPK ^ (alunoPK >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NotaPK other = (NotaPK) obj;
		if (alunoPK != other.alunoPK)
			return false;
		return true;
	}

}
