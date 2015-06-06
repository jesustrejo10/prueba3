insert into PERMISO values(1,'Usuario');
insert into PERMISO values(2,'Edificio');
insert into PERMISO values(3,'contrato');
insert into PERMISO values(4,'Propietario');
insert into PERMISO values(5,'Bienes Raices');
insert into PERMISO values(6,'JuntaCondominio');
insert into PROPIETARIO values (1,'JUAN','ANDRES','PEREZ','GONZALEZ',9100314);
insert into PROPIETARIO values (2,'LUIS','ENRIQUE','RODRIGUEZ','BOLIVAR',11113003); 
insert into PROPIETARIO values (3,'MARIA','LAURA','GUTIERREZ','',12133001);
insert into PROPIETARIO values (4,'MIGUEL','ANGEL','ZAMORA','MIRANDA',13151003);
insert into PROPIETARIO values (5,'ANA','ISABEL','MENDEZ','',14159006);
insert into PROPIETARIO values (6,'ARMANDO','','PEREZ','GONZALEZ',20264029);
insert into PROPIETARIO values (7,'LUIS','ENRIQUE','HERNANDEZ','',14161002); 
insert into PROPIETARIO values (8,'ASTRID','','GUTIERREZ','',13151001);
insert into PROPIETARIO values (9,'PEDRO','','ZAMORA','',13147007);
insert into PROPIETARIO values (10,'JOSE','ISRAEL','MENDEZ','PACHECO',12136003);
insert into PROPIETARIO values (11,'FABRICIO','LUIS','SANTO','',9100314);
insert into PROPIETARIO values (12,'KATHERINE','VALENTINA','BOLIVAR','',11113003); 
insert into PROPIETARIO values (13,'ESTHER','LAURA','GUTIERREZ','',12133001);
insert into PROPIETARIO values (14,'DANIELA','ANGEL','','MIRANDA',13151003);
insert into PROPIETARIO values (15,'GABRIELA','ISABEL','','',14159006);
insert into PROPIETARIO values (16,'FRANCISCO','','PEREZ','',20264029);
insert into PROPIETARIO values (17,'ABRAHAM','ENRIQUE','HERNANDEZ','',14161002); 
insert into PROPIETARIO values (18,'CARLOS','','SOTO','',13151001);
insert into PROPIETARIO values (19,'CESAR','','CAYO','',13147007);
insert into PROPIETARIO values (20,'ANGELA','','CHAVEZ','PACHECO',12136003);
insert into FONDO values (4,'CAJACHICA');
insert into FONDO values (2,'RESERVA');
insert into FONDO values (3,'MEJORA');
insert into FONDO values (1,'TRABAJO');
insert into HORARIO values(1,'OFICINA','LUNES');	
insert into HORARIO values(2,'OFICINA','MARTES');
insert into HORARIO values(3,'OFICINA','MIERCOLES');
insert into HORARIO values(4,'OFICINA','JUEVES');
insert into HORARIO values(5,'OFICINA','VIERNES');
insert into HORARIO values(6,'OFICINA','SABADO');
insert into HORARIO values(7,'OFICINA','DOMINGO');
insert into HORARIO values(8,'ASAMBLEA','LUNES');
insert into HORARIO values(9,'ASAMBLEA','MARTES');
insert into HORARIO values(10,'ASAMBLEA','MIERCOLES');
insert into HORARIO values(11,'ASAMBLEA','JUEVES');
insert into HORARIO values(12,'ASAMBLEA','VIERNES');
insert into HORARIO values(13,'ASAMBLEA','SABADO');
insert into HORARIO values(14,'ASAMBLEA','DOMINGO');
insert into ROL(ROL_CLAVE,ROL_NOMBRE,ROL_DESCRIPCION) VALUES (1,'MASTER','ROL_DE_PRUEBA');
insert into CHEQUE values(1,'Pago Recibo Mensual',2000,'ENDOSABLE','01');
insert into CHEQUE values(2,'Pago Cuota Especial',1500,'NO_ENDOSABLE','02');
insert into CHEQUE values(3,'Deposito Mensual',5000,'ENDOSABLE','03');
insert into CHEQUE values(4,'Reparaciones Lobby',500,'NO_ENDOSABLE','04');
insert into CHEQUE values(5,'Reparaciones Lobby',900,'NO_ENDOSABLE','05');
insert into TARJETA values(1,'Parte de pago Recibo',1500,'0001','CREDITO');
insert into TARJETA values(2,'Cuota mensual Apartamento',3000,'0002','DEBITO');
insert into TARJETA values(3,'2do Pago Mensual Recibo',780,'0003','DEBITO');
insert into TARJETA values(4,'Parte de pago Recibo',980,'0004','CREDITO');
insert into TARJETA values(5,'Cuota Mensual',2000,'0005','DEBITO');	
insert into EMPLEADO values(1,'Luis','Manuel','Rojas','');
insert into EMPLEADO values(2,'Jesus','','Trejo','');
insert into EMPLEADO values(3,'Gustavo','Jose','Mendez','Torres');
insert into EMPLEADO values(4,'Pedro','Jose','Hernandez','Herrera');
insert into EMPLEADO values(5,'Juan','Javier','Ramos','Mendoza');
insert into EMPLEADO values(6,'Ana','Karina','Profe','');
insert into EMPLEADO values(7,'Aracelis','Del Carmen','Torres','Fernandez');
insert into EMPLEADO values(8,'Julio','Cesar','Mendez','Issa');
insert into EMPLEADO values(9,'Orlando','Jose','Vale','Torres');
insert into EMPLEADO values(10,'Juan','Manuel','Govea','Torres');
insert into EMPLEADO values(11,'Daniel','Alfredo','Febres','Cordero');
insert into EMPLEADO values(12,'Daniel','','Santiago','Romero');
insert into EMPLEADO values(13,'Rodrigo','Alfonso','Alvarez','');
insert into EMPLEADO values(14,'Pedro','','Marinez','');
insert into EMPLEADO values(15,'George','','Madi','');
INSERT INTO PROVEEDORSERVICIO VALUES (1010,'LUZ ELECTRICA','PROVEEDOR DE ELECTRICIDAD');
INSERT INTO PROVEEDORSERVICIO VALUES (1011,'HIDROCAPITAL','PROVEEDOR DE AGUA POTABLE');
INSERT INTO PROVEEDORSERVICIO VALUES (1012,'CANTV','PROVEEDOR DE TELEFONIA');
INSERT INTO PROVEEDORSERVICIO VALUES (1013,'DIRECTV','PROVEEDOR DE TELEVISION');
INSERT INTO PROVEEDORSERVICIO VALUES (1014,'PICINAS A DOMICILIO','SERVICIOS DE PISCINA');
INSERT INTO PROVEEDORSERVICIO VALUES (1015,'TE CUIDAMOS','PROVEEDOR DE SEGURIDAD');
INSERT INTO PROVEEDORSERVICIO VALUES (1016,'ASENSORIA','SERVICIOS DE ASENSORES');
INSERT INTO PROVEEDORSERVICIO VALUES (1017,'TU JARDIN','MANTENIMIENTO DE AREAS VERDES');
insert into UNIDADTRIBUTARIA VALUES(1,3,'SI');
insert into ROLPER(RP_CLAVE,RP_FK_PERMISO,RP_FK_ROL) VALUES (1,1,1);
insert into ROLPER(RP_CLAVE,RP_FK_PERMISO,RP_FK_ROL) VALUES (2,2,1);
insert into ROLPER(RP_CLAVE,RP_FK_PERMISO,RP_FK_ROL) VALUES (3,3,1);
insert into ROLPER(RP_CLAVE,RP_FK_PERMISO,RP_FK_ROL) VALUES (4,4,1);
insert into ROLPER(RP_CLAVE,RP_FK_PERMISO,RP_FK_ROL) VALUES (5,5,1);
insert into ROLPER(RP_CLAVE,RP_FK_PERMISO,RP_FK_ROL) VALUES (6,6,1);
insert into OFICINA values(1,'Automatic@hotmail.com','floresta',14154);
insert into OFICINA values(2,'Automatic@hotmail.com','Cremo',14154);
insert into OFICINA values(3,'Automatic@hotmail.com','Rosaria',14154);
insert into OFICINA values(4,'Automatic@hotmail.com','Las Velitas',14154);
insert into OFICINA values(5,'Automatic@hotmail.com','Administradora C.A',14154);
insert into OFICINA values(6,'Automatic@hotmail.com','Juntas C.A',14154);
insert into OFICINA values(7,'Automatic@hotmail.com','Registros y Administraciones',14154);
insert into OFICINA values(8,'Automatic@hotmail.com','Edificios y Casas',14154);
insert into OFICINA values(9,'Automatic@hotmail.com','Casas y Edificios',14154);
insert into OFICINA values(10,'Automatic@hotmail.com','Administramos C.A',14154);
insert into OFICINA values(11,'Automatic@hotmail.com','Te Ayudamos',14154);
insert into OFICINA values(12,'Automatic@hotmail.com','Nosotros lo Tenemos C.A',14154);
insert into OFICINA values(13,'Automatic@hotmail.com','Se Ordena',14154);
insert into OFICINA values(14,'Automatic@hotmail.com','La Junta es de Todos',14154);
insert into OFICINA values(15,'Automatic@hotmail.com','El Orden Juntas C.A',14154);
insert into OFICINA values(16,'Automatic@hotmail.com','Administradora Anonima C.A',14154);
insert into OFICINA values(17,'Automatic@hotmail.com','Administradora No tan Anonima C.A',14154);
insert into OFICINA values(18,'Automatic@hotmail.com','Juntas Condominio',14154);
insert into OFICINA values(19,'Automatic@hotmail.com','Loto',14154);
insert into OFICINA values(20,'Automatic@hotmail.com','Rosas C.A',14154);

insert into ASAMBLEA values(1,'Obras de Mantenimiento','13/06/15','ORDINARIA',1,14154);
insert into ASAMBLEA values(2,'Reparacion Tubo de Gas','18/02/15','EXTRAORDINARIA',4,14154);
insert into ASAMBLEA values(3,'Obras de Mantenimiento','19/07/15','ORDINARIA',12,14154);
insert into ASAMBLEA values(4,'Obras de Mantenimiento','11/12/15','ORDINARIA',1,14154);
insert into ASAMBLEA values(5,'Reparacion Calle 14','12/04/15','EXTRAORDINARIA',3,14154);


