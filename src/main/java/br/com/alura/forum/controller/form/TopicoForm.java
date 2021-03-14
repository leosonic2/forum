package br.com.alura.forum.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.modelo.Usuario;
import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.repository.UsuarioRepository;

public class TopicoForm {

	@NotNull
	@NotBlank
	private String titulo;

	@NotNull
	@NotBlank
	private String mensagem;

	@NotNull
	@NotBlank
	private String nomeCurso;

	@NotNull
	@NotBlank
	private String nomeAluno;

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public Topico converter(CursoRepository repository, UsuarioRepository usuarioRepository) {

		Usuario usuario = usuarioRepository.findByNome(this.nomeAluno);
		Curso curso = repository.findByNome(this.nomeCurso);
		return new Topico(this.titulo, this.mensagem, curso, usuario);
	}

}
