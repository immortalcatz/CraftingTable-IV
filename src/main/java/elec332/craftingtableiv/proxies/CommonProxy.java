package elec332.craftingtableiv.proxies;

import elec332.core.world.WorldHelper;
import net.minecraft.util.BlockPos;
import net.minecraftforge.fml.common.network.IGuiHandler;
import elec332.craftingtableiv.CraftingTableIV;
import elec332.craftingtableiv.blocks.container.CraftingTableIVContainer;
import elec332.craftingtableiv.tileentity.TileEntityCraftingTableIV;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by Elec332 on 23-3-2015.
 */
public class CommonProxy implements IGuiHandler{

    public void registerRenders(){
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == CraftingTableIV.guiID)
            return new CraftingTableIVContainer(player, (TileEntityCraftingTableIV) WorldHelper.getTileAt(world, new BlockPos(x, y, z)));
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
        return null;
    }
}
