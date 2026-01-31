package dev.amble.client.screens;

import dev.amble.K9Mod;
import dev.amble.core.K9Items;
import dev.amble.core.items.K9LithiumCellItem;
import dev.amble.core.screenhandlers.K9CellScreenHandler;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class K9CellScreen extends HandledScreen<K9CellScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(K9Mod.MOD_ID, "textures/gui/container/k9_cell_screen.png");

    public K9CellScreen(K9CellScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        // Center the title
        titleX = (backgroundWidth - textRenderer.getWidth("K9")) / 2;
    }

    @Override
    public void handledScreenTick() {
        super.handledScreenTick();
    }

    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        String batteryLevel = this.getScreenHandler().getBattery() + "%";
        for (int i = 0; i < 8; i++) {
            if(!this.handler.getSlot(i).getStack().isEmpty()) {
                int j = this.handler.getSlot(i).getStack().getItem() == K9Items.K9_LITHIUM_CELL ? 19 : 0;
                if(this.handler.getSlot(i).getStack().getItem() == K9Items.K9_LITHIUM_CELL) {
                    NbtCompound nbt = this.handler.getSlot(i).getStack().getNbt();
                    if (nbt != null) {
                        int other = nbt.getInt(K9LithiumCellItem.BATTERY_KEY) <= 5 && nbt.getInt(K9LithiumCellItem.BATTERY_KEY) > 0 ? 38 : 19;
                        j = nbt.getInt(K9LithiumCellItem.BATTERY_KEY) <= 0 ? 57 : other;
                    }
                }
                context.drawTexture(TEXTURE, this.handler.getSlot(i).x - 1, this.handler.getSlot(i).y + 16, j, 167, 18, 6);
            }
        }
        context.drawCenteredTextWithShadow(this.textRenderer, Text.of(batteryLevel), (this.backgroundWidth - this.textRenderer.getWidth(batteryLevel) + 150) / 2, (this.backgroundHeight - 153) / 2, 0x00ff00);
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        int i = (this.width - this.backgroundWidth) / 2;
        int j = ((this.height) - this.backgroundHeight) / 2;
        context.drawTexture(TEXTURE, i, j, 0, 0, this.backgroundWidth, this.backgroundHeight);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        this.drawMouseoverTooltip(context, mouseX, mouseY);
    }
}