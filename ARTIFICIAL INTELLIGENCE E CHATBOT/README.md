# 🛰️ OrbitSafe — Sistema de Conectividade Espacial e Emergências Climáticas

> **Global Solution — Turma 1TDSPH (2026)**  
> **Disciplina:** Artificial Intelligence & Chatbot  
> **Projeto:** Desenvolvimento de um ecossistema conversacional inteligente focado na prevenção, monitoramento e resposta ágil a desastres ambientais.  

---

## DESCRIÇÃO DO PROJETO

O **OrbitSafe AI** é uma solução de inteligência artificial voltada para atuar como um assistente virtual especializado em monitoramento ambiental e mitigação de impactos causados por desastres climáticos. O chatbot foi concebido para atender tanto cidadãos em áreas vulneráveis quanto órgãos públicos, centralizando o fluxo de alertas, fornecendo dados meteorológicos regionais e permitindo o registro ágil de chamados de socorro em cenários onde redes terrestres convencionais falham.

---

## OBJETIVO

O objetivo do ecossistema OrbitSafe AI é aplicar conceitos avançados de **Processamento de Linguagem Natural (PLN)**, **Sistemas de Diálogo por Voz** e **Automação de Fluxos de Conversação** para construir uma ferramenta resiliente e acessível, capaz de diminuir o tempo de resposta em crises ambientais e salvar vidas através da informação automatizada.

---

## ECNOLOGIAS & INTEGRAÇÕES UTILIZADAS

O ecossistema do chat inteligente foi construído a partir de tecnologias de ponta em computação cognitiva e orquestração de APIs:

* **IBM Watson Assistant:** Motor cognitivo responsável pelo gerenciamento de intenções, mapeamento de entidades e controle de nós de diálogo da conversa.
* **Node-RED:** Orquestrador central responsável pela automação de fluxos, tratamento de mensagens entrantes/saintes e integração de canais.
* **Telegram Bot API:** Canal de comunicação integrado para atendimento direto ao usuário via aplicativo.
* **TELEGRAM BOT:**
   - Username do Bot: @orbitsafe_bot
   - Token de Acesso: 8921084278:AAEyoEQC2jxZMw7W_UklXsSMQmATmi5wBls).
* **IBM Watson Speech-to-Text (STT):** Serviço de IA utilizado no fluxo do Telegram para converter mensagens de voz enviadas pelo usuário em texto legível para o assistente.
* **IBM Watson Text-to-Speech (TTS):** Transformação de respostas de texto do assistente virtual em áudio sintetizado para total acessibilidade no Telegram.
* **Webchat:** Canal de comunicação web embutido em portal frontend para testes rápidos da interface conversacional.

---

## FLUXO CONVERSACIONAL (WATSON ASSISTANT)

O modelo de linguagem configurado no arquivo `Assistente_OrbitSafe-dialog.json` é composto pelas seguintes estruturas cognitivas:

### 1. Intenções (*Intents*)
* `#saudação`: Identifica o início da conversa.
* `#alertas`: Consulta por riscos climáticos ativos no território nacional.
* `#região`: Filtra o status de monitoramento de cidades ou estados específicos.
* `#riscos`: Consulta direta a previsões de tempo e clima.
* `#solicitar_ajuda`: Gatilho de emergência acionado quando o usuário se encontra isolado ou em perigo iminente.
* `#sistema`: Fornece informações institucionais sobre o propósito do OrbitSafe e sua equipe de desenvolvimento.
* `#agradecimento`: Encerramento da conversa.

### 2. Entidades (*Entities*)
* `@desastre`: Captura termos específicos como *enchente, deslizamento, incêndio, tempestade*.
* `@clima`: Extrai variáveis como *chuva, temperatura, umidade, vento*.
* `@estado`: Mapeia dinamicamente os 26 estados brasileiros e o Distrito Federal para fornecer alertas regionalizados.

### 3. Solicitação de Emergência (*Variáveis de contexto*)
Ao disparar a intenção `#solicitar_ajuda`, o nó de diálogo inicia uma rotina robusta de coleta de dados estruturados (*slots*), obrigatória para o envio de auxílio:
* **`$nome_completo`** (Nome do cidadão)
* **`$idade`** (Coleta numérica do perfil)
* **`$telefone`** (Contato para as equipes de resgate)
* **`$endereco`** (Localização exata da ocorrência)
* **`$descricao`** (Relato breve do cenário de crise)

---

## ARQUITETURA DE INTEGRAÇÃO (NODE-RED)

O pipeline configurado no `OrbitSafeAI_NodeRED.json` opera em duas frentes complementares:

<pre>

Usuário (Texto/Voz) ──> Telegram Receiver ──> [Se Voz: Watson STT] ──> Função procIN ──> IBM Watson Assistant
│
Usuário (Mensagem/Áudio) <── Telegram Sender <── [Se Voz: Watson TTS] <── Função procOut <───────┘

</pre>

1. **Tratamento de Entrada (`procIN`):** Recebe o payload do Telegram, converte arquivos de voz por meio do nó *Watson STT* e injeta o texto gerado de maneira limpa do API do Watson Assistant.
2. **Tratamento de Saída (`procOut`):** Captura a resposta estruturada em JSON enviada pelo Watson, formata blocos textuais e gera dinamicamente botões interativos de acordo com o Watson Assistant, que facilitam a navegabilidade do usuário nas opções do menu.