insert into EMP_OFI values(1,'Jefe Administrativo',3,1);
insert into EMP_OFI values(2,'Registrador',5,4);
insert into EMP_OFI values(3,'Coordinador',8,7);
insert into EMP_OFI values(4,'Jefe Administrativo',14,2);
insert into EMP_OFI values(5,'Coordinador',3,3);
insert into EMP_OFI values(6,'Jefe Administrativo',8,9);
insert into EMP_OFI values(7,'Jefe Administrativo',2,10);
insert into EMP_OFI values(8,'Jefe Administrativo',4,5);
insert into EMP_OFI values(9,'Jefe Administrativo',10,8);
insert into EMP_OFI values(10,'Delegado',4,6);
insert into EMP_OFI values(11,'Jefe Despacho',4,12);
insert into EMP_OFI values(12,'Jefe Administrativo',5,15);
insert into EMP_OFI values(13,'Jefe Administrativo',7,6);	


insert into EDIFICIO values(1,'J-5768493','Terrazas del Avila',14154);
insert into EDIFICIO values(2,'J-5769071','Margaritas',14154);
insert into EDIFICIO values(3,'J-5769649','Rosas',14154);
insert into EDIFICIO values(4,'J-5770227','La Piedra',14154);
insert into EDIFICIO values(5,'J-5770805','Montaña Grande',14154);
insert into EDIFICIO values(6,'J-5771383','Montaña Pequeña',14154);
insert into EDIFICIO values(7,'J-5771961','Alto Grande',14154);
insert into EDIFICIO values(8,'J-5772539','Alto Pequeño',14154);
insert into EDIFICIO values(9,'J-5773117','Gran Baja de Arriba',14154);
insert into EDIFICIO values(10,'J-5773695','Gran Arriba de Abajo',14154);
insert into EDIFICIO values(11,'J-5774273','La Hacienda',14154);
insert into EDIFICIO values(12,'J-5774851','La Molienda',14154);
insert into EDIFICIO values(13,'J-5775429','La Casona',14154);
insert into EDIFICIO values(14,'J-5776007','Villa Hermosa',14154);
insert into EDIFICIO values(15,'J-5776585','Torreon',14154);
insert into EDIFICIO values(16,'J-5777163','La Esperanza',14154);
insert into EDIFICIO values(17,'J-5777741','El Rodeo',14154);
insert into EDIFICIO values(18,'J-5778319','La Guarita',14154);
insert into EDIFICIO values(19,'J-5778897','Plaza',14154);
insert into EDIFICIO values(20,'J-5779475','Mirandinos',14154);
insert into EDIFICIO values(21,'J-5780053','Mocuchies',14154);
insert into EDIFICIO values(22,'J-5780631','Avila Grande',14154);
insert into EDIFICIO values(23,'J-5781209','Avila Pequeña',14154);
insert into EDIFICIO values(24,'J-5781787','Los Altos',14154);
insert into EDIFICIO values(25,'J-5782365','La Trinidad',14154);
insert into EDIFICIO values(26,'J-5782943','Parque Grande',14154);
insert into EDIFICIO values(27,'J-5783521','Parque Pequeño',14154);
insert into EDIFICIO values(28,'J-5784099','El Venado',14154);
insert into EDIFICIO values(29,'J-5784677','El Paraiso',14154);
insert into EDIFICIO values(30,'J-5785255','Gran Altamira',14154);

