package com.personal.petsitter.services.base;

import java.util.ArrayList;
import java.util.List;

public interface BasePicturesToList {

    default List<String> picturesToList(String picture1, String picture2, String picture3,
                                        String picture4, String picture5) {

        List<String> list = new ArrayList<>();

        if(picture1 != null) {
            list.add(picture1);
        }
        if(picture2 != null) {
            list.add(picture2);
        }
        if(picture3 != null) {
            list.add(picture3);
        }
        if(picture4 != null) {
            list.add(picture4);
        }
        if(picture5 != null) {
            list.add(picture5);
        }

        return list;
    }
}