---

## ESTRUTURA DO PROJETO

<pre>
ORBITSAFE_AI/
│
├── Assistente_OrbitSafe-dialog.json   # Export do Workspace/Skill do IBM Watson Assistant
├── OrbitSafeAI_NodeRED.json           # Fluxo (Flow) completo exportado do Node-RED
└── README.md                          # Documentação focada na arquitetura de IA

</pre>

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

## COMO EXECUTAR

### PRIMEIRA MANEIRA(CHATBOT): 

1. Faça o clone deste repositório na sua máquina local:
   bash
   git clone https://github.com/isabelleferreiraa/ORBITSAFE-Global-Solution.git
   
2. Navegue até a pasta do projeto:
   bash
   cd ORBITSAFE

3. Abra no seu editor de código-fonte e vá até o Go Live:
   > No canto inferior direito haverá um botão para abrir e acessar o chatbot;

### SEGUNDA MANEIRA (TELEGRAM):

O Node-RED atua como o orquestrador central do **OrbitSafe AI**, interligando o Telegram (entrada e saída de texto/voz), os serviços cognitivos da IBM Cloud (Watson Assistant, Speech-to-Text e Text-to-Speech) e as funções de tratamento de dados.

#### Pré-requisitos:
Antes de iniciar, certifique-se de ter o **Node.js** instalado em sua máquina (versão LTS recomendada).

---

#### Passo 1: Instalação e Inicialização do Node-RED
1. Abra o seu terminal (Prompt de Comando ou PowerShell no Windows, Terminal no macOS/Linux).
2. Instale o Node-RED globalmente executando o seguinte comando:
   ```bash
   npm install -g --unsafe-perm node-red

```

3. Após o término da instalação, inicialize o servidor local do Node-RED:
```bash
node-red

```

4. Mantenha o terminal aberto. O Node-RED estará rodando localmente. Abra o seu navegador e acesse o endereço fornecido no terminal (geralmente `http://127.0.0.1:1880`).

---

#### Passo 2: Instalação dos Nós (Palette) Necessários

Para que o fluxo do OrbitSafe funcione sem erros de nós ausentes, você precisa instalar os módulos do Telegram e do Watson:

1. Na interface do Node-RED no navegador, clique no menu do canto superior direito (ícone de três linhas horizontais).
2. Selecione a opção **Manage palette**.
3. Vá até a aba **Install**.
4. No campo de busca, procure e instale os seguintes pacotes:
* `node-red-contrib-telegrambot` (Responsável pela comunicação com o app do Telegram)
* `node-red-node-watson` (Responsável pela conexão com Watson Assistant, STT e TTS)
5. Clique em **Close** após a conclusão das instalações.

---

#### Passo 3: Importação do Fluxo (Flow)

1. Clique novamente no menu do canto superior direito e selecione **Import**.
2. Clique em **select a file to import** e selecione o arquivo `OrbitSafeAI_NodeRED.json` contido no repositório (ou copie o conteúdo de texto do arquivo JSON e cole diretamente na caixa de texto).
3. Certifique-se de importar em uma "New flow" (Nova aba) e clique no botão **Import**.

---

#### Passo 4: Configuração das Credenciais e APIs

Com o fluxo carregado na sua tela, é necessário configurar as chaves de acesso que conectam os serviços:

1. **Configuração do Bot do Telegram:**
* Localize o nó laranja chamado `telegram receiver` ou `telegram sender`.
* Dê um duplo clique em qualquer um deles.
* No campo **Bot**, clique no ícone de lápis para editar as configurações.
* Insira o *Token de Acesso* gerado pelo BotFather do Telegram e dê um nome ao bot (ex: `OrbitSafe AI`).
* Clique em **Update** e depois em **Done**.


2. **Configuração dos Nós da IBM Cloud (Watson):**
* Localize os nós do ecossistema Watson (como o nó do `assistant`, `speech to text` e `text to speech`).
* Dê um duplo clique em cada um deles individualmente.
* Insira a respectiva **API Key** e a **Service URL** geradas na sua conta do IBM Cloud para cada serviço.
* No nó do `assistant`, lembre-se de preencher também o **Assistant ID** (ou ID do ambiente).
* Clique em **Done** em cada nó configurado.

---

#### Passo 5: Ativação do Fluxo (Deploy)

1. Com tudo configurado, clique no botão vermelho **Deploy** localizado no canto superior direito da tela do Node-RED.
2. Se aparecer a mensagem *"Successfully deployed"*, o fluxo estará ativo e rodando.
3. Agora, basta abrir o Telegram, buscar pelo seu bot e enviar um comando ou áudio para iniciar a interação controlada e automatizada pelo Node-RED.

---

## CONTATO

Para dúvidas, suporte técnico ou informações sobre o ecossistema OrbitSafe, entre em contato com a equipe de desenvolvimento através dos canais abaixo:

* **Dúvidas:** Abra uma [*Issue* diretamente no nosso repositório do GitHub](https://github.com/marifernandesgm/ORBITSAFE.git)

---
OrbitSafe 2026 — Fiap Global Solution. Todos os direitos reservados.
