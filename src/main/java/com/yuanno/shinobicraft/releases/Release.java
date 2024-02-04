package com.yuanno.shinobicraft.releases;

public class Release {
    private String release = "";
    private String subRelease1 = "";
    private String SubRelease2 = "";
    private String subRelease3 = "";
    public Release(String release, String subRelease1, String subRelease2, String subRelease3) {
        this.release = release;
        this.subRelease1 = subRelease1;
        this.SubRelease2 = subRelease2;
        this.subRelease3 = subRelease3;
    }

    public Release(String release, String subRelease1, String subRelease2) {
        this.release = release;
        this.subRelease1 = subRelease1;
        this.SubRelease2 = subRelease2;
    }
    public Release(String release, String subRelease1) {
        this.release = release;
        this.subRelease1 = subRelease1;
    }

    public Release(String release) {
        this.release = release;
    }

    public String getRelease() {
        return release;
    }

    public String getSubRelease1() {
        return subRelease1;
    }

    public String getSubRelease2() {
        return SubRelease2;
    }

    public String getSubRelease3() {
        return subRelease3;
    }
}
