# ============================================================
#   ORBITSAFE - GLOBAL SOLUTION FIAP 2026
#   Conectividade via Satélites para Regiões Remotas
# ============================================================
# Integrantes:
#   Isabelle Ferreira Neri Feitoza- RM: 573507
#   Marina Fernandes Gomes Mesquita RM: 571265
#   Milena Silva Conegin          - RM: 568923
# Turma: 1TDSPH - FIAP
# ============================================================

# Listas para armazenar os dados
usuarios = []
emergencias = []

# ------------------------------------------------------------
# FUNCOES:
# ------------------------------------------------------------

"""
Exibe no terminal o menu principal 
com todas as opções disponíveis no sistema OrbitSafe.
"""
def exibir_menu():
    print("============================================")
    print("        OrbitSafe - MENU PRINCIPAL       ")
    print("============================================")
    print("[1] Sobre o projeto")
    print("[2] Cadastrar usuário")
    print("[3] Registrar emergência")
    print("[4] Consultar risco climático")
    print("[5] Consultar conectividade")
    print("[6] Monitorar queimadas")
    print("[7] Ver relatórios")
    print("[0] Sair")
    print("============================================")


"""
Funcionalidade: Apresenta o resumo sobre o OrbitSafe, os objetivos e o escopo do 
projeto OrbitSafe para o usuário.

"""
def sobre_o_projeto():
    print("\n============================================")
    print("  SOBRE O ORBITSAFE")
    print("============================================")
    print("O OrbitSafe e uma plataforma de monitoramento")
    print("de emergências que usa satélites para manter")
    print("comunicação em regiões remotas e situações")
    print("de desastre como enchentes e queimadas.")
    print("============================================\n")


"""
Funcionalidade: Captura os dados cadastrais do usuário (Nome, CPF, Cidade e Estado),
aplica validações de dados para evitar erros e armazena 
o registro estruturado em formato de dicionário.
"""
def cadastrar_usuario():
    print("\n============================================")
    print("  CADASTRO DE USUÁRIO")
    print("============================================")

    #Tratativa de erro: Nome deve conter apenas letras, sem números ou símbolos
    while True:
        nome = input("Digite seu nome: ").strip()
        if nome.replace(" ", "").isalpha() and len(nome) > 0:
         
            break
        print("Erro: Nome inválido. Digite apenas letras (não use números ou símbolos).\n")

    # Tratativa de erro: CPF deve conter exatamente 11 dígitos numéricos
    while True:
        cpf = input("Digite seu CPF (somente números, 11 dígitos): ").strip()
        if cpf.isdigit() and len(cpf) == 11:
            break
        print("Erro: CPF inválido. Digite apenas os 11 números, sem pontos ou traços.")

    #Tratativa de erro: cidade deve conter apenas letras 
    while True:
        cidade = input("Digite sua cidade: ").strip()
        if cidade.replace(" ", "").isalpha() and len(cidade) > 0:
            cidade = cidade.title()
            break
        print("Erro: Cidade inválida. Digite apenas letras.\n")

    # Tratativa de erro: Estado não deve ser digitado com siglas 
    while True:
        estado = input("Digite seu estado (ex: São Paulo): ").strip().upper()
        if estado.replace(" ", "").isalpha() and len(estado) > 2:
            break
        print("Erro: Estado inválido. Por favor, digite o nome completo do estado(ex: São Paulo).")
   
# Estruturação do registro utilizando Dicionário (Chave-Valor)
    usuario = {
        "nome": nome,
        "cpf": cpf,
        "cidade": cidade,
        "estado": estado
    }

    usuarios.append(usuario)

    print("\nUsuário cadastrado com sucesso!")
    print("Nome  :", nome)
    print("CPF   :", cpf)
    print(f"Cidade: {cidade} - Estado: {estado}")
    print("============================================\n")


