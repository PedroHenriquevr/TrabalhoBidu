ALTER TABLE Contas add CONSTRAINT FK_Contas_Cliente foreign key(id_cliente) references Cliente(id_cliente);
