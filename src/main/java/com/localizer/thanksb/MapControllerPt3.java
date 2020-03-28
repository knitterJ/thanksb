package com.localizer.thanksb;//package com.localizer.thanksb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

//Współrzędne będą zadane na sztywno

@Controller
public class MapControllerPt3 {

    private DataRepo dataRepo;

    public MapControllerPt3(DataRepo dataRepo) {
        this.dataRepo = dataRepo;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getMap(Model model){

     model.addAttribute("pointLista", dataRepo.getPointList());
     return "map";
    }
}
