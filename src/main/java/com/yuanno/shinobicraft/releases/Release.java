package com.yuanno.shinobicraft.releases;

import java.util.ArrayList;

public class Release {
    private String releaseName = "";
    private Release subRelease1;
    private Release subRelease2;
    private Release subRelease3;
    private ArrayList<Release> releases = new ArrayList<>();
    public Release(String releaseName, Release subRelease1, Release subRelease2, Release subRelease3) {
        this.releaseName = releaseName;
        this.subRelease1 = subRelease1;
        this.subRelease2 = subRelease2;
        this.subRelease3 = subRelease3;
        releases.add(subRelease1);
        releases.add(subRelease2);
        releases.add(subRelease3);
    }

    public Release(String releaseName, Release subRelease1, Release subRelease2) {
        this.releaseName = releaseName;
        this.subRelease1 = subRelease1;
        this.subRelease2 = subRelease2;
        releases.add(subRelease1);
        releases.add(subRelease2);
    }
    public Release(String releaseName, Release subRelease1) {
        this.releaseName = releaseName;
        this.subRelease1 = subRelease1;
        releases.add(subRelease1);
    }

    public Release(String release) {
        this.releaseName = release;
    }
    public Release()
    {
        this.releaseName = "";
    }

    public String getRelease() {
        return releaseName;
    }

    public Release getSubRelease1() {
        return subRelease1;
    }

    public Release getSubRelease2() {
        return subRelease2;
    }

    public Release getSubRelease3() {
        return subRelease3;
    }

    public boolean hasSubReleases()
    {
        return !subRelease1.getRelease().isEmpty() || !subRelease2.getRelease().isEmpty() || !subRelease3.getRelease().isEmpty();
    }

    public ArrayList<Release> getSubReleases()
    {
        return this.releases;
    }
}
