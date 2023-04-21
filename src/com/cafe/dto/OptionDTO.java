package com.cafe.dto;

public class OptionDTO extends TypeDTO {
    private String size;
    private int addShot;
    private boolean isSyrup;
    private boolean isIce;
    private boolean isCold;
    private boolean isSizeUp;

    protected OptionDTO() {}

    public OptionDTO(String name, int price, String size, 
            int addShot, boolean isSyrup, boolean isIce, 
            boolean isCold, boolean isSizeUp) {
        super(name, price);
        this.size = size;
        this.addShot = addShot;
        this.isSyrup = isSyrup;
        this.isIce = isIce;
        this.isCold = isCold;
        this.isSizeUp = isSizeUp;
    }

    @Override
    public String toString() {
        return super.toString() + ", size=" + size + ", addShot=" + addShot
                + ", isSyrup=" + isSyrup + ", isIce=" + isIce
                + ", isCold=" + isCold + ", isSizeUp=" + isSizeUp;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getAddShot() {
        return addShot;
    }

    public void setAddShot(int addShot) {
        this.addShot = addShot;
    }

    public boolean isSyrup() {
        return isSyrup;
    }

    public void setSyrup(boolean isSyrup) {
        this.isSyrup = isSyrup;
    }

    public boolean isIce() {
        return isIce;
    }

    public void setIce(boolean isIce) {
        this.isIce = isIce;
    }

    public boolean isCold() {
        return isCold;
    }

    public void setCold(boolean isCold) {
        this.isCold = isCold;
    }

    public boolean isSizeUp() {
        return isSizeUp;
    }

    public void setSizeUp(boolean isSizeUp) {
        this.isSizeUp = isSizeUp;
    }
}
