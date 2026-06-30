// ============================================================
//  ORBITSAFE – SCRIPT PRINCIPAL
//  Todas as funcionalidades interativas centralizadas em JS
// ============================================================

document.addEventListener("DOMContentLoaded", function () {

    /* ==========================================
        MENU RESPONSIVO (HAMBURGER)
       ========================================== */
    const menuToggle = document.getElementById("menu-toggle");
    const navMenu = document.getElementById("nav-menu");

    if (menuToggle && navMenu) {
        menuToggle.addEventListener("click", function () {
            navMenu.classList.toggle("active");
            // Alterna ícone do hamburger
            this.textContent = navMenu.classList.contains("active") ? "✕" : "☰";
        });

        // Fecha menu ao clicar em um link (mobile)
        const navLinks = navMenu.querySelectorAll(".cabecalho__link");
        navLinks.forEach(function (link) {
            link.addEventListener("click", function () {
                navMenu.classList.remove("active");
                menuToggle.textContent = "☰";
            });
        });
    }

    /* ==========================================
        LINK ATIVO NA NAVEGAÇÃO (highlight dinâmico)
       ========================================== */
    (function highlightActiveLink() {
        const currentPage = window.location.pathname.split("/").pop() || "index.html";
        const allNavLinks = document.querySelectorAll(".cabecalho__link");
        allNavLinks.forEach(function (link) {
            const href = link.getAttribute("href");
            if (href) {
                const linkPage = href.split("/").pop();
                if (linkPage === currentPage) {
                    link.classList.add("cabecalho__link--active");
                }
            }
        });
    })();

    /* ==========================================
        MODAL SOS – VALIDAÇÃO COM FEEDBACK VISUAL
       ========================================== */
    const abrirSOS = document.getElementById("abrirSOS");
    const fecharSOS = document.getElementById("fecharSOS");
    const modalSOS = document.getElementById("modalSOS");
    const enviarSOS = document.getElementById("enviarSOS");

    // Seleciona os campos SOS dentro do modal (inputs e textarea)
    let sosNome, sosLocalizacao, sosMensagem;
    if (modalSOS) {
        const sosInputs = modalSOS.querySelectorAll("input[type='text']");
        const sosTextarea = modalSOS.querySelector("textarea");
        if (sosInputs.length >= 2) {
            sosNome = sosInputs[0];
            sosLocalizacao = sosInputs[1];
        }
        sosMensagem = sosTextarea;
    }

    // Abre modal SOS com animação
    if (abrirSOS && modalSOS) {
        abrirSOS.addEventListener("click", function () {
            modalSOS.style.display = "flex";
            modalSOS.querySelector(".sos-conteudo").style.animation = "fadeSlideUp 0.4s ease";
        });
    }

    // Fecha modal SOS
    if (fecharSOS && modalSOS) {
        fecharSOS.addEventListener("click", function () {
            modalSOS.style.display = "none";
        });
    }

    // Fecha modal clicando fora
    if (modalSOS) {
        window.addEventListener("click", function (event) {
            if (event.target === modalSOS) {
                modalSOS.style.display = "none";
            }
        });
    }

    // Envio SOS com validação e FEEDBACK VISUAL (sem alert)
    if (enviarSOS) {
        enviarSOS.addEventListener("click", function (event) {
            event.preventDefault();

            if (!sosNome || !sosLocalizacao || !sosMensagem) return;

            if (!sosNome.value.trim() || !sosLocalizacao.value.trim() || !sosMensagem.value.trim()) {
                exibirFeedback(modalSOS.querySelector(".sos-conteudo"), "❌ Preencha todos os campos do relatório de emergência.", "erro");
                // Destaca campos vazios
                [sosNome, sosLocalizacao, sosMensagem].forEach(function (campo) {
                    if (!campo.value.trim()) {
                        campo.style.border = "2px solid #ff4444";
                        campo.addEventListener("input", function () {
                            campo.style.border = "1px solid #334155";
                        }, { once: true });
                    }
                });
            } else {
                exibirFeedback(modalSOS.querySelector(".sos-conteudo"), "🚨 SOS transmitido via satélite OrbitSafe com sucesso!", "sucesso");
                // Limpa campos
                sosNome.value = "";
                sosLocalizacao.value = "";
                sosMensagem.value = "";
                // Fecha modal após feedback
                setTimeout(function () {
                    modalSOS.style.display = "none";
                }, 2500);
            }
        });
    }

    /* ==========================================
        FORMULÁRIO DE CONTATO – TRATAMENTO VIA JS
       ========================================== */
    const formContato = document.querySelector(".contato__formulario form");
    if (formContato) {
        formContato.addEventListener("submit", function (event) {
            event.preventDefault();

            const nome = document.getElementById("nome");
            const email = document.getElementById("email");
            const assunto = document.getElementById("assunto");
            const mensagem = document.getElementById("mensagem");

            // Validação campo a campo
            let valido = true;
            const campos = [nome, email, assunto, mensagem];

            campos.forEach(function (campo) {
                if (!campo.value.trim()) {
                    valido = false;
                    campo.style.border = "2px solid #ff4444";
                    campo.addEventListener("input", function () {
                        campo.style.border = "1px solid #334155";
                    }, { once: true });
                    campo.addEventListener("change", function () {
                        campo.style.border = "1px solid #334155";
                    }, { once: true });
                }
            });

            // Validação de email
            if (email && email.value.trim()) {
                const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
                if (!emailRegex.test(email.value.trim())) {
                    valido = false;
                    email.style.border = "2px solid #ff4444";
                    exibirFeedback(formContato, "❌ Por favor, insira um e-mail válido.", "erro");
                    return;
                }
            }

            if (!valido) {
                exibirFeedback(formContato, "❌ Por favor, preencha todos os campos obrigatórios.", "erro");
                return;
            }

            // Sucesso
            exibirFeedback(formContato, "✅ Mensagem enviada com sucesso! Entraremos em contato em breve.", "sucesso");

            // Limpa formulário
            formContato.reset();
        });
    }

    /* ==========================================
        FUNÇÃO DE FEEDBACK VISUAL (substitui alert)
       ========================================== */
    function exibirFeedback(container, mensagem, tipo) {
        // Remove feedback anterior se existir
        const feedbackAnterior = container.querySelector(".feedback-msg");
        if (feedbackAnterior) feedbackAnterior.remove();

        const feedback = document.createElement("div");
        feedback.className = "feedback-msg";
        feedback.textContent = mensagem;

        // Estilo dinâmico
        feedback.style.cssText = [
            "padding: 1.2rem 2rem",
            "border-radius: 1rem",
            "text-align: center",
            "font-weight: bold",
            "font-size: 1.6rem",
            "margin-top: 1rem",
            "animation: fadeSlideUp 0.4s ease",
            "transition: opacity 0.5s ease"
        ].join(";");

        if (tipo === "sucesso") {
            feedback.style.background = "rgba(0, 207, 100, 0.15)";
            feedback.style.border = "1px solid #00cf64";
            feedback.style.color = "#00ff7f";
        } else {
            feedback.style.background = "rgba(255, 68, 68, 0.15)";
            feedback.style.border = "1px solid #ff4444";
            feedback.style.color = "#ff6b6b";
        }

        container.appendChild(feedback);

        // Remove feedback automaticamente após 4 segundos
        setTimeout(function () {
            feedback.style.opacity = "0";
            setTimeout(function () {
                if (feedback.parentNode) feedback.remove();
            }, 500);
        }, 4000);
    }

    /* ==========================================
        FAQ ACCORDION INTERATIVO
       ========================================== */
    const faqCards = document.querySelectorAll(".faq__card");
    if (faqCards.length > 0) {
        faqCards.forEach(function (card) {
            const pergunta = card.querySelector("h2");
            const resposta = card.querySelector("p");

            if (pergunta && resposta) {
                // Esconde resposta inicialmente
                resposta.style.maxHeight = "0";
                resposta.style.overflow = "hidden";
                resposta.style.transition = "max-height 0.5s ease, opacity 0.5s ease, padding 0.5s ease";
                resposta.style.opacity = "0";
                resposta.style.paddingTop = "0";

                // Adiciona ícone de toggle
                pergunta.style.cursor = "pointer";
                pergunta.style.display = "flex";
                pergunta.style.justifyContent = "space-between";
                pergunta.style.alignItems = "center";

                const icone = document.createElement("span");
                icone.textContent = "+";
                icone.className = "faq-toggle-icon";
                icone.style.cssText = "font-size: 3rem; color: #00cfff; transition: transform 0.3s ease; flex-shrink: 0; margin-left: 1rem;";
                pergunta.appendChild(icone);

                pergunta.addEventListener("click", function () {
                    const isOpen = card.classList.contains("faq--open");

                    // Fecha todos os outros
                    faqCards.forEach(function (otherCard) {
                        if (otherCard !== card) {
                            otherCard.classList.remove("faq--open");
                            const otherResp = otherCard.querySelector("p");
                            const otherIcon = otherCard.querySelector(".faq-toggle-icon");
                            if (otherResp) {
                                otherResp.style.maxHeight = "0";
                                otherResp.style.opacity = "0";
                                otherResp.style.paddingTop = "0";
                            }
                            if (otherIcon) {
                                otherIcon.textContent = "+";
                                otherIcon.style.transform = "rotate(0deg)";
                            }
                        }
                    });

                    // Toggle do card clicado
                    if (isOpen) {
                        card.classList.remove("faq--open");
                        resposta.style.maxHeight = "0";
                        resposta.style.opacity = "0";
                        resposta.style.paddingTop = "0";
                        icone.textContent = "+";
                        icone.style.transform = "rotate(0deg)";
                    } else {
                        card.classList.add("faq--open");
                        resposta.style.maxHeight = resposta.scrollHeight + 20 + "px";
                        resposta.style.opacity = "1";
                        resposta.style.paddingTop = "1.5rem";
                        icone.textContent = "−";
                        icone.style.transform = "rotate(180deg)";
                    }
                });
            }
        });
    }

    /* ==========================================
        ANIMAÇÃO DE SCROLL (INTERSECTION OBSERVER)
       ========================================== */
    const observerOptions = { threshold: 0.15, rootMargin: "0px 0px -50px 0px" };

    const scrollObserver = new IntersectionObserver(function (entries) {
        entries.forEach(function (entry) {
            if (entry.isIntersecting) {
                entry.target.classList.add("animate-in");
                scrollObserver.unobserve(entry.target);
            }
        });
    }, observerOptions);

    // Seleciona elementos para animar
    const animTargets = document.querySelectorAll(
        ".conteudo__sec, .card, .card-metrica, .bloco-grafico, .secao-tabela, " +
        ".faq__card, .valores__card, .sobre__container, .integrante, .repositorio, " +
        ".bloco-mapa, .bloco-ocorrencias, .titulo-central, .titulo-dashboard, " +
        ".contato__titulo, .contato__formulario, .integrantes__titulo, .faq__titulo, " +
        ".painel-status-orbital, .painel-telemetria, .painel-cobertura-global"
    );

    animTargets.forEach(function (el) {
        el.classList.add("scroll-hidden");
        scrollObserver.observe(el);
    });

    /* ==========================================
        CONTADORES ANIMADOS (Dashboard + Monitoramento)
       ========================================== */
    function animarContador(elemento, valorFinal, sufixo, duracao) {
        if (!elemento) return;

        const inicio = 0;
        const incremento = valorFinal / (duracao / 16);
        let atual = inicio;

        const timer = setInterval(function () {
            atual += incremento;
            if (atual >= valorFinal) {
                atual = valorFinal;
                clearInterval(timer);
            }

            if (Number.isInteger(valorFinal)) {
                elemento.textContent = Math.floor(atual).toLocaleString("pt-BR") + (sufixo || "");
            } else {
                elemento.textContent = atual.toFixed(2) + (sufixo || "");
            }
        }, 16);
    }

    // Animar métricas do Dashboard quando visíveis
    const metricaObserver = new IntersectionObserver(function (entries) {
        entries.forEach(function (entry) {
            if (entry.isIntersecting) {
                const id = entry.target.id;
                if (id === "dado-trans") animarContador(entry.target, 1.25, " TB", 1500);
                if (id === "latencia-med") animarContador(entry.target, 18, "ms", 1200);
                if (id === "ia-triagem") animarContador(entry.target, 4300, "", 1500);
                if (id === "resiliencia-tot") animarContador(entry.target, 99.98, "%", 2000);
                metricaObserver.unobserve(entry.target);
            }
        });
    }, { threshold: 0.5 });

    document.querySelectorAll(".valor-metrica").forEach(function (el) {
        if (el.id) metricaObserver.observe(el);
    });

    // Animar contadores do Monitoramento
    const numeros = document.querySelectorAll(".numero");
    if (numeros.length > 0) {
        const numObserver = new IntersectionObserver(function (entries) {
            entries.forEach(function (entry) {
                if (entry.isIntersecting) {
                    const el = entry.target;
                    const textoOriginal = el.textContent.trim();
                    el.setAttribute("data-final", textoOriginal);
                    // Para "24 / 24" e "1.420" e "98,4%" parseamos
                    if (textoOriginal.includes("/")) {
                        // Não animar, deixar como está
                    } else if (textoOriginal.includes(",")) {
                        const num = parseFloat(textoOriginal.replace(".", "").replace(",", ".").replace("%", ""));
                        animarContador(el, num, textoOriginal.includes("%") ? "%" : "", 1800);
                    } else if (textoOriginal.includes(".")) {
                        const num = parseInt(textoOriginal.replace(".", ""), 10);
                        el.textContent = "0";
                        animarContador(el, num, "", 1500);
                    }
                    numObserver.unobserve(el);
                }
            });
        }, { threshold: 0.5 });

        numeros.forEach(function (n) { numObserver.observe(n); });
    }

    /* ==========================================
        GRÁFICO SVG DE BARRAS (Dashboard – substitui imagem)
       ========================================== */
    const containerGraficoBarras = document.getElementById("grafico-barras-svg");
    if (containerGraficoBarras) {
        const dados = [
            { regiao: "Sudeste", valor: 98, cor: "#00cfff" },
            { regiao: "Norte", valor: 75, cor: "#38bdf8" },
            { regiao: "Nordeste", valor: 88, cor: "#06b6d4" },
            { regiao: "Sul", valor: 92, cor: "#22d3ee" },
            { regiao: "C.Oeste", valor: 85, cor: "#67e8f9" }
        ];

        const svgNS = "http://www.w3.org/2000/svg";
        const svg = document.createElementNS(svgNS, "svg");
        svg.setAttribute("viewBox", "0 0 500 280");
        svg.setAttribute("preserveAspectRatio", "xMidYMid meet");
        svg.style.width = "100%";
        svg.style.height = "100%";

        // Linhas de fundo
        [0.25, 0.5, 0.75, 1].forEach(function (pct) {
            const y = 240 - (pct * 200);
            const line = document.createElementNS(svgNS, "line");
            line.setAttribute("x1", "40");
            line.setAttribute("y1", y.toString());
            line.setAttribute("x2", "480");
            line.setAttribute("y2", y.toString());
            line.setAttribute("stroke", "#334155");
            line.setAttribute("stroke-width", "1");
            line.setAttribute("stroke-dasharray", "4,4");
            svg.appendChild(line);

            // Label do eixo Y
            const label = document.createElementNS(svgNS, "text");
            label.setAttribute("x", "35");
            label.setAttribute("y", (y + 4).toString());
            label.setAttribute("text-anchor", "end");
            label.setAttribute("fill", "#94a3b8");
            label.setAttribute("font-size", "12");
            label.textContent = Math.round(pct * 100) + "%";
            svg.appendChild(label);
        });

        const barWidth = 55;
        const gap = 30;
        const startX = 65;

        dados.forEach(function (d, i) {
            const x = startX + i * (barWidth + gap);
            const barHeight = (d.valor / 100) * 200;
            const y = 240 - barHeight;

            // Definir gradiente por barra
            const gradId = "barGrad" + i;
            const defs = svg.querySelector("defs") || (function () {
                const df = document.createElementNS(svgNS, "defs");
                svg.insertBefore(df, svg.firstChild);
                return df;
            })();

            const grad = document.createElementNS(svgNS, "linearGradient");
            grad.setAttribute("id", gradId);
            grad.setAttribute("x1", "0");
            grad.setAttribute("y1", "0");
            grad.setAttribute("x2", "0");
            grad.setAttribute("y2", "1");
            const stop1 = document.createElementNS(svgNS, "stop");
            stop1.setAttribute("offset", "0%");
            stop1.setAttribute("stop-color", d.cor);
            const stop2 = document.createElementNS(svgNS, "stop");
            stop2.setAttribute("offset", "100%");
            stop2.setAttribute("stop-color", d.cor.replace("ff", "88"));
            grad.appendChild(stop1);
            grad.appendChild(stop2);
            defs.appendChild(grad);

            // Barra com animação
            const rect = document.createElementNS(svgNS, "rect");
            rect.setAttribute("x", x.toString());
            rect.setAttribute("y", "240");
            rect.setAttribute("width", barWidth.toString());
            rect.setAttribute("height", "0");
            rect.setAttribute("rx", "6");
            rect.setAttribute("ry", "6");
            rect.setAttribute("fill", "url(#" + gradId + ")");
            rect.style.filter = "drop-shadow(0 0 6px " + d.cor + "40)";
            svg.appendChild(rect);

            // Animar barra
            setTimeout(function () {
                rect.setAttribute("y", y.toString());
                rect.setAttribute("height", barHeight.toString());
                rect.style.transition = "all 1s cubic-bezier(0.4, 0, 0.2, 1)";
            }, 200 + i * 150);

            // Valor acima da barra
            const valorText = document.createElementNS(svgNS, "text");
            valorText.setAttribute("x", (x + barWidth / 2).toString());
            valorText.setAttribute("y", (y - 8).toString());
            valorText.setAttribute("text-anchor", "middle");
            valorText.setAttribute("fill", "#ffffff");
            valorText.setAttribute("font-size", "14");
            valorText.setAttribute("font-weight", "bold");
            valorText.textContent = d.valor + "%";
            valorText.style.opacity = "0";
            svg.appendChild(valorText);

            setTimeout(function () {
                valorText.style.transition = "opacity 0.5s ease";
                valorText.style.opacity = "1";
            }, 800 + i * 150);

            // Label do eixo X
            const labelX = document.createElementNS(svgNS, "text");
            labelX.setAttribute("x", (x + barWidth / 2).toString());
            labelX.setAttribute("y", "260");
            labelX.setAttribute("text-anchor", "middle");
            labelX.setAttribute("fill", "#d7d7d7");
            labelX.setAttribute("font-size", "13");
            labelX.textContent = d.regiao;
            svg.appendChild(labelX);
        });

        containerGraficoBarras.appendChild(svg);
    }

    /* ==========================================
        SMOOTH SCROLL PARA LINKS INTERNOS
       ========================================== */
    document.querySelectorAll('a[href^="#"]').forEach(function (anchor) {
        anchor.addEventListener("click", function (e) {
            e.preventDefault();
            const target = document.querySelector(this.getAttribute("href"));
            if (target) {
                target.scrollIntoView({ behavior: "smooth", block: "start" });
            }
        });
    });

    /* ==========================================
        EFEITO PARALLAX NO SCROLL (sutil para cards)
       ========================================== */
    let ticking = false;
    window.addEventListener("scroll", function () {
        if (!ticking) {
            window.requestAnimationFrame(function () {
                const scrolled = window.pageYOffset;
                const heroTexto = document.querySelector(".hero__texto");
                if (heroTexto) {
                    heroTexto.style.transform = "translateY(" + (scrolled * 0.3) + "px)";
                    heroTexto.style.opacity = Math.max(1 - scrolled / 600, 0).toString();
                }
                ticking = false;
            });
            ticking = true;
        }
    });

    /* ==========================================
        HOVER GLOW INTERATIVO NOS CARDS
       ========================================== */
    const glowCards = document.querySelectorAll(".conteudo__sec, .card, .card-metrica, .valores__card, .integrante");
    glowCards.forEach(function (card) {
        card.addEventListener("mousemove", function (e) {
            const rect = card.getBoundingClientRect();
            const x = e.clientX - rect.left;
            const y = e.clientY - rect.top;
            card.style.background =
                "radial-gradient(600px circle at " + x + "px " + y + "px, rgba(0,207,255,0.06), transparent 40%), " +
                "rgba(255,255,255,0.05)";
        });

        card.addEventListener("mouseleave", function () {
            card.style.background = "rgba(255,255,255,0.05)";
        });
    });

    /* ==========================================
        BOTÃO SOS – ANIMAÇÃO DE PULSAR
       ========================================== */
    if (abrirSOS) {
        abrirSOS.style.animation = "sosPulse 2s ease-in-out infinite";
    }

    /* ==========================================
        TOOLTIP NOS LINKS DA NAVBAR
       ========================================== */
    const navLinksAll = document.querySelectorAll(".cabecalho__link");
    navLinksAll.forEach(function (link) {
        link.addEventListener("mouseenter", function () {
            this.style.transform = "translateY(-2px)";
        });
        link.addEventListener("mouseleave", function () {
            this.style.transform = "translateY(0)";
        });
    });

    /* ==========================================
        TABELA INTERATIVA (Dashboard)
       ========================================== */
    const tableRows = document.querySelectorAll(".tabela-dados tbody tr");
    tableRows.forEach(function (row) {
        row.addEventListener("click", function () {
            // Toggle highlight
            this.classList.toggle("row-highlight");
        });
    });

    /* ==========================================
        ALERTAS INTERATIVOS (Monitoramento)
       ========================================== */
    const alertaItems = document.querySelectorAll(".alerta");
    alertaItems.forEach(function (alerta) {
        alerta.style.cursor = "pointer";
        alerta.addEventListener("click", function () {
            // Toggle expandir detalhes
            if (this.classList.contains("alerta-expandido")) {
                this.classList.remove("alerta-expandido");
                const detalhe = this.querySelector(".alerta-detalhe");
                if (detalhe) detalhe.remove();
            } else {
                this.classList.add("alerta-expandido");
                const detalhe = document.createElement("p");
                detalhe.className = "alerta-detalhe";
                detalhe.style.cssText = "margin-top: 1rem; font-size: 1.5rem; opacity: 0.8; animation: fadeSlideUp 0.3s ease;";

                if (this.classList.contains("critico")) {
                    detalhe.textContent = "⚠️ Nível crítico: Evacuação recomendada. Equipes de resgate acionadas via satélite OrbitSafe-03.";
                } else if (this.classList.contains("moderado")) {
                    detalhe.textContent = "🌧️ Nível moderado: Monitoramento ativo. Satélites OrbitSafe-12 cobrindo a região.";
                } else {
                    detalhe.textContent = "📡 Nível informativo: Dados sendo coletados. Sem necessidade de ação imediata.";
                }

                this.appendChild(detalhe);
            }
        });
    });

    /* ==========================================
        SCROLL TO TOP (criado via JS)
       ========================================== */
    const scrollTopBtn = document.createElement("button");
    scrollTopBtn.id = "scrollTopBtn";
    scrollTopBtn.innerHTML = "↑";
    scrollTopBtn.style.cssText = [
        "position: fixed",
        "bottom: 100px",
        "width: 50px",
        "height: 50px",
        "border: 1px solid rgba(0,207,255,0.3)",
        "border-radius: 50%",
        "background: rgba(7,20,46,0.9)",
        "color: #00cfff",
        "font-size: 2.2rem",
        "cursor: pointer",
        "z-index: 9998",
        "opacity: 0",
        "transition: opacity 0.4s ease, transform 0.3s ease",
        "pointer-events: none",
        "backdrop-filter: blur(10px)"
    ].join(";");

    document.body.appendChild(scrollTopBtn);

    scrollTopBtn.addEventListener("click", function () {
        window.scrollTo({ top: 0, behavior: "smooth" });
    });

    window.addEventListener("scroll", function () {
        if (window.pageYOffset > 400) {
            scrollTopBtn.style.opacity = "1";
            scrollTopBtn.style.pointerEvents = "auto";
        } else {
            scrollTopBtn.style.opacity = "0";
            scrollTopBtn.style.pointerEvents = "none";
        }
    });

    /* ==========================================
        ANIMAÇÃO DA LINHA SVG DO GRÁFICO (Dashboard)
       ========================================== */
    const chartLine = document.querySelector(".chart-line");
    if (chartLine) {
        const length = chartLine.getTotalLength ? chartLine.getTotalLength() : 1000;
        chartLine.style.strokeDasharray = length;
        chartLine.style.strokeDashoffset = length;
        chartLine.style.transition = "stroke-dashoffset 2s ease-in-out";

        const chartObserver = new IntersectionObserver(function (entries) {
            entries.forEach(function (entry) {
                if (entry.isIntersecting) {
                    chartLine.style.strokeDashoffset = "0";
                    chartObserver.unobserve(entry.target);
                }
            });
        }, { threshold: 0.3 });

        chartObserver.observe(chartLine);
    }

});

