package br.com.fiap.main;

import br.com.fiap.bean.Cadastro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUICadastro extends JPanel {
    private Cadastro cadastro;
    private JLabel lbNome, lbCpf, lbEmail, lbTelefone, lbCidade, lbBairro, lbRua, lbNumero;
    private JTextField tfNome, tfCpf, tfEmail, tfTelefone, tfCidade, tfBairro, tfRua, tfNumero;
    private JTextArea taTitulo;
    private JButton btnSalvar;

    public GUICadastro() {
        cadastro = new Cadastro();
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(null);
        setBackground(Color.gray);


        lbNome = new JLabel("Nome Completo: ", JLabel.RIGHT);
        tfNome = new JTextField();
        lbNome.setForeground(Color.white);
        lbNome.setBounds(10, 85, 120, 25);
        tfNome.setBounds(140, 85, 120, 25);

        lbCpf = new JLabel("CPF: ", JLabel.RIGHT);
        tfCpf = new JTextField();
        lbCpf.setForeground(Color.white);
        lbCpf.setBounds(200, 85, 120, 25);
        tfCpf.setBounds(329, 85, 100, 25);

        lbEmail = new JLabel("E-mail: ", JLabel.RIGHT);
        tfEmail = new JTextField();
        lbEmail.setForeground(Color.white);
        lbEmail.setBounds(10, 120, 120, 25);
        tfEmail.setBounds(140, 120, 120, 25);

        lbTelefone = new JLabel("Telefone: ", JLabel.RIGHT);
        tfTelefone = new JTextField();
        lbTelefone.setForeground(Color.white);
        lbTelefone.setBounds(200, 120, 120, 25);
        tfTelefone.setBounds(329, 120, 120, 25);


        lbCidade = new JLabel("Cidade: ", JLabel.RIGHT);
        tfCidade = new JTextField();
        lbCidade.setForeground(Color.white);
        lbCidade.setBounds(200, 155, 120, 25);
        tfCidade.setBounds(329, 155, 120, 25);

        lbBairro = new JLabel("Bairro: ", JLabel.RIGHT);
        tfBairro = new JTextField();
        lbBairro.setForeground(Color.white);
        lbBairro.setBounds(10, 155, 120, 25);
        tfBairro.setBounds(140, 155, 120, 25);


        lbRua = new JLabel("Rua: ", JLabel.RIGHT);
        tfRua = new JTextField();
        lbRua.setForeground(Color.white);
        lbRua.setBounds(200, 190, 120, 25);
        tfRua.setBounds(329, 190, 120, 25);

        lbNumero = new JLabel("Nº Residência: ", JLabel.RIGHT);
        tfNumero = new JTextField();
        lbNumero.setForeground(Color.white);
        lbNumero.setBounds(10, 190, 120, 25);
        tfNumero.setBounds(140, 190, 120, 25);

        taTitulo = new JTextArea("Cadastre-se no OrbitSafe", 5, 250);
        taTitulo.setFont(new Font("Verdana", Font.BOLD, 14));
        taTitulo.setForeground(Color.white);
        taTitulo.setBackground(getBackground());
        taTitulo.setEditable(false);
        taTitulo.setBounds(200, 40, 250, 100);

        //botão
        btnSalvar = new JButton("Salvar Dados");
        btnSalvar.setBounds(150, 240, 290, 50);

        //adicionando os componentes no painel
        add(lbNome);add(tfNome);
        add(lbCpf);add(tfCpf);
        add(lbEmail);add(tfEmail);
        add(lbTelefone);add(tfTelefone);
        add(lbCidade);add(tfCidade);
        add(lbBairro);add(tfBairro);
        add(lbRua);add(tfRua);
        add(lbNumero);add(tfNumero);
        add(taTitulo);
        add(btnSalvar);

    }

    private void atualizarTela() {
        tfNome.setText("");
        tfCpf.setText("");
        tfEmail.setText("");
        tfTelefone.setText("");
        tfCidade.setText("");
        tfBairro.setText("");
        tfRua.setText("");
        tfNumero.setText("");
    }

    private void definirEventos() {


        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (tfNome.getText().isBlank() || tfCpf.getText().isBlank() || tfEmail.getText().isBlank() ||
                            tfTelefone.getText().isBlank() || tfCidade.getText().isBlank() || tfBairro.getText().isBlank() ||
                            tfRua.getText().isBlank() || tfNumero.getText().isBlank()) {

                        throw new Exception("Preencha todos os campos!");
                    }
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, e2.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    Double.parseDouble(tfCpf.getText());
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, "O campo CPF deve conter apenas números!", "Erro de Digitação", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    Long.parseLong(tfTelefone.getText());
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, "O campo Telefone deve conter apenas números (ex: 11999999999)!", "Erro de Digitação", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    Integer.parseInt(tfNumero.getText());
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, "O campo Nº Residência deve conter apenas números!", "Erro de Digitação", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                //Criar o objeto e salvar
                Cadastro cadastro = new Cadastro();
                cadastro.setNomeUsuario(tfNome.getText());
                cadastro.setCpf(tfCpf.getText());
                cadastro.setEmail(tfEmail.getText());
                cadastro.setTelefone(tfTelefone.getText());
                cadastro.setCidade(tfCidade.getText());
                cadastro.setBairro(tfBairro.getText());
                cadastro.setRua(tfRua.getText());
                cadastro.setNumeroResidencia(Integer.parseInt(tfNumero.getText()));

                String resultado = "--- Cadastro ---\n"
                        + "Nome: " + cadastro.getNomeUsuario() + "\n"
                        + "CPF: " + cadastro.getCpf() + "\n"
                        + "E-mail: " + cadastro.getEmail() + "\n"
                        + "Telefone: " + cadastro.getTelefone() + "\n"
                        + "Cidade: " + cadastro.getCidade() + "\n"
                        + "Bairro: " + cadastro.getBairro() + "\n"
                        + "Rua: " + cadastro.getRua() + ", Nº " + cadastro.getNumeroResidencia() + "\n";

                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "OrbitSafe", JOptionPane.INFORMATION_MESSAGE);

                atualizarTela();
            }
        });

    }
}
