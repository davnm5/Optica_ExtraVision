
use optica;
DELIMITER $$
DROP PROCEDURE IF EXISTS registrar_pacientes$$
create PROCEDURE `registrar_pacientes`(in nombres varchar(45), in apellidos varchar(45),in direccion varchar(45),in cedula int(11),in telefono int (10) )
BEGIN
   insert into paciente(nombre,apellido,direccion,cedula,telefono)
   values(nombres,apellidos,direccion,cedula,telefono);
    END$$
  DELIMITER ;  
  
