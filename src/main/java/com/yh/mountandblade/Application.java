package com.yh.mountandblade;

import com.yh.mountandblade.util.ResourceReader;
import com.yh.mountandblade.util.TextWriter;
import com.yh.mountandblade.util.Translater;

import java.io.IOException;

public class Application {

    private static String TEST_FILE_PATH1 = "dialogs.csv";
    private static String TEST_FILE_PATH2 = "factions.csv";
    private static String TEST_FILE_PATH3 = "game_menus.csv";
    private static String TEST_FILE_PATH4 = "game_strings.csv";
    private static String TEST_FILE_PATH5 = "hints.csv";
    private static String TEST_FILE_PATH6 = "info_pages.csv";
    private static String TEST_FILE_PATH7 = "item_kinds.csv";
    private static String TEST_FILE_PATH8 = "item_modifiers.csv";
    private static String TEST_FILE_PATH9 = "parties.csv";
    private static String TEST_FILE_PATH10 = "party_templates.csv";
    private static String TEST_FILE_PATH11 = "quests.csv";
    private static String TEST_FILE_PATH12 = "quick_strings.csv";
    private static String TEST_FILE_PATH13 = "skills.csv";
    private static String TEST_FILE_PATH14 = "skins.csv";
    private static String TEST_FILE_PATH15 = "troops.csv";
    private static String TEST_FILE_PATH16 = "ui.csv";
    private static String TEST_FILE_PATH17 = "uimain.csv";

    private static void translate(final String fileName) throws IOException {
        String rawText  = ResourceReader.getText(fileName);
        String convertText = Translater.convert(rawText);
        TextWriter.writeText("result/" + fileName, convertText);
    }
    public static void main(String[] args) throws IOException {

        translate(TEST_FILE_PATH1);
        translate(TEST_FILE_PATH2);
        translate(TEST_FILE_PATH3);
        translate(TEST_FILE_PATH4);
        translate(TEST_FILE_PATH5);
        translate(TEST_FILE_PATH6);
        translate(TEST_FILE_PATH7);
        translate(TEST_FILE_PATH8);
        translate(TEST_FILE_PATH9);
        translate(TEST_FILE_PATH10);
        translate(TEST_FILE_PATH11);
        translate(TEST_FILE_PATH12);
        translate(TEST_FILE_PATH13);
        translate(TEST_FILE_PATH14);
        translate(TEST_FILE_PATH15);
        translate(TEST_FILE_PATH16);
        translate(TEST_FILE_PATH17);
    }
}