"""
Funcionalidade: Registra ocorrências críticas no sistema mapeando categorias 
e severidade. Usando mapeamentos de dicionários protegidos 
por blocos try-except para evitar quebra do programa por digitação errada.
"""
def registrar_emergencia():
    print("\n============================================")
    print("  REGISTRAR EMERGÊNCIA")
    print("============================================")
    print("Tipos de emergência:")
    print("[1] Enchente")
    print("[2] Queimada")
    print("[3] Deslizamento")
    print("[4] Tempestade")

    tipo_opcao = input("Escolha o tipo: ")

    # Dicionário de mapeamento para traduzir a opção numérica no nome do desastre
    tipos_validos = {"1": "Enchente", "2": "Queimada", "3": "Deslizamento", "4": "Tempestade"}
    try:
        tipo = tipos_validos[tipo_opcao]
    except KeyError:
        print("Aviso: Opção inválida. Tipo definido como 'Outro'.")
        tipo = "Outro"

    local = input("Local da ocorrência: ")

    print("Grau de emergência:")
    print("[1] Baixo")
    print("[2] Médio")
    print("[3] Alto")
    print("[4] Crítico")

    grau_opcao = input("Escolha o grau: ")

    # Mapeamento do nível de gravidade
    graus_validos = {"1": "Baixo", "2": "Médio", "3": "Alto", "4": "Crítico"}
    try:
        grau = graus_validos[grau_opcao]
    except KeyError:
        print("Aviso: Opção inválida. Grau definido como 'Não informado'.")
        grau = "Não informado"

    # Criação do objeto da emergência
    emergencia = {
        "tipo": tipo,
        "local": local,
        "grau": grau
    }

    emergencias.append(emergencia)

    print("\nEmergência registrada!")
    print("Tipo :", tipo)
    print("Local:", local)
    print("Grau :", grau)

    # Informa qual suporte será enviado com base na gravidade
    if grau == "Crítico":
        print(">> Acionando: SAMU + Bombeiros + Defesa Civil")
    elif grau == "Alto":
        print(">> Acionando: Bombeiros + Defesa Civil")
    elif grau == "Médio":
        print(">> Acionando: Equipe de vistoria local")
    else:
        print(">> Acao: Monitoramento remoto")

    print("============================================\n")


"""
Funcionalidade: Avalia os parâmetros numéricos climáticos capturados da atmosfera 
e calcula o grau de risco para a região.
Parâmetros:
- temperatura (float): Temperatura local em graus Celsius.
- chuva (float): Volume acumulado de precipitação em milímetros (mm).
- vento (float): Velocidade dos ventos em km/h.
Retorno:
- string: Retorna textualmente o nível ponderado ("Alto", "Médio" ou "Baixo").
"""
def calcular_risco(temperatura, chuva, vento):
    """Calcula e retorna o nível de risco climático com base nos dados fornecidos."""
    if temperatura > 38 or chuva > 80 or vento > 50:
        return "Alto"
    elif temperatura > 32 or chuva > 40 or vento > 30:
        return "Médio"
    else:
        return "Baixo"


"""
Funcionalidade: Interface de consulta de riscos para uma localidade específica. 
Interage com o usuário para receber telemetria climática simulada, 
protegendo a entrada de dados contra erros de conversão de tipos (ValueError).
Parâmetros:
- cidade (string): Nome do município passado dinamicamente pelo programa principal.

"""
def consultar_risco_climatico(cidade):
    """Consulta o risco climático de uma cidade passada como parâmetro."""
    print("\n============================================")
    print("  CONSULTA DE RISCO CLIMÁTICO")
    print("============================================")

    while True:
      try:
        temperatura = float(input("Temperatura atual (°C): "))
        break
      except ValueError:
        print("\nErro: Por favor, digite apenas números nos campos climáticos.")
        print("============================================\n")
    
    
    while True:
      try:
        chuva = float(input("Volume de chuva (mm):   "))
        break
      except ValueError:
        print("\nErro: Por favor, digite apenas números nos campos climáticos.")
        print("============================================\n")
      
    
    while True:
      try:
        vento = float(input("Velocidade do vento (km/h): "))
        break
      except ValueError:
        print("\nErro: Por favor, digite apenas números nos campos climáticos.")
        print("============================================\n")
      

    # Usa a função com return para obter o nível de risco
    risco = calcular_risco(temperatura, chuva, vento)

    print("\nResultado para:", cidade)
    print("Temperatura :", temperatura, "°C")
    print("Chuva       :", chuva, "mm")
    print("Vento       :", vento, "km/h")
    print("Nível de risco:", risco)
    print("============================================\n")

