package com.hasantuncay.designPatterns.creational.builderpattern;

import java.util.ArrayList;
import java.util.List;



public class Pizza {
    private final String dough; // hamur
    private final String sauce; // sos
    private final List<String> toppings; // malzemeler

    private Pizza(Builder builder) {
        this.dough = builder.dough;
        this.sauce = builder.sauce;
        this.toppings = builder.toppings;
    }

    public static class Builder {
        private String dough = "";
        private String sauce = "";
        private List<String> toppings = new ArrayList<>();

        public Builder dough(String dough) {
            this.dough = dough;
            return this;
        }

        public Builder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public Builder addTopping(String topping) {
            this.toppings.add(topping);
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "dough='" + dough + '\'' +
                ", sauce='" + sauce + '\'' +
                ", toppings=" + toppings +
                '}';
    }
}
