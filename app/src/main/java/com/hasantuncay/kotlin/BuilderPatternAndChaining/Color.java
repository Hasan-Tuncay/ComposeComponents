package com.hasantuncay.kotlin.BuilderPatternAndChaining;

public class Color {
    private int red;
    private int green;
    private int blue;

    public Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    @Override
    public String toString() {
        return "(" + red + ", " + green + ", " + blue + ")";
    }

    public static class Builder {
        private int red;
        private int green;
        private int blue;

        public Builder red(int value) {
            red = value;
            return this;
        }

        public Builder green(int value) {
            green = value;
            return this;
        }

        public Builder blue(int value) {
            blue = value;
            return this;
        }

        public Color build() {
            return new Color(red, green, blue);
        }
    }

    public static void main(String[] args) {
        Color color1 = new Color(1, 2, 3);
        System.out.println(color1);  // (1, 2, 3)

        Color color2 = new Builder()
                .red(76)
                .green(89)
                .blue(0)
                .build();
        System.out.println(color2);  // (76, 89, 0)

        // Method chaining without Builder is not possible in Java for immutable objects
        // You'll have to use the constructor or setters if object is mutable
    }
}