/* ==========================================
    INJETAR CSS DE ANIMAÇÕES VIA JS
   ========================================== */
(function injectAnimationCSS() {
    const style = document.createElement("style");
    style.textContent = [
        "@keyframes fadeSlideUp {",
        "  from { opacity: 0; transform: translateY(20px); }",
        "  to { opacity: 1; transform: translateY(0); }",
        "}",
        "@keyframes sosPulse {",
        "  0%, 100% { box-shadow: 0 0 0 0 rgba(255,51,51,0.5); }",
        "  50% { box-shadow: 0 0 0 12px rgba(255,51,51,0); }",
        "}",
        ".scroll-hidden {",
        "  opacity: 0;",
        "  transform: translateY(30px);",
        "  transition: opacity 0.8s ease, transform 0.8s ease;",
        "}",
        ".animate-in {",
        "  opacity: 1 !important;",
        "  transform: translateY(0) !important;",
        "}",
        ".row-highlight {",
        "  background: rgba(0,207,255,0.08) !important;",
        "  border-left: 3px solid #00cfff;",
        "}",
        ".cabecalho__link {",
        "  display: inline-block;",
        "  transition: color 0.4s ease, transform 0.3s ease;",
        "}",
        ".cabecalho__link--active {",
        "  color: #00cfff !important;",
        "  text-shadow: 0 0 8px rgba(0,207,255,0.4);",
        "}"
    ].join("\n");
    document.head.appendChild(style);
})();

