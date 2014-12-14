# ---------------------------------------------------------------------- #
# Target DBMS:           MySQL 5                                         #
# Project name:          jsf_primefaces                                  #
# Author:                Augusto Branquinho                              #
# Created on:            2014-04-14                                      #
# ---------------------------------------------------------------------- #

/*
 * CREATE A NEW USER ON MySQL.
 */
CREATE USER 'wpattern'@'localhost' IDENTIFIED BY '123456';
GRANT ALL PRIVILEGES ON *.* TO 'wpattern'@'localhost' WITH GRANT OPTION;
