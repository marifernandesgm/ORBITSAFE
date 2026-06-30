package br.com.fiap.main;

import br.com.fiap.bean.CentralDeControle;
import br.com.fiap.bean.Ocorrencia;
import br.com.fiap.bean.Satelite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUICentralDeControle extends JPanel {

    private CentralDeControle central;
    private Ocorrencia ocorrencia;
    private Satelite satelite;
    private JLabel lbNomeCentral, lbStatusOperacao, lbNomeUsuario, lbQueixaUsuario, lbNivelGravidade, lbStatusRede;
    private JTextField tfNomeCentral, tfStatusOperacao, tfNomeUsuario, tfQueixaUsuario, tfNivelGravidade, tfStatusRede;
    private JTextArea taTitulo1, taTitulo2;
    private JButton btnAnalisarDados, btnReceberQueixa, btnEnviarSocorro;

    public GUICentralDeControle() {
        central = new CentralDeControle();
        ocorrencia = new Ocorrencia();
        satelite = new Satelite();
        inicializandoComponentes();
        definirEvento();
    }

    public void inicializandoComponentes() {
        setLayout(null);
        setBackground(Color.gray);

        taTitulo1 = new JTextArea("Central de Controle");
        taTitulo1.setFont(new Font("Verdana", Font.BOLD, 18));
        taTitulo1.setForeground(Color.white);
        taTitulo1.setBackground(getBackground());
        taTitulo1.setEditable(false);
        taTitulo1.setBounds(160, 20, 250, 30);

        lbNomeCentral = new JLabel("Nome da Central: ", JLabel.RIGHT);
        tfNomeCentral = new JTextField(central.getNomeCentral());
        lbNomeCentral.setForeground(Color.white);
        lbNomeCentral.setBounds(20, 70, 150, 25);
        tfNomeCentral.setBounds(180, 70, 200, 25);
        tfNomeCentral.setEditable(false);

        lbStatusOperacao = new JLabel("Status Operação:", JLabel.RIGHT);
        tfStatusOperacao = new JTextField(central.getStatusOperacao());
        lbStatusOperacao.setForeground(Color.white);
        lbStatusOperacao.setBounds(20, 110, 150, 25);
        tfStatusOperacao.setBounds(180, 110, 200, 25);
        tfStatusOperacao.setEditable(false);

        //botão
        btnAnalisarDados = new JButton("Analisar Dados");
        btnAnalisarDados.setBounds(180, 150, 200, 25);

        //simulação das queixas do usuário
        taTitulo2 = new JTextArea("Simulação de Queixa");
        taTitulo2.setFont(new Font("Verdana", Font.BOLD, 18));
        taTitulo2.setForeground(Color.white);
        taTitulo2.setBackground(getBackground());
        taTitulo2.setBounds(160, 210, 250, 30);
        taTitulo2.setEditable(false);

        lbNomeUsuario = new JLabel("Nome do Usuário:", JLabel.RIGHT);
        tfNomeUsuario = new JTextField("João Silva");
        lbNomeUsuario.setForeground(Color.white);
        lbNomeUsuario.setBounds(20, 260, 150, 25);
        tfNomeUsuario.setBounds(180, 260, 200, 25);

        lbQueixaUsuario = new JLabel("Queixa Atual:", JLabel.RIGHT);
        tfQueixaUsuario = new JTextField("Caiu o barranco devido a chuva forte");
        lbQueixaUsuario.setForeground(Color.white);
        lbQueixaUsuario.setBounds(20, 300, 150, 25);
        tfQueixaUsuario.setBounds(180, 300, 205, 25);

        lbNivelGravidade = new JLabel("Nível Gravidade:", JLabel.RIGHT);
        tfNivelGravidade = new JTextField("Gravíssimo");
        lbNivelGravidade.setForeground(Color.white);
        lbNivelGravidade.setBounds(20, 340, 150, 25);
        tfNivelGravidade.setBounds(180, 340, 200, 25);
        tfNivelGravidade.setEditable(false);

        lbStatusRede = new JLabel("Status da Rede:", JLabel.RIGHT);
        tfStatusRede = new JTextField();
        lbStatusRede.setForeground(Color.white);
        lbStatusRede.setBounds(20, 380, 150, 25);
        tfStatusRede.setBounds(180, 380, 200, 25);
        tfStatusRede.setEditable(false);

        //botões
        btnReceberQueixa = new JButton("Receber Queixa");
        btnReceberQueixa.setBounds(60, 420, 180, 25);

        btnEnviarSocorro = new JButton("Enviar Socorro");
        btnEnviarSocorro.setBounds(260, 420, 180, 25);

        //adicionando todos os componentes na tela
        add(taTitulo1);add(taTitulo2);
        add(lbNomeCentral);add(tfNomeCentral);
        add(lbStatusOperacao);add(tfStatusOperacao);
        add(lbNomeUsuario);add(tfNomeUsuario);
        add(lbQueixaUsuario);add(tfQueixaUsuario);
        add(lbNivelGravidade);add(tfNivelGravidade);
        add(lbStatusRede);add(tfStatusRede);
        add(btnReceberQueixa);add(btnEnviarSocorro);
        add(btnAnalisarDados);

    }

    private void atualizarTela(CentralDeControle central){
        tfStatusOperacao.setText(central.getStatusOperacao());
    }

    private void atualizarTela(Satelite satelite){
        tfStatusRede.setText(satelite.getStatusRede());
    }

    private Ocorrencia obterUsuarioTela() {
        ocorrencia.setNomeUsuario(tfNomeUsuario.getText());
        ocorrencia.setQueixaAtual(tfQueixaUsuario.getText());
        ocorrencia.setNivelGravidade(tfNivelGravidade.getText());
        return ocorrencia;
    }

    public void definirEvento() {

        btnAnalisarDados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String gravidadeSelecionada = tfNivelGravidade.getText();

                central.analisarDados(gravidadeSelecionada);

                atualizarTela(central);

                JOptionPane.showMessageDialog(null, "Dados analisados! Status da central: " + central.getStatusOperacao());
            }
        });


        btnReceberQueixa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ocorrencia ocorrencia = obterUsuarioTela();

                satelite.determinarStatusRede(ocorrencia.getNivelGravidade());

                central.receberQueixaUsuario(ocorrencia);

                atualizarTela(satelite);

                JOptionPane.showMessageDialog(null, "Queixa de " + ocorrencia.getNomeUsuario() + " processada com sucesso!");
            }
        });


        btnEnviarSocorro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ocorrencia ocorrencia = obterUsuarioTela();

                String respostaSocorro = central.enviarSocorro(ocorrencia);



                JOptionPane.showMessageDialog(null, "Enviamos o suporte de ajuda: " + respostaSocorro, "OrbitSafe", JOptionPane.WARNING_MESSAGE);
            }
        });
    }
}

