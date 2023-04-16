package junkuang.domain;

public class Demo {
    int num;
    String name;

    public Demo() {
    }

    public Demo(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }
}