package dev.titanite.sparkwave.sword_saint.neoforge;

import net.neoforged.fml.common.Mod;

import dev.titanite.sparkwave.sword_saint.SwordSaint;

@Mod(SwordSaint.MOD_ID)
public final class SwordSaintNeoForge {
    public SwordSaintNeoForge() {
        // Run our common setup.
        SwordSaint.init();
    }
}
