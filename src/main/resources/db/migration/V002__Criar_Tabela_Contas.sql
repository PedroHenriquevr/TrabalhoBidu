CREATE TABLE Contas (
  id_contas int not null AUTO_INCREMENT PRIMARY KEY,
  date_conta Date not null,
  valor_conta decimal(12,2),
  id_cliente int not null
);