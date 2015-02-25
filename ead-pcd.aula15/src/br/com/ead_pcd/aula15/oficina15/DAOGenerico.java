package br.com.ead_pcd.aula15.oficina15;

public interface DAOGenerico {
	public boolean inserir(Object o);
	public boolean atualizar(Object o);
	public boolean excluir(int id);
	public Object buscarPorId(int id);
}
