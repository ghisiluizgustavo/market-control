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

INSERT INTO `produto` (`id`, `nome`, `data_vencimento`, `valor`, `cod_barras`, `quantidade`) VALUES (1, "KiArroz", "2028-05-28", 10.5, "1111", 10);
INSERT INTO `produto` (`id`, `nome`, `data_vencimento`, `valor`, `cod_barras`, `quantidade`) VALUES (2, "Carne moída", "2028-04-13", 20.5, "2222", 20);

INSERT INTO `venda` (`id`, `valor`, `tipo_pagamento`, `data_venda`) VALUES (1, 50.2, "DINHEIRO", "2021-05-12");
INSERT INTO `venda` (`id`, `valor`, `tipo_pagamento`, `data_venda`) VALUES (2, 30.4, "DINHEIRO", "2021-06-02");

INSERT INTO `venda_produto` (`venda_id`, `produto_id`) VALUES (1, 1);
INSERT INTO `venda_produto` (`venda_id`, `produto_id`) VALUES (1, 2);
INSERT INTO `venda_produto` (`venda_id`, `produto_id`) VALUES (1, 2);
INSERT INTO `venda_produto` (`venda_id`, `produto_id`) VALUES (2, 1);
INSERT INTO `venda_produto` (`venda_id`, `produto_id`) VALUES (2, 1);