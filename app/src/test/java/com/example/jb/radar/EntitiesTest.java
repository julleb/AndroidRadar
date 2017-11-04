package com.example.jb.radar;

import com.example.jb.radar.Entity.EntitiesExtractor;
import com.example.jb.radar.Entity.Entity;

import org.junit.Test;

/**
 * Created by jb on 2017-05-26.
 */

public class EntitiesTest {



    String realJson = "{\"Entities\": [{\"Health\":-842150451, \"Position\": { \"x\":\"-4.31602e+08\", \"y\":" +
            " \"-4.31602e+08\", \"z\":\"-4.31602e+08\"}, \"Team\":-842150451, \"Dormant\":-842150451},{\"Health\":-842150451," +
            " \"Position\": { \"x\":\"-4.31602e+08\", \"y\": \"-4.31602e+08\", \"z\":\"-4.31602e+08\"}, \"Team\":-842150451, " +
            "\"Dormant\":-842150451},{\"Health\":-842150451, \"Position\": { \"x\":\"-4.31602e+08\", \"y\": " +
            "\"-4.31602e+08\", \"z\":\"-4.31602e+08\"}, \"Team\":-842150451, \"Dormant\":-842150451}], \"LocalPlayer\": " +
            "{\"Health\":-842150451, \"EyePosition\":{ \"x\": \"-4.31602e+08\", \"y\": \"-4.31602e+08\", \"z\": \"-4.31602e+08\"}," +
            " \"Position\": { \"x\":\"-4.31602e+08\", \"y\": \"-4.31602e+08\", \"z\":\"-4.31602e+08\"}, \"Team\":-842150451}}";


    String x = "{\"Entities\": [{\"Health\":100, \"Position\": { \"x\":-696.845, \"y\": -806.624, \"z\":134.862}, \"Team\":2, \"Dormant\":0},{\"Health\":100, \"Position\": { \"x\":334.369, \"y\": 2433.73, \"z\":-126.969}, \"Team\":3, \"Dormant\":1},{\"Health\":100, \"Position\": { \"x\":351.392, \"y\": 2352.94, \"z\":-126.969}, \"Team\":3, \"Dormant\":1},{\"Health\":0, \"Position\": { \"x\":-696.845, \"y\": -806.624, \"z\":198.862}, \"Team\":0, \"Dormant\":536870912},{\"Health\":0, \"Position\": { \"x\":-696.845, \"y\": -806.624, \"z\":198.862}, \"Team\":0, \"Dormant\":536870912},{\"Health\":0, \"Position\": { \"x\":-696.845, \"y\": -806.624, \"z\":198.862}, \"Team\":0, \"Dormant\":536870912},{\"Health\":0, \"Position\": { \"x\":-696.845, \"y\": -806.624, \"z\":198.862}, \"Team\":0, \"Dormant\":536870912},{\"Health\":0, \"Position\": { \"x\":-696.845, \"y\": -806.624, \"z\":198.862}, \"Team\":0, \"Dormant\":536870912},{\"Health\":0, \"Position\": { \"x\":-696.845, \"y\": -806.624, \"z\":198.862}, \"Team\":0, \"Dormant\":536870912},{\"Health\":0, \"Position\": { \"x\":-696.845, \"y\": -806.624, \"z\":198.862}, \"Team\":0, \"Dormant\":536870912},{\"Health\":0, \"Position\": { \"x\":-696.845, \"y\": -806.624, \"z\":198.862}, \"Team\":0, \"Dormant\":536870912},{\"Health\":0, \"Position\": { \"x\":-696.845, \"y\": -806.624, \"z\":198.862}, \"Team\":0, \"Dormant\":536870912}], \"LocalPlayer\": {\"Health\":0, \"EyePosition\":{ \"x\": 0, \"y\": 178, \"z\": 0}, \"Position\": { \"x\":-696.845, \"y\": -806.624, \"z\":198.862}, \"Team\":0}}";
    @Test
    public void test() {
        EntitiesExtractor e = new EntitiesExtractor();
        e.createEntities(realJson);

        Entity ent = e.getEntityList().get(0);
        System.out.println(ent.getHealth());

        System.out.println(e.getLocalPlayer().getEyePosition()[2]);
        System.out.println(e.getLocalPlayer().getHealth());

    }
}
