package simwir.ct.tile;

import simwir.ct.CompactTanks;
import simwir.ct.handler.TankHandler;
import simwir.ct.lib.BlockReferences;

public class TileLargeTank extends TileSmallTank{
	public final TankHandler tank = new TankHandler(BlockReferences.LARGE_TANK_UNC_NAME, CompactTanks.largeCapacity, this);
}
