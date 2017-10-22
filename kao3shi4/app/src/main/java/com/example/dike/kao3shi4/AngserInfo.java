package com.example.dike.kao3shi4;

import java.util.ArrayList;

/**
 * Created by dike on 2017/10/18.
 */
public class AngserInfo {

    private String nameId;
    private String name;
    private ArrayList<AngserOpionInfo> options;
    private String rightOption;

    public String getNameId() {
        return nameId;
    }

    public void setNameId(String nameId) {
        this.nameId = nameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<AngserOpionInfo> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<AngserOpionInfo> options) {
        this.options = options;
    }

    public String getRightOption() {
        return rightOption;
    }

    public void setRightOption(String rightOption) {
        this.rightOption = rightOption;
    }
}
