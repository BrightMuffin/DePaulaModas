package com.finalcurso.modas.servico;

import java.util.List;

import com.finalcurso.modas.entidade.Roupa;

public interface RoupaService {
	public List<Roupa> listarRoupas();

	public Roupa obterRoupa(Long id);

	public void excluirRoupa(Long id);

	public void alterarRoupa(Roupa roupa);
}
