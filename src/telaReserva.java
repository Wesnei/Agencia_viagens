import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import models.Reserva;

public class telaReserva extends JFrame {
    private JTextField dataReservaField;
    private JTextField clienteIdField;
    private JTextField pacoteIdField;
    private JButton confirmarButton;
    private JButton cancelarButton;

    public telaReserva() {
        setTitle("Reserva");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(91, 129, 132));
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setPreferredSize(new Dimension(520, getHeight()));

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
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel header = new JLabel("Faça uma Reserva!", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 20));
        header.setForeground(new Color(91, 129, 132));
        gbc.gridwidth = 2;  // Abrange as duas colunas
        gbc.anchor = GridBagConstraints.CENTER;
        rightPanel.add(header, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST;

        rightPanel.add(new JLabel("Data da Reserva:"), gbc);
        gbc.gridy++;
        dataReservaField = new JTextField(20);
        dataReservaField.setPreferredSize(new Dimension(200, 30));
        rightPanel.add(dataReservaField, gbc);

        gbc.gridy++;
        rightPanel.add(new JLabel("ID do Cliente:"), gbc);
        gbc.gridy++;
        clienteIdField = new JTextField(20);
        clienteIdField.setPreferredSize(new Dimension(200, 30));
        rightPanel.add(clienteIdField, gbc);

        gbc.gridy++;
        rightPanel.add(new JLabel("ID do Pacote:"), gbc);
        gbc.gridy++;
        pacoteIdField = new JTextField(20);
        pacoteIdField.setPreferredSize(new Dimension(200, 30));
        rightPanel.add(pacoteIdField, gbc);

        JPanel buttonsPanel = new JPanel(new GridLayout(1, 2, 10, 0)); // Layout com espaçamento entre botões
        buttonsPanel.setPreferredSize(new Dimension(200, 40));

        confirmarButton = new JButton("Confirmar");
        confirmarButton.setBackground(new Color(25, 139, 0));
        confirmarButton.setForeground(Color.WHITE);
        confirmarButton.setFocusPainted(false);
        confirmarButton.setPreferredSize(new Dimension(90, 40));

        cancelarButton = new JButton("Cancelar");
        cancelarButton.setBackground(new Color(139, 0, 0));
        cancelarButton.setForeground(Color.WHITE);
        cancelarButton.setFocusPainted(false);
        cancelarButton.setPreferredSize(new Dimension(90, 40));

        buttonsPanel.add(confirmarButton);
        buttonsPanel.add(cancelarButton);

        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        rightPanel.add(buttonsPanel, gbc);

        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);

        setVisible(true);

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Converte a data
                    String dataTexto = dataReservaField.getText();
                    Date dataReserva = new Date();
                    int clienteId = Integer.parseInt(clienteIdField.getText());
                    int pacoteId = Integer.parseInt(pacoteIdField.getText());

                    Reserva reserva = new Reserva(1, dataReserva, "Confirmada", clienteId, pacoteId);

                    JOptionPane.showMessageDialog(null, "Reserva confirmada para o cliente ID: " + reserva.getClienteId());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro: ID de Cliente ou Pacote inválido.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao criar reserva: " + ex.getMessage());
                }
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        new telaReserva();
    }
}
