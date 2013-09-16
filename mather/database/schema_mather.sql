CREATE TABLE public.programas (
	id_programa bigint not null primary key,
	nm_programa varchar(100),
	nm_caminho varchar(120),
	nm_arquivo varchar(50),
	dm_tipo_programa varchar(4)
) with oids;
ALTER TABLE public.programas 
	OWNER TO mather;
	
CREATE TABLE public.sistemas (
	id_sistema bigint not null primary key,
	nm_sistema varchar(50)
) with oids;
ALTER TABLE public.sistemas 
	OWNER TO mather;
	
CREATE TABLE public.menus (
	id_menu bigint not null primary key,
	nm_menu varchar(50),
	id_sistema bigint
) with oids;
ALTER TABLE public.menus 
	OWNER TO mather;
	
CREATE TABLE public.programas_menus (
	id_programa_menu bigint not null primary key,
	id_programa bigint,
	id_menu bigint
) with oids;
ALTER TABLE public.programas_menus 
	OWNER TO mather;
	
CREATE TABLE public.perfis (
	id_perfil bigint not null primary key,
	nm_perfil varchar(50)
) with oids;
ALTER TABLE public.perfis 
	OWNER TO mather;
	
CREATE TABLE public.perfis_sistemas (
	id_perfil_sistema bigint not null primary key,
	id_perfil bigint not null,
	id_sistema bigint not null
) with oids;
ALTER TABLE public.perfis_sistemas 
	OWNER TO mather;

CREATE TABLE public.paises
(
   id_pais bigint not null primary key, 
   cd_pais character varying(4), 
   nm_pais character varying(100)
) 
WITH OIDS;
ALTER TABLE public.paises
  OWNER TO mather;
  
CREATE TABLE public.estados
(
   id_estado bigint not null primary key, 
   cd_estado character varying(4), 
   nm_estado character varying(100),
   id_pais bigint not null,
   CONSTRAINT estado_pais_fk FOREIGN KEY (id_pais) REFERENCES paises (id_pais) ON DELETE CASCADE ON UPDATE CASCADE
) 
WITH OIDS;
ALTER TABLE public.estados
  OWNER TO mather;
  
CREATE TABLE public.cidades
(
   id_cidade bigint not null primary key, 
   cd_cidade character varying(4), 
   nm_cidade character varying(100),
   id_estado bigint not null,
   CONSTRAINT cidade_estado_fk FOREIGN KEY (id_estado) REFERENCES estados (id_estado) ON DELETE CASCADE ON UPDATE CASCADE
) 
WITH OIDS;
ALTER TABLE public.cidades
  OWNER TO mather;
  
CREATE TABLE public.pessoas (
    id_pessoa bigint NOT NULL primary key,
    nr_cnpj_cpf character varying(14),
	nm_razao_social character varying(100),
	nm_fantasia character varying(100),
	nm_endereco character varying(100),
	nr_endereco character varying(20),
	nm_complemento character varying(200),
	nm_bairro character varying(100),
    nr_cep character varying(15),
	nr_telefone character varying(100),
    nm_inscricao_estadual character varying(20),
    id_cidade bigint NOT NULL,
    dm_situacao character(1),
    email character varying(200),
    nm_site character varying(200),
    nr_fax character varying(100),
    CONSTRAINT pessoa_cidade_fk FOREIGN KEY (id_cidade) REFERENCES cidades (id_cidade) ON DELETE CASCADE ON UPDATE CASCADE
) WITH OIDS;
ALTER TABLE public.pessoas 
	OWNER TO mather;
	
CREATE TABLE public.usuarios
(
   id_usuario bigint not null primary key, 
   nm_usuario character varying(40), 
   nm_senha character varying(100),
   id_perfil bigint not null,
   id_pessoa bigint not null,
   CONSTRAINT us_perf_fk FOREIGN KEY (id_perfil) REFERENCES perfis (id_perfil) ON DELETE CASCADE ON UPDATE CASCADE,
   CONSTRAINT us_pes_fk FOREIGN KEY (id_pessoa) REFERENCES pessoas (id_pessoa) ON DELETE CASCADE ON UPDATE CASCADE
) 
WITH OIDS;
ALTER TABLE public.usuarios
  OWNER TO mather;
  
