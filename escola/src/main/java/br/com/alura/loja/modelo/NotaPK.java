package br.com.alura.loja.modelo;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class NotaPK implements Serializable {
	
	private static final long serialVersionUID = -2306183897180172279L;
	private long alunoPK;
	private long seriePK;
	private long materiaPK;

	public NotaPK() {
	}

	public NotaPK(long alunoPK, long seriePK, long materiaPK) {
		super();
		this.alunoPK = alunoPK;
		this.seriePK = seriePK;
		this.materiaPK = materiaPK;
	}

	public long getAlunoPK() {
		return alunoPK;
	}

	public void setAlunoPK(long alunoPK) {
		this.alunoPK = alunoPK;
	}

	public long getSeriePK() {
		return seriePK;
	}

	public void setSeriePK(long seriePK) {
		this.seriePK = seriePK;
	}

	public long getMateriaPK() {
		return materiaPK;
	}

	public void setMateriaPK(long materiaPK) {
		this.materiaPK = materiaPK;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (alunoPK ^ (alunoPK >>> 32));
		result = prime * result + (int) (materiaPK ^ (materiaPK >>> 32));
		result = prime * result + (int) (seriePK ^ (seriePK >>> 32));
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
		if (materiaPK != other.materiaPK)
			return false;
		if (seriePK != other.seriePK)
			return false;
		return true;
	}

}
