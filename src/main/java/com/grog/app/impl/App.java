package com.grog.app.impl;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.TerminalResizeListener;

import java.io.IOException;
import javax.swing.*;

// TODO extend KeyListener in input class or something

public class App {

    public static void main(String[] args) throws IOException {
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        terminal.enterPrivateMode();
        terminal.clearScreen();

        final TextGraphics textGraphics = terminal.newTextGraphics();

        textGraphics.setForegroundColor(TextColor.ANSI.YELLOW);
        textGraphics.setBackgroundColor(TextColor.ANSI.RED);
        terminal.clearScreen();
        terminal.flush();

        textGraphics.putString(2, 1, "Lanterna Tutorial 2 - Press ESC to exit", SGR.BOLD);
        textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
        textGraphics.putString(5, 3, "Terminal Size: ", SGR.BOLD);
        textGraphics.putString(5 + "Terminal Size: ".length(), 3, terminal.getTerminalSize().toString());

        terminal.flush();

        terminal.addResizeListener(new TerminalResizeListener() {
            public void onResized(Terminal terminal, TerminalSize newSize) {
                // Be careful here though, this is likely running on a separate thread. Lanterna is threadsafe in
                // a best-effort way so while it shouldn't blow up if you call terminal methods on multiple threads,
                // it might have unexpected behavior if you don't do any external synchronization
                try {
                    terminal.clearScreen();
                    textGraphics.drawLine(5, 3, newSize.getColumns() - 1, 3, ' ');
                    textGraphics.putString(5, 3, "Terminal Size: ", SGR.BOLD);
                    textGraphics.putString(5 + "Terminal Size: ".length(), 3, newSize.toString());
                    terminal.flush();
                }
                catch(IOException e) {
                    // Not much we can do here
                    throw new RuntimeException(e);
                }
            }
        });

        textGraphics.putString(5, 4, "Last Keystroke: ", SGR.BOLD);
        textGraphics.putString(5 + "Last Keystroke: ".length(), 4, "<Pending>");
        terminal.flush();

        terminal.flush();

        KeyStroke keyStroke = terminal.readInput();
        while(keyStroke.getKeyType() != KeyType.Escape) {
            textGraphics.drawLine(5, 4, terminal.getTerminalSize().getColumns() - 1, 4, ' ');
            textGraphics.putString(5, 4, "Last Keystroke: ", SGR.BOLD);
            textGraphics.putString(5 + "Last Keystroke: ".length(), 4, keyStroke.toString());
            terminal.flush();
            keyStroke = terminal.readInput();
        }

        terminal.close();
    }

}
