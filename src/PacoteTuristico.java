import javax.swing.*;
import java.awt.*;

public class PacoteTuristico extends JFrame {

    private JTextField nomeField;
    private JTextField precoField;
    private JTextField descricaoField;
    private JButton cadastrarButton;

    public PacoteTuristico() {
        setTitle("Cadastro de Pacote Turístico");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new GridLayout(1, 2));

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(90, 130, 130));
        leftPanel.setLayout(new BorderLayout());

        JLabel empresaLabel = new JLabel("Horizontes Travel", SwingConstants.CENTER);
        empresaLabel.setFont(new Font("Serif", Font.ITALIC, 32));
        empresaLabel.setForeground(Color.WHITE);

        JLabel footerLabel = new JLabel("copyright © 2024 all rights reserved", SwingConstants.CENTER);
        footerLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        footerLabel.setForeground(Color.WHITE);

        leftPanel.add(empresaLabel, BorderLayout.CENTER);
        leftPanel.add(footerLabel, BorderLayout.SOUTH);

        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        JLabel titleLabel = new JLabel("Cadastre um Pacote Turístico", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        titleLabel.setForeground(new Color(90, 130, 130));
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20, 10, 20, 10);
        rightPanel.add(titleLabel, gbc);

        nomeField = new JTextField();
        nomeField.setPreferredSize(new Dimension(200, 30));

        precoField = new JTextField();
        precoField.setPreferredSize(new Dimension(200, 30));

        descricaoField = new JTextField();
        descricaoField.setPreferredSize(new Dimension(200, 30));

        cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setBackground(new Color(90, 130, 130));
        cadastrarButton.setForeground(Color.WHITE);
        cadastrarButton.setPreferredSize(new Dimension(200, 40));

        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;

        gbc.gridx = 0;
        gbc.gridy = 1;
        rightPanel.add(new JLabel("Nome:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        rightPanel.add(nomeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        rightPanel.add(new JLabel("Preço:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        rightPanel.add(precoField, gbc);


        gbc.gridx = 0;
        gbc.gridy = 3;
        rightPanel.add(new JLabel("Descrição:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        rightPanel.add(descricaoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20, 10, 20, 10);
        rightPanel.add(cadastrarButton, gbc);

        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);

        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PacoteTuristico frame = new PacoteTuristico();
            frame.setVisible(true);
        });
    }
}
