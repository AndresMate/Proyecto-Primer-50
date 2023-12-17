package Logic;

public class Word {
    private String word;
    private String meaning;
    private String translation;

    public Word(String word, String meaning, String translation) {
        this.word = word;
        this.meaning = meaning;
        this.translation = translation;
    }

    public String getWord() {
        return word;
    }

    public String getMeaning() {
        return meaning;
    }

    public String getTranslation() {
        return translation;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public boolean isEmpty() {
        return word == null || word.isEmpty();
    }
}