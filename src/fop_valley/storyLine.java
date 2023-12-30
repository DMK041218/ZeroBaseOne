package fop_valley;
public class storyLine {
    public static void printIntro(){
        BasicFunctions.clearScreen();
        BasicFunctions.printHeading("The beginning of the story");
        System.out.println("One day, you wake up to find your peaceful village has been turned into ruins,");
        System.out.println("and the culprit behind all this is the sudden appearance of monsters from another world.");
        System.out.println("Houses lie in rubble, and the villagers have scattered, fleeing from the ominous presence of these otherworldly creatures.");
        //TODO ASCII Art of Fire Here and Clear the console.
        System.out.println("After asking around, you learned that the monsters’ stronghold is located in a valley named FOP.");
        System.out.println("Amidst the chaos, you decide to face the challenge head-on, embarking on a journey to explore this dangerous and mysterious place.");
        BasicFunctions.continueGame();
    }

    public static void PrintChap2(){
        //print Chapter2 when player reaches Lv.15
        BasicFunctions.clearScreen();
        BasicFunctions.printHeading("Chapter 2");
        System.out.println("You've come a long way so far.");
        System.out.println("In the process, your combat skills and abilities have been greatly improved,");
        System.out.println("and now you can easily deal with these monsters.");
        //TODO ASCII Art of Road and Footprint Here and Clear the console.
        System.out.println("But there is still a long way to go before reaching FOP Valley, and the road is long and difficult.");
        System.out.println("Continue to work hard to avenge the villagers.");
        BasicFunctions.continueGame();
    }

    public static void finalChap(){
        //print FinalChapter when player reaches Lv.35
        BasicFunctions.clearScreen();
        BasicFunctions.printHeading("Final Chapter");
        System.out.println("You went through many hardships and obstacles and finally got here");
        System.out.println(" Congratulations. Next, you will face the most powerful existence behind all this darkness.");
        System.out.println("Are you ready for this?");
        //TODO ASCII Art of Valley with Monsters Here and Clear the console.
        //TODO Add Final Battle Here.
        BasicFunctions.continueGame();
    }


}
