package designpatterns.creational.factorymethod;


public class GetPlanFactory {

    //use getPlan method to get object of type Plan
    public Plan getPlan(PlanTypes planType) {
        if (planType == null) {
            return null;
        }
        if (planType == PlanTypes.DOMESTICPLAN) {
            return new DomesticPlan();
        } else if (planType == PlanTypes.COMMERCIALPLAN) {
            return new CommercialPlan();
        } else if (planType == PlanTypes.INSTITUTIONALPLAN) {
            return new InstitutionalPlan();
        }
        return null;
    }
}
