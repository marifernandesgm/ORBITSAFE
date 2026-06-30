
# 🛰️ OrbitSafe — Sistema Inteligente de Monitoramento e Emergências Climáticas

> Global Solution — Turma 1TDSPH (2026)
> Sistema desenvolvido em Python para simular o gerenciamento de emergências ambientais, monitoramento climático e conectividade via satélites.

---

## 📌 Descrição do Projeto

O **OrbitSafe** é uma aplicação desenvolvida em **Python** com o objetivo de simular um sistema inteligente de monitoramento de desastres ambientais e suporte à tomada de decisões durante situações de emergência.

A aplicação foi criada para demonstrar como tecnologias de software podem auxiliar no gerenciamento de ocorrências climáticas, cadastro de usuários, avaliação de riscos e manutenção da conectividade em regiões afetadas por desastres naturais.

O sistema possui um menu interativo executado no terminal e contempla as seguintes funcionalidades:

1. **Sobre o Projeto:** apresentação dos objetivos do OrbitSafe.
2. **Cadastro de Usuários:** registro de cidadãos utilizando validações dos dados informados.
3. **Registro de Emergências:** cadastro de ocorrências ambientais com classificação de gravidade.
4. **Consulta de Risco Climático:** cálculo automático do nível de risco com base em temperatura, chuva e velocidade do vento.
5. **Consulta de Conectividade:** simulação da ativação de comunicação via satélite em regiões sem internet.
6. **Monitoramento de Queimadas:** análise da quantidade de focos de incêndio nos principais biomas brasileiros.
7. **Relatórios do Sistema:** exibição dos usuários e ocorrências registradas durante a execução.

---

# 🎯 Objetivo

O OrbitSafe demonstra como a programação em Python pode ser utilizada para simular sistemas de apoio à gestão de desastres naturais, integrando cadastro de usuários, monitoramento climático, análise de riscos, comunicação via satélite e geração de relatórios em um único sistema.

---

# 🚀 Tecnologias Utilizadas

O sistema foi desenvolvido utilizando apenas recursos da linguagem Python, aplicando os principais conceitos estudados na disciplina.

* **Python 3**
* Funções
* Listas
* Dicionários
* Estruturas condicionais (`if`, `elif`, `else`)
* Estruturas de repetição (`while` e `for`)
* Estrutura `match-case`
* Tratamento de exceções (`try` e `except`)
* Entrada e saída de dados pelo terminal

---

# ⚙️ Funcionalidades Desenvolvidas

### 📋 Cadastro de Usuários

Permite cadastrar usuários informando:

* Nome;
* CPF;
* Cidade;
* Estado.

Todos os campos passam por validações antes de serem armazenados.

---

### 🚨 Registro de Emergências

Permite registrar ocorrências ambientais classificando:

* Tipo de desastre;
* Local da ocorrência;
* Grau de severidade.

O sistema ainda informa automaticamente qual equipe seria acionada de acordo com o nível de gravidade.

---

### 🌦 Consulta de Risco Climático

Recebe informações climáticas da região:

* Temperatura;
* Volume de chuva;
* Velocidade do vento.

Com esses dados é calculado automaticamente um nível de risco:

* Baixo;
* Médio;
* Alto.

---

### 📡 Consulta de Conectividade

Simula o monitoramento da infraestrutura de comunicação.

Caso a internet esteja indisponível, o sistema realiza a simulação do acionamento da comunicação via satélite.

---

### 🔥 Monitoramento de Queimadas

Realiza uma simulação dos focos de incêndio em cinco importantes biomas brasileiros:

* Amazônia;
* Cerrado;
* Pantanal;
* Caatinga;
* Mata Atlântica.

Cada região recebe uma classificação de risco conforme a quantidade de focos informados.

---

### 📊 Relatórios

Apresenta um resumo contendo:

* Quantidade de usuários cadastrados;
* Quantidade de emergências registradas;
* Listagem completa dos usuários;
* Listagem das ocorrências cadastradas.

---

# 📁 Estrutura do Projeto

```text
ORBITSAFE_PYTHON/
│
├── OrbitSafeGS.py          # Código principal do sistema
├── OrbitSafePY.pdf
└── README.md
```

---

# 💻 Conceitos de Python Aplicados

Durante o desenvolvimento foram utilizados diversos conceitos fundamentais da linguagem:

* Modularização através de funções
* Listas para armazenamento dos dados
* Dicionários para representação de usuários e emergências
* Estruturas de repetição
* Estruturas condicionais
* Tratamento de exceções (`try`/`except`)
* Validação de entrada do usuário
* Utilização de parâmetros e retorno de funções
* Organização do código em blocos bem documentados
* Comentários utilizando DocStrings

---

# ▶️ Como Executar

1. Clone este repositório:

```bash
git clone https://github.com/marifernandesgm/ORBITSAFE.git
```

2. Entre na pasta do projeto:

```bash
cd ORBITSAFE
```

3. Execute o programa:

```bash
python OrbitSafeGS.py
```

ou

```bash
python3 OrbitSafeGS.py
```

---

# 👥 Integrantes

**Isabelle Ferreira Neri Feitoza** — RM 573507

**Marina Fernandes Gomes Mesquita** — RM 571265

**Milena Silva Conegin** — RM 568923

Turma: **1TDSPH**

FIAP — Global Solution 2026

---

# 📞 Contato

Em caso de dúvidas sobre o projeto, entre em contato com a equipe de desenvolvimento através do repositório oficial do OrbitSafe.

---

**OrbitSafe 2026 — FIAP Global Solution. Todos os direitos reservados.**

---

Esse README mantém a mesma identidade visual do projeto Front-End, mas agora está totalmente adaptado às funcionalidades reais do sistema em Python.
