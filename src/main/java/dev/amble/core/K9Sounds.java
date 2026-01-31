package dev.amble.core;

import dev.amble.K9Mod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class K9Sounds {
    public static final SoundEvent K9_DEFENSE = SoundEvent.of(K9Mod.id("k9_defense"));
    public static final SoundEvent K9_DIE = SoundEvent.of(K9Mod.id("k9_die"));
    public static final SoundEvent K9_HURT = SoundEvent.of(K9Mod.id("k9_hurt"));
    public static final SoundEvent K9_MASTER = SoundEvent.of(K9Mod.id("k9_master"));
    public static final SoundEvent K9_RESTART = SoundEvent.of(K9Mod.id("k9_restart"));
    public static final SoundEvent K9_RUN = SoundEvent.of(K9Mod.id("k9_run"));

    public static void init() {

    }
    private static SoundEvent register(String name) {
        return register(K9Mod.id(name));
    }
    private static SoundEvent register(Identifier id) {
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
}
