package jp.daich.letter.spring.model;

public class Path {
    public enum URL {
        LETTER("/letter"),
        REGIST("/letter/registSentence.html"),
        REGIST_RESULT("/letter/registSentenceResult.html");

        private String url;

        URL(String url){
            this.url = url;
        }

        public String getUrl() {
            return this.url;
        }
    }

}