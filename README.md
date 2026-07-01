# 🛰️ OrbitSafe — Sistema de Conectividade Espacial e Emergências Climáticas

> **Global Solution — FIAP (2026)** > **Turma:** 1TDSPH  
> **Solução integrada transdisciplinar:** Engenharia de Software, Modelagem de Negócios, Building Relational Database, Java (DDD & GUI), Python, Inteligência Artificial (Watson Assistant & Node-RED) e Desenvolvimento Web Front-End.  
> Projeto focado em conectividade via satélites de órbita baixa  para prevenção, monitoramento e resposta ágil a desastres ambientais.

---

## Sobre o Projeto

O **OrbitSafe** é uma plataforma ecossistêmica desenvolvida para auxiliar no monitoramento de desastres naturais e climáticos em regiões vulneráveis do Brasil. 

A proposta surgiu a partir do desafio da Global Solution 2026, cujo objetivo é desenvolver uma solução tecnológica capaz de minimizar os impactos humanitários e estruturais causados por eventos extremos como enchentes, tempestades, incêndios florestais, ventos fortes e deslizamentos de terra.

O sistema utiliza uma arquitetura resiliente baseada em satélites de órbita baixa (LEO) para garantir o tráfego de dados e conectividade contínua mesmo quando a infraestrutura terrestre convencional (antenas de telefonia, redes de energia) é severamente comprometida. Desse modo, equipes de resgate, órgãos governamentais e cidadãos conseguem manter canais ativos de comunicação durante situações críticas de isolamento.

Ao unificar engenharia de requisitos, viabilidade mercadológica, modelagem estruturada de banco de dados relacionais, interfaces web responsivas, interfaces gráficas locais, processamento lógico de dados em scripts locais e um chatbot inteligente integrado a canais de mensageria com suporte a voz, o OrbitSafe oferece uma resposta integrada de ponta a ponta focado em prevenção, agilidade e triagem de emergências.

---

## Objetivos do Ecossistema

* **Monitorar riscos ambientais:** Centralizar indicadores críticos para avaliação contínua.
* **Informar a população:** Oferecer canais interativos e preditivos sobre condições climáticas severas.
* **Simular alertas de desastres:** Disponibilizar rotinas de classificação de risco em tempo real.
* **Otimizar o fluxo de socorro:** Facilitar e agilizar o contato entre o cidadão em risco, operadores e centrais de Defesa Civil.
* **Demonstrar maturidade arquitetural:** Aplicar os conceitos acadêmicos de Engenharia de Software, Modelagem Relacional, Orientação a Objetos, Inteligência Artificial e Desenvolvimento Web de forma acionável e ágil.

---

## Relação com os Objetivos de Desenvolvimento Sustentável (ODS)

* **ODS 11 — Cidades e Comunidades Sustentáveis:** Fornece tecnologia crítica de mitigação para aumentar a resiliência das cidades e reduzir significativamente o número de mortes e pessoas afetadas por catástrofes climáticas.
* **ODS 13 — Ação Contra a Mudança Global do Clima:** Fortalece a capacidade de adaptação, resiliência e alerta rápido frente aos riscos induzidos pelas mudanças climáticas antropogênicas e meteorológicas.
* **ODS 9 — Indústria, Inovação e Infraestrutura:** Utiliza tecnologias inovadoras como: Inteligência Artificial; Processamento de Linguagem Natural; Assistentes virtuais; Reconhecimento e síntese de voz. Essas tecnologias são aplicadas para resolver um problema real da sociedade, demonstrando como a inovação pode ser utilizada para gerar impacto positivo.

---

## Arquitetura Geral e Módulos por Disciplina

O ecossistema OrbitSafe foi dividido em blocos arquiteturais especializados, distribuídos entre as disciplinas estratégicas e técnicas do semestre:

### 1. Software Engineering and Business Model

Camada estratégica focada em concepção de mercado.
* **Conceito & Proposta de Valor:** Formulação do plano estratégico de mercado visando o atendimento das Defesas Civis e órgãos públicos.
* **Business Model Canvas (BMC):** Estruturação de parceiros, canais, fontes de receita e estimativa de viabilidade financeira (Investimento inicial projetado de R$ 150.000,00 para o MVP).
* **Gestão Ágil:** Planejamento e controle de escopo utilizando Backlog do Produto e Histórias de Usuário (*User Stories*) refinadas.
* **Avaliação Heurística de IHC:** Mapeamento minucioso das interfaces de protótipo sob o crivo das **10 Heurísticas de Usabilidade de Jakob Nielsen** (tratando visibilidade de status, flexibilidade e prevenção de erros).

### 2. Building Relational Databases

Módulo focado na modelagem, persistência, integridade e estruturação de dados relacionais corporativos para suportar a infraestrutura de dados da plataforma.
* **Modelo Conceitual e Relacional:** Criação de diagramas de Entidade e Relacionamento (MER) mapeando fluxos consistentes de usuários e centrais.
* **Estrutura de Tabelas (DDL):** Mapeamento físico e criação de restrições de chaves primárias (`PRIMARY KEY`) e estrangeiras (`FOREIGN KEY`) para os seguintes componentes lógicos:
  * `CENT_CONTROL`: Armazena as centrais físicas responsáveis pelo gerenciamento operacional de risco.
  * `DISPOSITIVO`: Mapeia sensores e equipamentos de campo dos cidadãos com controle de nível de bateria.
  * `EMERGENCIA` e `OCORRENCIA`: Estrutura de chamados que armazena a descrição física e o grau de gravidade.
  * `OPERADOR`: Identifica os técnicos responsáveis por monitorar as centrais.
  * `SATELITE`: Controla os módulos orbitais associados à infraestrutura de conectividade de contingência.
  * `USUARIO`: Registro cadastral único de cidadãos e civis.

