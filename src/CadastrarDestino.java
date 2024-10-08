import dao.DestinoDao;
import models.Destino;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarDestino extends JFrame {

    private JTextField nomeField;
    private JTextField descricaoField;
    private JTextField pacoteIdField;
    private JButton cadastrarButton;

    public CadastrarDestino() {
        setTitle("Cadastro de Destino");
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
        gbc.insets = new Insets(9, 10, 8, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel header = new JLabel("Cadastre um Novo Destino!", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 20));
        header.setForeground(new Color(91, 129, 132));
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        rightPanel.add(header, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST;

        rightPanel.add(new JLabel("Nome do Destino:"), gbc);
        gbc.gridy++;
        nomeField = new JTextField(20);
        rightPanel.add(nomeField, gbc);

        gbc.gridy++;
        rightPanel.add(new JLabel("Descrição:"), gbc);
        gbc.gridy++;
        descricaoField = new JTextField(20);
        rightPanel.add(descricaoField, gbc);


        gbc.gridy++;
        rightPanel.add(new JLabel("Pacote ID"), gbc);
        gbc.gridy++;
        pacoteIdField = new JTextField(20);  // Novo campo
        rightPanel.add(pacoteIdField, gbc);


        gbc.gridy++;
        gbc.insets = new Insets(20, 10, 5, 10);
        gbc.gridwidth = 2; // O botão ocupará duas colunas
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
                try{


                    String nome = nomeField.getText();
                    String descricao = descricaoField.getText();
                    String pacoteIdText = pacoteIdField.getText();

                    int pacoteId;
                    pacoteId = Integer.parseInt(pacoteIdText);


                    Destino destino = new Destino(0, nome, descricao, pacoteId);
                    DestinoDao destinoDao = new DestinoDao();
                    boolean sucesso = destinoDao.inserir(destino);

                    if (sucesso) {
                        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro: Pacote ID inválido. Verifique o ID e tente novamente.", "Erro de Cadastro", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Erro: O ID deve ser um número inteiro ");
                } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao cria destino: " + ex.getMessage());
            }

            }
        });
    }

    public static void main(String[] args) {
        new CadastrarDestino();
    }
}
