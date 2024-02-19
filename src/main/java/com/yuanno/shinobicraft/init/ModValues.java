package com.yuanno.shinobicraft.init;

import com.yuanno.shinobicraft.releases.Release;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ModValues {

    // randomizer
    public static Random random = new Random();

    // basic releases
    public static final Release WATER_RELEASE = new Release("water_release");
    public static final Release FIRE_RELEASE = new Release("fire_release");
    public static final Release WIND_RELEASE = new Release("wind_release");
    public static final Release EARTH_RELEASE = new Release("earth_release");
    public static final Release LIGHTNING_RELEASE = new Release("lightning_release");
    public static final ArrayList<Release> NATURE_RELEASES = new ArrayList<Release>() {{
        add(WATER_RELEASE);
        add(FIRE_RELEASE);
        add(WIND_RELEASE);
        add(EARTH_RELEASE);
        add(LIGHTNING_RELEASE);
    }};

    // advanced releases
    public static final Release BLAZE_RELEASE = new Release("blaze_release", FIRE_RELEASE, LIGHTNING_RELEASE);
    public static final Release BOIL_RELEASE = new Release("boil_release", WATER_RELEASE, FIRE_RELEASE);
    public static final Release CRYSTAL_RELEASE = new Release("crystal_release", EARTH_RELEASE, LIGHTNING_RELEASE);
    public static final Release DARK_RELEASE = new Release("dark_release");
    public static final Release DUST_RELEASE = new Release("dust_release", EARTH_RELEASE, WIND_RELEASE, FIRE_RELEASE);
    public static final Release EXPLOSION_RELEASE = new Release("explosion_release", LIGHTNING_RELEASE, EARTH_RELEASE);
    public static final Release IRONSAND_RELEASE =  new Release("ironsand_release");
    public static final Release LAVA_RELEASE = new Release("lava_release", FIRE_RELEASE, EARTH_RELEASE);
    public static final Release MAGNET_RELEASE = new Release("magnet_release", WIND_RELEASE, LIGHTNING_RELEASE);
    public static final Release PAPER_RELEASE = new Release("paper_release");
    public static final Release SCORCH_RELEASE = new Release("scorch_release", FIRE_RELEASE, WIND_RELEASE);
    public static final Release STEEL_RELEASE = new Release("steel_release", LIGHTNING_RELEASE, EARTH_RELEASE);
    public static final Release STORM_RELEASE = new Release("storm_release", WATER_RELEASE, LIGHTNING_RELEASE);
    public static final Release WOOD_RELEASE = new Release("wood_release", WATER_RELEASE, EARTH_RELEASE);
    public static final Release YIN_RELEASE = new Release("yin_release");
    public static final Release YANG_RELEASE = new Release("yang_release");
    public static final Release YINGYANG_RELEASE = new Release("yingyang_release");
    public static final ArrayList<Release> ADVANCED_RELEASES = new ArrayList<Release>() {{
        add(BLAZE_RELEASE);
        add(BOIL_RELEASE);
        add(CRYSTAL_RELEASE);
        add(DARK_RELEASE);
        add(DUST_RELEASE);
        add(EXPLOSION_RELEASE);
        add(IRONSAND_RELEASE);
        add(LAVA_RELEASE);
        add(MAGNET_RELEASE);
        add(PAPER_RELEASE);
        add(SCORCH_RELEASE);
        add(STEEL_RELEASE);
        add(STORM_RELEASE);
        add(WOOD_RELEASE);
        add(YIN_RELEASE);
        add(YANG_RELEASE);
        add(YINGYANG_RELEASE);
    }};

    //special release
    public static final String COSMIC_RELEASE = "cosmic_release";
    public static final String INK_RELEASE = "ink_release";

    // dojutsu
    public static final String SHARINGAN = "sharingan";
    public static final String RINNEGAN = "rinnegan";
    public static final String BYAKUGAN = "byakugan";
    public static final String RINNESHARINGAN = "rinnesharingan";
    public static final String KETSURYUGAN = "ketsuryugan";

    public static final String SENJU = "Senju";
    public static final String UCHIHA = "Uchiha";
    public static final String HYUGA = "Hyuga";
    public static final String UZUMAKI = "Uzumaki";
    public static final String INUZUKA = "Inuzuka";
    public static final String LEE = "Lee";
    public static final String NARA = "Nara";
    public static final String SARUTOBI = "Sarutobi";
    public static final String HARUNO = "Haruno";
    public static final String YAMANAKA = "Yamanaka";
    public static final String HATAKA = "Hatake";
    public static final String CHINOIKE = "Chinoike";

    public static final ArrayList<String> CLANS = new ArrayList<String>() {{
        add(SENJU);
        add(UCHIHA);
        add(HYUGA);
        add(UZUMAKI);
        add(INUZUKA);
        add(LEE);
        add(NARA);
        add(SARUTOBI);
        add(HARUNO);
        add(YAMANAKA);
        add(HATAKA);
        add(CHINOIKE);
    }};

    public static final Map<String, String> CLAN_DESCRIPTIONS = new HashMap<String, String>() {{
        put(SENJU, "Higher fuuinjutsu and ninjutsu gain");
        put(UCHIHA, "Get the sharingan");
        put(HYUGA, "Get the byakugan");
        put(UZUMAKI, "Get higher chakra pool");
        put(INUZUKA, "Get a pet companion and higher summon gain");
        put(LEE, "Higher taijutsu stat gain");
        put(NARA, "Higher intelligence stat gain");
        put(SARUTOBI, "Guaranteed minimum of 3 releases");
        put(HARUNO, "Higher healing gain");
        put(YAMANAKA, "Has telepathy");
        put(HATAKA, "Fast mastery gain");
        put(CHINOIKE, "Get the ketsuryugan");
    }};
}
