package _2_Design_Patterms;

public class BuilderPattern {

    private String element1;

    private String element2;

    private BuilderPattern() {
    }

    public BuilderPattern(String element1, String element2) {
        this.element1 = element1;
        this.element2 = element2;
    }

    public String getElement1() {
        return element1;
    }

    public String getElement2() {
        return element2;
    }

    public static void main(String[] args) {
        final BuilderPattern build = new BuilderClass()
                .setElement1("Hello")
                .setElement2("And you")
                .build();
    }
}

class BuilderClass {

    private String element1;

    private String element2;

    public BuilderClass setElement1(String element1) {
        this.element1 = element1;
        return this;
    }

    public BuilderClass setElement2(String element2) {
        this.element2 = element2;
        return this;
    }

    public BuilderPattern build() {
        return new BuilderPattern(element1, element2);
    }
}


