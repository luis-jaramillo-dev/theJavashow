package dev.luisjaramillo.challenges;

import java.io.Closeable;
import java.io.IOException;

public class Java9Exceptions {
    static String marvelHero = "";

    byte test = 127;

    public static void main(String... args) throws Exception {
        Logan logan = new Logan();
        new Java9Exceptions().executeAction(new PeterParker(), logan);
        System.out.println(marvelHero + logan.wolverineCloseCount);
    }

    private void executeAction(Closeable spiderMan, AutoCloseable wolverine) throws Exception {
        try (spiderMan; wolverine) {
            wolverine.close();
        } catch (Exception ignore) {
            marvelHero += "?";
            spiderMan.close();
        }
    }
//>?##1

    static class PeterParker implements Closeable {
        @Override
        public void close() {
            marvelHero += "#";
        }
    }

    static class Logan implements AutoCloseable {
        int wolverineCloseCount = 0;

        @Override
        public void close() throws IOException {
            marvelHero += ">";
            wolverineCloseCount++;
            if (wolverineCloseCount >= 1) {
                throw new IOException();
            }
        }
    }
}
