package com.yh.mountandblade.util;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Translater {

    private static Translate translate;
    private static Translate.TranslateOption sourceLanguage = Translate.TranslateOption.sourceLanguage("en");
    private static Translate.TranslateOption targetLanguage = Translate.TranslateOption.targetLanguage("ko");

    private static Pattern ACTION = Pattern.compile("(%[ds]{1}|%[0-9]\\.[0-9]f|\\{[^\\{\\}].\\})");

    private static Translate getTranslateService() {

        if (null == translate) {
            translate = TranslateOptions.getDefaultInstance().getService();
        }
        return translate;
    }

    private static String translate(String text,
                                    Translate.TranslateOption source,
                                    Translate.TranslateOption target) {

        Translate translate = Translater.getTranslateService();
        Translation translation = translate.translate(text, source, target);
        return translation.getTranslatedText();
    }

    public static String convert(final String rawText) {

        StringBuilder convertText = new StringBuilder();
        final Matcher matcher = Pattern.compile("(.*\\|)(.*)").matcher(rawText);
        while (matcher.find()) {
            String textName = matcher.group(1);
            String text = matcher.group(2);
            List<String> acts = new ArrayList<>();
            final Matcher act = ACTION.matcher(text);
            while (act.find()) {
                acts.add(act.group(1));
            }

            text = ACTION.matcher(text).replaceAll("[[]]");

            text = translate(text, sourceLanguage, targetLanguage);
            text.replaceAll("&amp;", "&");
            text.replaceAll("&#35;", "\'");
            text.replaceAll("&quot;", "\"");
            text.replaceAll("&lt;", "&");
            text.replaceAll("&gt;", "&");
            for (String action : acts) {
                text = text.replaceFirst("\\[\\[\\]\\]", action);
            }
            try {

                convertText.append(textName).append(text).append("\n");
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        return convertText.toString();
    }
}
