CREATE DATABASE reserva

---------------------------------------------------
CREATE TABLE usuarios(
usu_codigo INT AUTO_INCREMENT,
usuario VARCHAR(50) NOT NULL,
PASSWORD VARCHAR(120) NOT NULL,
activo TINYINT NOT NULL DEFAULT 1,
PRIMARY KEY (usu_codigo),
UNIQUE(usuario));
------------------------------------------------
CREATE TABLE roles(
rol_codigo INT PRIMARY KEY AUTO_INCREMENT,
usu_codigo INT,
rol_nombre VARCHAR(50),
UNIQUE(usu_codigo, rol_nombre));
-----------------------------------------------
ALTER TABLE roles ADD FOREIGN KEY (usu_codigo)
REFERENCES usuarios(usu_codigo);
-------------------------------------------------
INSERT INTO usuarios(usuario, PASSWORD, activo)
VALUES('user','$2a$10$d4xudKcjpOkN0oyTM8zF/.iG96/DLocmONFfFrOX75mdn7H9jS4ea',1)

INSERT INTO usuarios(usuario, PASSWORD, activo)
VALUES('moderator','$2a$10$7DhETx8knXQ0sskeB4rORui/68CkKV9T9jOMx3AWVbScLqk2Xg2ka',1)

INSERT INTO usuarios(usuario, PASSWORD, activo)
VALUES('admin','$2a$10$IompOT5IHYoFshWMVjokwuZ6Qj3b3UJvlauHRnu1khmQyutL7JSlC',1)

-------------------------------------------------
INSERT INTO roles (usu_codigo,rol_nombre) VALUES(1,'user');
INSERT INTO roles (usu_codigo,rol_nombre) VALUES(2,'moderador');
INSERT INTO roles (usu_codigo,rol_nombre) VALUES(3,'admin');