insert into APARTAMENTO VALUES (1,'75m X 80m')
insert into CUENTA VALUES (1,'75m X 80m')
insert into APT_DET VALUES (1,10,1,12,'',1,1,1000000,'NO',1);
insert into APARTAMENTO VALUES (2,'75m X 80m')
insert into CUENTA VALUES (2,'75m X 80m')
insert into APT_DET VALUES (2,10,2,19,'',1,2,1000000,'NO',11);
insert into APARTAMENTO VALUES (3,'75m X 80m')
insert into CUENTA VALUES (3,'75m X 80m')
insert into APT_DET VALUES (3,10,3,4,'',1,3,1000000,'NO',10);
insert into APARTAMENTO VALUES (4,'75m X 80m')
insert into CUENTA VALUES (4,'75m X 80m')
insert into APT_DET VALUES (4,10,4,17,'',1,4,1000000,'NO',4);
insert into APARTAMENTO VALUES (5,'75m X 80m')
insert into CUENTA VALUES (5,'75m X 80m')
insert into APT_DET VALUES (5,10,5,7,'',1,5,1000000,'NO',1);
insert into APARTAMENTO VALUES (6,'75m X 80m')
insert into CUENTA VALUES (6,'75m X 80m')
insert into APT_DET VALUES (6,10,6,7,'',1,6,1000000,'NO',11);
insert into APARTAMENTO VALUES (7,'75m X 80m')
insert into CUENTA VALUES (7,'75m X 80m')
insert into APT_DET VALUES (7,10,7,14,'',1,7,1000000,'NO',14);
insert into APARTAMENTO VALUES (8,'75m X 80m')
insert into CUENTA VALUES (8,'75m X 80m')
insert into APT_DET VALUES (8,10,8,16,'',1,8,1000000,'NO',11);
insert into APARTAMENTO VALUES (9,'75m X 80m')
insert into CUENTA VALUES (9,'75m X 80m')
insert into APT_DET VALUES (9,10,9,17,'',1,9,1000000,'NO',10);
insert into APARTAMENTO VALUES (10,'75m X 80m')
insert into CUENTA VALUES (10,'75m X 80m')
insert into APT_DET VALUES (10,10,10,12,'',1,10,1000000,'NO',7);
insert into APARTAMENTO VALUES (11,'75m X 80m')
insert into CUENTA VALUES (11,'75m X 80m')
insert into APT_DET VALUES (11,10,11,6,'',2,11,1000000,'NO',6);
insert into APARTAMENTO VALUES (12,'75m X 80m')
insert into CUENTA VALUES (12,'75m X 80m')
insert into APT_DET VALUES (12,10,12,10,'',2,12,1000000,'NO',1);
insert into APARTAMENTO VALUES (13,'75m X 80m')
insert into CUENTA VALUES (13,'75m X 80m')
insert into APT_DET VALUES (13,10,13,13,'',2,13,1000000,'NO',5);
insert into APARTAMENTO VALUES (14,'75m X 80m')
insert into CUENTA VALUES (14,'75m X 80m')
insert into APT_DET VALUES (14,10,14,5,'',2,14,1000000,'NO',3);
insert into APARTAMENTO VALUES (15,'75m X 80m')
insert into CUENTA VALUES (15,'75m X 80m')
insert into APT_DET VALUES (15,10,15,16,'',2,15,1000000,'NO',6);
insert into APARTAMENTO VALUES (16,'75m X 80m')
insert into CUENTA VALUES (16,'75m X 80m')
insert into APT_DET VALUES (16,10,16,9,'',2,16,1000000,'NO',15);
insert into APARTAMENTO VALUES (17,'75m X 80m')
insert into CUENTA VALUES (17,'75m X 80m')
insert into APT_DET VALUES (17,10,17,20,'',2,17,1000000,'NO',11);
insert into APARTAMENTO VALUES (18,'75m X 80m')
insert into CUENTA VALUES (18,'75m X 80m')
insert into APT_DET VALUES (18,10,18,16,'',2,18,1000000,'NO',6);
insert into APARTAMENTO VALUES (19,'75m X 80m')
insert into CUENTA VALUES (19,'75m X 80m')
insert into APT_DET VALUES (19,10,19,6,'',2,19,1000000,'NO',13);
insert into APARTAMENTO VALUES (20,'75m X 80m')
insert into CUENTA VALUES (20,'75m X 80m')
insert into APT_DET VALUES (20,10,20,9,'',2,20,1000000,'NO',5);
insert into APARTAMENTO VALUES (21,'75m X 80m')
insert into CUENTA VALUES (21,'75m X 80m')
insert into APT_DET VALUES (21,10,21,3,'',3,21,1000000,'NO',1);
insert into APARTAMENTO VALUES (22,'75m X 80m')
insert into CUENTA VALUES (22,'75m X 80m')
insert into APT_DET VALUES (22,10,22,7,'',3,22,1000000,'NO',1);
insert into APARTAMENTO VALUES (23,'75m X 80m')
insert into CUENTA VALUES (23,'75m X 80m')
insert into APT_DET VALUES (23,10,23,2,'',3,23,1000000,'NO',9);
insert into APARTAMENTO VALUES (24,'75m X 80m')
insert into CUENTA VALUES (24,'75m X 80m')
insert into APT_DET VALUES (24,10,24,5,'',3,24,1000000,'NO',4);
insert into APARTAMENTO VALUES (25,'75m X 80m')
insert into CUENTA VALUES (25,'75m X 80m')
insert into APT_DET VALUES (25,10,25,5,'',3,25,1000000,'NO',13);
insert into APARTAMENTO VALUES (26,'75m X 80m')
insert into CUENTA VALUES (26,'75m X 80m')
insert into APT_DET VALUES (26,10,26,15,'',3,26,1000000,'NO',1);
insert into APARTAMENTO VALUES (27,'75m X 80m')
insert into CUENTA VALUES (27,'75m X 80m')
insert into APT_DET VALUES (27,10,27,14,'',3,27,1000000,'NO',1);
insert into APARTAMENTO VALUES (28,'75m X 80m')
insert into CUENTA VALUES (28,'75m X 80m')
insert into APT_DET VALUES (28,10,28,12,'',3,28,1000000,'NO',1);
insert into APARTAMENTO VALUES (29,'75m X 80m')
insert into CUENTA VALUES (29,'75m X 80m')
insert into APT_DET VALUES (29,10,29,11,'',3,29,1000000,'NO',8);
insert into APARTAMENTO VALUES (30,'75m X 80m')
insert into CUENTA VALUES (30,'75m X 80m')
insert into APT_DET VALUES (30,10,30,19,'',3,30,1000000,'NO',1);
insert into APARTAMENTO VALUES (31,'75m X 80m')
insert into CUENTA VALUES (31,'75m X 80m')
insert into APT_DET VALUES (31,10,31,18,'',4,31,1000000,'NO',3);
insert into APARTAMENTO VALUES (32,'75m X 80m')
insert into CUENTA VALUES (32,'75m X 80m')
insert into APT_DET VALUES (32,10,32,16,'',4,32,1000000,'NO',10);
insert into APARTAMENTO VALUES (33,'75m X 80m')
insert into CUENTA VALUES (33,'75m X 80m')
insert into APT_DET VALUES (33,10,33,17,'',4,33,1000000,'NO',11);
insert into APARTAMENTO VALUES (34,'75m X 80m')
insert into CUENTA VALUES (34,'75m X 80m')
insert into APT_DET VALUES (34,10,34,13,'',4,34,1000000,'NO',14);
insert into APARTAMENTO VALUES (35,'75m X 80m')
insert into CUENTA VALUES (35,'75m X 80m')
insert into APT_DET VALUES (35,10,35,13,'',4,35,1000000,'NO',15);
insert into APARTAMENTO VALUES (36,'75m X 80m')
insert into CUENTA VALUES (36,'75m X 80m')
insert into APT_DET VALUES (36,10,36,8,'',4,36,1000000,'NO',3);
insert into APARTAMENTO VALUES (37,'75m X 80m')
insert into CUENTA VALUES (37,'75m X 80m')
insert into APT_DET VALUES (37,10,37,8,'',4,37,1000000,'NO',14);
insert into APARTAMENTO VALUES (38,'75m X 80m')
insert into CUENTA VALUES (38,'75m X 80m')
insert into APT_DET VALUES (38,10,38,19,'',4,38,1000000,'NO',3);
insert into APARTAMENTO VALUES (39,'75m X 80m');
insert into CUENTA VALUES (39,'75m X 80m');
insert into APT_DET VALUES (39,10,39,'',18,4,39,1000000,'NO',15);
insert into APARTAMENTO VALUES (40,'75m X 80m');
insert into CUENTA VALUES (40,'75m X 80m');
insert into APT_DET VALUES (40,10,40,'',4,4,40,1000000,'NO',7);
insert into APARTAMENTO VALUES (41,'75m X 80m')
insert into CUENTA VALUES (41,'75m X 80m')
insert into APT_DET VALUES (41,10,41,4,'',5,41,1000000,'NO',5);
insert into APARTAMENTO VALUES (42,'75m X 80m')
insert into CUENTA VALUES (42,'75m X 80m')
insert into APT_DET VALUES (42,10,42,15,'',5,42,1000000,'NO',10);
insert into APARTAMENTO VALUES (43,'75m X 80m')
insert into CUENTA VALUES (43,'75m X 80m')
insert into APT_DET VALUES (43,10,43,14,'',5,43,1000000,'NO',1);
insert into APARTAMENTO VALUES (44,'75m X 80m')
insert into CUENTA VALUES (44,'75m X 80m')
insert into APT_DET VALUES (44,10,44,15,'',5,44,1000000,'NO',10);
insert into APARTAMENTO VALUES (45,'75m X 80m')
insert into CUENTA VALUES (45,'75m X 80m')
insert into APT_DET VALUES (45,10,45,16,'',5,45,1000000,'NO',3);
insert into APARTAMENTO VALUES (46,'75m X 80m')
insert into CUENTA VALUES (46,'75m X 80m')
insert into APT_DET VALUES (46,10,46,16,'',5,46,1000000,'NO',1);
insert into APARTAMENTO VALUES (47,'75m X 80m')
insert into CUENTA VALUES (47,'75m X 80m')
insert into APT_DET VALUES (47,10,47,12,'',5,47,1000000,'NO',5);
insert into APARTAMENTO VALUES (48,'75m X 80m')
insert into CUENTA VALUES (48,'75m X 80m')
insert into APT_DET VALUES (48,10,48,6,'',5,48,1000000,'NO',4);
insert into APARTAMENTO VALUES (49,'75m X 80m')
insert into CUENTA VALUES (49,'75m X 80m')
insert into APT_DET VALUES (49,10,49,8,'',5,49,1000000,'NO',14);
insert into APARTAMENTO VALUES (50,'75m X 80m')
insert into CUENTA VALUES (50,'75m X 80m')
insert into APT_DET VALUES (50,10,50,17,'',5,50,1000000,'NO',2);
insert into APARTAMENTO VALUES (51,'75m X 80m')
insert into CUENTA VALUES (51,'75m X 80m')
insert into APT_DET VALUES (51,10,51,2,'',6,51,1000000,'NO',7);
insert into APARTAMENTO VALUES (52,'75m X 80m')
insert into CUENTA VALUES (52,'75m X 80m')
insert into APT_DET VALUES (52,10,52,2,'',6,52,1000000,'NO',3);
insert into APARTAMENTO VALUES (53,'75m X 80m')
insert into CUENTA VALUES (53,'75m X 80m')
insert into APT_DET VALUES (53,10,53,3,'',6,53,1000000,'NO',14);
insert into APARTAMENTO VALUES (54,'75m X 80m')
insert into CUENTA VALUES (54,'75m X 80m')
insert into APT_DET VALUES (54,10,54,9,'',6,54,1000000,'NO',7);
insert into APARTAMENTO VALUES (55,'75m X 80m');
insert into CUENTA VALUES (55,'75m X 80m');
insert into APT_DET VALUES (55,10,55,'',6,6,55,1000000,'NO',1);
insert into APARTAMENTO VALUES (56,'75m X 80m')
insert into CUENTA VALUES (56,'75m X 80m')
insert into APT_DET VALUES (56,10,56,17,'',6,56,1000000,'NO',7);
insert into APARTAMENTO VALUES (57,'75m X 80m')
insert into CUENTA VALUES (57,'75m X 80m')
insert into APT_DET VALUES (57,10,57,12,'',6,57,1000000,'NO',9);
insert into APARTAMENTO VALUES (58,'75m X 80m')
insert into CUENTA VALUES (58,'75m X 80m')
insert into APT_DET VALUES (58,10,58,2,'',6,58,1000000,'NO',4);
insert into APARTAMENTO VALUES (59,'75m X 80m')
insert into CUENTA VALUES (59,'75m X 80m')
insert into APT_DET VALUES (59,10,59,6,'',6,59,1000000,'NO',14);
insert into APARTAMENTO VALUES (60,'75m X 80m')
insert into CUENTA VALUES (60,'75m X 80m')
insert into APT_DET VALUES (60,10,60,1,'',6,60,1000000,'NO',12);
insert into APARTAMENTO VALUES (61,'75m X 80m')
insert into CUENTA VALUES (61,'75m X 80m')
insert into APT_DET VALUES (61,10,61,3,'',7,61,1000000,'NO',2);
insert into APARTAMENTO VALUES (62,'75m X 80m')
insert into CUENTA VALUES (62,'75m X 80m')
insert into APT_DET VALUES (62,10,62,3,'',7,62,1000000,'NO',7);
insert into APARTAMENTO VALUES (63,'75m X 80m')
insert into CUENTA VALUES (63,'75m X 80m')
insert into APT_DET VALUES (63,10,63,12,'',7,63,1000000,'NO',8);
insert into APARTAMENTO VALUES (64,'75m X 80m')
insert into CUENTA VALUES (64,'75m X 80m')
insert into APT_DET VALUES (64,10,64,3,'',7,64,1000000,'NO',6);
insert into APARTAMENTO VALUES (65,'75m X 80m')
insert into CUENTA VALUES (65,'75m X 80m')
insert into APT_DET VALUES (65,10,65,16,'',7,65,1000000,'NO',8);
insert into APARTAMENTO VALUES (66,'75m X 80m')
insert into CUENTA VALUES (66,'75m X 80m')
insert into APT_DET VALUES (66,10,66,3,'',7,66,1000000,'NO',14);
insert into APARTAMENTO VALUES (67,'75m X 80m')
insert into CUENTA VALUES (67,'75m X 80m')
insert into APT_DET VALUES (67,10,67,14,'',7,67,1000000,'NO',1);
insert into APARTAMENTO VALUES (68,'75m X 80m')
insert into CUENTA VALUES (68,'75m X 80m')
insert into APT_DET VALUES (68,10,68,16,'',7,68,1000000,'NO',2);
insert into APARTAMENTO VALUES (69,'75m X 80m')
insert into CUENTA VALUES (69,'75m X 80m')
insert into APT_DET VALUES (69,10,69,13,'',7,69,1000000,'NO',1);
insert into APARTAMENTO VALUES (70,'75m X 80m')
insert into CUENTA VALUES (70,'75m X 80m')
insert into APT_DET VALUES (70,10,70,7,'',7,70,1000000,'NO',1);
insert into APARTAMENTO VALUES (71,'75m X 80m')
insert into CUENTA VALUES (71,'75m X 80m')
insert into APT_DET VALUES (71,10,71,13,'',8,71,1000000,'NO',5);
insert into APARTAMENTO VALUES (72,'75m X 80m')
insert into CUENTA VALUES (72,'75m X 80m')
insert into APT_DET VALUES (72,10,72,3,'',8,72,1000000,'NO',13);
insert into APARTAMENTO VALUES (73,'75m X 80m')
insert into CUENTA VALUES (73,'75m X 80m')
insert into APT_DET VALUES (73,10,73,9,'',8,73,1000000,'NO',1);
insert into APARTAMENTO VALUES (74,'75m X 80m')
insert into CUENTA VALUES (74,'75m X 80m')
insert into APT_DET VALUES (74,10,74,14,'',8,74,1000000,'NO',15);
insert into APARTAMENTO VALUES (75,'75m X 80m')
insert into CUENTA VALUES (75,'75m X 80m')
insert into APT_DET VALUES (75,10,75,14,'',8,75,1000000,'NO',8);
insert into APARTAMENTO VALUES (76,'75m X 80m')
insert into CUENTA VALUES (76,'75m X 80m')
insert into APT_DET VALUES (76,10,76,13,'',8,76,1000000,'NO',4);
insert into APARTAMENTO VALUES (77,'75m X 80m')
insert into CUENTA VALUES (77,'75m X 80m')
insert into APT_DET VALUES (77,10,77,17,'',8,77,1000000,'NO',4);
insert into APARTAMENTO VALUES (78,'75m X 80m')
insert into CUENTA VALUES (78,'75m X 80m')
insert into APT_DET VALUES (78,10,78,7,'',8,78,1000000,'NO',10);
insert into APARTAMENTO VALUES (79,'75m X 80m')
insert into CUENTA VALUES (79,'75m X 80m')
insert into APT_DET VALUES (79,10,79,11,'',8,79,1000000,'NO',10);
insert into APARTAMENTO VALUES (80,'75m X 80m')
insert into CUENTA VALUES (80,'75m X 80m')
insert into APT_DET VALUES (80,10,80,15,'',8,80,1000000,'NO',12);
insert into APARTAMENTO VALUES (81,'75m X 80m')
insert into CUENTA VALUES (81,'75m X 80m')
insert into APT_DET VALUES (81,10,81,6,'',9,81,1000000,'NO',8);
insert into APARTAMENTO VALUES (82,'75m X 80m')
insert into CUENTA VALUES (82,'75m X 80m')
insert into APT_DET VALUES (82,10,82,3,'',9,82,1000000,'NO',4);
insert into APARTAMENTO VALUES (83,'75m X 80m');
insert into CUENTA VALUES (83,'75m X 80m');
insert into APT_DET VALUES (83,10,83,'',16,9,83,1000000,'NO',5);
insert into APARTAMENTO VALUES (84,'75m X 80m')
insert into CUENTA VALUES (84,'75m X 80m')
insert into APT_DET VALUES (84,10,84,2,'',9,84,1000000,'NO',1);
insert into APARTAMENTO VALUES (85,'75m X 80m')
insert into CUENTA VALUES (85,'75m X 80m')
insert into APT_DET VALUES (85,10,85,16,'',9,85,1000000,'NO',8);
insert into APARTAMENTO VALUES (86,'75m X 80m')
insert into CUENTA VALUES (86,'75m X 80m')
insert into APT_DET VALUES (86,10,86,16,'',9,86,1000000,'NO',12);
insert into APARTAMENTO VALUES (87,'75m X 80m')
insert into CUENTA VALUES (87,'75m X 80m')
insert into APT_DET VALUES (87,10,87,13,'',9,87,1000000,'NO',15);
insert into APARTAMENTO VALUES (88,'75m X 80m')
insert into CUENTA VALUES (88,'75m X 80m')
insert into APT_DET VALUES (88,10,88,10,'',9,88,1000000,'NO',9);
insert into APARTAMENTO VALUES (89,'75m X 80m')
insert into CUENTA VALUES (89,'75m X 80m')
insert into APT_DET VALUES (89,10,89,7,'',9,89,1000000,'NO',15);
insert into APARTAMENTO VALUES (90,'75m X 80m')
insert into CUENTA VALUES (90,'75m X 80m')
insert into APT_DET VALUES (90,10,90,3,'',9,90,1000000,'NO',3);
insert into APARTAMENTO VALUES (91,'75m X 80m')
insert into CUENTA VALUES (91,'75m X 80m')
insert into APT_DET VALUES (91,10,91,1,'',10,91,1000000,'NO',7);
insert into APARTAMENTO VALUES (92,'75m X 80m')
insert into CUENTA VALUES (92,'75m X 80m')
insert into APT_DET VALUES (92,10,92,17,'',10,92,1000000,'NO',1);
insert into APARTAMENTO VALUES (93,'75m X 80m')
insert into CUENTA VALUES (93,'75m X 80m')
insert into APT_DET VALUES (93,10,93,18,'',10,93,1000000,'NO',11);
insert into APARTAMENTO VALUES (94,'75m X 80m')
insert into CUENTA VALUES (94,'75m X 80m')
insert into APT_DET VALUES (94,10,94,17,'',10,94,1000000,'NO',15);
insert into APARTAMENTO VALUES (95,'75m X 80m')
insert into CUENTA VALUES (95,'75m X 80m')
insert into APT_DET VALUES (95,10,95,7,'',10,95,1000000,'NO',13);
insert into APARTAMENTO VALUES (96,'75m X 80m')
insert into CUENTA VALUES (96,'75m X 80m')
insert into APT_DET VALUES (96,10,96,20,'',10,96,1000000,'NO',14);
insert into APARTAMENTO VALUES (97,'75m X 80m')
insert into CUENTA VALUES (97,'75m X 80m')
insert into APT_DET VALUES (97,10,97,5,'',10,97,1000000,'NO',14);
insert into APARTAMENTO VALUES (98,'75m X 80m')
insert into CUENTA VALUES (98,'75m X 80m')
insert into APT_DET VALUES (98,10,98,19,'',10,98,1000000,'NO',7);
insert into APARTAMENTO VALUES (99,'75m X 80m')
insert into CUENTA VALUES (99,'75m X 80m')
insert into APT_DET VALUES (99,10,99,6,'',10,99,1000000,'NO',1);
insert into APARTAMENTO VALUES (100,'75m X 80m')
insert into CUENTA VALUES (100,'75m X 80m')
insert into APT_DET VALUES (100,10,100,10,'',10,100,1000000,'NO',15);
insert into APARTAMENTO VALUES (101,'75m X 80m')
insert into CUENTA VALUES (101,'75m X 80m')
insert into APT_DET VALUES (101,10,101,15,'',11,101,1000000,'NO',1);
insert into APARTAMENTO VALUES (102,'75m X 80m')
insert into CUENTA VALUES (102,'75m X 80m')
insert into APT_DET VALUES (102,10,102,11,'',11,102,1000000,'NO',8);
insert into APARTAMENTO VALUES (103,'75m X 80m')
insert into CUENTA VALUES (103,'75m X 80m')
insert into APT_DET VALUES (103,10,103,8,'',11,103,1000000,'NO',8);
insert into APARTAMENTO VALUES (104,'75m X 80m')
insert into CUENTA VALUES (104,'75m X 80m')
insert into APT_DET VALUES (104,10,104,17,'',11,104,1000000,'NO',9);
insert into APARTAMENTO VALUES (105,'75m X 80m')
insert into CUENTA VALUES (105,'75m X 80m')
insert into APT_DET VALUES (105,10,105,12,'',11,105,1000000,'NO',7);
insert into APARTAMENTO VALUES (106,'75m X 80m')
insert into CUENTA VALUES (106,'75m X 80m')
insert into APT_DET VALUES (106,10,106,8,'',11,106,1000000,'NO',1);
insert into APARTAMENTO VALUES (107,'75m X 80m')
insert into CUENTA VALUES (107,'75m X 80m')
insert into APT_DET VALUES (107,10,107,16,'',11,107,1000000,'NO',9);
insert into APARTAMENTO VALUES (108,'75m X 80m')
insert into CUENTA VALUES (108,'75m X 80m')
insert into APT_DET VALUES (108,10,108,5,'',11,108,1000000,'NO',15);
insert into APARTAMENTO VALUES (109,'75m X 80m');
insert into CUENTA VALUES (109,'75m X 80m');
insert into APT_DET VALUES (109,10,109,'',20,11,109,1000000,'NO',6);
insert into APARTAMENTO VALUES (110,'75m X 80m')
insert into CUENTA VALUES (110,'75m X 80m')
insert into APT_DET VALUES (110,10,110,6,'',11,110,1000000,'NO',7);
insert into APARTAMENTO VALUES (111,'75m X 80m')
insert into CUENTA VALUES (111,'75m X 80m')
insert into APT_DET VALUES (111,10,111,2,'',11,111,1000000,'NO',2);
insert into APARTAMENTO VALUES (112,'75m X 80m')
insert into CUENTA VALUES (112,'75m X 80m')
insert into APT_DET VALUES (112,10,112,20,'',11,112,1000000,'NO',2);
insert into APARTAMENTO VALUES (113,'75m X 80m')
insert into CUENTA VALUES (113,'75m X 80m')
insert into APT_DET VALUES (113,10,113,7,'',11,113,1000000,'NO',8);
insert into APARTAMENTO VALUES (114,'75m X 80m')
insert into CUENTA VALUES (114,'75m X 80m')
insert into APT_DET VALUES (114,10,114,10,'',11,114,1000000,'NO',12);
insert into APARTAMENTO VALUES (115,'75m X 80m')
insert into CUENTA VALUES (115,'75m X 80m')
insert into APT_DET VALUES (115,10,115,14,'',11,115,1000000,'NO',14);
insert into APARTAMENTO VALUES (116,'75m X 80m')
insert into CUENTA VALUES (116,'75m X 80m')
insert into APT_DET VALUES (116,10,116,17,'',11,116,1000000,'NO',13);
insert into APARTAMENTO VALUES (117,'75m X 80m')
insert into CUENTA VALUES (117,'75m X 80m')
insert into APT_DET VALUES (117,10,117,20,'',11,117,1000000,'NO',2);
insert into APARTAMENTO VALUES (118,'75m X 80m')
insert into CUENTA VALUES (118,'75m X 80m')
insert into APT_DET VALUES (118,10,118,11,'',11,118,1000000,'NO',12);
insert into APARTAMENTO VALUES (119,'75m X 80m')
insert into CUENTA VALUES (119,'75m X 80m')
insert into APT_DET VALUES (119,10,119,17,'',11,119,1000000,'NO',6);
insert into APARTAMENTO VALUES (120,'75m X 80m')
insert into CUENTA VALUES (120,'75m X 80m')
insert into APT_DET VALUES (120,10,120,9,'',11,120,1000000,'NO',13);
insert into APARTAMENTO VALUES (121,'75m X 80m')
insert into CUENTA VALUES (121,'75m X 80m')
insert into APT_DET VALUES (121,10,121,18,'',12,121,1000000,'NO',12);
insert into APARTAMENTO VALUES (122,'75m X 80m')
insert into CUENTA VALUES (122,'75m X 80m')
insert into APT_DET VALUES (122,10,122,5,'',12,122,1000000,'NO',7);
insert into APARTAMENTO VALUES (123,'75m X 80m')
insert into CUENTA VALUES (123,'75m X 80m')
insert into APT_DET VALUES (123,10,123,20,'',12,123,1000000,'NO',3);
insert into APARTAMENTO VALUES (124,'75m X 80m')
insert into CUENTA VALUES (124,'75m X 80m')
insert into APT_DET VALUES (124,10,124,1,'',12,124,1000000,'NO',1);
insert into APARTAMENTO VALUES (125,'75m X 80m')
insert into CUENTA VALUES (125,'75m X 80m')
insert into APT_DET VALUES (125,10,125,16,'',12,125,1000000,'NO',9);
insert into APARTAMENTO VALUES (126,'75m X 80m')
insert into CUENTA VALUES (126,'75m X 80m')
insert into APT_DET VALUES (126,10,126,1,'',12,126,1000000,'NO',8);
insert into APARTAMENTO VALUES (127,'75m X 80m')
insert into CUENTA VALUES (127,'75m X 80m')
insert into APT_DET VALUES (127,10,127,15,'',12,127,1000000,'NO',14);
insert into APARTAMENTO VALUES (128,'75m X 80m');
insert into CUENTA VALUES (128,'75m X 80m');
insert into APT_DET VALUES (128,10,128,'',8,12,128,1000000,'NO',1);
insert into APARTAMENTO VALUES (129,'75m X 80m')
insert into CUENTA VALUES (129,'75m X 80m')
insert into APT_DET VALUES (129,10,129,4,'',12,129,1000000,'NO',11);
insert into APARTAMENTO VALUES (130,'75m X 80m')
insert into CUENTA VALUES (130,'75m X 80m')
insert into APT_DET VALUES (130,10,130,9,'',12,130,1000000,'NO',15);
insert into APARTAMENTO VALUES (131,'75m X 80m')
insert into CUENTA VALUES (131,'75m X 80m')
insert into APT_DET VALUES (131,10,131,10,'',12,131,1000000,'NO',10);
insert into APARTAMENTO VALUES (132,'75m X 80m')
insert into CUENTA VALUES (132,'75m X 80m')
insert into APT_DET VALUES (132,10,132,2,'',12,132,1000000,'NO',10);
insert into APARTAMENTO VALUES (133,'75m X 80m')
insert into CUENTA VALUES (133,'75m X 80m')
insert into APT_DET VALUES (133,10,133,15,'',12,133,1000000,'NO',10);
insert into APARTAMENTO VALUES (134,'75m X 80m')
insert into CUENTA VALUES (134,'75m X 80m')
insert into APT_DET VALUES (134,10,134,7,'',12,134,1000000,'NO',11);
insert into APARTAMENTO VALUES (135,'75m X 80m')
insert into CUENTA VALUES (135,'75m X 80m')
insert into APT_DET VALUES (135,10,135,7,'',12,135,1000000,'NO',8);
insert into APARTAMENTO VALUES (136,'75m X 80m')
insert into CUENTA VALUES (136,'75m X 80m')
insert into APT_DET VALUES (136,10,136,13,'',12,136,1000000,'NO',6);
insert into APARTAMENTO VALUES (137,'75m X 80m')
insert into CUENTA VALUES (137,'75m X 80m')
insert into APT_DET VALUES (137,10,137,4,'',12,137,1000000,'NO',4);
insert into APARTAMENTO VALUES (138,'75m X 80m')
insert into CUENTA VALUES (138,'75m X 80m')
insert into APT_DET VALUES (138,10,138,18,'',12,138,1000000,'NO',4);
insert into APARTAMENTO VALUES (139,'75m X 80m')
insert into CUENTA VALUES (139,'75m X 80m')
insert into APT_DET VALUES (139,10,139,15,'',12,139,1000000,'NO',5);
insert into APARTAMENTO VALUES (140,'75m X 80m')
insert into CUENTA VALUES (140,'75m X 80m')
insert into APT_DET VALUES (140,10,140,7,'',12,140,1000000,'NO',5);
insert into APARTAMENTO VALUES (141,'75m X 80m')
insert into CUENTA VALUES (141,'75m X 80m')
insert into APT_DET VALUES (141,10,141,19,'',13,141,1000000,'NO',11);
insert into APARTAMENTO VALUES (142,'75m X 80m')
insert into CUENTA VALUES (142,'75m X 80m')
insert into APT_DET VALUES (142,10,142,13,'',13,142,1000000,'NO',3);
insert into APARTAMENTO VALUES (143,'75m X 80m')
insert into CUENTA VALUES (143,'75m X 80m')
insert into APT_DET VALUES (143,10,143,9,'',13,143,1000000,'NO',1);
insert into APARTAMENTO VALUES (144,'75m X 80m')
insert into CUENTA VALUES (144,'75m X 80m')
insert into APT_DET VALUES (144,10,144,8,'',13,144,1000000,'NO',13);
insert into APARTAMENTO VALUES (145,'75m X 80m')
insert into CUENTA VALUES (145,'75m X 80m')
insert into APT_DET VALUES (145,10,145,4,'',13,145,1000000,'NO',14);
insert into APARTAMENTO VALUES (146,'75m X 80m')
insert into CUENTA VALUES (146,'75m X 80m')
insert into APT_DET VALUES (146,10,146,18,'',13,146,1000000,'NO',14);
insert into APARTAMENTO VALUES (147,'75m X 80m')
insert into CUENTA VALUES (147,'75m X 80m')
insert into APT_DET VALUES (147,10,147,8,'',13,147,1000000,'NO',13);
insert into APARTAMENTO VALUES (148,'75m X 80m')
insert into CUENTA VALUES (148,'75m X 80m')
insert into APT_DET VALUES (148,10,148,7,'',13,148,1000000,'NO',12);
insert into APARTAMENTO VALUES (149,'75m X 80m')
insert into CUENTA VALUES (149,'75m X 80m')
insert into APT_DET VALUES (149,10,149,8,'',13,149,1000000,'NO',6);
insert into APARTAMENTO VALUES (150,'75m X 80m')
insert into CUENTA VALUES (150,'75m X 80m')
insert into APT_DET VALUES (150,10,150,10,'',13,150,1000000,'NO',6);
insert into APARTAMENTO VALUES (151,'75m X 80m')
insert into CUENTA VALUES (151,'75m X 80m')
insert into APT_DET VALUES (151,10,151,1,'',13,151,1000000,'NO',8);
insert into APARTAMENTO VALUES (152,'75m X 80m');
insert into CUENTA VALUES (152,'75m X 80m');
insert into APT_DET VALUES (152,10,152,'',13,13,152,1000000,'NO',12);
insert into APARTAMENTO VALUES (153,'75m X 80m')
insert into CUENTA VALUES (153,'75m X 80m')
insert into APT_DET VALUES (153,10,153,1,'',13,153,1000000,'NO',8);
insert into APARTAMENTO VALUES (154,'75m X 80m')
insert into CUENTA VALUES (154,'75m X 80m')
insert into APT_DET VALUES (154,10,154,7,'',13,154,1000000,'NO',15);
insert into APARTAMENTO VALUES (155,'75m X 80m')
insert into CUENTA VALUES (155,'75m X 80m')
insert into APT_DET VALUES (155,10,155,1,'',13,155,1000000,'NO',6);
insert into APARTAMENTO VALUES (156,'75m X 80m')
insert into CUENTA VALUES (156,'75m X 80m')
insert into APT_DET VALUES (156,10,156,3,'',13,156,1000000,'NO',9);
insert into APARTAMENTO VALUES (157,'75m X 80m')
insert into CUENTA VALUES (157,'75m X 80m')
insert into APT_DET VALUES (157,10,157,9,'',13,157,1000000,'NO',11);
insert into APARTAMENTO VALUES (158,'75m X 80m')
insert into CUENTA VALUES (158,'75m X 80m')
insert into APT_DET VALUES (158,10,158,7,'',13,158,1000000,'NO',1);
insert into APARTAMENTO VALUES (159,'75m X 80m')
insert into CUENTA VALUES (159,'75m X 80m')
insert into APT_DET VALUES (159,10,159,10,'',13,159,1000000,'NO',14);
insert into APARTAMENTO VALUES (160,'75m X 80m')
insert into CUENTA VALUES (160,'75m X 80m')
insert into APT_DET VALUES (160,10,160,2,'',13,160,1000000,'NO',9);
insert into APARTAMENTO VALUES (161,'75m X 80m')
insert into CUENTA VALUES (161,'75m X 80m')
insert into APT_DET VALUES (161,10,161,14,'',14,161,1000000,'NO',9);
insert into APARTAMENTO VALUES (162,'75m X 80m')
insert into CUENTA VALUES (162,'75m X 80m')
insert into APT_DET VALUES (162,10,162,3,'',14,162,1000000,'NO',2);
insert into APARTAMENTO VALUES (163,'75m X 80m')
insert into CUENTA VALUES (163,'75m X 80m')
insert into APT_DET VALUES (163,10,163,3,'',14,163,1000000,'NO',1);
insert into APARTAMENTO VALUES (164,'75m X 80m')
insert into CUENTA VALUES (164,'75m X 80m')
insert into APT_DET VALUES (164,10,164,2,'',14,164,1000000,'NO',1);
insert into APARTAMENTO VALUES (165,'75m X 80m')
insert into CUENTA VALUES (165,'75m X 80m')
insert into APT_DET VALUES (165,10,165,8,'',14,165,1000000,'NO',11);
insert into APARTAMENTO VALUES (166,'75m X 80m')
insert into CUENTA VALUES (166,'75m X 80m')
insert into APT_DET VALUES (166,10,166,17,'',14,166,1000000,'NO',11);
insert into APARTAMENTO VALUES (167,'75m X 80m')
insert into CUENTA VALUES (167,'75m X 80m')
insert into APT_DET VALUES (167,10,167,12,'',14,167,1000000,'NO',1);
insert into APARTAMENTO VALUES (168,'75m X 80m')
insert into CUENTA VALUES (168,'75m X 80m')
insert into APT_DET VALUES (168,10,168,17,'',14,168,1000000,'NO',10);
insert into APARTAMENTO VALUES (169,'75m X 80m')
insert into CUENTA VALUES (169,'75m X 80m')
insert into APT_DET VALUES (169,10,169,10,'',14,169,1000000,'NO',11);
insert into APARTAMENTO VALUES (170,'75m X 80m')
insert into CUENTA VALUES (170,'75m X 80m')
insert into APT_DET VALUES (170,10,170,7,'',14,170,1000000,'NO',3);
insert into APARTAMENTO VALUES (171,'75m X 80m')
insert into CUENTA VALUES (171,'75m X 80m')
insert into APT_DET VALUES (171,10,171,20,'',14,171,1000000,'NO',1);
insert into APARTAMENTO VALUES (172,'75m X 80m')
insert into CUENTA VALUES (172,'75m X 80m')
insert into APT_DET VALUES (172,10,172,8,'',14,172,1000000,'NO',1);
insert into APARTAMENTO VALUES (173,'75m X 80m')
insert into CUENTA VALUES (173,'75m X 80m')
insert into APT_DET VALUES (173,10,173,14,'',14,173,1000000,'NO',15);
insert into APARTAMENTO VALUES (174,'75m X 80m')
insert into CUENTA VALUES (174,'75m X 80m')
insert into APT_DET VALUES (174,10,174,2,'',14,174,1000000,'NO',13);
insert into APARTAMENTO VALUES (175,'75m X 80m');
insert into CUENTA VALUES (175,'75m X 80m');
insert into APT_DET VALUES (175,10,175,'',16,14,175,1000000,'NO',12);
insert into APARTAMENTO VALUES (176,'75m X 80m')
insert into CUENTA VALUES (176,'75m X 80m')
insert into APT_DET VALUES (176,10,176,14,'',14,176,1000000,'NO',11);
insert into APARTAMENTO VALUES (177,'75m X 80m')
insert into CUENTA VALUES (177,'75m X 80m')
insert into APT_DET VALUES (177,10,177,11,'',14,177,1000000,'NO',3);
insert into APARTAMENTO VALUES (178,'75m X 80m');
insert into CUENTA VALUES (178,'75m X 80m');
insert into APT_DET VALUES (178,10,178,'',10,14,178,1000000,'NO',4);
insert into APARTAMENTO VALUES (179,'75m X 80m')
insert into CUENTA VALUES (179,'75m X 80m')
insert into APT_DET VALUES (179,10,179,4,'',14,179,1000000,'NO',7);
insert into APARTAMENTO VALUES (180,'75m X 80m')
insert into CUENTA VALUES (180,'75m X 80m')
insert into APT_DET VALUES (180,10,180,15,'',14,180,1000000,'NO',9);
insert into APARTAMENTO VALUES (181,'75m X 80m')
insert into CUENTA VALUES (181,'75m X 80m')
insert into APT_DET VALUES (181,10,181,11,'',15,181,1000000,'NO',8);
insert into APARTAMENTO VALUES (182,'75m X 80m')
insert into CUENTA VALUES (182,'75m X 80m')
insert into APT_DET VALUES (182,10,182,14,'',15,182,1000000,'NO',7);
insert into APARTAMENTO VALUES (183,'75m X 80m')
insert into CUENTA VALUES (183,'75m X 80m')
insert into APT_DET VALUES (183,10,183,15,'',15,183,1000000,'NO',7);
insert into APARTAMENTO VALUES (184,'75m X 80m')
insert into CUENTA VALUES (184,'75m X 80m')
insert into APT_DET VALUES (184,10,184,3,'',15,184,1000000,'NO',1);
insert into APARTAMENTO VALUES (185,'75m X 80m')
insert into CUENTA VALUES (185,'75m X 80m')
insert into APT_DET VALUES (185,10,185,19,'',15,185,1000000,'NO',6);
insert into APARTAMENTO VALUES (186,'75m X 80m')
insert into CUENTA VALUES (186,'75m X 80m')
insert into APT_DET VALUES (186,10,186,14,'',15,186,1000000,'NO',13);
insert into APARTAMENTO VALUES (187,'75m X 80m')
insert into CUENTA VALUES (187,'75m X 80m')
insert into APT_DET VALUES (187,10,187,10,'',15,187,1000000,'NO',2);
insert into APARTAMENTO VALUES (188,'75m X 80m')
insert into CUENTA VALUES (188,'75m X 80m')
insert into APT_DET VALUES (188,10,188,17,'',15,188,1000000,'NO',4);
insert into APARTAMENTO VALUES (189,'75m X 80m')
insert into CUENTA VALUES (189,'75m X 80m')
insert into APT_DET VALUES (189,10,189,19,'',15,189,1000000,'NO',5);
insert into APARTAMENTO VALUES (190,'75m X 80m')
insert into CUENTA VALUES (190,'75m X 80m')
insert into APT_DET VALUES (190,10,190,5,'',15,190,1000000,'NO',3);
insert into APARTAMENTO VALUES (191,'75m X 80m')
insert into CUENTA VALUES (191,'75m X 80m')
insert into APT_DET VALUES (191,10,191,8,'',15,191,1000000,'NO',5);
insert into APARTAMENTO VALUES (192,'75m X 80m')
insert into CUENTA VALUES (192,'75m X 80m')
insert into APT_DET VALUES (192,10,192,15,'',15,192,1000000,'NO',6);
insert into APARTAMENTO VALUES (193,'75m X 80m')
insert into CUENTA VALUES (193,'75m X 80m')
insert into APT_DET VALUES (193,10,193,18,'',15,193,1000000,'NO',5);
insert into APARTAMENTO VALUES (194,'75m X 80m')
insert into CUENTA VALUES (194,'75m X 80m')
insert into APT_DET VALUES (194,10,194,9,'',15,194,1000000,'NO',15);
insert into APARTAMENTO VALUES (195,'75m X 80m')
insert into CUENTA VALUES (195,'75m X 80m')
insert into APT_DET VALUES (195,10,195,9,'',15,195,1000000,'NO',14);
insert into APARTAMENTO VALUES (196,'75m X 80m')
insert into CUENTA VALUES (196,'75m X 80m')
insert into APT_DET VALUES (196,10,196,4,'',15,196,1000000,'NO',10);
insert into APARTAMENTO VALUES (197,'75m X 80m')
insert into CUENTA VALUES (197,'75m X 80m')
insert into APT_DET VALUES (197,10,197,2,'',15,197,1000000,'NO',14);
insert into APARTAMENTO VALUES (198,'75m X 80m')
insert into CUENTA VALUES (198,'75m X 80m')
insert into APT_DET VALUES (198,10,198,20,'',15,198,1000000,'NO',13);
insert into APARTAMENTO VALUES (199,'75m X 80m')
insert into CUENTA VALUES (199,'75m X 80m')
insert into APT_DET VALUES (199,10,199,8,'',15,199,1000000,'NO',8);
insert into APARTAMENTO VALUES (200,'75m X 80m')
insert into CUENTA VALUES (200,'75m X 80m')
insert into APT_DET VALUES (200,10,200,5,'',15,200,1000000,'NO',4);
insert into APARTAMENTO VALUES (201,'75m X 80m')
insert into CUENTA VALUES (201,'75m X 80m')
insert into APT_DET VALUES (201,10,201,17,'',16,201,1000000,'NO',11);
insert into APARTAMENTO VALUES (202,'75m X 80m')
insert into CUENTA VALUES (202,'75m X 80m')
insert into APT_DET VALUES (202,10,202,18,'',16,202,1000000,'NO',7);
insert into APARTAMENTO VALUES (203,'75m X 80m')
insert into CUENTA VALUES (203,'75m X 80m')
insert into APT_DET VALUES (203,10,203,20,'',16,203,1000000,'NO',15);
insert into APARTAMENTO VALUES (204,'75m X 80m')
insert into CUENTA VALUES (204,'75m X 80m')
insert into APT_DET VALUES (204,10,204,10,'',16,204,1000000,'NO',1);
insert into APARTAMENTO VALUES (205,'75m X 80m')
insert into CUENTA VALUES (205,'75m X 80m')
insert into APT_DET VALUES (205,10,205,7,'',16,205,1000000,'NO',4);
insert into APARTAMENTO VALUES (206,'75m X 80m')
insert into CUENTA VALUES (206,'75m X 80m')
insert into APT_DET VALUES (206,10,206,18,'',16,206,1000000,'NO',15);
insert into APARTAMENTO VALUES (207,'75m X 80m');
insert into CUENTA VALUES (207,'75m X 80m');
insert into APT_DET VALUES (207,10,207,'',4,16,207,1000000,'NO',7);
insert into APARTAMENTO VALUES (208,'75m X 80m')
insert into CUENTA VALUES (208,'75m X 80m')
insert into APT_DET VALUES (208,10,208,16,'',16,208,1000000,'NO',5);
insert into APARTAMENTO VALUES (209,'75m X 80m')
insert into CUENTA VALUES (209,'75m X 80m')
insert into APT_DET VALUES (209,10,209,7,'',16,209,1000000,'NO',10);
insert into APARTAMENTO VALUES (210,'75m X 80m')
insert into CUENTA VALUES (210,'75m X 80m')
insert into APT_DET VALUES (210,10,210,4,'',16,210,1000000,'NO',10);
insert into APARTAMENTO VALUES (211,'75m X 80m')
insert into CUENTA VALUES (211,'75m X 80m')
insert into APT_DET VALUES (211,10,211,3,'',16,211,1000000,'NO',1);
insert into APARTAMENTO VALUES (212,'75m X 80m')
insert into CUENTA VALUES (212,'75m X 80m')
insert into APT_DET VALUES (212,10,212,5,'',16,212,1000000,'NO',15);
insert into APARTAMENTO VALUES (213,'75m X 80m')
insert into CUENTA VALUES (213,'75m X 80m')
insert into APT_DET VALUES (213,10,213,15,'',16,213,1000000,'NO',3);
insert into APARTAMENTO VALUES (214,'75m X 80m');
insert into CUENTA VALUES (214,'75m X 80m');
insert into APT_DET VALUES (214,10,214,'',9,16,214,1000000,'NO',8);
insert into APARTAMENTO VALUES (215,'75m X 80m')
insert into CUENTA VALUES (215,'75m X 80m')
insert into APT_DET VALUES (215,10,215,2,'',16,215,1000000,'NO',2);
insert into APARTAMENTO VALUES (216,'75m X 80m')
insert into CUENTA VALUES (216,'75m X 80m')
insert into APT_DET VALUES (216,10,216,16,'',16,216,1000000,'NO',9);
insert into APARTAMENTO VALUES (217,'75m X 80m');
insert into CUENTA VALUES (217,'75m X 80m');
insert into APT_DET VALUES (217,10,217,'',4,16,217,1000000,'NO',1);
insert into APARTAMENTO VALUES (218,'75m X 80m')
insert into CUENTA VALUES (218,'75m X 80m')
insert into APT_DET VALUES (218,10,218,17,'',16,218,1000000,'NO',6);
insert into APARTAMENTO VALUES (219,'75m X 80m')
insert into CUENTA VALUES (219,'75m X 80m')
insert into APT_DET VALUES (219,10,219,7,'',16,219,1000000,'NO',4);
insert into APARTAMENTO VALUES (220,'75m X 80m')
insert into CUENTA VALUES (220,'75m X 80m')
insert into APT_DET VALUES (220,10,220,4,'',16,220,1000000,'NO',8);
insert into APARTAMENTO VALUES (221,'75m X 80m')
insert into CUENTA VALUES (221,'75m X 80m')
insert into APT_DET VALUES (221,10,221,10,'',17,221,1000000,'NO',11);
insert into APARTAMENTO VALUES (222,'75m X 80m')
insert into CUENTA VALUES (222,'75m X 80m')
insert into APT_DET VALUES (222,10,222,16,'',17,222,1000000,'NO',4);
insert into APARTAMENTO VALUES (223,'75m X 80m')
insert into CUENTA VALUES (223,'75m X 80m')
insert into APT_DET VALUES (223,10,223,6,'',17,223,1000000,'NO',12);
insert into APARTAMENTO VALUES (224,'75m X 80m')
insert into CUENTA VALUES (224,'75m X 80m')
insert into APT_DET VALUES (224,10,224,16,'',17,224,1000000,'NO',6);
insert into APARTAMENTO VALUES (225,'75m X 80m')
insert into CUENTA VALUES (225,'75m X 80m')
insert into APT_DET VALUES (225,10,225,15,'',17,225,1000000,'NO',5);
insert into APARTAMENTO VALUES (226,'75m X 80m')
insert into CUENTA VALUES (226,'75m X 80m')
insert into APT_DET VALUES (226,10,226,16,'',17,226,1000000,'NO',6);
insert into APARTAMENTO VALUES (227,'75m X 80m')
insert into CUENTA VALUES (227,'75m X 80m')
insert into APT_DET VALUES (227,10,227,4,'',17,227,1000000,'NO',11);
insert into APARTAMENTO VALUES (228,'75m X 80m')
insert into CUENTA VALUES (228,'75m X 80m')
insert into APT_DET VALUES (228,10,228,13,'',17,228,1000000,'NO',3);
insert into APARTAMENTO VALUES (229,'75m X 80m')
insert into CUENTA VALUES (229,'75m X 80m')
insert into APT_DET VALUES (229,10,229,7,'',17,229,1000000,'NO',14);
insert into APARTAMENTO VALUES (230,'75m X 80m')
insert into CUENTA VALUES (230,'75m X 80m')
insert into APT_DET VALUES (230,10,230,15,'',17,230,1000000,'NO',8);
insert into APARTAMENTO VALUES (231,'75m X 80m')
insert into CUENTA VALUES (231,'75m X 80m')
insert into APT_DET VALUES (231,10,231,16,'',17,231,1000000,'NO',6);
insert into APARTAMENTO VALUES (232,'75m X 80m')
insert into CUENTA VALUES (232,'75m X 80m')
insert into APT_DET VALUES (232,10,232,11,'',17,232,1000000,'NO',3);
insert into APARTAMENTO VALUES (233,'75m X 80m')
insert into CUENTA VALUES (233,'75m X 80m')
insert into APT_DET VALUES (233,10,233,10,'',17,233,1000000,'NO',11);
insert into APARTAMENTO VALUES (234,'75m X 80m')
insert into CUENTA VALUES (234,'75m X 80m')
insert into APT_DET VALUES (234,10,234,12,'',17,234,1000000,'NO',2);
insert into APARTAMENTO VALUES (235,'75m X 80m')
insert into CUENTA VALUES (235,'75m X 80m')
insert into APT_DET VALUES (235,10,235,6,'',17,235,1000000,'NO',4);
insert into APARTAMENTO VALUES (236,'75m X 80m')
insert into CUENTA VALUES (236,'75m X 80m')
insert into APT_DET VALUES (236,10,236,18,'',17,236,1000000,'NO',14);
insert into APARTAMENTO VALUES (237,'75m X 80m')
insert into CUENTA VALUES (237,'75m X 80m')
insert into APT_DET VALUES (237,10,237,12,'',17,237,1000000,'NO',1);
insert into APARTAMENTO VALUES (238,'75m X 80m')
insert into CUENTA VALUES (238,'75m X 80m')
insert into APT_DET VALUES (238,10,238,1,'',17,238,1000000,'NO',10);
insert into APARTAMENTO VALUES (239,'75m X 80m')
insert into CUENTA VALUES (239,'75m X 80m')
insert into APT_DET VALUES (239,10,239,17,'',17,239,1000000,'NO',6);
insert into APARTAMENTO VALUES (240,'75m X 80m')
insert into CUENTA VALUES (240,'75m X 80m')
insert into APT_DET VALUES (240,10,240,12,'',17,240,1000000,'NO',1);
insert into APARTAMENTO VALUES (241,'75m X 80m')
insert into CUENTA VALUES (241,'75m X 80m')
insert into APT_DET VALUES (241,10,241,7,'',18,241,1000000,'NO',4);
insert into APARTAMENTO VALUES (242,'75m X 80m')
insert into CUENTA VALUES (242,'75m X 80m')
insert into APT_DET VALUES (242,10,242,1,'',18,242,1000000,'NO',1);
insert into APARTAMENTO VALUES (243,'75m X 80m')
insert into CUENTA VALUES (243,'75m X 80m')
insert into APT_DET VALUES (243,10,243,19,'',18,243,1000000,'NO',9);
insert into APARTAMENTO VALUES (244,'75m X 80m')
insert into CUENTA VALUES (244,'75m X 80m')
insert into APT_DET VALUES (244,10,244,4,'',18,244,1000000,'NO',15);
insert into APARTAMENTO VALUES (245,'75m X 80m')
insert into CUENTA VALUES (245,'75m X 80m')
insert into APT_DET VALUES (245,10,245,12,'',18,245,1000000,'NO',12);
insert into APARTAMENTO VALUES (246,'75m X 80m')
insert into CUENTA VALUES (246,'75m X 80m')
insert into APT_DET VALUES (246,10,246,18,'',18,246,1000000,'NO',6);
insert into APARTAMENTO VALUES (247,'75m X 80m')
insert into CUENTA VALUES (247,'75m X 80m')
insert into APT_DET VALUES (247,10,247,1,'',18,247,1000000,'NO',7);
insert into APARTAMENTO VALUES (248,'75m X 80m')
insert into CUENTA VALUES (248,'75m X 80m')
insert into APT_DET VALUES (248,10,248,11,'',18,248,1000000,'NO',14);
insert into APARTAMENTO VALUES (249,'75m X 80m')
insert into CUENTA VALUES (249,'75m X 80m')
insert into APT_DET VALUES (249,10,249,9,'',18,249,1000000,'NO',1);
insert into APARTAMENTO VALUES (250,'75m X 80m')
insert into CUENTA VALUES (250,'75m X 80m')
insert into APT_DET VALUES (250,10,250,19,'',18,250,1000000,'NO',6);
insert into APARTAMENTO VALUES (251,'75m X 80m')
insert into CUENTA VALUES (251,'75m X 80m')
insert into APT_DET VALUES (251,10,251,12,'',18,251,1000000,'NO',8);
insert into APARTAMENTO VALUES (252,'75m X 80m')
insert into CUENTA VALUES (252,'75m X 80m')
insert into APT_DET VALUES (252,10,252,9,'',18,252,1000000,'NO',14);
insert into APARTAMENTO VALUES (253,'75m X 80m')
insert into CUENTA VALUES (253,'75m X 80m')
insert into APT_DET VALUES (253,10,253,1,'',18,253,1000000,'NO',2);
insert into APARTAMENTO VALUES (254,'75m X 80m')
insert into CUENTA VALUES (254,'75m X 80m')
insert into APT_DET VALUES (254,10,254,10,'',18,254,1000000,'NO',10);
insert into APARTAMENTO VALUES (255,'75m X 80m')
insert into CUENTA VALUES (255,'75m X 80m')
insert into APT_DET VALUES (255,10,255,12,'',18,255,1000000,'NO',14);
insert into APARTAMENTO VALUES (256,'75m X 80m')
insert into CUENTA VALUES (256,'75m X 80m')
insert into APT_DET VALUES (256,10,256,15,'',18,256,1000000,'NO',7);
insert into APARTAMENTO VALUES (257,'75m X 80m')
insert into CUENTA VALUES (257,'75m X 80m')
insert into APT_DET VALUES (257,10,257,10,'',18,257,1000000,'NO',10);
insert into APARTAMENTO VALUES (258,'75m X 80m')
insert into CUENTA VALUES (258,'75m X 80m')
insert into APT_DET VALUES (258,10,258,14,'',18,258,1000000,'NO',3);
insert into APARTAMENTO VALUES (259,'75m X 80m')
insert into CUENTA VALUES (259,'75m X 80m')
insert into APT_DET VALUES (259,10,259,17,'',18,259,1000000,'NO',6);
insert into APARTAMENTO VALUES (260,'75m X 80m')
insert into CUENTA VALUES (260,'75m X 80m')
insert into APT_DET VALUES (260,10,260,7,'',18,260,1000000,'NO',14);
insert into APARTAMENTO VALUES (261,'75m X 80m')
insert into CUENTA VALUES (261,'75m X 80m')
insert into APT_DET VALUES (261,10,261,18,'',19,261,1000000,'NO',7);
insert into APARTAMENTO VALUES (262,'75m X 80m')
insert into CUENTA VALUES (262,'75m X 80m')
insert into APT_DET VALUES (262,10,262,4,'',19,262,1000000,'NO',13);
insert into APARTAMENTO VALUES (263,'75m X 80m')
insert into CUENTA VALUES (263,'75m X 80m')
insert into APT_DET VALUES (263,10,263,19,'',19,263,1000000,'NO',13);
insert into APARTAMENTO VALUES (264,'75m X 80m')
insert into CUENTA VALUES (264,'75m X 80m')
insert into APT_DET VALUES (264,10,264,12,'',19,264,1000000,'NO',14);
insert into APARTAMENTO VALUES (265,'75m X 80m')
insert into CUENTA VALUES (265,'75m X 80m')
insert into APT_DET VALUES (265,10,265,15,'',19,265,1000000,'NO',6);
insert into APARTAMENTO VALUES (266,'75m X 80m')
insert into CUENTA VALUES (266,'75m X 80m')
insert into APT_DET VALUES (266,10,266,19,'',19,266,1000000,'NO',13);
insert into APARTAMENTO VALUES (267,'75m X 80m')
insert into CUENTA VALUES (267,'75m X 80m')
insert into APT_DET VALUES (267,10,267,10,'',19,267,1000000,'NO',13);
insert into APARTAMENTO VALUES (268,'75m X 80m')
insert into CUENTA VALUES (268,'75m X 80m')
insert into APT_DET VALUES (268,10,268,3,'',19,268,1000000,'NO',15);
insert into APARTAMENTO VALUES (269,'75m X 80m')
insert into CUENTA VALUES (269,'75m X 80m')
insert into APT_DET VALUES (269,10,269,9,'',19,269,1000000,'NO',2);
insert into APARTAMENTO VALUES (270,'75m X 80m')
insert into CUENTA VALUES (270,'75m X 80m')
insert into APT_DET VALUES (270,10,270,4,'',19,270,1000000,'NO',3);
insert into APARTAMENTO VALUES (271,'75m X 80m')
insert into CUENTA VALUES (271,'75m X 80m')
insert into APT_DET VALUES (271,10,271,8,'',19,271,1000000,'NO',9);
insert into APARTAMENTO VALUES (272,'75m X 80m')
insert into CUENTA VALUES (272,'75m X 80m')
insert into APT_DET VALUES (272,10,272,11,'',19,272,1000000,'NO',14);
insert into APARTAMENTO VALUES (273,'75m X 80m')
insert into CUENTA VALUES (273,'75m X 80m')
insert into APT_DET VALUES (273,10,273,2,'',19,273,1000000,'NO',7);
insert into APARTAMENTO VALUES (274,'75m X 80m')
insert into CUENTA VALUES (274,'75m X 80m')
insert into APT_DET VALUES (274,10,274,13,'',19,274,1000000,'NO',6);
insert into APARTAMENTO VALUES (275,'75m X 80m')
insert into CUENTA VALUES (275,'75m X 80m')
insert into APT_DET VALUES (275,10,275,18,'',19,275,1000000,'NO',1);
insert into APARTAMENTO VALUES (276,'75m X 80m')
insert into CUENTA VALUES (276,'75m X 80m')
insert into APT_DET VALUES (276,10,276,12,'',19,276,1000000,'NO',6);
insert into APARTAMENTO VALUES (277,'75m X 80m')
insert into CUENTA VALUES (277,'75m X 80m')
insert into APT_DET VALUES (277,10,277,19,'',19,277,1000000,'NO',4);
insert into APARTAMENTO VALUES (278,'75m X 80m')
insert into CUENTA VALUES (278,'75m X 80m')
insert into APT_DET VALUES (278,10,278,15,'',19,278,1000000,'NO',5);
insert into APARTAMENTO VALUES (279,'75m X 80m')
insert into CUENTA VALUES (279,'75m X 80m')
insert into APT_DET VALUES (279,10,279,17,'',19,279,1000000,'NO',8);
insert into APARTAMENTO VALUES (280,'75m X 80m')
insert into CUENTA VALUES (280,'75m X 80m')
insert into APT_DET VALUES (280,10,280,1,'',19,280,1000000,'NO',1);
insert into APARTAMENTO VALUES (281,'75m X 80m')
insert into CUENTA VALUES (281,'75m X 80m')
insert into APT_DET VALUES (281,10,281,20,'',20,281,1000000,'NO',9);
insert into APARTAMENTO VALUES (282,'75m X 80m');
insert into CUENTA VALUES (282,'75m X 80m');
insert into APT_DET VALUES (282,10,282,'',4,20,282,1000000,'NO',9);
insert into APARTAMENTO VALUES (283,'75m X 80m')
insert into CUENTA VALUES (283,'75m X 80m')
insert into APT_DET VALUES (283,10,283,5,'',20,283,1000000,'NO',9);
insert into APARTAMENTO VALUES (284,'75m X 80m')
insert into CUENTA VALUES (284,'75m X 80m')
insert into APT_DET VALUES (284,10,284,1,'',20,284,1000000,'NO',1);
insert into APARTAMENTO VALUES (285,'75m X 80m')
insert into CUENTA VALUES (285,'75m X 80m')
insert into APT_DET VALUES (285,10,285,14,'',20,285,1000000,'NO',7);
insert into APARTAMENTO VALUES (286,'75m X 80m')
insert into CUENTA VALUES (286,'75m X 80m')
insert into APT_DET VALUES (286,10,286,11,'',20,286,1000000,'NO',8);
insert into APARTAMENTO VALUES (287,'75m X 80m')
insert into CUENTA VALUES (287,'75m X 80m')
insert into APT_DET VALUES (287,10,287,12,'',20,287,1000000,'NO',13);
insert into APARTAMENTO VALUES (288,'75m X 80m');
insert into CUENTA VALUES (288,'75m X 80m');
insert into APT_DET VALUES (288,10,288,'',4,20,288,1000000,'NO',7);
insert into APARTAMENTO VALUES (289,'75m X 80m')
insert into CUENTA VALUES (289,'75m X 80m')
insert into APT_DET VALUES (289,10,289,16,'',20,289,1000000,'NO',14);
insert into APARTAMENTO VALUES (290,'75m X 80m')
insert into CUENTA VALUES (290,'75m X 80m')
insert into APT_DET VALUES (290,10,290,1,'',20,290,1000000,'NO',3);
insert into APARTAMENTO VALUES (291,'75m X 80m');
insert into CUENTA VALUES (291,'75m X 80m');
insert into APT_DET VALUES (291,10,291,'',6,20,291,1000000,'NO',11);
insert into APARTAMENTO VALUES (292,'75m X 80m')
insert into CUENTA VALUES (292,'75m X 80m')
insert into APT_DET VALUES (292,10,292,13,'',20,292,1000000,'NO',2);
insert into APARTAMENTO VALUES (293,'75m X 80m')
insert into CUENTA VALUES (293,'75m X 80m')
insert into APT_DET VALUES (293,10,293,3,'',20,293,1000000,'NO',14);
insert into APARTAMENTO VALUES (294,'75m X 80m')
insert into CUENTA VALUES (294,'75m X 80m')
insert into APT_DET VALUES (294,10,294,4,'',20,294,1000000,'NO',13);
insert into APARTAMENTO VALUES (295,'75m X 80m')
insert into CUENTA VALUES (295,'75m X 80m')
insert into APT_DET VALUES (295,10,295,8,'',20,295,1000000,'NO',13);
insert into APARTAMENTO VALUES (296,'75m X 80m')
insert into CUENTA VALUES (296,'75m X 80m')
insert into APT_DET VALUES (296,10,296,20,'',20,296,1000000,'NO',13);
insert into APARTAMENTO VALUES (297,'75m X 80m')
insert into CUENTA VALUES (297,'75m X 80m')
insert into APT_DET VALUES (297,10,297,16,'',20,297,1000000,'NO',3);
insert into APARTAMENTO VALUES (298,'75m X 80m')
insert into CUENTA VALUES (298,'75m X 80m')
insert into APT_DET VALUES (298,10,298,8,'',20,298,1000000,'NO',8);
insert into APARTAMENTO VALUES (299,'75m X 80m')
insert into CUENTA VALUES (299,'75m X 80m')
insert into APT_DET VALUES (299,10,299,10,'',20,299,1000000,'NO',12);
insert into APARTAMENTO VALUES (300,'75m X 80m')
insert into CUENTA VALUES (300,'75m X 80m')
insert into APT_DET VALUES (300,10,300,14,'',20,300,1000000,'NO',10);

