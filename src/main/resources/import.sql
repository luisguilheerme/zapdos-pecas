
INSERT INTO tb_make (name) VALUES('Fiat');
INSERT INTO tb_make (name) VALUES('Volkswagen');
INSERT INTO tb_make (name) VALUES('Ford');
INSERT INTO tb_make (name) VALUES('Chevrolet');
INSERT INTO tb_make (name) VALUES('Toyota');
INSERT INTO tb_make (name) VALUES('Honda');
INSERT INTO tb_make (name) VALUES('BMW');
INSERT INTO tb_make (name) VALUES('Mercedes-Benz');
INSERT INTO tb_make (name) VALUES('Audi');
INSERT INTO tb_make (name) VALUES('Nissan');


INSERT INTO tb_model (name, make_id) VALUES('Uno', 1);
INSERT INTO tb_model (name, make_id) VALUES('Palio', 1);
INSERT INTO tb_model (name, make_id) VALUES('Gol', 2);
INSERT INTO tb_model (name, make_id) VALUES('Jetta', 2);
INSERT INTO tb_model (name, make_id) VALUES('Fiesta', 3);
INSERT INTO tb_model (name, make_id) VALUES('Focus', 3);
INSERT INTO tb_model (name, make_id) VALUES('Onix', 4);
INSERT INTO tb_model (name, make_id) VALUES('Cruze', 4);
INSERT INTO tb_model (name, make_id) VALUES('Corolla', 5);
INSERT INTO tb_model (name, make_id) VALUES('Camry', 5);
INSERT INTO tb_model (name, make_id) VALUES('Civic', 6);
INSERT INTO tb_model (name, make_id) VALUES('Accord', 6);
INSERT INTO tb_model (name, make_id) VALUES('X3', 7);
INSERT INTO tb_model (name, make_id) VALUES('X5', 7);
INSERT INTO tb_model (name, make_id) VALUES('C-Class', 8);
INSERT INTO tb_model (name, make_id) VALUES('E-Class', 8);
INSERT INTO tb_model (name, make_id) VALUES('A3', 9);
INSERT INTO tb_model (name, make_id) VALUES('A6', 9);
INSERT INTO tb_model (name, make_id) VALUES('Altima', 10);
INSERT INTO tb_model (name, make_id) VALUES('Maxima', 10);


INSERT INTO tb_group (name) VALUES('Sensores');
INSERT INTO tb_group (name) VALUES('Interruptores');
INSERT INTO tb_group (name) VALUES('Lanternas');
INSERT INTO tb_group (name) VALUES('Chicotes');
INSERT INTO tb_group (name) VALUES('Cabos e Fios');


INSERT INTO tb_subgroup (name, group_id) VALUES('Sensor de Temperatura', 1);
INSERT INTO tb_subgroup (name, group_id) VALUES('Sensor de Velocidade', 1);
INSERT INTO tb_subgroup (name, group_id) VALUES('Sensor de Oxigênio', 1);
INSERT INTO tb_subgroup (name, group_id) VALUES('Interruptor de Luz de Freio', 2);
INSERT INTO tb_subgroup (name, group_id) VALUES('Interruptor de Luz de Ré', 2);
INSERT INTO tb_subgroup (name, group_id) VALUES('Lanterna Dianteira', 3);
INSERT INTO tb_subgroup (name, group_id) VALUES('Lanterna Traseira', 3);
INSERT INTO tb_subgroup (name, group_id) VALUES('2 Vias', 4);
INSERT INTO tb_subgroup (name, group_id) VALUES('4 Vias', 4);
INSERT INTO tb_subgroup (name, group_id) VALUES('Cabo de Bateria', 5);
INSERT INTO tb_subgroup (name, group_id) VALUES('Cabo de Ignição', 5);


INSERT INTO tb_user (email, name, password) VALUES('john.doe@email.com', 'John Doe', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (email, name, password) VALUES('jane.smith@email.com', 'Jane Smith', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (email, name, password) VALUES('robert.johnson@email.com', 'Robert Johnson', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (email, name, password) VALUES('emily.williams@email.com', 'Emily Williams', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (email, name, password) VALUES('michael.brown@email.com', 'Michael Brown', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');


INSERT INTO tb_role (authority) VALUES ('ROLE_CLIENT');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');


INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (4, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (5, 1);


INSERT INTO tb_brand (name) VALUES('3RHO');
INSERT INTO tb_brand (name) VALUES('MTE');
INSERT INTO tb_brand (name) VALUES('COFRAN');
INSERT INTO tb_brand (name) VALUES('HT');
INSERT INTO tb_brand (name) VALUES('CONDUMAX');
INSERT INTO tb_brand (name) VALUES('CIAFUNDI');
INSERT INTO tb_brand (name) VALUES('TC');
INSERT INTO tb_brand (name) VALUES('RAINHA DAS SETE');
INSERT INTO tb_brand (name) VALUES('DS');
INSERT INTO tb_brand (name) VALUES('MARFLEX');

INSERT INTO tb_part (brand_id, subgroup_id, code, descricao, original_code) VALUES(2, 1, 'MTE3005', 'Sensor de Temperatura', '0499195011');
INSERT INTO tb_part (brand_id, subgroup_id, code, descricao, original_code) VALUES(1, 4, 'RH0367', 'Interruptor de Luz de Freio', '3B0945511A');
INSERT INTO tb_part (brand_id, subgroup_id, code, descricao, original_code) VALUES(3, 6, 'HT91128', 'Lanterna Dianteira LD', '');
INSERT INTO tb_part (brand_id, subgroup_id, code, descricao, original_code) VALUES (5, 10, 'CB50', 'Cabo de Bateria', '');
INSERT INTO tb_part (brand_id, subgroup_id, code, descricao, original_code) VALUES (9, 2, 'DS2502', 'Sensor de Velocidade', '3259578271');
INSERT INTO tb_part (brand_id, subgroup_id, code, descricao, original_code) VALUES (2, 3, 'MTE7774', 'Sensor de Oxigênio Universal', 'UNIVERSAL');
INSERT INTO tb_part (brand_id, subgroup_id, code, descricao, original_code) VALUES (1, 5, 'RH4422', 'Interruptor de Luz de Ré', '0149415211');
INSERT INTO tb_part (brand_id, subgroup_id, code, descricao, original_code) VALUES (3, 7, 'HT25133', 'Lanterna Traseira LE', '');
INSERT INTO tb_part (brand_id, subgroup_id, code, descricao, original_code) VALUES (7, 9, 'TC1031', 'Chicote 4 Vias', '');



