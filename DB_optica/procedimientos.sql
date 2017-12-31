
use optica;
DELIMITER $$
DROP PROCEDURE IF EXISTS registrar_pacientes$$
create PROCEDURE `registrar_pacientes`(in nombres varchar(45), in apellidos varchar(45),in direccion varchar(45),
in cedula int(11),in telefono int (10), in id int(11) )
BEGIN
   insert into paciente(nombre,apellido,direccion,cedula,telefono,Empresa_idEmpresa)
   values(nombres,apellidos,direccion,cedula,telefono,id);
    END$$
  DELIMITER ;  
  
  
  use optica;
  DELIMITER $$
DROP PROCEDURE IF EXISTS registrar_productos$$
create PROCEDURE registrar_productos(in precio_lente float, in descripcion_lente varchar(100),cantidad_lentes int(10),
in precio_lunas float,in marca varchar(45) ,in descripcion_lunas varchar(100),cantidad_lunas int(10))
BEGIN
insert into lentes(precio,descripcion,cantidad)
   values(precio_lente,descripcion_lente,cantidad_lentes);
insert into par_lunas(precio,marca,descripcion,cantidad)
	values(precio_lunas,marca,descripcion_lunas,cantidad_lunas);
    END$$
  DELIMITER ;  
  