insert into AREACOMUN values (1,'Piscina');
insert into AREACOMUN values (2,'CanchasDeportivas');
insert into AREACOMUN values (3,'Sauna');
insert into AREACOMUN values (4,'Gimnacio');
insert into AREACOMUN values (5,'Recepcion');
insert into AREACOMUN values (6,'Estacionamiento');
insert into AREACOMUN values (7,'Ascensor');
insert into AREACOMUN values (8,'Areas Verdes');
insert into AREACOMUN values (9,'Parque Infantil');
insert into AREACOMUN values (10,'Sala de Juegos');

insert into AREA_DET values(1,1,1);
insert into AREA_DET values(2,2,1);
insert into AREA_DET values(3,3,1);
insert into AREA_DET values(4,4,1);
insert into AREA_DET values(5,1,2);
insert into AREA_DET values(6,2,2);
insert into AREA_DET values(7,3,2);
insert into AREA_DET values(8,1,4);
insert into AREA_DET values(9,7,4);
insert into AREA_DET values(10,3,17);
insert into AREA_DET values(11,8,16);
insert into AREA_DET values(12,5,13);
insert into AREA_DET values(13,10,10);
insert into AREA_DET values(14,1,9);
insert into AREA_DET values(15,9,4);

insert into CONTRATO values(1,2000000,'13/01/15','14/09/15',1,1);
insert into CONTRATO values(2,1123320,'01/01/15','14/09/15',2,2);
insert into CONTRATO values(3,2012300,'01/01/15','14/09/15',3,3);
insert into CONTRATO values(4,1231233,'02/02/15','14/09/15',4,4);
insert into CONTRATO values(5,1231234,'10/03/15','15/05/15',5,5);

