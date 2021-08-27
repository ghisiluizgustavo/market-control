CREATE TABLE `venda` (
 `id` int UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
 `valor` float NOT NULL,
 `tipo_pagamento` varchar(155),
 `data_venda` date
);