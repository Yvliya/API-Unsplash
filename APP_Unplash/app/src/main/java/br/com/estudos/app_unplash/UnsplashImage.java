package br.com.estudos.app_unplash;

public class UnsplashImage {
    private String id;
    private Urls urls;

    public String getId() {
        return id;
    }

    public Urls getUrls() {
        return urls;
    }

    public static class Urls {
        private String regular;

        public String getRegular() {
            return regular;
        }
    }
}