"""
Funcionalidade: Passa por uma lista com os principais biomas do Brasil (Amazônia, Cerrado, etc.)
.O sistema pede a quantidade de focos de incêndio
e diz se a situação está normal, em atenção ou crítica,
além de não quebrar se o usuário digitar letras em vez de números.
"""
def monitorar_queimadas():
    print("\n============================================")
    print("  MONITORAMENTO DE QUEIMADAS")
    print("============================================")

    regioes = ["Amazônia", "Cerrado", "Pantanal", "Caatinga", "Mata Atlântica"]

    for regiao in regioes:
        while True:
            try:
                focos = int(input("Focos detectados em " + regiao + ": "))
                break  # Só sai do loop se for um número inteiro válido
            except ValueError:
                # Mudamos a vírgula por + para a frase colar certinho no ponto final
                print("Erro: Valor inválido para " + regiao + ". Digite apenas números inteiros.\n")

        if focos > 200:
            nivel = "CRÍTICO"
        elif focos > 80:
            nivel = "ATENÇÃO"
        else:
            nivel = "Normal"

        print("->", regiao, ":", focos, "focos -", nivel)

    print("============================================\n")

"""
Funcionalidade: Verifica o status da infraestrutura local de telecomunicação 
. Se ela cair, o sistema liga automaticamente a internet por satélite 
para o lugar não ficar sem comunicação.
"""
def consultar_conectividade():
    print("\n============================================")
    print("  CONSULTA DE CONECTIVIDADE")
    print("============================================")

    #Tratativa: Não aceita letras e espaço vazio 
    while True:
        regiao = input("Digite a região ou cidade: ").strip().title()
        if regiao.replace(" ", "").isalpha() and len(regiao) > 0:
            break
        print("Erro: Nome da região inválido. Use apenas letras.\n")

    # Tratativa: Obriga o usuário a responder 'sim' ou 'não'
    while True:
        status = input("A internet está funcionando? (sim/não): ").strip().lower()
        if status in ["sim", "não", "nao"]:
            break
        print("Erro: Por favor, responda apenas com 'sim' ou 'não'.\n")
    if status == "sim":
        print("\nConectividade OK em:", regiao)
        print("Sinal de internet disponível.")
    else:
        print("\nConectividade FALHOU em:", regiao)
        print("Ativando comunicação via satélite...")
        print("Satélite SAT-ALPHA acionado para a região.")

    print("============================================\n")

"""
Funcionalidade: Passa por uma lista com os principais biomas do Brasil (Amazônia, Cerrado, etc.) 
. O sistema pede a quantidade de focos de incêndio 
e diz se a situação está normal, em atenção ou crítica, 
além de não quebrar se o usuário digitar letras em vez de números.
"""


"""
Mostra um resumo na tela com a quantidade total de usuários e de emergências salvas. 
Depois, ele lê as duas listas e exibe os dados organizados linha por linha.
"""
def ver_relatorios():
    print("\n============================================")
    print("  RELATÓRIOS DO SISTEMA")
    print("============================================")

    print("Usuários cadastrados:", len(usuarios))
    print("Emergências registradas:", len(emergencias))

    # Lista os usuários
    if len(usuarios) > 0:
        print("\n-- Usuários --")
        for u in usuarios:
            print(f"- {u['nome']} | {u['cpf']} | Cidade: {u['cidade']} - Estado: {u['estado']}")

    # Lista as emergencias
    if len(emergencias) > 0:
        print("\n-- Emergências --")
        for e in emergencias:
            print("-", e["tipo"], "|", e["local"], "| Grau:", e["grau"])

    print("============================================\n")


# ------------------------------------------------------------
# PROGRAMA PRINCIPAL
# ------------------------------------------------------------

while True:
    exibir_menu()
    opcao = input("Escolha uma opção: ")

    match opcao:
        case "1":
           sobre_o_projeto()
        case "2":
           cadastrar_usuario()
        case "3":
            registrar_emergencia()        
        case "4":
            while True:
                cidade = input("Digite o nome da cidade para consulta: ").strip().title()
                if cidade.replace(" ", "").isalpha() and len(cidade) > 0:
                    break  # Sai do loop se o nome for válido
                print("Erro: Nome de cidade inválido. Digite apenas letras.\n")
                
            consultar_risco_climatico(cidade)
        case "5":
            consultar_conectividade()
        case "6":
            monitorar_queimadas()
        case "7":
            ver_relatorios()
        case "0":
            print("\nSaindo do OrbitSafe. Até logo!")
            break
        case _:
            print("\nOpção inválida. Tente novamente.\n")