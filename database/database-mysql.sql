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
  `venda_id` int,
  `produto_id` int
);

ALTER TABLE `venda_produto` ADD FOREIGN KEY (`venda_id`) REFERENCES `venda` (`id`);

ALTER TABLE `venda_produto` ADD FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`);
