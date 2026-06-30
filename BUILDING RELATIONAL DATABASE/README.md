# 🛰️ OrbitSafe — Sistema de Conectividade Espacial e Emergências Climáticas

> Global Solution — Turma 1TDSPH (2026)  
> Disciplina: Building Relational DataBase   
> Projeto desenvolvido para a disciplina de **Building Relational Database (BRD)**, contemplando a modelagem conceitual, modelo relacional e implementação do banco de dados Oracle para o sistema OrbitSafe.

---

## DESCRIÇÃO DO PROJETO

O **OrbitSafe** é uma solução desenvolvida durante a **Global Solution FIAP 2026** com o objetivo de criar uma plataforma capaz de auxiliar o monitoramento de emergências ambientais e climáticas em regiões remotas, utilizando conceitos inspirados em tecnologias espaciais e comunicação via satélite.

Nesta etapa da disciplina **Building Relational Database**, foi realizado todo o projeto do banco de dados responsável por armazenar as informações do sistema, desde o levantamento dos requisitos até a implementação física em SQL Oracle.

O projeto contempla:

* Levantamento de requisitos;
* Definição das entidades do sistema;
* Regras de negócio;
* Modelo Entidade-Relacionamento (MER);
* Modelo Relacional;
* Script SQL para criação do banco de dados.

---

## OBJETIVO

O objetivo deste projeto é desenvolver uma estrutura de banco de dados relacional capaz de suportar o funcionamento do sistema OrbitSafe, garantindo organização, integridade e consistência das informações relacionadas ao monitoramento de emergências, dispositivos, usuários e comunicação via satélites.

---

## TECNOLOGIAS UTILIZADAS

O banco de dados foi desenvolvido utilizando as tecnologias e ferramentas estudadas na disciplina.

* Oracle Database 11g;
* Oracle SQL Developer Data Modeler;
* SQL (DDL);
* Modelagem Entidade-Relacionamento (MER);
* Modelo Relacional;
* Chaves Primárias (Primary Key);
* Chaves Estrangeiras (Foreign Key);
* Regras de Integridade Referencial.

---

## ESTRUTURA DO BANCO DE DADOS

O projeto foi modelado para representar todos os componentes necessários ao funcionamento do sistema OrbitSafe.

As principais entidades desenvolvidas foram:

### Usuário

Armazena os dados dos cidadãos cadastrados no sistema, responsáveis pela utilização dos dispositivos e pelo registro das ocorrências.

Principais informações:

* Nome
* CPF
* Telefone
* E-mail
* Endereço

---

### Dispositivo

Representa os equipamentos utilizados pelos usuários para envio de alertas e compartilhamento de localização.

Cada dispositivo pertence a um único usuário.

Informações armazenadas:

* Tipo do dispositivo
* Status
* Bateria
* Localização
* Data de cadastro

---

### Emergência

Responsável pelo armazenamento das ocorrências registradas.

Cada emergência contém:

* Nível da emergência
* Status
* Data e hora
* Latitude
* Longitude
* Descrição da ocorrência

Além disso, cada emergência está vinculada a:

* um dispositivo;
* um satélite;
* uma central de controle.

---

### Satélite

Representa os satélites responsáveis pelo monitoramento e comunicação das regiões atendidas.

São armazenados:

* Nome
* Tipo
* Status de operação

---

### Central de Controle

Responsável pelo gerenciamento das emergências registradas.

Informações:

* Nome
* Localização
* Status de operação

---

### Operador

Representa os profissionais responsáveis pelo atendimento das ocorrências.

Cada operador pertence a uma central de controle.

---

### Operador_Emergência

Entidade associativa responsável por implementar o relacionamento muitos-para-muitos entre Operadores e Emergências.

Também registra:

* Data do atendimento
* Status do atendimento

---

# Regras de Negócio

Durante a modelagem foram definidas as seguintes regras:

