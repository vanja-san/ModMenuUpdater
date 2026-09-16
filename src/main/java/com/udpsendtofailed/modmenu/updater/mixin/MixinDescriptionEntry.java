package com.udpsendtofailed.modmenu.updater.mixin;

import com.udpsendtofailed.modmenu.updater.api.DescriptionEntryExtension;
import net.minecraft.client.gui.components.ContainerObjectSelectionList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

// Target the inner class
@Mixin(targets = "com.terraformersmc.modmenu.gui.widget.DescriptionListWidget$DescriptionEntry")
public abstract class MixinDescriptionEntry extends ContainerObjectSelectionList.Entry<MixinDescriptionEntry> implements DescriptionEntryExtension {
    
    // Shadow the public field from the original Mod Menu code
    @Shadow public boolean updateTextEntry;

    @Override
    public void setUpdateBadge(boolean isBadge) {
        // By setting this to true, Mod Menu's original render method 
        // will automatically draw the badge and indent the text for us.
        this.updateTextEntry = isBadge;
    }
}