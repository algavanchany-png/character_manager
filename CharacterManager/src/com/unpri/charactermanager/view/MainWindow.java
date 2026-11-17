
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainWindow extends JFrame {

    private final CharacterManager manager;

    private JPanel characterPanel;
    private JLabel averageLabel;
    private JLabel totalLabel;

    // Constructor
    public MainWindow(CharacterManager manager) {

        this.manager = manager;

        setTitle("Character Manager - Sprint #3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 550);
        setMinimumSize(new Dimension(450, 350));
        setLocationRelativeTo(null);

        initializeComponents();
        refreshCharacterList();
    }

    // Membuat seluruh komponen GUI
    private void initializeComponents() {

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(245, 247, 250));

        // Header
        JLabel titleLabel = new JLabel(
                "CHARACTER MANAGER",
                SwingConstants.CENTER
        );

        titleLabel.setFont(
                new Font("SansSerif", Font.BOLD, 24)
        );

        titleLabel.setForeground(new Color(44, 62, 80));

        JLabel subtitleLabel = new JLabel(
                "Character Management System",
                SwingConstants.CENTER
        );

        subtitleLabel.setFont(
                new Font("SansSerif", Font.PLAIN, 13)
        );

        JPanel headerPanel = new JPanel(new GridLayout(2, 1));
        headerPanel.setOpaque(false);

        headerPanel.add(titleLabel);
        headerPanel.add(subtitleLabel);

        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // Daftar karakter
        characterPanel = new JPanel();
        characterPanel.setLayout(
                new BoxLayout(characterPanel, BoxLayout.Y_AXIS)
        );

        characterPanel.setBackground(
                new Color(245, 247, 250)
        );

        JScrollPane scrollPane = new JScrollPane(characterPanel);

        scrollPane.setBorder(
                BorderFactory.createTitledBorder("Daftar Karakter")
        );

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Bagian bawah: statistik dan tombol
        JPanel bottomPanel = new JPanel(
                new GridLayout(3, 1, 5, 5)
        );

        bottomPanel.setOpaque(false);

        totalLabel = new JLabel("Total Karakter: 0");

        averageLabel = new JLabel("Rata-rata Level: 0.00");

        totalLabel.setFont(
                new Font("SansSerif", Font.BOLD, 14)
        );

        averageLabel.setFont(
                new Font("SansSerif", Font.BOLD, 14)
        );

        JButton addButton = new JButton(
                "Tambah Karakter Demo"
        );

        addButton.setFocusPainted(false);

        addButton.addActionListener(e -> addDemoCharacter());

        bottomPanel.add(totalLabel);
        bottomPanel.add(averageLabel);
        bottomPanel.add(addButton);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        setContentPane(mainPanel);
    }

    // Menampilkan data karakter secara dinamis
    private void refreshCharacterList() {

        characterPanel.removeAll();

        ArrayList<Character> characters =
                manager.getAllCharacters();

        for (Character character : characters) {

            JPanel card = new JPanel(new GridLayout(2, 1, 5, 5));

            card.setBorder(
                    BorderFactory.createCompoundBorder(
                            BorderFactory.createLineBorder(
                                    new Color(210, 215, 220)
                            ),
                            new EmptyBorder(10, 12, 10, 12)
                    )
            );

            card.setBackground(Color.WHITE);

            JLabel nameLabel = new JLabel(
                    character.getName() +
                    "  |  " + character.getType()
            );

            nameLabel.setFont(
                    new Font("SansSerif", Font.BOLD, 15)
            );

            JLabel detailLabel = new JLabel(
                    "Level: " + character.getLevel() +
                    "   HP: " + character.getHitPoints() +
                    "   Attack: " + character.getAttackPower() +
                    "   Mana: " + character.getMana()
            );

            detailLabel.setFont(
                    new Font("SansSerif", Font.PLAIN, 12)
            );

            card.add(nameLabel);
            card.add(detailLabel);

            card.setMaximumSize(
                    new Dimension(Integer.MAX_VALUE, 75)
            );

            card.setAlignmentX(Component.LEFT_ALIGNMENT);

            characterPanel.add(card);
            characterPanel.add(Box.createVerticalStrut(8));
        }

        // Memperbarui statistik
        totalLabel.setText(
                "Total Karakter: " +
                manager.getTotalCharacters()
        );

        averageLabel.setText(
                String.format(
                        "Rata-rata Level: %.2f",
                        manager.getAverageLevel()
                )
        );

        characterPanel.revalidate();
        characterPanel.repaint();
    }

    // Event tombol tambah karakter
    private void addDemoCharacter() {

        int number = manager.getTotalCharacters() + 1;

        Character newCharacter = new Character(
                "Hero " + number,
                CharacterType.WARRIOR,
                8
        );

        boolean added = manager.addCharacter(newCharacter);

        if (added) {

            refreshCharacterList();

            JOptionPane.showMessageDialog(
                    this,
                    "Karakter berhasil ditambahkan!",
                    "Informasi",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
}
