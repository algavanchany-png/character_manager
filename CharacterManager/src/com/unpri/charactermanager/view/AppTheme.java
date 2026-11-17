package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.CharacterType;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class AppTheme {
    // 3 Warna Utama Tema
    public static final Color COLOR_PRIMARY = new Color(44, 62, 80);
    public static final Color COLOR_BACKGROUND = new Color(245, 247, 250);
    public static final Color COLOR_CARD_BG = Color.WHITE;
    public static final Color COLOR_HIGHLIGHT_GOLD = new Color(212, 175, 55);

    // 3 Font Utama
    public static final Font FONT_TITLE = new Font("SansSerif", Font.BOLD, 22);
    public static final Font FONT_SUBTITLE = new Font("SansSerif", Font.PLAIN, 12);
    public static final Font FONT_BODY = new Font("SansSerif", Font.PLAIN, 13);
    public static final Font FONT_BOLD_BODY = FONT_BODY.deriveFont(Font.BOLD);

    // 1 Border Utama
    public static final Border BORDER_CARD = BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(new Color(210, 215, 220), 1),
        BorderFactory.createEmptyBorder(10, 12, 10, 12)
    );

    // Method colorFor untuk warna kartu berdasarkan Role/CharacterType
    public static Color colorFor(CharacterType type) {
        if (type == null) return COLOR_CARD_BG;
        switch (type) {
            case WARRIOR:
                return new Color(253, 237, 236); // Merah muda lembut
            case MAGE:
                return new Color(235, 245, 255); // Biru muda lembut
            case ARCHER:
                return new Color(234, 250, 234); // Hijau muda lembut
            case ASSASSIN:
                return new Color(244, 236, 247); // Ungu muda lembut
            default:
                return COLOR_CARD_BG;
        }
    }
}