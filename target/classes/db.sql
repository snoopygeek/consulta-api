CREATE DATABASE `consulta` /*!40100 DEFAULT CHARACTER SET utf8 */;

-- consulta.especialidades definition

CREATE TABLE `especialidades` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(128) NOT NULL,
  `DESCRICAO` text DEFAULT NULL,
  `SITUACAO` varchar(64) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;


-- consulta.medicos definition

CREATE TABLE `medicos` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(128) NOT NULL,
  `DATA_NASCIMENTO` date DEFAULT NULL,
  `SITUACAO` varchar(64) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


-- consulta.medicos_especialidades definition

CREATE TABLE `medicos_especialidades` (
  `id_medico` bigint(20) NOT NULL,
  `id_especialidade` bigint(20) NOT NULL,
  PRIMARY KEY (`id_medico`,`id_especialidade`),
  KEY `medicos_especialidades_FK` (`id_especialidade`),
  CONSTRAINT `medicos_especialidades_FK` FOREIGN KEY (`id_especialidade`) REFERENCES `especialidades` (`ID`),
  CONSTRAINT `medicos_especialidades_FK_1` FOREIGN KEY (`id_medico`) REFERENCES `medicos` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
