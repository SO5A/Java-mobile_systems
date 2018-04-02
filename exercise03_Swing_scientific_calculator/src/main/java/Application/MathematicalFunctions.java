package Application;

public class MathematicalFunctions extends Object{
    private String name;
    private String function;

    public MathematicalFunctions(String name, String equivalent){
        this.name = name;
        this.function = equivalent;
    }

    public String toString(){
        return name;
    }

    public String getFunction() {
        return function;
    }

}