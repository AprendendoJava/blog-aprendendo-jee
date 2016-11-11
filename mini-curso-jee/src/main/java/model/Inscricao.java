package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints =@UniqueConstraint(columnNames={"inscricao_curso_id", "inscricao_aluno_id"}))
public class Inscricao {
	
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	@JoinColumn(name="inscricao_curso_id")
	private Curso curso;
	
	@ManyToOne
	@JoinColumn(name = "inscricao_aluno_id")
	private Aluno aluno;
	
	private Date dataInscricao;
	
	
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Date getDataInscricao() {
		return dataInscricao;
	}
	public void setDataInscricao(Date dataInscricao) {
		this.dataInscricao = dataInscricao;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

}