public class DecoratorComponents {
    public static abstract class NurseDecorator implements Nurse {
        protected Nurse decoratedNurse;

        public NurseDecorator(Nurse decoratedNurse) {
            this.decoratedNurse = decoratedNurse;
        }

        @Override
        public void performDuties() {
            decoratedNurse.performDuties();
        }
    }

    public static class PediatricNurseDecorator extends NurseDecorator {
        public PediatricNurseDecorator(Nurse decoratedNurse) {
            super(decoratedNurse);
        }

        @Override
        public void performDuties() {
            super.performDuties();
            System.out.println("Specializing in pediatric care.");
        }
    }

    public static class GeriatricNurseDecorator extends NurseDecorator {
        public GeriatricNurseDecorator(Nurse decoratedNurse) {
            super(decoratedNurse);
        }

        @Override
        public void performDuties() {
            super.performDuties();
            System.out.println("Specializing in geriatric care.");
        }
    }

    public static class RespiratoryNurseDecorator extends NurseDecorator {
        public RespiratoryNurseDecorator(Nurse decoratedNurse) {
            super(decoratedNurse);
        }

        @Override
        public void performDuties() {
            super.performDuties();
            System.out.println("Specializing in respitory care.");
        }
    }
}