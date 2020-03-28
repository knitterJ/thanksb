//package com.localizer.thanksb;//package com.localizer.thanksb;
//
//import org.springframework.stereotype.Controller;
//        import org.springframework.ui.Model;
//        import org.springframework.web.bind.annotation.RequestMapping;
//        import org.springframework.web.bind.annotation.RequestMethod;
//        import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.ArrayList;
//import java.util.List;
//
////Współrzędne będą zadane na sztywno
//
//@Controller
//public class MapControllerPt2 {
//    @RequestMapping(method = RequestMethod.GET)
//    public String getMap(Model model){
//
//     List<Point> listaPunktow = new ArrayList<>();
//     listaPunktow.add(new Point(51.76,19.48, "SKAŻONA JEDNA OSOBA"));
//     listaPunktow.add(new Point(50.82,17.14, "WYKRYTE DWA PRZYPADKI"));
//
//     //Przekazujemy jako atrybut całą utworzoną powyżej pointListę
//
//     model.addAttribute("pointLista", listaPunktow);
//
//     return "map";
//    }
//}