document.addEventListener("DOMContentLoaded", function () {

    // MENU HAMBÚRGUER RESPONSIVO 
    const hamburger = document.querySelector(".cabecalho__hamburger");
    const menuLista = document.querySelector(".cabecalho__lista");

    if (hamburger && menuLista) {
        hamburger.addEventListener("click", () => {
            menuLista.classList.toggle("active");
        });
    }

    // CREDENCIAIS PADRÕES DO SISTEMA 
    const USUARIO_PADRAO = "admin";
    const SENHA_PADRAO = "orbitsafe2026";

    // LÓGICA DE CADASTRO DE NOVO COLABORADOR 
    const formCadastro = document.getElementById("formCadastro");
    if (formCadastro) {
        formCadastro.addEventListener("submit", function (e) {
            e.preventDefault();
            const cadUsuario = document.getElementById("cadUsuario").value.trim();
            const cadEmail = document.getElementById("cadEmail").value.trim();
            const cadSenha = document.getElementById("cadSenha").value;
            const msgSucesso = document.getElementById("msgSucessoCad");
            const msgErro = document.getElementById("msgErroCad");

            // Reseta mensagens de feedback
            msgSucesso.style.display = "none";
            msgErro.style.display = "none";

            // Impede criar um usuário com o mesmo nome do admin padrão
            if (cadUsuario.toLowerCase() === USUARIO_PADRAO) {
                msgErro.textContent = "❌ Usuário já existente no sistema.";
                msgErro.style.display = "block";
                return;
            }

            // Validação simples de formato de e-mail usando Regex
            const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if (!emailRegex.test(cadEmail)) {
                msgErro.textContent = "❌ Por favor, insira um e-mail válido.";
                msgErro.style.display = "block";
                return;
            }

            // Verifica se o usuário já existe no localStorage
            if (localStorage.getItem(cadUsuario)) {
                msgErro.textContent = "❌ Usuário já existente no sistema.";
                msgErro.style.display = "block";
            } else {
                // Cria um objeto para salvar os dados do colaborador
                const dadosColaborador = {
                    email: cadEmail,
                    senha: cadSenha
                };

                // Salva no localStorage convertendo o objeto para texto (JSON)
                localStorage.setItem(cadUsuario, JSON.stringify(dadosColaborador));

                msgSucesso.style.display = "block";
                formCadastro.reset();
            }
        });
    }

    // LÓGICA DE AUTENTICAÇÃO 
    const formLogin = document.getElementById("formLogin");
    if (formLogin) {
        formLogin.addEventListener("submit", function (e) {
            e.preventDefault();
            const usuario = document.getElementById("loginUsuario").value.trim();
            const senha = document.getElementById("loginSenha").value;
            const msgErro = document.getElementById("msgErroLogin");

            msgErro.style.display = "none";

            // Tenta buscar o cadastro correspondente no localStorage
            const dadosSalvos = localStorage.getItem(usuario);
            let senhaSalva = null;

            // Se encontrou dados do usuário, transforma o texto de volta em objeto para ler a senha
            if (dadosSalvos) {
                try {
                    const colaborador = JSON.parse(dadosSalvos);
                    senhaSalva = colaborador.senha;
                } catch (err) {
                    // Caso o dado antigo ainda esteja no formato antigo (só texto)
                    senhaSalva = dadosSalvos;
                }
            }

            // Valida as credenciais (seja o administrador padrão ou conta cadastrada)
            if ((usuario === USUARIO_PADRAO && senha === SENHA_PADRAO) || (senhaSalva && senhaSalva === senha)) {
                sessionStorage.setItem("logado", "true");
                window.location.href = "dashboard.html"; 
            } else {
                msgErro.style.display = "block";
            }
        });
    }
});