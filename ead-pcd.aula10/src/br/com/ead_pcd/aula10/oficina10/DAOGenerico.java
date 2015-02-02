package br.com.ead_pcd.aula10.oficina10;

public interface DAOGenerico {
	public boolean inserir(Object o);
	public boolean atualizar(Object o);
	public boolean excluir(int id);
	public Object buscarPorId(int id);
}
