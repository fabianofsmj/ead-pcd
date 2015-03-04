<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Sistema de Gestão Financeira</title>
</head>
<body>
	<h1>Cadastro Usuários</h1>
	<p align="right"><a href="index.html">Voltar</a></p>
	<form id="formCadastroDeUsuarios" name="cadastroDeUsuarios" method="post" action="cadastroDeUsuario">
		<p>Login: <input type="text" name="login" value="${login }"/></p>
		<p>Nome: <input type="text" name="nome" value="${nome }"/></p>
		<p>Senha: <input type="password" name="senha" value="${senha }"/></p>
		<input type="hidden" name=id value="${id }" />
		<p>
			<input type="submit" name="acao" value="Pesquisar"/>
			| <input type="submit" name="acao" value="Incluir"/>
			| <input type="submit" name="acao" value="Salvar"/>
			| <input type="submit" name="acao" value="Excluir"/>
		</p>
	</form>
</body>
</html>