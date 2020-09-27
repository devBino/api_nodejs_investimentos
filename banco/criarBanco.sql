drop database ativos;

create database ativos
default character set utf8
default collate utf8_general_ci;

use ativos;

create table usuario(
    cdUsuario bigint not null auto_increment,
    nmUsuario varchar(105) unique not null,
    dsSenha varchar(105) unique not null,
    dsEmail varchar(105) unique not null,
    cdPermissao enum('1','2','3') not null,
    cdStatus enum('1','2') default '1',

    primary key(cdUsuario)
)default charset = utf8;

create index idx_nmUsuario on usuario(nmUsuario);
create index idx_dsEmail on usuario(dsEmail);

create table tipo_ativo(
    cdTipo int not null auto_increment,
    nmTipo varchar(105) unique not null,
    cdStatus enum('1','2') default '1',

    primary key(cdTipo)
)default charset = utf8;

create index idx_nmTipo on tipo_ativo(nmTipo);

create table ativo(
    cdAtivo int not null auto_increment,
    nmAtivo varchar(155) unique not null,
    vlAtivo decimal(12,2) not null,
    cdTipo int not null,
    cdStatus enum('1','2') default '1',

    foreign key(cdTipo) references tipo_ativo(cdTipo),
    primary key(cdAtivo)
)default charset = utf8;

create index idx_nmAtivo on ativo(nmAtivo);

insert into usuario (nmUsuario,dsSenha,dsEmail,cdPermissao)
values ('admin','d033e22ae348aeb5660fc2140aec35850c4da997','admin@admin.com.br','1');