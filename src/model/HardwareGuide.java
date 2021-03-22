package model;

import java.awt.*;

public class HardwareGuide extends Guide {

    public HardwareGuide(String title, Image pic, String type, String description) {
        super(title, pic, type, description);
    }

    public HardwareGuide(String title, String type, String description) {
        super(title, type, description);

    }
}