insert into LIBRO values(1,'OFICINA',1);
insert into LIBRO values(2,'JUNTA',2);
insert into LIBRO values(3,'JUNTA',3);
insert into LIBRO values(4,'JUNTA',4);
insert into LIBRO values(5,'JUNTA',5);

insert into JUNTACONDOMINIO values(1,'01/01/15','21/12/16',1);
insert into JUNTACONDOMINIO values(2,'01/01/15','21/12/16',2);
insert into JUNTACONDOMINIO values(3,'01/01/15','21/12/16',3);
insert into JUNTACONDOMINIO values(4,'01/01/15','21/12/16',4);
insert into JUNTACONDOMINIO values(5,'01/01/15','21/12/16',13);
insert into JUNTACONDOMINIO values(6,'01/01/15','21/12/16',14);
insert into JUNTACONDOMINIO values(7,'01/01/15','21/12/16',16);
insert into JUNTACONDOMINIO values(8,'01/01/15','21/12/16',17);
insert into JUNTACONDOMINIO values(9,'01/01/15','21/12/16',20);
insert into JUNTACONDOMINIO values(10,'22/12/15','21/12/17',1);

insert into RECIBOMENSUAL values(1,'01/01/15','APROBADO',1);
insert into RECIBOMENSUAL values(2,'02/01/15','NOAPROBADO',2);
insert into RECIBOMENSUAL values(3,'03/01/15','NOAPROBADO',7);
insert into RECIBOMENSUAL values(4,'04/01/15','APROBADO',3);
insert into RECIBOMENSUAL values(5,'05/01/15','APROBADO',9);