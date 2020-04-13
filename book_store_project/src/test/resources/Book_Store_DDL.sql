create database gb1w20;
use gb1w20;

create user gb1w20@'localhost' identified with mysql_native_password by 'bench3chips' require none;
create user gb1w20@'%' identified with mysql_native_password by 'bench3chips' require none;

grant all on gb1w20.* to gb1w20@'localhost';
grant all on gb1w20.* to gb1w20@'%';

flush privileges;