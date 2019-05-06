package tij.innerclasses.controller;

public class NewGreenhouseControls extends GreenhouseControls {

    private boolean waterMistGenerators = false;

    public class WaterMistGeneratorsOn extends Event {

        public WaterMistGeneratorsOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            waterMistGenerators = true;
        }

        @Override
        public String toString() {
            return "New Greenhouse water mist generators is on";
        }
    }

    public class WaterMistGeneratorsOff extends Event {

        public WaterMistGeneratorsOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            waterMistGenerators = false;
        }

        @Override
        public String toString() {
            return "New Greenhouse water mist generators is off";
        }
    }

}
