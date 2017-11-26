package conveyor;

/**
 * Created by alex on 26.11.17.
 */
public class Conveyor {
    ConveyorView view;
    private final int ZONE_COUNT=5;

    public Conveyor() {
        view = new ConveyorView();
        for (int index=0;index<ZONE_COUNT;index++)
            view.addZone();
    }

    public ConveyorView getView() {
        return view;
    }

    public void next(){
        System.out.println("Next");
    }
}
