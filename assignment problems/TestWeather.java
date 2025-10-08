class Weather {
    public Weather() {
        System.out.println("Weather constructor");
    }
    public void show() {
        System.out.println("General weather");
    }
}

class Storm extends Weather {
    public Storm() {
        super();
        System.out.println("Storm constructor");
    }
    @Override
    public void show() {
        System.out.println("Stormy weather");
    }
}

class Thunderstorm extends Storm {
    public Thunderstorm() {
        super();
        System.out.println("Thunderstorm constructor");
    }
    @Override
    public void show() {
        System.out.println("Thundery storm conditions");
    }
}

class Sunshine extends Weather {
    public Sunshine() {
        super();
        System.out.println("Sunshine constructor");
    }
    @Override
    public void show() {
        System.out.println("Sunny weather");
    }
}

public class TestWeather {
    public static void main(String[] args) {
        Weather[] forecast = new Weather[4];
        forecast[0] = new Weather();
        System.out.println("---");
        forecast[1] = new Storm();
        System.out.println("---");
        forecast[2] = new Thunderstorm();
        System.out.println("---");
        forecast[3] = new Sunshine();
        System.out.println("=== Polymorphic show() calls ===");
        for (Weather w : forecast) {
            w.show();
        }
    }
}
