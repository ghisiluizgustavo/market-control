CREATE TABLE `produto` (
  `id` int UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `data_vencimento` date,
  `valor` float NOT NULL,
  `cod_barras` varchar(255) NOT NULL,
  `quantidade` int NOT NULL
);

CREATE TABLE `venda` (
  `id` int UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `valor` float NOT NULL,
  `tipo_pagamento` varchar(155),
  `data_venda` date
);

CREATE TABLE `venda_produto` (
  `id_venda` int,
  `id_prod` int
);

ALTER TABLE `venda_produto` ADD FOREIGN KEY (`id_venda`) REFERENCES `venda` (`id`);

ALTER TABLE `venda_produto` ADD FOREIGN KEY (`id_prod`) REFERENCES `produto` (`id`);
