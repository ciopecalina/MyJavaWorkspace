package composition_aggregation_polymorphism.composition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Case {

    public void pressPowerButton() {
        System.out.println("class Case: Power button pressed.");
    }

    public void pressVolumeUp() {
        System.out.println("class Case: Volume UP pressed.");
    }

    public void pressVolumeDown() {
        System.out.println("class Case: Volume DOWN pressed.");
    }
}

class Cover {
}

class Dimensions {
    private final int width;
    private final int length;
    private final int depth;

    public Dimensions(int width, int length, int depth) {
        this.width = width;
        this.length = length;
        this.depth = depth;
    }
}

class Microphone {
    private final int maxVolume;
    private int crtVolume;

    public Microphone(int maxVolume) {
        this.maxVolume = maxVolume;
        this.crtVolume = 25 * maxVolume / 100;
    }

    public Microphone(int maxVolume, int crtVolume) {
        this.maxVolume = maxVolume;
        this.crtVolume = crtVolume;
    }

    public boolean increaseVolume() {
        if (this.crtVolume < this.maxVolume) {
            this.crtVolume++;

            return true;
        }

        return false;
    }

    public boolean decreaseVolume() {
        if (this.crtVolume > 0) {
            this.crtVolume--;

            return true;
        }
        return false;
    }

    public void muteMicrophone() {
        this.crtVolume = 0;
    }
}

class Pixel {
    private String color;

    public Pixel() {
        this("white"); // #FFFFFF
    }

    public Pixel(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}


class Screen {

    private ArrayList<Pixel> pixels;
    private Dimensions dimensions;

    public Screen(int nrPixels, int width, int length, int depth) {
        this.dimensions = new Dimensions(width, length, depth);
        this.pixels = new ArrayList<>(nrPixels);
        for (int i = 1; i <= nrPixels; i++) {
            this.pixels.add(new Pixel());
        }
    }

    public void setPixel(int index, String color) {
        this.pixels.get(index).setColor(color);
    }

    public String getPixel(int index) {
        return this.pixels.get(index).getColor();
    }

    public void colorScreen(String color) {
        for (Pixel pixel : this.pixels) {
            pixel.setColor(color);
        }
    }
}


class Smartphone {
    // Composition:
    private final Screen theScreen;
    private final Case theCase;
    private final Speaker theSpeaker;
    private final Microphone theMicrophone;

    // Aggregation:
    private Cover aCover;

    public Smartphone(Screen theScreen, Case theCase, Speaker theSpeaker, Microphone theMicrophone) {
        this.theScreen = theScreen;
        this.theCase = theCase;
        this.theSpeaker = theSpeaker;
        this.theMicrophone = theMicrophone;
    }

    public Smartphone(int pixelsNo, int width, int length, int depth, int speakerMaxVol, int microMaxVol) {
        this.theScreen = new Screen(pixelsNo, width, length, depth);
        this.theCase = new Case();
        this.theSpeaker = new Speaker(speakerMaxVol);
        this.theMicrophone = new Microphone(microMaxVol);
    }

    public Smartphone(int pixelsNo, int width, int length, int depth, int speakerMaxVol, int speakerCrtVol,
                      int microMaxVol, int microCrtVol) {
        this.theScreen = new Screen(pixelsNo, width, length, depth);
        this.theCase = new Case();
        this.theSpeaker = new Speaker(speakerMaxVol, speakerCrtVol);
        this.theMicrophone = new Microphone(microMaxVol, microCrtVol);
    }

    public boolean setCover(Cover aCover) {
        System.out.println("Setting a cover");

        if (this.aCover != null) {
            System.out.println("Error: A cover is already in place!");
            return false;
        }

        this.aCover = aCover;
        return true;
    }

    public Cover removeCover() {
        Cover referenceToCover = this.aCover;
        this.aCover = null; // remove cover
        return referenceToCover;
    }

    public void pressPowerButton() {
        System.out.println("class Smartphone: delegate to Case -> pressPowerButton");
        this.theCase.pressPowerButton();
    }

    public boolean pressVolumeUp() {
        System.out.println("class Smartphone: delegate to Case -> pressVolumeUp and Speaker -> increaseVolume");
        this.theCase.pressVolumeUp();
        return this.theSpeaker.increaseVolume();
    }

    public boolean pressVolumeDown() {
        System.out.println("class Smartphone: delegate to Case -> pressVolumeDown and Speaker -> decreaseVolume");
        this.theCase.pressVolumeDown();
        return this.theSpeaker.decreaseVolume();
    }

    public void setPixel(int index, String color) {
        this.theScreen.setPixel(index, color);
    }

    public void colorScreen(String color) {
        System.out.println("class Smartphone: delegate to Screen -> Pixel -> colorScreen");
        this.theScreen.colorScreen(color);
    }

