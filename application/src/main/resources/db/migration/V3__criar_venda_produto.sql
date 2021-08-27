CREATE TABLE `venda_produto` (
 `venda_id` int,
 `produto_id` int
);

ALTER TABLE `venda_produto` ADD FOREIGN KEY (`venda_id`) REFERENCES `venda` (`id`);
ALTER TABLE `venda_produto` ADD FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`);

