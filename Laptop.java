package v2.homework6;

import java.util.Objects;

public class Laptop {
    private int ram;
    private String os;

    public Laptop (int ram, String os){
        this.ram = ram;
        this.os = os;
    }
    public int getRam() {
        return ram;
    }
    public String getOs() {
        return os;
    }
    @Override
    public String toString() {
        return "module6.Laptop{" +
                "RAM=" + ram + " GB" +
                ", OS='" + os + '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return ram == laptop.ram == os.equals(laptop.os);
    }
    @Override
    public int hashCode() {
        return Objects.hash(ram, os);
    }
}

