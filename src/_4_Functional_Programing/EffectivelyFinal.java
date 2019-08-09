package _4_Functional_Programing;

public class EffectivelyFinal {
}

interface Gorilla {
    String move();
}

class GorillaFamily {

    String walk = "walk";

    void everyonePlay(boolean baby) {
        String approach = "amble";
        //approach = "run"; //if uncomment, value will not be effectively final - because it changed

        play(() -> walk);
        play(() -> baby ? "hitch a ride" : "run");
        play(() -> approach);
    }

    void play(Gorilla g) {
        System.out.println(g.move());
    }
}
