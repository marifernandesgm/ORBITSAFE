// Aguarda todo o conteúdo HTML da página ser carregado
document.addEventListener("DOMContentLoaded", function () {

    /* ==========================================
        MENU RESPONSIVO 
       ========================================== */
    const menuToggle = document.getElementById("menu-toggle");
    const navMenu = document.getElementById("nav-menu");

    if (menuToggle && navMenu) {
        menuToggle.addEventListener("click", function () {
            // Alterna a classe para abrir/fechar o menu no CSS (.cabecalho__lista.active)
            navMenu.classList.toggle("active");
        });
    }


    /* ==========================================
        MODAL SOS E VALIDAÇÃO 
       ========================================== */
    const abrirSOS = document.getElementById("abrirSOS");
    const fecharSOS = document.getElementById("fecharSOS");
    const modalSOS = document.getElementById("modalSOS");
    const enviarSOS = document.getElementById("enviarSOS");

    // Campos de validação interna do Modal
    const sosNome = document.getElementById("sos-nome");
    const sosLocalizacao = document.getElementById("sos-localizacao");
    const sosMensagem = document.getElementById("sos-mensagem");

    // Evento para abrir a janela de emergência SOS
    if (abrirSOS) {
        abrirSOS.addEventListener("click", function () {
            modalSOS.style.display = "flex";
        });
    }

    // Evento para fechar a janela de emergência
    if (fecharSOS) {
        fecharSOS.addEventListener("click", function () {
            modalSOS.style.display = "none";
        });
    }

    // Evento de envio com VALIDAÇÃO e preventDefault() exigido no critério
    if (enviarSOS) {
        enviarSOS.addEventListener("click", function (event) {
            
            // Verifica se algum dos campos do modal está vazio
            if (!sosNome.value.trim() || !sosLocalizacao.value.trim() || !sosMensagem.value.trim()) {
                
                // Bloqueia a ação padrão (Critério Obrigatório)
                event.preventDefault(); 
                
                // Mensagem de erro amigável na tela
                alert("❌ Erro: Todos os campos do relatório de emergência precisam ser preenchidos.");
                
            } else {
                // Caso passe na validação, o fluxo prossegue com sucesso
                alert("🚨 SOS transmitido via satélite OrbitSafe com sucesso.");
                
                // Limpa os campos após o envio com sucesso
                sosNome.value = "";
                sosLocalizacao.value = "";
                sosMensagem.value = "";
                
                // Oculta o modal
                modalSOS.style.display = "none";
            }
        });
    }

    // Fecha o modal caso o usuário clique fora da área de conteúdo
    window.addEventListener("click", function (event) {
        if (event.target === modalSOS) {
            modalSOS.style.display = "none";
        }
    });

});