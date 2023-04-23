package com.cafe.dto;

public class BeverageOptionDTO extends CafeMenuDTO {
    private String size;
    private int addShot;
    private boolean isSyrup;
    private boolean isIce;
    private boolean isCold;
    private boolean isSizeUp;
    private boolean isWhipping;

    protected BeverageOptionDTO() {}

    public BeverageOptionDTO(String name, int price, String size, 
            int addShot, boolean isSyrup, boolean isIce, 
            boolean isCold, boolean isSizeUp, boolean isWhipping) {
        super(name, price);
        this.size = size;
        this.addShot = addShot;
        this.isSyrup = isSyrup;
        this.isIce = isIce;
        this.isCold = isCold;
        this.isSizeUp = isSizeUp;
        this.isWhipping = isWhipping;
    }

    public String checkSize() {
    	if(isSizeUp == true) {
    		return " large ";
    	}
    	else{
    		return " regular ";
    	}
    }
    
    public String checkSyrup() {
    	if(isSyrup == true) {
    		return " 시럽 추가됨 ";
    	}
    	else{
    		return " 시럽 없음 ";
    	}
    }
    
    public String checkICE() {
    	if(isCold == true) {
    		return " 얼음 추가됨 ";
    	}
    	else{
    		return " 얼음 추가 없음 ";
    	}
    }
    
    public String checkCold() {
    	if(isCold == true) {
    		return " ice ";
    	}
    	else{
    		return " hot ";
    	}
    }
    
    public String checkWhipping() {
    	if(isWhipping == true) {
    		return " 휘핑 추가됨 ";
    	}
    	else{
    		return " 휘핑 없음 ";
    	}
    }
    
    @Override
    public String toString() {
        return super.toString() + ", size=" + checkSize() + ", addShot=" + addShot
                + ", isSyrup=" + checkSyrup() + ", isIce=" + checkICE() + ", isCold=" + checkCold()
                + ", isWhipping =" + checkWhipping();
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

    public boolean isWhipping() {
        return isWhipping;
    }

    public void setWhipping(boolean isWhipping) {
        this.isWhipping = isWhipping;
    }
}
