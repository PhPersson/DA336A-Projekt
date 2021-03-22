package model;

import java.awt.*;
import java.awt.*;
import java.util.List;

public class SoftwareGuide extends Guide {
    public SoftwareGuide(String title, Image pic, String type, String description) {
        super(title, pic, type, description);
    }

    public SoftwareGuide(String title, String type, String description) {
        super(title, type, description);
    }
}
