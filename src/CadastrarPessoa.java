import dao.ClienteDao;
import dao.PessoaDao;
import models.Cliente;
import models.Pessoa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarPessoa extends JFrame {

    private JTextField nomeField;
    private JTextField emailField;
    private JTextField telefoneField;
    private JTextField cpfField;
    private JButton cadastrarButton;

    public CadastrarPessoa() {
        setTitle("Cadastro");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(91, 129, 132));
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setPreferredSize(new Dimension(500, getHeight()));

        JLabel title = new JLabel("Horizontes Travel", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.ITALIC, 28));
        title.setForeground(Color.WHITE);
        leftPanel.add(title, BorderLayout.CENTER);

        JLabel copyright = new JLabel("copyright © 2024 all rights reserved", SwingConstants.CENTER);
        copyright.setForeground(Color.WHITE);
        leftPanel.add(copyright, BorderLayout.SOUTH);

        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel header = new JLabel("Cadastra-se no Nosso Sistema!", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 20));
        header.setForeground(new Color(91, 129, 132));
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        rightPanel.add(header, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST;

        rightPanel.add(new JLabel("Nome:"), gbc);
        gbc.gridy++;
        nomeField = new JTextField(20);
        rightPanel.add(nomeField, gbc);

        gbc.gridy++;
        rightPanel.add(new JLabel("Email:"), gbc);
        gbc.gridy++;
        emailField = new JTextField(20);
        rightPanel.add(emailField, gbc);

        gbc.gridy++;
        rightPanel.add(new JLabel("Telefone:"), gbc);
        gbc.gridy++;
        telefoneField = new JTextField(20);
        rightPanel.add(telefoneField, gbc);

        gbc.gridy++;
        rightPanel.add(new JLabel("CPF ou Registro:"), gbc);
        gbc.gridy++;
        cpfField = new JTextField(20);
        rightPanel.add(cpfField, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setBackground(new Color(91, 129, 132));
        cadastrarButton.setForeground(Color.WHITE);
        rightPanel.add(cadastrarButton, gbc);

        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);

        setVisible(true);
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String email = emailField.getText();
                String telefone = telefoneField.getText();
                int cpf = Integer.parseInt(cpfField.getText());

                Pessoa pessoa = new Pessoa(0, nome, email, telefone);
                PessoaDao pessoaDao = new PessoaDao();
                pessoaDao.inserir(pessoa);

                Cliente cliente = new Cliente(pessoa.getId(), nome, email, telefone, cpf);
                ClienteDao clienteDao = new ClienteDao();
                clienteDao.inserir(cliente);

                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
            }
        });
    }
}


