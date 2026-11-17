package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class MainWindow extends JFrame {
    private final CharacterManager manager;
    private JPanel characterPanel;
    private JLabel averageLabel;
    private JLabel totalLabel;
    
    // Konstanta batas level untuk Mini-Challenge
    private static final int HIGHLIGHT_LEVEL_THRESHOLD = 5;

    public MainWindow(CharacterManager manager) {
        this.manager = manager;
        setTitle("Character Manager - Sprint #4 (Theming & MVC)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(480, 400));
        initializeComponents();
        refreshCharacterList();
        pack(); // Menggunakan pack() sesuai ketentuan
        setLocationRelativeTo(null);
    }

    private void initializeComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(AppTheme.COLOR_BACKGROUND);

        // Header
        JLabel titleLabel = new JLabel("CHARACTER MANAGER", SwingConstants.CENTER);
        titleLabel.setFont(AppTheme.FONT_TITLE);
        titleLabel.setForeground(AppTheme.COLOR_PRIMARY);

        JLabel subtitleLabel = new JLabel("Sprint #4: Theming & Component Properties", SwingConstants.CENTER);
        subtitleLabel.setFont(AppTheme.FONT_SUBTITLE);

        JPanel headerPanel = new JPanel(new GridLayout(2, 1, 0, 5));
        headerPanel.setOpaque(false);
        headerPanel.add(titleLabel);
        headerPanel.add(subtitleLabel);
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // Daftar Karakter
        characterPanel = new JPanel();
        characterPanel.setLayout(new BoxLayout(characterPanel, BoxLayout.Y_AXIS));
        characterPanel.setBackground(AppTheme.COLOR_BACKGROUND);

        JScrollPane scrollPane = new JScrollPane(characterPanel);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Daftar Karakter Aktif"));
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Bagian Bawah (Statistik & Tombol)
        JPanel bottomPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        bottomPanel.setOpaque(false);

        totalLabel = new JLabel("Total Karakter: 0");
        totalLabel.setFont(AppTheme.FONT_BOLD_BODY);
        
        averageLabel = new JLabel("Rata-rata Level: 0.00");
        averageLabel.setFont(AppTheme.FONT_BOLD_BODY);

        JButton addButton = new JButton("Tambah Karakter Baru");
        addButton.setFocusPainted(false);
        addButton.addActionListener(e -> addDemoCharacter());

        bottomPanel.add(totalLabel);
        bottomPanel.add(averageLabel);
        bottomPanel.add(addButton);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        setContentPane(mainPanel);
    }

    public void refreshCharacterList() {
        characterPanel.removeAll();
        ArrayList<Character> characters = manager.getAllCharacters();

        for (Character character : characters) {
            JPanel card = new JPanel(new GridLayout(2, 1, 3, 3));
            card.setBorder(AppTheme.BORDER_CARD);
            
            // Menggunakan warna background berdasarkan role via AppTheme.colorFor()
            card.setBackground(AppTheme.colorFor(character.getType()));
            card.setOpaque(true);

            JLabel nameLabel = new JLabel(character.getName() + "  |  Role: " + character.getType());
            nameLabel.setFont(AppTheme.FONT_BOLD_BODY);

            // Properti Tambahan 1: Mini-Challenge Level >= 5 (Teks Emas & Tebal)
            // Properti Tambahan 2: Tooltip dinamis berisi detail atribut lengkap
            if (character.getLevel() >= HIGHLIGHT_LEVEL_THRESHOLD) {
                nameLabel.setForeground(AppTheme.COLOR_HIGHLIGHT_GOLD);
                nameLabel.setFont(AppTheme.FONT_BOLD_BODY.deriveFont(Font.BOLD, 14f));
            }

            JLabel detailLabel = new JLabel("Level: " + character.getLevel() + 
                "   |   HP: " + character.getHitPoints() + 
                "   |   ATK: " + character.getAttackPower() + 
                "   |   Mana: " + character.getMana());
            detailLabel.setFont(AppTheme.FONT_BODY);

            // Menetapkan Tooltip pada kartu sebagai Properti Tambahan pilihan
            card.setToolTipText("Detail Karakter -> Nama: " + character.getName() + ", HP: " + character.getHitPoints());

            card.add(nameLabel);
            card.add(detailLabel);
            card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 75));
            card.setAlignmentX(Component.LEFT_ALIGNMENT);

            characterPanel.add(card);
            characterPanel.add(Box.createVerticalStrut(8));
        }

        totalLabel.setText("Total Karakter: " + manager.getTotalCharacters());
        averageLabel.setText(String.format("Rata-rata Level: %.2f", manager.getAverageLevel()));

        characterPanel.revalidate();
        characterPanel.repaint();
    }

    private void addDemoCharacter() {
        int count = manager.getTotalCharacters() + 1;
        Character newChar = new Character("Hero " + count, CharacterType.WARRIOR, 6);
        if (manager.addCharacter(newChar)) {
            refreshCharacterList();
            pack(); // Sesuaikan ukuran jendela otomatis setelah data bertambah
            JOptionPane.showMessageDialog(this, "Karakter " + newChar.getName() + " berhasil ditambahkan!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}