package com.hasantuncay.kotlin.Enumaration;


public enum Season {
    SPRING("İlkbahar", 15),
    SUMMER("Yaz", 30),
    AUTUMN("Sonbahar", 20),
    WINTER("Kış", 5);

    private String name;
    private int averageTemp;

    Season(String name, int averageTemp) {
        this.name = name;
        this.averageTemp = averageTemp;
    }

    public String getName() {
        return name;
    }

    public int getAverageTemp() {
        return averageTemp;
    }

    // Mevsime bağlı aktivite önerisi sunan metod
    public String getActivitySuggestion() {
        switch (this) {
            case SPRING:
                return "Bahar çiçekleri arasında yürüyüş yapabilirsiniz.";
            case SUMMER:
                return "Plajda vakit geçirmek için mükemmel bir zaman!";
            case AUTUMN:
                return "Sonbahar yapraklarının arasında piknik yapın.";
            case WINTER:
                return "Karın tadını çıkarın, kayak yapabilirsiniz!";
            default:
                return "Mevsim dışı bir aktivite bulun!";
        }
    }
}

  class Test {
    public static void main(String[] args) {
        Season summer = Season.SUMMER;

        System.out.println("Mevsim: " + summer.getName());
        System.out.println("Ortalama Sıcaklık: " + summer.getAverageTemp() + "°C");
    }
}
