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
    taxaAdmin decimal(10,4) not null default 0.00,
    taxaCustodia decimal(10,4) not null default 0.00,
    taxaPerformace decimal(10,4) not null default 0.00,
    cdTipo int not null,
    cdStatus enum('1','2') default '1',

    foreign key(cdTipo) references tipo_ativo(cdTipo),
    primary key(cdAtivo)
)default charset = utf8;

create index idx_nmAtivo on ativo(nmAtivo);


create table aporte(
    cdAporte bigint not null auto_increment,
    cdAtivo int not null,
    vlAporte decimal(12,2) not null,
    qtde int not null default 1,
    subTotal decimal(12,2) not null,
    dtAporte datetime not null,
    cdStatus enum('1','2') default '1',

    foreign key(cdAtivo) references ativo(cdAtivo),
    primary key(cdAporte)

)default charset = utf8;

create index idx_vlAporte on aporte(vlAporte);
create index idx_dtApote on aporte(dtAporte);

insert into usuario (nmUsuario,dsSenha,dsEmail,cdPermissao)
values ('admin','d033e22ae348aeb5660fc2140aec35850c4da997','admin@admin.com.br','1');