package conveyor;

import detail.Detail;
import detail.DetailView;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 26.11.17.
 */
public class ConveyerZoneModel {
    private List ditales;

    public ConveyerZoneModel() {
        ditales = new ArrayList<DetailView>();
    }

    void addDetail(DetailView detail){
        ditales.add(detail);
    }

    public List<DetailView> getDitales() {
        return ditales;
    }


}
