package nl.tompleiter;

public class Player {
    private String name;
    private int age;
    private float gameTime;


    //    Constructor
    public Player(String name, int age) {
        this.name = name;
        this.age = age;
        this.gameTime = 0;
    }

    public int getAge () {
        return age;
    }

    public String getName () {
        return name;
    }

    public void setGameTime (float totalGameTime) { gameTime ++;}

}
