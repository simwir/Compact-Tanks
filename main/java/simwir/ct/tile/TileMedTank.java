package simwir.ct.tile;

import simwir.ct.CompactTanks;
import simwir.ct.handler.TankHandler;
import simwir.ct.lib.BlockReferences;

public class TileMedTank extends TileSmallTank{
	public final TankHandler tank = new TankHandler(BlockReferences.MED_TANK_UNC_NAME, CompactTanks.medCapacity, this);

}
