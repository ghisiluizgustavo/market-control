CREATE TABLE `produto` (
   `id` int UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
   `nome` varchar(255) NOT NULL,
   `data_vencimento` date,
   `valor` float NOT NULL,
   `cod_barras` varchar(255) NOT NULL,
   `quantidade` int NOT NULL
);
