package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.view.MainWindow;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        CharacterManager manager = new CharacterManager();

        // 6 Karakter dengan variasi role dan level
        manager.addCharacter(new Character("Arthur", CharacterType.WARRIOR, 6));   // Level >= 5 (Highlight Emas)
        manager.addCharacter(new Character("Merlin", CharacterType.MAGE, 3));
        manager.addCharacter(new Character("Robin", CharacterType.ARCHER, 4));
        manager.addCharacter(new Character("Morgana", CharacterType.MAGE, 7));   // Level >= 5 (Highlight Emas)
        manager.addCharacter(new Character("Athena", CharacterType.ASSASSIN, 5)); // Level >= 5 (Highlight Emas)
        manager.addCharacter(new Character("Lancelot", CharacterType.WARRIOR, 2));

        SwingUtilities.invokeLater(() -> {
            MainWindow window = new MainWindow(manager);
            window.setVisible(true);
        });
    }
}