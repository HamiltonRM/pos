DROP SCHEMA IF EXISTS proyecto;
CREATE DATABASE proyecto;

use proyecto;

CREATE TABLE IF NOT EXISTS proyecto.cliente(
id INT NOT NULL auto_increment,
nit varchar(45) NOT NULL,
nombre VARCHAR (45) NOT NULL,
apellidos VARCHAR (45) NOT NULL,
edad VARCHAR (45) NOT NULL,
sexo VARCHAR (45) NOT NULL,
direccion VARCHAR (45) NOT NULL,
PRIMARY KEY (id))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS proyecto.proveedor(
id INT NOT NULL AUTO_INCREMENT,
nombre_proveedor VARCHAR(45) NOT NULL,
nit VARCHAR(45) NOT NULL,
PRIMARY KEY(id))
ENGINE =InnoDB;

CREATE TABLE IF NOT EXISTS proyecto.marca(
id int not null auto_increment,
codigo VARCHAR(45) NOT NULL,
nombre VARCHAR(45) NOT NULL,
descripcion VARCHAR (45)NULL,
PRIMARY KEY(id))
ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS proyecto.medida(
id INT NOT NULL auto_increment,
codigo VARCHAR(45) NOT NULL,
nombre VARCHAR(45) NOT NULL,
abreviatura VARCHAR(45) NULL,
PRIMARY KEY (id))
ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS proyecto.seccion (
id INT NOT NULL AUTO_INCREMENT,
codigo VARCHAR(45) NOT NULL ,
nombre VARCHAR (45) NOT NULL,
descripcion VARCHAR(45)NULL,
PRIMARY KEY (id))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS proyecto.categoria(
id INT NOT NULL AUTO_INCREMENT,
codigo VARCHAR(45) NOT NULL ,
nombre VARCHAR(45) NOT NULL,
descripcion VARCHAR(45) NULL,
PRIMARY KEY (id))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS proyecto.producto(
id INT NOT NULL auto_increment,
nombre VARCHAR(45) NOT NULL,
cantidad	VARCHAR(45) NOT NULL,
precio VARCHAR(45) NOT NULL,
codigo VARCHAR(45) NOT NULL,
marca_id INT NOT NULL ,
medida_id INT NOT NULL,
seccion_id INT NOT NULL ,
categoria_id INT NOT NULL,
PRIMARY KEY (id),
INDEX fk_producto_marca_idx(marca_id ASC)VISIBLE,
INDEX fk_producto_medida_idx(medida_id ASC)VISIBLE,
INDEX fk_producto_seccion_idx(seccion_id ASC)VISIBLE,
INDEX fk_producto_cateogoria_idx(categoria_id ASC)VISIBLE,
CONSTRAINT fk_producto_marca
FOREIGN KEY(marca_id)
REFERENCES proyecto.marca(id)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
CONSTRAINT fk_producto_medida
FOREIGN KEY(medida_id)
REFERENCES proyecto.medida(id)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
CONSTRAINT fk_producto_seccion
FOREIGN KEY(seccion_id)
REFERENCES proyecto.seccion(id)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
CONSTRAINT fk_producto_categoria
FOREIGN KEY(categoria_id)
REFERENCES proyecto.categoria(id)
ON DELETE NO ACTION
ON UPDATE NO ACTION)
ENGINE =InnoDB;

