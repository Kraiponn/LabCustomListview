package com.ksn.kraiponn.lablistui.manager;

public class CustomGridViewItem {
    public int imgId;
    public String textTitle;
    public String textContent;
    public boolean isChecked;

    public CustomGridViewItem(
            int imgId, String textTitle, String textContent, boolean isChecked
    ) {
        this.imgId = imgId;
        this.textTitle = textTitle;
        this.textContent = textContent;
        this.isChecked = isChecked;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getTextTitle() {
        return textTitle;
    }

    public void setTextTitle(String textTitle) {
        this.textTitle = textTitle;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

}
