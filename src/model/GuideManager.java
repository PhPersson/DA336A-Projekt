package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class GuideManager {

    private List<Guide> guideList;
    private Guide guide;
    private dbCon con;

    public GuideManager() {

    }

    public void showGuideList(){

    }

    public void addNewGuide(String title, Image pic, String type, String description){
       // addNewGuideToList(new Guide(title,pic ,type ,description ));

    }
/*
    public void addNewGuideToList(Guide guide){
        guideList.add(guide);
    }

    public String[] getGuideList(){

        ArrayList<String> user = con.getAllGuides();

        String[] InfoStrings = new String[user.size()];
        for(int i =0; i < InfoStrings.length;i++ ){
            if (user != null){
                InfoStrings[i] = user.toString();
            }
        }
        return InfoStrings;
    }

 */


    public void addNewGuide(){

    }

    public void RemoveGuide(){

    }


}