CREATE TABLE IF NOT EXISTS proyecto. usuario(
id INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(45) NOT NULL,
email VARCHAR(45)NOT NULL,
contrasenia VARCHAR(45) NOT NULL,
PRIMARY KEY (id))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS proyecto.forma_pago(
id INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(45) NOT NULL,
descripcion VARCHAR (45) NULL,
PRIMARY KEY(id))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS proyecto.venta(
id INT NOT NULL AUTO_INCREMENT,
fecha DATETIME NOT NULL,
usuario_id INT NOT NULL,
cliente_id int NOT NULL,
forma_pago_id INT NOT NULL,
PRIMARY KEY (id),
INDEX fk_venta_usuario_idx(usuario_id ASC) VISIBLE,
INDEX fk_venta_cliente_idx(cliente_id ASC)VISIBLE,
INDEX fk_venta_forma_pago_idx(forma_pago_id ASC)VISIBLE,
CONSTRAINT fk_venta_usuario
FOREIGN KEY (usuario_id)
REFERENCES proyecto.usuario(id)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
CONSTRAINT fk_venta_cliente
FOREIGN KEY (cliente_id)
REFERENCES proyecto.cliente(id)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
CONSTRAINT fk_venta_forma_pago
FOREIGN KEY (forma_pago_id)
REFERENCES proyecto.forma_pago(id)
ON DELETE NO ACTION
ON UPDATE NO ACTION)
ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS proyecto.compra(
id INT NOT NULL AUTO_INCREMENT,
cantidad INT NOT NULL,
fecha DATETIME NOT NULL,
usuario_id INT NOT NULL,
proveedor_id INT NOT NULL,
forma_pago_id INT NOT NULL,
PRIMARY KEY (id),
INDEX fk_compra_usuario_idx(usuario_id ASC)VISIBLE,
INDEX fk_compra_Proveedor_idx(proveedor_id ASC)VISIBLE,
INDEX fk_comprea_forma_pago_idx(forma_pago_id ASC)VISIBLE,
CONSTRAINT fk_compra_usuario
FOREIGN KEY(usuario_id)
REFERENCES proyecto.usuario(id)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
CONSTRAINT fk_compra_proveedor
FOREIGN KEY(proveedor_id)
REFERENCES proyecto.proveedor(id)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
CONSTRAINT fk_compra_Forma_pago
FOREIGN KEY(forma_pago_id)
REFERENCES proyecto.forma_pago(id)
ON DELETE NO ACTION
ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS proyecto.detalle_compra(
id INT NOT NULL AUTO_INCREMENT,
cantidad INT NOT NULL,
compra_id INT NOT NULL,
producto_id int NOT NULL,
PRIMARY KEY(id),
INDEX fk_detalle_compra_compra_idx(compra_id ASC)VISIBLE,
INDEX fk_detalle_compra_producto_idx(producto_id ASC)VISIBLE,
CONSTRAINT fk_detalle_compra_compra
FOREIGN KEY (compra_id)
REFERENCES proyecto.compra(id)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
CONSTRAINT fk_detalle_compra_producto
FOREIGN KEY (producto_id)
REFERENCES proyecto.producto(id)
ON DELETE NO ACTION
ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS proyecto.detalle_venta(
id INT NOT NULL AUTO_INCREMENT,
cantidad INT NOT NULL,
venta_id INT NOT NULL,
producto_id int NOT NULL,
PRIMARY KEY (id),
INDEX fk_detalle_venta_venta_idx(venta_id ASC)VISIBLE,
INDEX fk_detalle_venta_producto_idx(producto_id ASC)VISIBLE,
CONSTRAINT fk_detalle_venta_venta
FOREIGN KEY (venta_id)
REFERENCES proyecto.venta(id)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
CONSTRAINT fk_detalle_venta_producto
FOREIGN KEY (producto_id)
REFERENCES proyecto.producto(id)
ON DELETE NO ACTION
ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS proyecto.rol(
id INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(45) NOT NULL,
descripcion VARCHAR(45) NOT NULL,
PRIMARY KEY (id))
ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS proyecto.usuario_has_rol(
rol_id INT NOT NULL auto_increment,
usuario_id INT NOT NULL,
PRIMARY KEY(rol_id, Usuario_id),
INDEX fk_usuario_has_rol_usuario_idx(usuario_id ASC)VISIBLE,
CONSTRAINT fk_usuario_has_rol_rol
FOREIGN KEY(rol_id)
REFERENCES proyecto.rol(id)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
CONSTRAINT fk_usuario_has_rol_usuario
FOREIGN KEY (usuario_id)
REFERENCES proyecto.usuario(id)
ON DELETE NO ACTION
ON UPDATE NO ACTION)
ENGINE=InnoDB;


