package Task1;

public class Display {
    private int width;
    private int height;
    private float ppi;
    private String model;

    public Display(int width, int height, float ppi, String model) {
        this.width = width;
        this.height = height;
        this.ppi = ppi;
        this.model = model;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getPpi() {
        return ppi;
    }

    public void setPpi(float ppi) {
        this.ppi = ppi;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void compareSize(Display otherDisplay) {
        int thisArea = this.width * this.height;
        int otherArea = otherDisplay.getWidth() * otherDisplay.getHeight();

        String result = (thisArea > otherArea) ?
                this.model + " has a bigger size." :
                (thisArea == otherArea) ?
                        this.model + " and " + otherDisplay.getModel() + " have the same size." :
                        otherDisplay.getModel() + " has a bigger size.";

        System.out.println(result);
    }

    public void compareSharpness(Display otherDisplay) {
        float otherPpi = otherDisplay.getPpi();

        String result = (this.ppi > otherPpi) ?
                this.model + " is sharper." :
                (this.ppi == otherPpi) ?
                        this.model + " and " + otherDisplay.getModel() + " are equally sharp." :
                        otherDisplay.getModel() + " is sharper.";

        System.out.println(result);
    }

    public void compareWithMonitor(Display otherDisplay) {
        compareSize(otherDisplay);
        compareSharpness(otherDisplay);
    }
}
