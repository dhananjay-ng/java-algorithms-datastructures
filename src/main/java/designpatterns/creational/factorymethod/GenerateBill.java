package designpatterns.creational.factorymethod;

public class GenerateBill {
    public static void main(String args[]) {
        GetPlanFactory planFactory = new GetPlanFactory();

        Plan p = planFactory.getPlan(PlanTypes.COMMERCIALPLAN);
        //call getRate() method and calculateBill()method of DomesticPaln.
        p.getRate();
        p.calculateBill(2);
    }
}
