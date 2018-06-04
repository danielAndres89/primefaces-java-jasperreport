/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cid.model;

import java.util.List;

/**
 *
 * @author dguilcapi
 */
public class Menu {

    private String code;
    private String name;
    private String url;
    private String icon;
    private int position;
    private String description;
    private List<Menu> lstSubmenus;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getIcon() {
        return icon;
    }

    public int getPosition() {
        return position;
    }

    public String getDescription() {
        return description;
    }

    public List<Menu> getLstSubmenus() {
        return lstSubmenus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLstSubmenus(List<Menu> lstSubmenus) {
        this.lstSubmenus = lstSubmenus;
    }

}
