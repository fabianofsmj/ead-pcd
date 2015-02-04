package br.com.ead_pcd.aula12.video12;

public interface DAOGenerico {
	public boolean inserir(Object object);
	public Object buscarPorId(int id);
	public boolean atualizar(Object object);
	public boolean excluir(int id);
}