* Um usuário pode possuir um ou mais dispositivos.
* Cada dispositivo pertence a apenas um usuário.
* Toda emergência deve estar vinculada a um dispositivo.
* Toda emergência deve possuir um satélite responsável pelo monitoramento.
* Uma central pode gerenciar diversas emergências.
* Todo operador pertence a uma central de controle.
* Uma emergência pode ser atendida por vários operadores.
* Um operador pode participar de diversas emergências.

---

# Modelo de Dados

O projeto foi desenvolvido seguindo as etapas clássicas de modelagem de banco de dados:

* Levantamento de Requisitos
* Definição das Entidades
* Regras de Negócio
* Modelo Conceitual (MER)
* Modelo Relacional
* Implementação Física em SQL Oracle

---

## ESTRUTURA DO PROJETO

<pre>
ORBITSAFE_DATABASE/
│
├── arquivo_sql.ddl          # Script SQL para criação das tabelas
├── 1TDSPH_ORBITSAFE.pdf     # Documentação completa do projeto
└── README.md
</pre>

---

## SISTEMA RELACIONAL

O banco de dados é composto pelas seguintes tabelas:

* USUARIO
* DISPOSITIVO
* EMERGENCIA
* SATELITE
* CENT_CONTROL
* OPERADOR
* OPER_EMER

As tabelas estão relacionadas por meio de chaves primárias e estrangeiras, garantindo a integridade referencial entre os registros.

---

## CONCEITOS APLICADOS

Durante o desenvolvimento foram aplicados diversos conceitos da disciplina de Building Relational Database, como:

* Levantamento de requisitos;
* Modelagem conceitual (MER);
* Engenharia reversa para modelo relacional;
* Normalização de dados;
* Criação de tabelas;
* Definição de atributos;
* Chaves primárias (PK);
* Chaves estrangeiras (FK);
* Relacionamentos 1:N;
* Relacionamentos N:N por entidade associativa;
* Integridade referencial;
* Implementação em Oracle SQL.

---

## COMO EXECUTAR

1. Abra o **Oracle SQL Developer** ou outra ferramenta compatível com Oracle Database.

2. Crie uma conexão com o banco Oracle.

3. Execute o arquivo:

```sql
arquivo_sql.ddl
```

4. O script criará automaticamente todas as tabelas, chaves primárias e chaves estrangeiras do sistema.

---

## DOCUMENTAÇÃO

A documentação completa do projeto encontra-se no arquivo:

```text
1TDSPH_ORBITSAFE.pdf
```

Ela contém:

* Levantamento de requisitos
* Contexto do problema
* Entidades do sistema
* Regras de negócio
* Modelo Conceitual (MER)
* Modelo Relacional
* Script SQL completo

---

## INTEGRANTES & AUTORES

Abaixo encontram-se os detalhes dos desenvolvedores responsáveis pela arquitetura e engenharia do OrbitSafe:

* Isabelle Ferreira Neri Feitoza — RM 573507 (DESENVOLVEDORA FULLSTACK) - Turma: 1TDSPH
  * [LinkedIn](https://www.linkedin.com/in/isabelle-ferreira-8844593ab/) | [GitHub](https://github.com/isabelleferreiraa)
* Milena Silva Conegin — RM 568923 (DESENVOLVEDORA FULLSTACK) - Turma: 1TDSPH
  * [LinkedIn](https://www.linkedin.com/in/milena-conegin-996b22269?utm_source=share_via&utm_content=profile&utm_medium=member_ios) | [GitHub](https://github.com/MilenaConegin)
* Marina Fernandes Gomes Mesquita — RM 571265 (DESENVOLVEDORA FULLSTACK) - Turma: 1TDSPH
  * [LinkedIn](https://www.linkedin.com/in/marifernandesgm-58460a40a) | [GitHub](https://github.com/marifernandesgm)

---

## CONTATO

Para dúvidas, suporte técnico ou informações sobre o ecossistema OrbitSafe, entre em contato com a equipe de desenvolvimento através dos canais abaixo:

* **Dúvidas:** Abra uma [*Issue* diretamente no nosso repositório do GitHub](https://github.com/marifernandesgm/ORBITSAFE.git)

---
OrbitSafe 2026 — Fiap Global Solution. Todos os direitos reservados.
