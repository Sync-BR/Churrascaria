/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  SYNC
 * Created: 12 de mar. de 2024
 *  Codigo Sql
 */

/*Criar Banco de dados*/
CREATE SCHEMA `churrascaria` ;
/*Criar Tabela de login*/
CREATE TABLE `churrascaria`.`usuarios` (
  `idUsuarios` INT NOT NULL AUTO_INCREMENT,
  `Login` VARCHAR(10) NOT NULL,
  `Password` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idUsuarios`, `Login`));
