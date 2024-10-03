import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial extends JFrame {

    private JButton cadastrarPessoaButton;
    private JButton cadastrarPacoteButton;
    private JButton cadastrarDestinoButton;
    private JButton fazerReservaButton;

    public TelaInicial() {
        setTitle("Horizontes Travel - Sistema");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        JLabel welcomeLabel = new JLabel("Bem-vindo ao Nosso Sistema!", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setForeground(new Color(91, 128, 128));

        JLabel selecioneOperacaoLabel = new JLabel("Selecione uma Operação", JLabel.CENTER);
        selecioneOperacaoLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        cadastrarPessoaButton = new JButton("Cadastrar Pessoa");
        cadastrarPacoteButton = new JButton("Cadastrar Pacote");
        cadastrarDestinoButton = new JButton("Cadastrar Destino");
        fazerReservaButton = new JButton("Fazer Reserva");

        Color buttonColor = new Color(91, 128, 128);
        cadastrarPessoaButton.setBackground(buttonColor);
        cadastrarPessoaButton.setForeground(Color.WHITE);
        cadastrarPacoteButton.setBackground(buttonColor);
        cadastrarPacoteButton.setForeground(Color.WHITE);
        cadastrarDestinoButton.setBackground(buttonColor);
        cadastrarDestinoButton.setForeground(Color.WHITE);
        fazerReservaButton.setBackground(buttonColor);
        fazerReservaButton.setForeground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = 0;
        painelDireita.add(welcomeLabel, gbc);
        gbc.gridy = 1;
        painelDireita.add(selecioneOperacaoLabel, gbc);
        gbc.gridy = 2;
        painelDireita.add(cadastrarPessoaButton, gbc);
        gbc.gridy = 3;
        painelDireita.add(cadastrarPacoteButton, gbc);
        gbc.gridy = 4;
        painelDireita.add(cadastrarDestinoButton, gbc);
        gbc.gridy = 5;
        painelDireita.add(fazerReservaButton, gbc);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, painelEsquerda, painelDireita);
        splitPane.setDividerLocation(300);
        splitPane.setResizeWeight(0.5);
        splitPane.setEnabled(false);

        add(splitPane);

        setVisible(true);
        cadastrarPessoaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               CadastrarPessoa cadastrarPessoa = new CadastrarPessoa();
            }
        });
    }
}
