package Java.StacknQueue;

public class TechBro implements EasilyCompared<TechBro>, Comparable<TechBro> {

    String language;

    TechBro(String language) {
        this.language = language;
    }

    public String toString() {
        return "Hey, I code in " + this.language + " !";
    }

    @Override
    public int compareTo(TechBro tb) {
        // TODO Auto-generated method stub
        return this.language.length() - tb.language.length();
    }

    // @Override
    public boolean greaterThan(TechBro e) {
        // TODO Auto-generated method stub
        return this.compareTo(e) > 0;
    }

    // @Override
    public boolean lessThan(TechBro e) {
        // TODO Auto-generated method stub
        return this.compareTo(e) < 0;
    }

    // @Override
    public boolean equalTo(TechBro e) {
        // TODO Auto-generated method stub
        return this.compareTo(e) == 0;
    }
}