package gui;
import simulation.Simulation;

public class RunSimulationBtn {
    private String time;
    private String orders;
    // constructor
    public RunSimulationBtn(String time, String orders){
        this.time = time;
        this.orders = orders;
    }
    public void runSimulation(){
        //create an instance of the simulation class and pass the time and order fields as arguments
        Simulation simulation = new Simulation(Integer.parseInt(time), Integer.parseInt(orders));
    }
}
