CREATE table produto(
	id uuid primary key,
	nome varchar(150),
	preco decimal(10,2),
	quantidade integer
);

--Script para consultar os registros da tabela
select * from produto;
