package br.com.fiap.main;

import br.com.fiap.bean.Emergencia;
import br.com.fiap.bean.Ocorrencia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIOcorrencia extends JPanel {
    private Ocorrencia ocorrencia;
    private Emergencia emergencia;
    private JLabel lbTipo, lbNivel, lbDescricao;
    private JTextField tfTipo, tfDescricao;
    private JTextArea taTitulo;
    private JButton btnNormal, btnMedio, btnGrave, btnGravissimo, btnEnviar;

    public GUIOcorrencia(){
        ocorrencia = new Ocorrencia();
        emergencia = new Emergencia();
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes(){
        setLayout(null);
        setBackground(Color.gray);

        lbTipo = new JLabel("Tipo de emergencia: ", JLabel.RIGHT);
        tfTipo = new JTextField();
        lbTipo.setForeground(Color.white);
        lbTipo.setBounds(10, 85, 120, 25);
        tfTipo.setBounds(140, 85, 410, 25);

        lbNivel = new JLabel("Nível: ");
        lbNivel.setForeground(Color.white);
        lbNivel.setBounds(95,120,120,25);


        lbDescricao = new JLabel("Descrição: ");
        tfDescricao = new JTextField();
        lbDescricao.setForeground(Color.white);
        lbDescricao.setBounds(65, 155,120,25);
        tfDescricao.setBounds(140, 155, 410,80);


        taTitulo = new JTextArea("Registrar Ocorrência", 5, 250);
        taTitulo.setFont(new Font("Verdana", Font.BOLD, 14));
        taTitulo.setForeground(Color.white);
        taTitulo.setBackground(getBackground());
        taTitulo.setEditable(false);
        taTitulo.setBounds(250, 30, 250, 50);


        //botão
        btnNormal = new JButton("Normal");
        btnNormal.setBounds(140, 120, 80, 25);

        btnMedio = new JButton("Médio");
        btnMedio.setBounds(240, 120, 80, 25);

        btnGrave = new JButton("Grave");
        btnGrave.setBounds(340, 120, 80, 25);

        btnGravissimo = new JButton("Gravíssimo");
        btnGravissimo.setBounds(440, 120, 110, 25);

        btnEnviar = new JButton("Enviar");
        btnEnviar.setBounds(260, 250, 200, 25);

        add(lbTipo);add(tfTipo);
        add(lbNivel);
        add(lbDescricao);add(tfDescricao);
        add(taTitulo);
        add(btnNormal);add(btnMedio);
        add(btnGrave);add(btnGravissimo);
        add(btnEnviar);

    }

    private void atualizarTela(){
        tfTipo.setText("");
        tfDescricao.setText("");
        ocorrencia.setNivelGravidade(null);
    }

    private void definirEventos(){

        btnNormal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ocorrencia.setNivelGravidade("Normal");
                ocorrencia.emitirAlerta();
            }
        });

        btnMedio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ocorrencia.setNivelGravidade("Médio");
                ocorrencia.emitirAlerta();
            }
        });

        btnGrave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ocorrencia.setNivelGravidade("Grave");
                ocorrencia.emitirAlerta();
            }
        });

        btnGravissimo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ocorrencia.setNivelGravidade("Gravíssimo");
                ocorrencia.emitirAlerta();
            }
        });

        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (tfTipo.getText().isBlank() || tfDescricao.getText().isBlank()){
                    JOptionPane.showMessageDialog(null,
                            "Preencha todos os campos!",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (ocorrencia.getNivelGravidade() == null) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Selecione um nível de gravidade antes de enviar a ocorrência!",
                            "Nível Não Selecionado",
                            JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }

                String nivelSelecionado = ocorrencia.getNivelGravidade();
                emergencia.calcularTempoEspera(nivelSelecionado);

                JOptionPane.showMessageDialog(null, "Ocorrência enviada para a central com sucesso!");

                JOptionPane.showMessageDialog(null, "Tempo de espera: " + emergencia.getTempoEspera());
            }
        });
    }
}
