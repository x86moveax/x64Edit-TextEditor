/*import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class SyntaxHighlighter {

    public static void highlightSyntax(JTextPane textPane) {
        // Определение стилей для ключевых слов, комментариев и строковых литералов
        StyleContext styleContext = StyleContext.getDefaultStyleContext();
        AttributeSet keywordStyle = styleContext.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.BLUE);
        AttributeSet commentStyle = styleContext.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.GRAY);
        AttributeSet stringStyle = styleContext.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.GREEN);

        // Определение набора ключевых слов для Java
        String[] keywords = {
                "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const",
                "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float",
                "for", "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new",
                "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super",
                "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while"
        };

        // Определение регулярных выражений для комментариев и строковых литералов
        String commentRegex = "//.*|/\\*(.|\\R)*?\\*
       /";
        String stringRegex = "\"[^\"]*\"";

        // Создание регулярного выражения для выделения ключевых слов
        StringBuilder keywordRegex = new StringBuilder();
        for (String keyword : keywords) {
            keywordRegex.append("\\b").append(keyword).append("\\b").append("|");
        }
        keywordRegex.deleteCharAt(keywordRegex.length() - 1);

        // Обработка текста и применение стилей
        StyledDocument doc = textPane.getStyledDocument();
        String text;
        try {
            text = doc.getText(0, doc.getLength());
            doc.setCharacterAttributes(0, text.length(), StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE), true);

            // Подсветка ключевых слов
            highlightPattern(textPane, keywordRegex.toString(), keywordStyle);

            // Подсветка комментариев
            highlightPattern(textPane, commentRegex, commentStyle);

            // Подсветка строковых литералов
            highlightPattern(textPane, stringRegex, stringStyle);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    private static void highlightPattern(JTextPane textPane, String pattern, AttributeSet style) {
        Highlighter highlighter = textPane.getHighlighter();
        Document doc = textPane.getDocument();
        String text;
        try {
            text = doc.getText(0, doc.getLength());
            int pos = 0;
            while ((pos = text.indexOf(pattern, pos)) >= 0) {
                highlighter.addHighlight(pos, pos + pattern.length(), style);
                pos += pattern.length();
            }
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Syntax Highlighter Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JTextPane textPane = new JTextPane();
        frame.add(new JScrollPane(textPane));

        frame.setVisible(true);

        // Вызов метода для подсветки синтаксиса
        highlightSyntax(textPane);
    }
}
        */
