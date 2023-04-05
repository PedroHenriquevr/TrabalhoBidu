CREATE TABLE Contas (
  idContas int not null AUTO_INCREMENT PRIMARY KEY,
  dateConta Date not null,
  valorConta decimal(12,2),
  idCliente int not null
);