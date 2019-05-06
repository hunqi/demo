package tij.innerclasses;

import tij.innerclasses.controller.NewGreenhouseControls;

public class NewGreenhouseController {

    public static void main(String[] args) {
        NewGreenhouseControls ngc = new NewGreenhouseControls();
        ngc.addEvent(ngc.new WaterMistGeneratorsOn(200));
        ngc.addEvent(ngc.new WaterMistGeneratorsOff(400));

        ngc.run();
    }

}
