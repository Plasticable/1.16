package cofh.thermal.core.common;

import cofh.core.util.FlagManager;

import java.util.function.BooleanSupplier;

import static cofh.core.util.constants.Constants.ID_THERMAL;

public class ThermalFlags {

    private ThermalFlags() {

    }

    private static final FlagManager FLAG_MANAGER = new FlagManager(ID_THERMAL);

    public static FlagManager manager() {

        return FLAG_MANAGER;
    }

    public static void setFlag(String flag, boolean enable) {

        FLAG_MANAGER.setFlag(flag, enable);
    }

    public static void setFlag(String flag, BooleanSupplier condition) {

        FLAG_MANAGER.setFlag(flag, condition);
    }

    public static BooleanSupplier getFlag(String flag) {

        return FLAG_MANAGER.getFlag(flag);
    }

    // region SPECIFIC FEATURES
    public static String FLAG_VANILLA_BLOCKS = "vanilla_blocks";
    public static String FLAG_ROCKWOOL = "rockwool";

    public static String FLAG_BEEKEEPER_ARMOR = "beekeeper_armor";
    public static String FLAG_DIVING_ARMOR = "diving_armor";
    public static String FLAG_HAZMAT_ARMOR = "hazmat_armor";

    public static String FLAG_AREA_AUGMENTS = "area_augments";
    public static String FLAG_DYNAMO_AUGMENTS = "dynamo_augments";
    public static String FLAG_MACHINE_AUGMENTS = "machine_augments";
    public static String FLAG_POTION_AUGMENTS = "potion_augments";
    public static String FLAG_STORAGE_AUGMENTS = "storage_augments";
    public static String FLAG_UPGRADE_AUGMENTS = "upgrade_augments";

    public static String FLAG_TOOL_COMPONENTS = "tool_components";

    public static String FLAG_PHYTOGRO_EXPLOSIVES = "phytogro_explosives";
    public static String FLAG_ELEMENTAL_EXPLOSIVES = "elemental_explosives";
    public static String FLAG_NUCLEAR_EXPLOSIVES = "nuclear_explosives";

    public static String FLAG_RESOURCE_APATITE = "apatite";
    public static String FLAG_RESOURCE_CINNABAR = "cinnabar";
    public static String FLAG_RESOURCE_NITER = "niter";
    public static String FLAG_RESOURCE_SULFUR = "sulfur";

    public static String FLAG_RESOURCE_COPPER = "copper";
    public static String FLAG_RESOURCE_TIN = "tin";
    public static String FLAG_RESOURCE_LEAD = "lead";
    public static String FLAG_RESOURCE_SILVER = "silver";
    public static String FLAG_RESOURCE_NICKEL = "nickel";

    public static String FLAG_RESOURCE_RUBY = "ruby";
    public static String FLAG_RESOURCE_SAPPHIRE = "sapphire";

    public static String FLAG_RESOURCE_OIL = "oil";

    public static String FLAG_RESOURCE_BRONZE = "bronze";
    public static String FLAG_RESOURCE_ELECTRUM = "electrum";
    public static String FLAG_RESOURCE_INVAR = "invar";
    public static String FLAG_RESOURCE_CONSTANTAN = "constantan";

    public static String FLAG_MOB_BASALZ = "basalz";
    public static String FLAG_MOB_BLITZ = "blitz";
    public static String FLAG_MOB_BLIZZ = "blizz";
    // endregion

    // region GENERATION FLAGS
    public static String FLAG_GEN_APATITE = "gen_apatite";
    public static String FLAG_GEN_CINNABAR = "gen_cinnabar";
    public static String FLAG_GEN_NITER = "gen_niter";
    public static String FLAG_GEN_SULFUR = "gen_sulfur";

    public static String FLAG_GEN_COPPER = "gen_copper";
    public static String FLAG_GEN_TIN = "gen_tin";
    public static String FLAG_GEN_LEAD = "gen_lead";
    public static String FLAG_GEN_SILVER = "gen_silver";
    public static String FLAG_GEN_NICKEL = "gen_nickel";

    public static String FLAG_GEN_RUBY = "gen_ruby";
    public static String FLAG_GEN_SAPPHIRE = "gen_sapphire";

    public static String FLAG_GEN_OIL = "gen_oil";
    // endregion

    static {
        setFlag(FLAG_RESOURCE_BRONZE, () -> getFlag(FLAG_RESOURCE_COPPER).getAsBoolean() && getFlag(FLAG_RESOURCE_TIN).getAsBoolean());
        setFlag(FLAG_RESOURCE_ELECTRUM, getFlag(FLAG_RESOURCE_SILVER));
        setFlag(FLAG_RESOURCE_INVAR, getFlag(FLAG_RESOURCE_NICKEL));
        setFlag(FLAG_RESOURCE_CONSTANTAN, () -> getFlag(FLAG_RESOURCE_COPPER).getAsBoolean() && getFlag(FLAG_RESOURCE_NICKEL).getAsBoolean());
    }

}
