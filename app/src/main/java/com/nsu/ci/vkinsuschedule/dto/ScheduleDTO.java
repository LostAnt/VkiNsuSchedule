package com.nsu.ci.vkinsuschedule.dto;

/**
 * Created by Andrew on 22.09.2016.
 */
public class ScheduleDTO {
    private String title;
    private String subTitle;
    private String suppText;

    public ScheduleDTO(String suppText, String title, String subTitle) {
        this.suppText = suppText;
        this.title = title;
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getSuppText() {
        return suppText;
    }

    public void setSuppText(String suppText) {
        this.suppText = suppText;
    }
}
