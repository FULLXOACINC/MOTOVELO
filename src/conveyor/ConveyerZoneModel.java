package conveyor;

import detail.Detail;
import detail.DetailView;
import genirator.DetailGenirator;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by alex on 26.11.17.
 */
public class ConveyerZoneModel {
    private final int COUNT =3;
    private List<Detail> details;
    private List<Detail> zoneDetails;

    ConveyerZoneModel() {
        details = new ArrayList<Detail>();
        zoneDetails = new ArrayList<Detail>();
    }

    void addDetail(Detail detail) {
        details.add(detail);
    }

    List<Detail> getDitales() {
        return new ArrayList<Detail>(details);
    }


    void setZoneDetails(String name) {
        setZoneDetails(DetailGenirator.get(name,COUNT));
    }

    Detail getRandomDetail(){
        return zoneDetails.get(new Random().nextInt(zoneDetails.size()));
    }

    void setDetails(List<Detail> details) {
        this.details = details;
    }

    private void setZoneDetails(List<Detail> zoneDetails) {
        this.zoneDetails = zoneDetails;
    }

    void clear() {
        details.removeAll(details);
    }

    public List<Detail> getZoneDetails() {
        return new ArrayList<>(zoneDetails);
    }
}
