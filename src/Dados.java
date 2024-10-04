import dao.PacoteTuristicoDao;
import dao.PessoaDao;
import models.PacoteTuristico;
import models.Pessoa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Dados extends JFrame {

    private JButton reservasButton;
    private JButton pessoasButton;
    private JButton pacotesButton;
    private JButton destinosButton;

    public Dados() {
        setTitle("Horizontes Travel - Sistema de Dados");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel painelEsquerda = new JPanel();
        painelEsquerda.setBackground(new Color(91, 128, 128));
        painelEsquerda.setLayout(new BorderLayout());
        JLabel logoLabel = new JLabel("Horizontes Travel", JLabel.CENTER);
        logoLabel.setFont(new Font("Serif", Font.ITALIC, 28));
        logoLabel.setForeground(Color.WHITE);
        painelEsquerda.add(logoLabel, BorderLayout.CENTER);

        JLabel copyrightLabel = new JLabel("copyright © 2024 all rights reserved", JLabel.CENTER);
        copyrightLabel.setForeground(Color.WHITE);
        painelEsquerda.add(copyrightLabel, BorderLayout.SOUTH);

        JPanel painelDireita = new JPanel();
        painelDireita.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0);

        JLabel welcomeLabel = new JLabel("Dados do Sistema", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setForeground(new Color(91, 128, 128));

        JLabel selecioneOperacaoLabel = new JLabel("Selecione uma Operação", JLabel.CENTER);
        selecioneOperacaoLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        reservasButton = new JButton("Visualizar Reservas");
        pessoasButton = new JButton("Visualizar Pessoas");
        pacotesButton = new JButton("Visualizar Pacotes");
        destinosButton = new JButton("Visualizar Destinos");

        Color buttonColor = new Color(91, 128, 128);
        reservasButton.setBackground(buttonColor);
        reservasButton.setForeground(Color.WHITE);
        pessoasButton.setBackground(buttonColor);
        pessoasButton.setForeground(Color.WHITE);
        pacotesButton.setBackground(buttonColor);
        pacotesButton.setForeground(Color.WHITE);
        destinosButton.setBackground(buttonColor);
        destinosButton.setForeground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = 0;
        painelDireita.add(welcomeLabel, gbc);
        gbc.gridy = 1;
        painelDireita.add(selecioneOperacaoLabel, gbc);
        gbc.gridy = 2;
        painelDireita.add(reservasButton, gbc);
        gbc.gridy = 3;
        painelDireita.add(pessoasButton, gbc);
        gbc.gridy = 4;
        painelDireita.add(pacotesButton, gbc);
        gbc.gridy = 5;
        painelDireita.add(destinosButton, gbc);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, painelEsquerda, painelDireita);
        splitPane.setDividerLocation(300);
        splitPane.setResizeWeight(0.5);
        splitPane.setEnabled(false);

        add(splitPane);

        setVisible(true);

        reservasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        pessoasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                PessoaDao pessoaDao = new PessoaDao();
                List<Pessoa> pessoas = pessoaDao.listar();

                StringBuilder info = new StringBuilder();
                for (Pessoa pessoa : pessoas) {
                    info.append("ID: ").append(pessoa.getId()).append("\n");
                    info.append("Nome: ").append(pessoa.getNome()).append("\n");
                    info.append("Email: ").append(pessoa.getEmail()).append("\n");
                    info.append("Telefone: ").append(pessoa.getTelefone()).append("\n");
                    info.append("-----------------------------\n");
                }

                JOptionPane.showMessageDialog(Dados.this, info.toString(), "Lista de Pessoas", JOptionPane.INFORMATION_MESSAGE);

            }
        });

        pacotesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                PacoteTuristicoDao pacoteTuristicoDao = new PacoteTuristicoDao();
                List<PacoteTuristico> pacoteTuristicos = pacoteTuristicoDao.listar();

                StringBuilder info = new StringBuilder();
                for (PacoteTuristico pacoteTuristico : pacoteTuristicos){
                    info.append("ID: ").append(pacoteTuristico.getId()).append("\n");
                    info.append("Nome: ").append(pacoteTuristico.getNome()).append("\n");
                    info.append("Preço: ").append(pacoteTuristico.getPreco()).append("\n");
                    info.append("Descrição: ").append(pacoteTuristico.getDescricao()).append("\n");
                }

                JOptionPane.showMessageDialog(Dados.this, info.toString(), "Lista de Pacotes Turisticos", JOptionPane.INFORMATION_MESSAGE);

            }
        });

        destinosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        new Dados();
    }
}
