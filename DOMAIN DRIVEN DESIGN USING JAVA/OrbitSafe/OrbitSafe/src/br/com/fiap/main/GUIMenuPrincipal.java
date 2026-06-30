package br.com.fiap.main;

import br.com.fiap.bean.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIMenuPrincipal extends JFrame {

    private Cadastro cadastro;
    private Ocorrencia ocorrencia;
    private CentralDeControle central;

    private Container contentPane;
    private JMenuBar mnBarra;
    private JMenu mnArquivo, mnNavegacao;
    private JMenuItem miCadastro, miOcorrencia, miCentralDeControle, miSair;

    public GUIMenuPrincipal(){
        cadastro = new Cadastro();
        ocorrencia = new Ocorrencia();
        central = new CentralDeControle();
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes(){
        setTitle("OrbitSafe");
        setBounds(0, 0, 600, 400);
        contentPane = getContentPane();

        //criando a barra e o menu
        mnBarra = new JMenuBar();
        mnArquivo = new JMenu("Arquivo");
        mnArquivo.setMnemonic('A');
        mnNavegacao = new JMenu("Navegação");
        mnNavegacao.setMnemonic('N');

        //criando os itens de menu
        miCadastro = new JMenuItem("Cadastro");
        miOcorrencia = new JMenuItem("Registrar Ocorrência");
        miCentralDeControle = new JMenuItem("Central de Controle");
        miSair = new JMenuItem("Sair", new ImageIcon(getClass().getResource("img/SAIR.png")));

        //define a barra de menu na janela principal
        setJMenuBar(mnBarra);
        // colocar os itens dentro do menu de escolhas
        mnBarra.add(mnArquivo);
        mnBarra.add(mnNavegacao);
        mnArquivo.add(miSair);
        mnNavegacao.add(miCadastro);
        mnNavegacao.add(miOcorrencia);
        mnNavegacao.add(miCentralDeControle);
    }

    private void definirEventos(){
        //clicar para fechar
        miSair.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        miCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUICadastro cadastro = new GUICadastro();
                contentPane.removeAll();
                contentPane.add(cadastro);
                contentPane.validate();
            }
        });

       miOcorrencia.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               GUIOcorrencia ocorrencia = new GUIOcorrencia();
               contentPane.removeAll();
               contentPane.add(ocorrencia);
               contentPane.validate();
           }
       });

       miCentralDeControle.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               GUICentralDeControle centralDeControle = new GUICentralDeControle();
               contentPane.removeAll();
               contentPane.add(centralDeControle);
               contentPane.validate();
           }
       });
    }

    public static void main(String[] args) {
        GUIMenuPrincipal frame = new GUIMenuPrincipal();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((tela.width - frame.getSize().width) / 2, (tela.height - frame.getSize().height) / 2);
        frame.setVisible(true);
    }
}
