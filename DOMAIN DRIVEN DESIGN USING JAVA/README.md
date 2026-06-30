# ☕ OrbitSafe — Sistema Inteligente de Monitoramento e Emergências Climáticas

> **Global Solution — Turma 1TDSPH (2026)** > Sistema desenvolvido em **Java** para a disciplina de **Domain Driven Design Using Java**, aplicando conceitos de orientação a objetos, modelagem de domínio e desenvolvimento de interfaces gráficas para simular o gerenciamento de emergências ambientais e monitoramento climático.

---

## 📌 Descrição do Projeto

O **OrbitSafe** é uma aplicação desenvolvida em **Java** com o objetivo de simular um sistema inteligente para monitoramento de desastres naturais e gerenciamento de situações de emergência através de uma interface gráfica (GUI).

O projeto foi construído utilizando os princípios da **Programação Orientada a Objetos (POO)** e conceitos de **Domain Driven Design (DDD)**, organizando as entidades de domínio de forma encapsulada e separando a lógica visual da lógica de negócio.

---

## 🎯 Objetivo

O OrbitSafe demonstra como os conceitos de **Domain Driven Design (DDD)** e da **Programação Orientada a Objetos** podem ser aplicados na construção de sistemas robustos, utilizando Java para representar o domínio do problema por meio de entidades (`beans`), interfaces e uma camada visual interativa para o utilizador.

---

## 🚀 Tecnologias e Recursos Utilizados

O sistema foi desenvolvido utilizando os seguintes recursos da linguagem Java:

* **Java 21**
* **Programação Orientada a Objetos (POO):** Encapsulamento, Herança, Polimorfismo e Abstração.
* **Interfaces Gráficas (GUI):** Desenvolvimento de ecrãs interativos para o utilizador.
* **Interfaces:** Utilização de contratos de comportamento (como a interface `Operador`).
* **Coleções e Tratamento de Exceções**
* **IDE de Desenvolvimento:** IntelliJ IDEA

---

## ⚙️ Funcionalidades Implementadas

* **👤 Cadastro de Usuários:** Gestão dos dados dos utilizadores responsáveis pelo sistema (Nome, CPF, Telefone, E-mail e Endereço).
* **📱 Gerenciamento de Dispositivos:** Registo dos dispositivos de comunicação utilizados nas emergências (Tipo, Status, Nível de bateria e Localização).
* **🚨 Registro de Emergências e Ocorrências:** Permite registar e acompanhar ocorrências ambientais, categorizando-as por gravidade, localização, data/horário e descrição detalhada.
* **📡 Monitoramento de Satélites:** Controlo dos satélites responsáveis pela comunicação e monitoramento de regiões remotas.
* **🏢 Central de Controle e Operadores:** Coordenação das operações de socorro através de centrais que gerem operadores e o fluxo de atendimento.

---

## 📁 Estrutura do Projeto

De acordo com o ambiente de desenvolvimento, o projeto está estruturado da seguinte forma:

```text
ORBITSAFE/
│
├── src/
│   └── br/com/fiap/
│       ├── bean/               # Camada de Domínio / Entidades (Java Beans)
│       │   ├── Cadastro.java
│       │   ├── CentralDeControle.java
│       │   ├── Emergencia.java
│       │   ├── Ocorrencia.java
│       │   ├── Operador.java   # Interface de contrato
│       │   └── Satelite.java
│       │
│       └── main/               # Camada de Execução e Interface Gráfica (GUI)
│           ├── img/            # Recursos visuais (Imagens/Ícones)
│           ├── GUICadastro.java
│           ├── GUICentralDeControle.java
│           ├── GUIMenuPrincipal.java  # Ponto de entrada da aplicação
│           └── GUIOcorrencia.java
│
├── .gitignore
├── OrbitSafe.iml
└── README.md

```

---

## 🏗️ Arquitetura do Projeto

O sistema divide-se claramente em duas grandes frentes de responsabilidade dentro do pacote fundamental `br.com.fiap`:

* **Pacote `bean`:** Contém as classes que moldam o negócio. Através do forte encapsulamento (atributos privados com métodos getters/setters), estas classes guardam o estado e as regras essenciais das entidades do domínio climático e de emergência.
* **Pacote `main`:** Concentra a experiência do utilizador (UI). Utiliza classes prefixadas com `GUI` para construir as janelas de interação, isolando a complexidade gráfica das regras de negócio puras.

---

## ▶️ Como Executar

### Pré-requisitos

* Java JDK 21 ou superior instalado.
* IDE **IntelliJ IDEA** (ou outra da sua preferência).

### Passo a Passo

1. **Clonar o repositório:**
```bash
git clone [https://github.com/marifernandesgm/ORBITSAFE.git](https://github.com/marifernandesgm/ORBITSAFE.git)

```


2. **Abrir no IntelliJ IDEA:**
* Vá a `File > Open` e selecione a pasta raiz do projeto. O IntelliJ irá detetar automaticamente o ficheiro de configuração `OrbitSafe.iml`.


3. **Executar a Aplicação:**
* Navegue no painel de projeto até: `src > br.com.fiap > main > GUIMenuPrincipal.java`.
* Clique com o botão direito em `GUIMenuPrincipal.java` e selecione **Run 'GUIMenuPrincipal.main()'** para abrir o ecrã principal do sistema.



---

## 👥 Integrantes

* **Andre Luiz Ramos Forastieri** — RM 572203
* **Eduardo Damasio Guelere** — RM 569960
* **Isabelle Ferreira Neri Feitoza** — RM 573507
* **Marina Fernandes Gomes Mesquita** — RM 571265
* **Milena Silva Conegin** — RM 568923
* **Turma:** 1TDSPH
* **FIAP — Global Solution 2026**

---

## 📞 Contato

Em caso de dúvidas sobre o projeto, entre em contacto com a equipa de desenvolvimento através do repositório oficial do OrbitSafe.

---

**OrbitSafe 2026 — FIAP Global Solution. Todos os direitos reservados.**

```

```