    public boolean increaseMicrophoneVolume() {
        System.out.println("class Smartphone: delegate to Microphone -> increaseVolume");
        return this.theMicrophone.increaseVolume();
    }

    public boolean decreaseMicrophoneVolume() {
        System.out.println("class Smartphone: delegate to Microphone -> decreaseVolume");
        return this.theMicrophone.decreaseVolume();
    }

    public void muteMicrophone() {
        System.out.println("class Smartphone: delegate to Microphone -> muteMicrophone");
        this.theMicrophone.muteMicrophone();
    }

    public void setSilenceMode() {
        System.out.println("class Smartphone: delegate to Speaker -> setSilenceMode");
        this.theSpeaker.setSilenceMode();
    }
}

class Speaker {
    private final int maxVolume;
    private int crtVolume;

    public Speaker(int maxVolume) {
        this.maxVolume = maxVolume;
        this.crtVolume = 25 * maxVolume / 100;
    }

    public Speaker(int maxVolume, int crtVolume) {
        this.maxVolume = maxVolume;
        this.crtVolume = crtVolume;
    }

    public boolean increaseVolume() {
        if (this.crtVolume < this.maxVolume) {
            this.crtVolume++;

            return true;
        }

        return false;
    }

    public boolean decreaseVolume() {
        if (this.crtVolume > 0) {
            this.crtVolume--;

            return true;
        }
        return false;
    }

    public void setSilenceMode() {
        this.crtVolume = 0;
    }
}


public class Main {
    private static Map<String, Integer> commandsMap = createCommandsMap();

    private static final int PIXEL = 0;
    private static final int SPEAKER = 1;
    private static final int MICROPHONE = 2;
    private static final int SCREEN = 3;
    private static final int SMARTPHONE = 4;

    private static Map<String, Integer> createCommandsMap() {
        Map<String, Integer> myMap = new HashMap<String, Integer>();
        myMap.put("Pixel", PIXEL);
        myMap.put("Speaker", SPEAKER);
        myMap.put("Microphone", MICROPHONE);
        myMap.put("Screen", SCREEN);
        myMap.put("Smartphone", SMARTPHONE);
        return myMap;
    }

    public static Pixel constructPixel(String[] params) {
        return new Pixel(params[1]);
    }

    public static Speaker constructSpeaker(String[] params) {
        int maxVol = Integer.parseInt(params[1]);
        int crtVol = Integer.parseInt(params[2]);
        return new Speaker(maxVol, crtVol);
    }

    public static Screen constructScreen(String[] params) {
        int nrPixels = Integer.parseInt(params[1]);
        int width = Integer.parseInt(params[2]);
        int length = Integer.parseInt(params[3]);
        int depth = Integer.parseInt(params[4]);
        return new Screen(nrPixels, width, length, depth);
    }

    public static Microphone constructMicrophone(String[] params) {
        int maxVol = Integer.parseInt(params[1]);
        int crtVol = Integer.parseInt(params[2]);
        return new Microphone(maxVol, crtVol);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] keywords = line.split("\\s+");
        switch (commandsMap.get(keywords[0])) {
            case PIXEL:
                Pixel myPixel = constructPixel(keywords);
                System.out.println(myPixel.getColor());
                break;
            case SPEAKER:
                Speaker mySpeaker = constructSpeaker(keywords);
                System.out.println(mySpeaker.decreaseVolume());
                System.out.println(mySpeaker.increaseVolume());
                mySpeaker.setSilenceMode();
                System.out.println(mySpeaker.decreaseVolume());
                break;
            case MICROPHONE:
                Microphone myMicrophone = constructMicrophone(keywords);
                System.out.println(myMicrophone.decreaseVolume());
                System.out.println(myMicrophone.increaseVolume());
                myMicrophone.muteMicrophone();
                System.out.println(myMicrophone.decreaseVolume());
                break;
            case SCREEN:
                Screen myScreen = constructScreen(keywords);
                myScreen.colorScreen("#FFFFFF");
                System.out.println(myScreen.getPixel(0));
                break;
            case SMARTPHONE:
                line = scanner.nextLine();
                keywords = line.split("\\s+");
                mySpeaker = constructSpeaker(keywords);
                line = scanner.nextLine();
                keywords = line.split("\\s+");
                myMicrophone = constructMicrophone(keywords);
                line = scanner.nextLine();
                keywords = line.split("\\s+");
                myScreen = constructScreen(keywords);
                Smartphone mySmartphone = new Smartphone(myScreen, new Case(), mySpeaker, myMicrophone);
                mySmartphone.setSilenceMode();
                System.out.println(mySmartphone.pressVolumeUp());
                System.out.println(mySmartphone.pressVolumeDown());

                mySmartphone.colorScreen("#FF00FF");

                mySmartphone.muteMicrophone();
                System.out.println(mySmartphone.increaseMicrophoneVolume());
                System.out.println(mySmartphone.decreaseMicrophoneVolume());
                break;
        }
    }
}
