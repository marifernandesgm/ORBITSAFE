-- Gerado por Oracle SQL Developer Data Modeler 24.3.1.351.0831
--   em:        2026-05-29 17:28:50 BRT
--   site:      Oracle Database 11g
--   tipo:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE CENT_CONTROL 
    ( 
     id_central        NUMBER (20)  NOT NULL , 
     nm_central        VARCHAR2 (100 CHAR)  NOT NULL , 
     ds_localizacao    VARCHAR2 (100 CHAR)  NOT NULL , 
     ds_statusOperacao VARCHAR2 (100 CHAR)  NOT NULL 
    ) 
;

ALTER TABLE CENT_CONTROL 
    ADD CONSTRAINT CENTRAL_CONTROLE_PK PRIMARY KEY ( id_central ) ;

CREATE TABLE DISPOSITIVO 
    ( 
     id_dispositivo         NUMBER (20)  NOT NULL , 
     ds_tipoDispositivo     VARCHAR2 (100 CHAR)  NOT NULL , 
     ds_statusDispositivo   VARCHAR2 (100 CHAR)  NOT NULL , 
     num_bateria            NUMBER (100) , 
     ds_localizacao         VARCHAR2 (100 CHAR)  NOT NULL , 
     USUARIO_id_usuario     NUMBER (20)  NOT NULL , 
     dt_cadastroDispositivo DATE 
    ) 
;

ALTER TABLE DISPOSITIVO 
    ADD CONSTRAINT DISPOSITIVO_PK PRIMARY KEY ( id_dispositivo ) ;

CREATE TABLE EMERGENCIA 
    ( 
     id_emergencia              NUMBER (20)  NOT NULL , 
     ds_nivelEmergencia         VARCHAR2 (100 CHAR)  NOT NULL , 
     ds_statusEmergencia        VARCHAR2 (100 CHAR)  NOT NULL , 
     dt_hora                    DATE  NOT NULL , 
     num_latitude               NUMBER (20,6)  NOT NULL , 
     num_longitude              NUMBER (20,6)  NOT NULL , 
     DISPOSITIVO_id_dispositivo NUMBER (20)  NOT NULL , 
     SATELITE_id_satelite       NUMBER (20)  NOT NULL , 
     ds_ocorrencia              VARCHAR2 (100 CHAR)  NOT NULL , 
     CENT_CONTROL_id_central    NUMBER (20)  NOT NULL 
    ) 
;

ALTER TABLE EMERGENCIA 
    ADD CONSTRAINT EMERGENCIA_PK PRIMARY KEY ( id_emergencia ) ;

CREATE TABLE OPER_EMER 
    ( 
     id_operadorEmergencia    NUMBER (20)  NOT NULL , 
     dt_atendimento           DATE  NOT NULL , 
     ds_statusAtendimento     VARCHAR2 (100 CHAR)  NOT NULL , 
     OPERADOR_id_operador     NUMBER (20,100)  NOT NULL , 
     EMERGENCIA_id_emergencia NUMBER (20)  NOT NULL 
    ) 
;

ALTER TABLE OPER_EMER 
    ADD CONSTRAINT OPERADOR_EMERGENCIA_PK PRIMARY KEY ( id_operadorEmergencia ) ;

CREATE TABLE OPERADOR 
    ( 
     id_operador             NUMBER (20,100)  NOT NULL , 
     nm_operador             VARCHAR2 (100 CHAR)  NOT NULL , 
     ds_cargoOperador        VARCHAR2 (100 CHAR) , 
     ds_nivelAcesso          VARCHAR2 (100 CHAR)  NOT NULL , 
     CENT_CONTROL_id_central NUMBER (20)  NOT NULL 
    ) 
;

ALTER TABLE OPERADOR 
    ADD CONSTRAINT OPERADOR_PK PRIMARY KEY ( id_operador ) ;

CREATE TABLE SATELITE 
    ( 
     id_satelite       NUMBER (20)  NOT NULL , 
     nm_satelite       VARCHAR2 (100 CHAR)  NOT NULL , 
     ds_tipoSatelite   VARCHAR2 (100 CHAR)  NOT NULL , 
     ds_statusOperacao VARCHAR2 (100 CHAR)  NOT NULL 
    ) 
;

ALTER TABLE SATELITE 
    ADD CONSTRAINT SATELITE_PK PRIMARY KEY ( id_satelite ) ;

CREATE TABLE USUARIO 
    ( 
     id_usuario   NUMBER (20)  NOT NULL , 
     nm_usuario   VARCHAR2 (100 CHAR)  NOT NULL , 
     num_cpf      VARCHAR2 (50 CHAR)  NOT NULL , 
     num_telefone NUMBER (20)  NOT NULL , 
     ds_email     VARCHAR2 (50 CHAR)  NOT NULL , 
     ds_endereco  VARCHAR2 (50 CHAR)  NOT NULL 
    ) 
;

ALTER TABLE USUARIO 
    ADD CONSTRAINT USUARIO_PK PRIMARY KEY ( id_usuario ) ;

ALTER TABLE DISPOSITIVO 
    ADD CONSTRAINT DISPOSITIVO_USUARIO_FK FOREIGN KEY 
    ( 
     USUARIO_id_usuario
    ) 
    REFERENCES USUARIO 
    ( 
     id_usuario
    ) 
;

ALTER TABLE EMERGENCIA 
    ADD CONSTRAINT EMERGENCIA_CENT_CONTROL_FK FOREIGN KEY 
    ( 
     CENT_CONTROL_id_central
    ) 
    REFERENCES CENT_CONTROL 
    ( 
     id_central
    ) 
;

ALTER TABLE EMERGENCIA 
    ADD CONSTRAINT EMERGENCIA_DISPOSITIVO_FK FOREIGN KEY 
    ( 
     DISPOSITIVO_id_dispositivo
    ) 
    REFERENCES DISPOSITIVO 
    ( 
     id_dispositivo
    ) 
;

ALTER TABLE EMERGENCIA 
    ADD CONSTRAINT EMERGENCIA_SATELITE_FK FOREIGN KEY 
    ( 
     SATELITE_id_satelite
    ) 
    REFERENCES SATELITE 
    ( 
     id_satelite
    ) 
;

ALTER TABLE OPER_EMER 
    ADD CONSTRAINT OPER_EMER_EMERGENCIA_FK FOREIGN KEY 
    ( 
     EMERGENCIA_id_emergencia
    ) 
    REFERENCES EMERGENCIA 
    ( 
     id_emergencia
    ) 
;

ALTER TABLE OPER_EMER 
    ADD CONSTRAINT OPER_EMER_OPERADOR_FK FOREIGN KEY 
    ( 
     OPERADOR_id_operador
    ) 
    REFERENCES OPERADOR 
    ( 
     id_operador
    ) 
;

ALTER TABLE OPERADOR 
    ADD CONSTRAINT OPERADOR_CENT_CONTROL_FK FOREIGN KEY 
    ( 
     CENT_CONTROL_id_central
    ) 
    REFERENCES CENT_CONTROL 
    ( 
     id_central
    ) 
;



-- Relatório do Resumo do Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             7
-- CREATE INDEX                             0
-- ALTER TABLE                             14
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