### 3. Domain Driven Design Using Java

Módulo de backend local e gerenciamento de domínio corporativo utilizando Programação Orientada a Objetos robusta e interface gráfica interativa para o operador.
* **Conceitos Aplicados:** Encapsulamento estrito (Java Beans), herança, polimorfismo, abstração e coleções temporárias (`ArrayList`) para emular persistência de banco de dados.
* **Modelagem de Domínio (`br.com.fiap.bean`):** Entidades estruturadas representando o negócio: `Cadastro`, `CentralDeControle`, `Emergencia`, `Ocorrencia`, `Satelite` e a interface abstrata `Operador`.
* **Interface Gráfica (`br.com.fiap.main`):** Camada visual Desktop desenvolvida em Java GUI (`GUIMenuPrincipal`, `GUICadastro`, `GUICentralDeControle`, `GUIOcorrencia`), isolando componentes gráficos das entidades de dados puros.

### 4. Python

Sistema utilitário executado via terminal simulando rotinas matemáticas de análise de riscos, cálculo meteorológico e triagem operacional em script ágil.
* **Conceitos Aplicados:** Estruturas condicionais avançadas, laços de repetição, coleções dinâmicas (Listas e Dicionários), funções parametrizadas, estrutura `match-case` e tratamento de exceções robusto (`try/except`).
* **Módulos Simulados:** Cadastro interno de usuários, registro imediato de desastres, calculadora automatizada de nível de risco climático (cruzando variáveis de vento, chuva e temperatura), simulação de focos de queimada por bioma brasileiro e acionamento simulado de roteamento via satélite em quedas de internet.

### 5. Artificial Intelligence & ChatBot

Camada cognitiva de interface conversacional automatizada com processamento de linguagem natural e barramento de integração de serviços (IoT).
* **IBM Watson Assistant:** Árvore de diálogo treinada com Intenções (`#saudacao`, `#alertas`, `#riscos`), Entidades (`@estados`, `@desastres`) e slots restritivos de preenchimento para automação de triagem.
* **Node-RED:** Orquestrador que implementa funções em JavaScript (`msg.payload`), trata variáveis contextuais de sessão e atua como meio de comunicação.
* **Integração & Acessibilidade:** Integração activa com a API do **Telegram Bot**, permitindo comandos remotos. Uso combinado dos serviços cognitivos **Speech to Text** (conversão de áudio enviado pelo usuário em texto interpretável) e **Text to Speech** (resposta sintetizada por voz para maior acessibilidade).

### 6. Web Development Front-End

Plataforma central web de acesso público e institucional, servindo como o painel principal visual do ecossistema OrbitSafe.
* **Tecnologias:** HTML5 semântico, estilização avançada com CSS3 e interatividade dinâmica via JavaScript Vanilla.
* **Funcionalidades da UI:** Dashboard analítico, central unificada de monitoramento, formulário de emergência rápida (Formulário SOS), área "Sobre" detalhada, FAQ e layout 100% responsivo com suporte a Menu Mobile.

---

## Tecnologias e Ferramentas Utilizadas

* **Linguagens de Programação:** Java 21, Python 3, JavaScript (ES6+), SQL (Oracle PL/SQL DDL)
* **Desenvolvimento Web:** HTML5, CSS3, JavaScript
* **Computação Cognitiva e IA:** IBM Watson Assistant, Speech to Text, Text to Speech, IBM Cloud
* **Orquestração de Fluxos:** Node-RED (Arquivos estruturados em JSON)
* **Design, Engenharia e Gestão:** Canva (Business Model Canvas), Notion (Gerenciamento de Backlog Ágil)
* **Versionamento de Código:** Git e GitHub

---

## Organização Estrutural do Projeto

<pre>
ORBITSAFE/
│
├── Front-End/               # Arquivos da plataforma Web responsiva
│   ├── index.html           # Página Inicial / Home
│   ├── css/                 # Estilizações da interface
│   ├── js/                  # Interatividade e lógica visual
│   └── assets/              # Imagens e ícones do sistema
│
├── Java/                    # Projeto Java com GUI
│   ├── src/br/com/fiap/
│   │   ├── bean/            # Classes de modelo e domínio encapsuladas
│   │   └── main/            # Interfaces gráficas (GUI) e ponto de partida
│   └── OrbitSafe.iml        # Arquivo de configuração do módulo IntelliJ
│
├── Relational_Database/     # Modelagem e persistência relacional
│   ├── arquivo_sql.ddl      # Script de criação de tabelas e constraints
│   └── 1TDSPH_ORBITSAFE.pdf # Documentação de requisitos de dados e diagramas
│
├── Python/                  # Script executado via console
│   └── OrbitSafeGS.py       # Algoritmos de triagem e riscos climáticos
│   └── OrbitSafePY.pdf      # Documentação de fluxo e diagramas
│
├── IA/                                    # Workspace de IA e Automação
│   ├── Assistente_OrbitSafe-dialog.json   # Árvore de diálogos e IA (Watson)
│   └── OrbitSafeAI_NodeRED.json           # Fluxo de nós e integração Telegram
│
├── Software Engineering/    # Engenharia de Software e Negócios
│   └── ORBITSAFE - GS - SOFTWARE ENGINEERING AND BUSINESS MODEL.pdf
│
├── .gitignore               # Filtros de versionamento (IntelliJ, VS Code, OS)
└── README.md                # Documentação Geral
</pre>

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
