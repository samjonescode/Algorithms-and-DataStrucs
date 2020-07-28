package StacknQueue;

class TechBro implements EasilyCompared<TechBro>, Comparable<TechBro> {

    String language;
    boolean doesLift;

    TechBro(String language, boolean doesLift) {
        this.language = language;
        this.doesLift = doesLift;
    }

    public String toString() {
        return "Hey, I code in " + this.language + " !";
    }

    public int compareTo(TechBro tb) {
        // TODO Auto-generated method stub
        return this.language.length() - tb.language.length();
    }

    /**
     * If the other bro does not lift, and this bro does, then obvi this bro > that
     * bro. If both bros lift, then the one with the shorter programming language
     * name is the greater bro.
     */
    public boolean greaterThan(TechBro e) {
        // TODO Auto-generated method stub
        if (e.doesLift && !this.doesLift) {
            return false;
        } else if (!e.doesLift && this.doesLift) {
            return true;
        }
        return this.compareTo(e) > 0;
    }

    public boolean lessThan(TechBro e) {
        // TODO Auto-generated method stub
        return this.compareTo(e) < 0;
    }

    public boolean equalTo(TechBro e) {
        // TODO Auto-generated method stub
        return this.compareTo(e) == 0;
    }
}