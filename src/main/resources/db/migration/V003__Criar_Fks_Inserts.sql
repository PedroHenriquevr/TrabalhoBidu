ALTER TABLE Contas add CONSTRAINT FK_Contas_Cliente foreign key(idCliente) references Cliente(idCliente);