CREATE TABLE public.usuarios_sistemas (
	id_usuario_sistema bigint not null primary key,
	id_usuario bigint not null,
	id_sistema bigint not null,
	dm_escrita varchar(4) default 'S'
) with oids;
ALTER TABLE public.usuarios_sistemas
  OWNER TO mather;
  
CREATE TABLE log_usuarios (
	oid_log_usuario bigint not null primary key,
	oid_usuario bigint not null,
	recurso varchar(100),
	informacao varchar(2000),
	acao varchar(40),
	data_hora timestamp
) with oids;
ALTER TABLE public.log_usuarios
  OWNER TO mather;

CREATE TABLE public.unidades
(
   id_unidade bigint not null primary key, 
   dm_tipo_lotacao character varying(4), 
   nr_capacidade numeric(3,0),
   id_pessoa bigint not null,
   CONSTRAINT un_pes_fk FOREIGN KEY (id_pessoa) REFERENCES pessoas (id_pessoa) ON DELETE CASCADE ON UPDATE CASCADE
) 
WITH OIDS;
ALTER TABLE public.unidades
  OWNER TO mather;
  
CREATE TABLE public.empresas
(
   id_empresa bigint not null primary key, 
   dm_tipo_atividade character varying(4), 
   nm_contato character varying(40), 
   id_pessoa bigint not null,
   CONSTRAINT em_pes_fk FOREIGN KEY (id_pessoa) REFERENCES pessoas (id_pessoa) ON DELETE CASCADE ON UPDATE CASCADE
) 
WITH OIDS;
ALTER TABLE public.empresas
  OWNER TO mather;
  
CREATE TABLE public.escolas
(
   id_escola bigint not null primary key, 
   dm_tipo_escola character varying(4), 
   nm_contato character varying(40), 
   id_pessoa bigint not null,
   CONSTRAINT es_pes_fk FOREIGN KEY (id_pessoa) REFERENCES pessoas (id_pessoa) ON DELETE CASCADE ON UPDATE CASCADE
) 
WITH OIDS;
ALTER TABLE public.empresas
  OWNER TO mather;

CREATE TABLE public.numeracoes
(
   id_numeracao bigint not null primary key, 
   nm_numeracao character varying(100), 
   nm_serie character varying(4),
   nr_inicial numeric (6,0),
   nr_final numeric (6,0),
   nr_proximo numeric (6,0),
   dm_tipo_impressao character varying(4)
) 
WITH OIDS;
ALTER TABLE public.numeracoes
  OWNER TO mather;
  
CREATE TABLE public.tipos_publicacoes
(
   id_tipo_publicacao bigint not null primary key, 
   nm_tipo_publicacao character varying(100), 
   dm_numeracao character varying(4) default 'N',
   id_numeracao bigint not null,
   CONSTRAINT num_public_fk FOREIGN KEY (id_numeracao) REFERENCES numeracoes (id_numeracao) ON DELETE CASCADE ON UPDATE CASCADE
) 
WITH OIDS;
ALTER TABLE public.tipos_publicacoes
  OWNER TO mather;
  
CREATE TABLE public.tipos_ocorrencias
(
   id_tipo_ocorrencia bigint not null primary key, 
   nm_tipo_ocorrencia character varying(100)
) 
WITH OIDS;
ALTER TABLE public.tipos_ocorrencias
  OWNER TO mather;
  
CREATE TABLE public.tipos_servicos
(
   id_tipo_servico bigint not null primary key, 
   nm_tipo_servico character varying(100)
) 
WITH OIDS;
ALTER TABLE public.tipos_servicos
  OWNER TO mather;
  
CREATE TABLE public.tipos_atividades
(
   id_tipo_atividade bigint not null primary key, 
   nm_tipo_atividade character varying(100)
) 
WITH OIDS;
ALTER TABLE public.tipos_atividades
  OWNER TO mather;
  
CREATE TABLE public.tipos_saidas
(
   id_tipo_saida bigint not null primary key, 
   nm_tipo_saida character varying(100)
) 
WITH OIDS;
ALTER TABLE public.tipos_saidas
  OWNER TO mather;
  
CREATE TABLE public.tipos_chegadas
(
   id_tipo_chegada bigint not null primary key, 
   nm_tipo_chegada character varying(100)
) 
WITH OIDS;
ALTER TABLE public.tipos_chegadas
  OWNER TO mather;