public class VerboseObject {
    String name;

    public VerboseObject(String name) {
        this.name = name;
        System.out.print("Object " + name + " constructed!\n");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.print("Object " + name + " destroyed!\n");
        super.finalize();
    }

    public void sayHello(){
        System.out.print("Object " + name + "says hello!\n");
    }
}
