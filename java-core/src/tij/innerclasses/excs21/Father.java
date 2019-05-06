package tij.innerclasses.excs21;

public interface Father {

    void smile(Father father);

    class Son implements Father {

        @Override
        public void smile(Father father) {
            System.out.println(father.getClass().getName() + " is smiling");
        }

        public static void main(String[] args) {
            Father father = new Son();
            father.smile(father);
        }
    }

}
