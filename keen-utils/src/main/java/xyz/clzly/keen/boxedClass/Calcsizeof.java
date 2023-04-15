package xyz.clzly.keen.boxedClass;

public class Calcsizeof {
    private void calcSize() {
        System.out.println("每个包装类所占字节：");
        System.out.println("Integer:" + Integer.SIZE/Byte.SIZE); // Integer:4
        System.out.println("Short:" + Short.SIZE/Byte.SIZE); // Short:2
        System.out.println("Long:" + Long.SIZE/Byte.SIZE); // Long:8
        System.out.println("Byte:" + Byte.BYTES); // Byte:1
        System.out.println("Character:" + Character.SIZE/Byte.SIZE); // Character:2
        System.out.println("Float:" + Float.SIZE/Byte.SIZE); // Float:4
        System.out.println("Double:" + Double.SIZE/Byte.SIZE); // Double:8
        // System.out.println("Boolean:" + Boolean.toString(false));
    }

    public static void main(String[] args) {
        Calcsizeof calcsizeof = new Calcsizeof();
        calcsizeof.calcSize();
    }
}